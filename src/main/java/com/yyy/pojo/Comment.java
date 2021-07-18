/**
 * Author: 老洋
 * Date:  2021/6/4 20:24
 */
package com.yyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论类
 */

@Data                   //get、set、toString
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
public class Comment {
    private Long id;
    private String nickname;        //昵称
    private String email;           //邮箱
    private String avatar;          //头像
    private String content;         //评论内容
    private Date createTime;        //创建时间
    private List<Comment> replyComments = new ArrayList<>();   //一个评论父类对象 ==>> 对应多条评论子类对象
    private Comment parentComment;  //多个子类 ==>>> 对应一个父类
    private Blog blog;              //多条评论  ==>>> 1篇博客
    private boolean adminComment;   //true为博主评论， false则不是
}