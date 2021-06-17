/**
 * Author: 老洋
 * Date:  2021/6/17 7:52
 */
package com.yyy.web;
import com.yyy.pojo.Blog;
import com.yyy.pojo.Tag;
import com.yyy.pojo.Type;
import com.yyy.service.BlogService;
import com.yyy.service.TagService;
import com.yyy.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    //获取到：所有标签
    //获取到第一个标签的：所有博客，打印一下
    //如果存在，那么只需要将，所有博客排序，以及标签传过去即可

    //跳转：标签页面
    @GetMapping("/tags/{id}")
    public String tags(
            @PageableDefault(size = 3, sort = {"updateTime"},
                    direction = Sort.Direction.DESC)
                    Pageable pageable, @PathVariable Long id, Model model){

        List<Tag> tags = tagService.listTagTop(100);

        if(id == -1){
            id = tags.get(0).getId();
        }


        //通过：tagId，查询到（该类型的：所有blog）
        model.addAttribute("page", blogService.listBlog(id, pageable));
        //查询到（所有的type）, 按拥有的（blog数目）递减
        model.addAttribute("tags", tags);

        model.addAttribute("myId", id);
        System.out.println(id);

        return "tags";
    }
}