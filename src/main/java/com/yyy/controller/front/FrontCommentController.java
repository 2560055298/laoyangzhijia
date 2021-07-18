/**
 * Author: 老洋
 * Date:  2021/6/29 17:54
 */
package com.yyy.controller.front;

import com.yyy.pojo.Comment;
import com.yyy.pojo.User;
import com.yyy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 前端：评论类（controller）
 */
@Controller
public class FrontCommentController {
    @Autowired
    CommentService commentService;


    //插入一条：评论信息
    @RequestMapping("/front/comments")
    public String commentAdd(Comment comment, Model model, HttpSession session){
        Object user = session.getAttribute("user");
        if(user != null){   //看是否：登录
            comment.setAvatar(((User)user).getAvatar());
            comment.setAdminComment(true);           //设置：评论权限，ture为管理员
        }

        commentService.insCommentByComment(comment);    //插入一条评论

        model.addAttribute("comments", commentService.queryCommentByBlogId(comment.getBlog().getId()));
        return "front/blog::commentList";
    }


    //查询评论信息
    //插入一条：评论信息
    @RequestMapping("/front/comments/{id}")
    public String commentAdd(@PathVariable Long id,Model model){

        model.addAttribute("comments", commentService.queryCommentByBlogId(id));
        return "front/blog::commentList";
    }

}