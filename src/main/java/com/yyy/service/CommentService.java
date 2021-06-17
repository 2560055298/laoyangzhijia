package com.yyy.service;
import com.yyy.pojo.Comment;
import java.util.List;

public interface CommentService {
    //通过博客ID：查询所有评论信息
    List<Comment> listCommentByBlogId(Long blogId);

    //保存：评论
    Comment savaComment(Comment comment);
}
