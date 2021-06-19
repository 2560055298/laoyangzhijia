package com.yyy.service;

import com.yyy.pojo.Blog;
import com.yyy.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * 博客类
 */
public interface BlogService {
    //查询：id获取（1篇博客)
    Blog getBlog(Long id);

    //查询：id获取到（博客信息）， 并将content内容markdown形式转为HTML
    Blog getAndConvert(Long id);

    //查询：分页（博客文章）， 传递Blog的原因是因为：检索博客（名称、分类）
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    //查询：分页（博客文章）
    Page<Blog> listBlog(Pageable pageable);

    //查询：推荐
    List<Blog> listBlogRecommendTop(Integer size);

    //查询：分页（通过，标签ID）
    Page<Blog> listBlog(Long tagId, Pageable pageable);

    //全局：搜索
    Page<Blog> listBlog(String query, Pageable pageable);

    //查询到：各个年份的（博客集合）
    Map<String, List<Blog>> archiveBlog();

    //查询：blog的数量
    public Long countBlog();

    //保存：博客文章
    Blog saveBlog(Blog blog);

    //更新：博客文章
    Blog updateBlog(Long id, Blog blog);

    //更新：博客访问次数
    int updateViews(Long id);

    //删除：博客文章
    void deleteBlog(Long id);
}
