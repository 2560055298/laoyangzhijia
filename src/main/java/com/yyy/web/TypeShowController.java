/**
 * Author: 老洋
 * Date:  2021/6/16 17:10
 */
package com.yyy.web;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yyy.pojo.Blog;
import com.yyy.pojo.Type;
import com.yyy.service.BlogService;
import com.yyy.service.TypeService;
import com.yyy.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用于显示：分类页面
 */
@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    //第一步：获取到所有的（类型）
    //跳转：类型页面
    @GetMapping("/types/{id}")
    public String types(
            @PageableDefault(size = 3, sort = {"updateTime"},
                    direction = Sort.Direction.DESC)
                    Pageable pageable, @PathVariable Long id,Model model){

        List<Type> types = typeService.listTypeTop(100);

        if(id == -1){
            id = types.get(0).getId();
        }

        BlogQuery blog = new BlogQuery();
        blog.setTypeId(id);
        //通过：模糊查询中的（typeId) 查询到（该类型的：所有blog）
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        //查询到（所有的type）, 按拥有的（blog数目）递减
        model.addAttribute("types", types);

        model.addAttribute("myId", id);
        System.out.println(id);

        return "types";
    }
}