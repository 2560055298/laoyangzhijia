package com.yyy.service;

import com.yyy.pojo.Blog;
import com.yyy.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 博客类
 */
public interface BlogService {
    //查询：id获取（1篇博客)
    Blog getBlog(Long id);

    //查询：分页（博客文章）， 传递Blog的原因是因为：检索博客（名称、分类）
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    //保存：博客文章
    Blog saveBlog(Blog blog);

    //更新：博客文章
    Blog updateBlog(Long id, Blog blog);

    //删除：博客文章
    void deleteBlog(Long id);
}
