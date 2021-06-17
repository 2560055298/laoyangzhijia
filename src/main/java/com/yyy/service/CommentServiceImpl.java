/**
 * Author: 老洋
 * Date:  2021/6/15 19:27
 */
package com.yyy.service;


import com.yyy.dao.CommentRepository;
import com.yyy.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    private List<Comment> tempRelays = new ArrayList<>();   //作为：存放子类评论

    private void recursively(Comment comment){
        tempRelays.add(comment);
        if(comment.getReplyComments().size() > 0){  //看：是否是子孙，有子孙就放到同一级
            List<Comment> replyComments = comment.getReplyComments();

            for(Comment replyComment : replyComments){
                recursively(replyComment);
            }
        }
    }

    private void combineChildren(List<Comment> comments){
        for(Comment comment:comments){
            List<Comment> replyComments = comment.getReplyComments();

            for(Comment replyComment : replyComments){
                recursively(replyComment);  //（1级）后面的：所有结点都放到（2级）

            }
            comment.setReplyComments(tempRelays);
            tempRelays = new ArrayList<>();
        }
    }


    //通过博客ID：查询所有评论信息
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by("createTime");
        //此时获取到的：comments其父评论为null
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId, sort);

        //实现：第二层评论 （第一层为：无父评论的结点）
        combineChildren(comments);

        return comments;
    }

    @Transactional
    //保存：评论
    @Override
    public Comment savaComment(Comment comment) {
        Long parentId = comment.getParentComment().getId();

        if(parentId == -1){     //说明：没有父级
            comment.setParentComment(null);
        }else{
            comment.setParentComment(commentRepository.getById(parentId));
        }

        comment.setCreateTime(new Date());       //设置：创建时间
        return commentRepository.save(comment);
    }

}