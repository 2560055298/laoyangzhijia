/**
 * Author: 老洋
 * Date:  2021/6/30 8:39
 */
package com.yyy.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.pojo.Blog;
import com.yyy.pojo.Type;
import com.yyy.service.BlogService;
import com.yyy.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * 前端分类：controller
 */

@Controller
public class FrontTypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Value("${typesize}")
    private Integer pageSizeConfig;         //type页面：按多少篇文章分页

    private Logger logger = LoggerFactory.getLogger(getClass());

    //类型页面
    @RequestMapping(value = {"/front/types/{id}","/front/types"})
    public String types(@PathVariable(required = false) Long id,
                        @RequestParam(required = false,defaultValue = "0")Long myid,
                        @RequestParam(required = false,defaultValue = "1")int pagenum,
                        @RequestParam(required = false,defaultValue = "2")int pagesize,
                        Model model){

        logger.info("type分页按" + pageSizeConfig  + "篇一页");

        if(pagesize == 2){
            pagesize = pageSizeConfig;      //初始值：进行设置
        }

        List<Type> types = typeService.queryAllTypes(); //查询所有的：types

        if(null != types && types.size() != 0 && null != id && -1 == id) {
            id = types.get(0).getId();
        }else if(myid != 0){
            id = myid;
        }

        PageHelper.startPage(pagenum, pagesize);
        List<Blog> blogs = blogService.queryBlogsByTypeId(id);        //通过typeId查询
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);


        model.addAttribute("types", types);
        model.addAttribute("currentTypeId", id);
        model.addAttribute("page", pageInfo);

        return "front/types";
    }

}