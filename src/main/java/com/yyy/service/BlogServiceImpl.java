/**
 * Author: 老洋
 * Date:  2021/6/8 7:51
 */
package com.yyy.service;


import com.yyy.NotFoundException;
import com.yyy.dao.BlogRepository;
import com.yyy.pojo.Blog;
import com.yyy.pojo.Tag;
import com.yyy.pojo.Type;
import com.yyy.util.MarkdownUtils;
import com.yyy.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getById(id);
    }

    //查询：id获取到（博客信息）， 并将content内容markdown形式转为HTML
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.getById(id);

        if(blog == null){
            throw new NotFoundException("该博客不存在");
        }

        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        return blog;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                //文章标题
                if(blog.getTitle() != null && !"".equals(blog.getTitle())){
                    predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }

                //文章类型
                if(blog.getTypeId() != null){
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }

                //是否推荐：进行查询
                if(blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }


                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> listBlogRecommendTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
        Pageable pageable = PageRequest.of(0, size, sort);
        return blogRepository.findTop(pageable);
    }

    //查询：分页（通过，标签ID）
    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join join = root.join("tags");
                return cb.equal(join.get("id"), tagId);
            }
        }, pageable);
    }

    //全局：搜索
    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findTop(query, pageable);
    }

    //不分页：查询所有blog, 通过creatTime降序
    @Override
    public List<Blog> listBlog() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return blogRepository.findAll(sort);
    }

    //发布博客
    @Override
    public Blog saveBlog(Blog blog) {
        blog.setCreateTime(new Date());     //发表时间
        blog.setUpdateTime(new Date());     //更新时间
        blog.setViews(0);                   //评论的次数
        return blogRepository.save(blog);
    }

    //修改博客
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog temp = blogRepository.getById(id);

        if(temp == null){
            throw new NotFoundException("不存在，该博客。");
        }

        blog.setCreateTime(temp.getCreateTime());
        blog.setUpdateTime(new Date());
        blog.setViews(temp.getViews());
        BeanUtils.copyProperties(blog, temp);
        return blogRepository.save(temp);
    }

    //更新：博客访问次数
    @Override
    public int updateViews(Long id) {
        return blogRepository.updateViewsById(id);
    }

    //删除博客
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
    
}