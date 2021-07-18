package com.yyy.mapper;

import com.yyy.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论表：持久层
 */
@Repository
public interface CommentMapper {
    //1、通过博客id：查询评论的总数
    Integer selComNumByBlogId(Long id);


    //2、通过博客id：查询评论
    List<Comment> selComsByBlogId(Long id);


    //3、通过评论父id：查询所有评论
    List<Comment> selComsByFatherComId(Long id);


    //4、通过博客id：删除对应的（所有）评论
    int deleteCommentsById(Long id);

    //5、插入一条评论
    int insertCommentByComment(Comment comment);

    //6、删除子评论：通过fatherCommentId
    int deleteChildsCommentByCommentId(Long fatherCommentId);

    //7、删除当前评论：通过commentId
    void deleteCommentsByCommentId(Long commentId);

    //8、评论总数目
    Long selCommentsNum();
}

