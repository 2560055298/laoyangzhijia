/**
 * Author: 老洋
 * Date:  2021/6/6 10:54
 */
package com.yyy.web.admin;

import com.yyy.pojo.Type;
import com.yyy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService service;


    /**
     * 查询：分类页面的（所有分类）
     * @param pageable  分页后的：分类
     * @param model     用于传递：分页内容
     * @return
     */
    @GetMapping("/types")
    public String types(
            @PageableDefault(
                    size = 3,
                    sort = {"id"}, direction = Sort.Direction.DESC)
                    Pageable pageable,
                    Model model){

        Page<Type> types = service.listType(pageable);

        model.addAttribute("page", types);
        return "/admin/types";
    }

    /**
     * 跳转到：添加分类页面
     * @return
     */
    @GetMapping("/input")
    public String input(){
        return "/admin/types_input";
    }


    /**
     * 接收分类：信息， 并添加到数据库
     * @return
     */
    @PostMapping("/types")
    public String post(Type type, HttpSession session){
        Type result = service.saveType(type);

        if(result == null){
            session.setAttribute("info", "false");
        }else{
            session.setAttribute("info", "true");
        }

        return "redirect:/admin/types";
    }

}