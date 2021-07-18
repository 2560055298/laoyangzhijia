/**
 * Author: 老洋
 * Date:  2021/6/29 11:16
 */
package com.yyy.controller.front;

import com.yyy.pojo.Blog;
import com.yyy.pojo.Comment;
import com.yyy.pojo.Tag;
import com.yyy.service.BlogService;
import com.yyy.service.CommentService;
import com.yyy.service.TagService;
import com.yyy.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端：博客（controller）
 */
@Controller
public class FrontBlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CommentService commentService;

    @Autowired
    TagService tagService;

    //跳转：文章页面
    @RequestMapping("/front/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        //1、通过ID获取到：博客
        Blog blog = blogService.queryBlogInfoById(id);

        //2、将markdown转为：html
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));

        //3、给博客：设置评论
        List<Comment> comments = commentService.queryCommentByBlogId(id);

        //4、博客：访问次数加1
        blogService.updateBlogViewsNumById(id);


        //5、给博客：显示标签 (可选)
        List<Tag> tags = tagService.queryTagsByBlogId(id);
        blog.setTags(tags);

        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);
        return "front/blog";
    }
}