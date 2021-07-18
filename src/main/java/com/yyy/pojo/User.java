/**
 * Author: 老洋
 * Date:  2021/6/4 20:39
 */
package com.yyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data                   //get、set、toString
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
public class User {
    private Long id;    //用户ID
    private String nickname;    //昵称
    private String username;    //用户名
    private String password;    //密码
    private String email;       //邮箱
    private String type;        //类型
    private String avatar;      //头像
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
    private List<Blog> blogs = new ArrayList<>();


    public User(Long id, String nickname, String password, String email, String avatar) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }
}