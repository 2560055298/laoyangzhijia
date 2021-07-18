package com.yyy.service;

import com.yyy.pojo.Comment;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论类：业务层
 */
public interface CommentService {
    //1、通过博客id：查询评论
    List<Comment> queryCommentByBlogId(Long id);

    //2、通过博客id：删除对应的（所有）评论
    int delCommentByBlogId(Long id);

    //3、插入一条评论
    int insCommentByComment(Comment comment);

    //4、删除评论：通过comment
    void delCommentbyComment(Comment comment);

    //5、评论总数目
    Long queryCommentsNum();
}
