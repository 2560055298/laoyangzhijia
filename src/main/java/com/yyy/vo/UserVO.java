/**
 * Author: 老洋
 * Date:  2021/7/10 7:18
 */
package com.yyy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 用于后台：显示（用户）数据表格（传输json信息所用）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String username;
    private String password;
    private String avatar;      //用户头像
    private String nickname;    //昵称
    private String email;       //邮箱
    private Date createTime;    //创建时间
    private String type;        //用户类型
}

