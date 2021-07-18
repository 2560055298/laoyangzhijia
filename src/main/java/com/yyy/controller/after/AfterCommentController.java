/**
 * Author: 老洋
 * Date:  2021/7/10 22:02
 */
package com.yyy.controller.after;
import com.yyy.pojo.Comment;
import com.yyy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//如何实现？
    //点击删除：判断是否有session没有session弹出一个中间框，进行登录
    //登录完成后：可以进行删除
        //1-1：先找一个semantic ui的弹出框， 点击删除，让它先弹出来。
        //1-2: 实现了可以弹出来的效果后， 进行session判断，有session=user那么不弹出来
                //没有的话，弹出来，点击登录，判断账号密码，确认后存入session

@Controller
public class AfterCommentController {
    @Autowired
    private CommentService commentService;

    //1、删除（博客）评论
    @RequestMapping("/after/delComment")
    public String delComment(Comment comment){
        commentService.delCommentbyComment(comment);    //删除评论：通过comment对象

        return "redirect:/front/blog/"+comment.getBlog().getId();
    }
}