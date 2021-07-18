/**
 * Author: 老洋
 * Date:  2021/6/4 19:56
 */
package com.yyy.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 博客类
 */
@Data                   //get、set、toString
@AllArgsConstructor
@NoArgsConstructor      //无参构造
public class Blog {
    private Long id;                    //ID
    private String title;               //标题
    private String content;             //内容
    private String firstPicture;        //首图
    private String flag;                //标记：原创、转载、翻译
    private Integer views;              //游览次数
    private boolean appreciation;       //赞赏开启
    private boolean shareStatement;     //版权开启
    private boolean commentabled;       //评论开启
    private boolean recommend;          //推荐开启
    private boolean published;          //发布开启
    private Date createTime;            //创建时间
    private Date updateTime;            //更新时间
    private User user;                  //多篇博客 ==>>> 一个用户
    private Type type;                  //多篇博客 ===>>> 一个类型
    private List<Tag> tags = new ArrayList<>();     //多篇博客 <==> 多个标签
    private String description;         //博客描述
    private String tagIds;              //用于存放：前端传来的（标签索引）例如：1, 2, 3
    private List<Comment> comments = new ArrayList<>();     //一篇博客 ==>> 多条评论
    private Integer commentNum;         //评论的次数（不放入：数据库）


    public Blog(String title, String content, String firstPicture, String flag, String description) {
        this.title = title;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = 0;
        this.createTime = new Date();
        this.updateTime = new Date();
        this.description = description;
    }
}

