/**
 * Author: 老洋
 * Date:  2021/6/15 17:06
 */
package com.yyy.web;

import com.yyy.pojo.Comment;
import com.yyy.pojo.User;
import com.yyy.service.BlogService;
import com.yyy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论控制器
 */
@Controller
@PropertySource(value = "classpath:application.yaml")
public class ConmmentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    /**
     * 保存：提交的评论
     * @param comment
     * @return
     */
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        User user = (User)session.getAttribute("user");
        Long blogId = comment.getBlog().getId();
        if(user != null){
            comment.setAvatar(user.getAvatar());        //设置用户头像
            comment.setAdminComment(true);
        }else{
            comment.setAvatar(avatar);                  //设置：评论头像
        }
        comment.setBlog(blogService.getBlog(blogId));     //设置：评论的blog
        commentService.savaComment(comment);              //保存：blog


        return "redirect:/comments/" + blogId;
    }

    /**
     * 根据评论的ID：获取评论列表, 回显到（前端页面）
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        List<Comment> comments = commentService.listCommentByBlogId(blogId);

        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }


}