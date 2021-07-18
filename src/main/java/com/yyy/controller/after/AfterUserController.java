/**
 * Author: 老洋
 * Date:  2021/7/9 21:55
 */
package com.yyy.controller.after;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.pojo.User;
import com.yyy.service.UserService;
import com.yyy.vo.DataVO;
import com.yyy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户：业务层对象
 */
@Controller
public class AfterUserController {
    @Autowired
    private UserService userService;

    //1-1、跳转：用户列表
    @RequestMapping("/after/userList")
    public String userList(){
        return "after/user-list";
    }

    //1-2、异步返回：用户（用户列表）数据
    @RequestMapping("/after/queryAllUser")
    @ResponseBody
    public DataVO<UserVO>  queryAllUser(Integer page, Integer limit){
        DataVO<UserVO> dataVO = new DataVO<>();
        //为dataVO设置：值
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(userService.queryUserNums());

        PageHelper.startPage(page, limit);
        List<UserVO> userVOS = userService.queryAllUserVO();
        PageInfo<UserVO> pageInfo = new PageInfo<>(userVOS);

        dataVO.setData(pageInfo.getList());

        return dataVO;
    }

    //2-1：跳转：修改用户页面
    @RequestMapping("/after/userUpdForm")
    public String userForm(){
        return "after/user-updForm";
    }

    //2-2：、正式修改（分类名称）
    @RequestMapping("/after/updUser")
    @ResponseBody
    public String updUser(Long userId, String newNickname,
                          String newAvatar, String newEmail,
                          String newPassword){


        User user = new User(userId, newNickname, newPassword, newEmail, newAvatar);
        int state = userService.updateUserInfo(user); //调用更新user对象的：业务层代码

        if(state > 0){      //状态 > 0 时： 表示更新成功，否则失败
            return "true";
        }
        return "false";
    }

    //3-1、跳转：用户添加页面
    @RequestMapping("/after/userAddPage")
    public String userAddPage(){
        return "after/user-add";
    }

    //3-2、正式添加：用户界面
    @RequestMapping("/after/userAdd")
    public String userAdd(User user, Model model){
        int state = userService.insUserByUser(user);    //添加用户

        if(state > 0){
            model.addAttribute("userAddMessage", "true"); //用户添加成功
        }else{
            model.addAttribute("userAddMessage", "false");//用户添加失败
        }

        System.out.println(state);

        return "after/user-add";
    }

    //4、删除：用户
    @RequestMapping("/after/delUser")
    @ResponseBody
    public String delUser(Long userId){
        int state = userService.delUserByUserId(userId);

        if(state > 0)
            return "true";

        return "false";
    }
}