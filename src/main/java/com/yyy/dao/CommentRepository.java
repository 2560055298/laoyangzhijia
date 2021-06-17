package com.yyy.dao;

import com.yyy.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //通过博客ID, 查询：评论信息
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
