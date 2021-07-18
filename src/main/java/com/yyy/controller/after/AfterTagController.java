/**
 * Author: 老洋
 * Date:  2021/7/6 8:07
 */
package com.yyy.controller.after;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.pojo.Tag;
import com.yyy.service.TagService;
import com.yyy.vo.DataVO;
import com.yyy.vo.TagInfo;
import com.yyy.vo.TagVO;
import com.yyy.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AfterTagController {
    @Autowired
    TagService tagService;

    //1、查询所有的：tags
    @RequestMapping("/after/selTags")
    @ResponseBody
    public List<TagInfo> selTags(){
        List<TagInfo> tagInfo = tagService.queryAllTag();//查询：所有的tag
        return tagInfo;
    }

    //2-1: 跳转到（标签列表）
    @RequestMapping("/after/tagList")
    public String tagList(){
        return "after/tag-list";
    }

    //2-2、异步返回：标签（列表）数据
    @RequestMapping("/after/queryAllTag")
    @ResponseBody
    public DataVO<TagVO>  queryAllTag(Integer page, Integer limit){
        DataVO<TagVO> dataVO = new DataVO<>();
        //为dataVO设置：值
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(tagService.queryTagNums());

        PageHelper.startPage(page, limit);
        List<TagVO> tagVOS = tagService.queryAllTagVO();
        PageInfo<TagVO> pageInfo = new PageInfo<>(tagVOS);

        dataVO.setData(pageInfo.getList());

        return dataVO;
    }


    //3-1：跳转修改：标签页面
    @RequestMapping("/after/tagUpdForm")
    public String tagForm(){
        return "after/tag-updForm";
    }

    //3-2：、正式修改（标签名称）
    @RequestMapping("/after/updTag")
    @ResponseBody
    public String updTag(Long tagId, String newTagName){
        int i = tagService.updateTagName(tagId, newTagName);

        if(i > 0){
            return "success";
        }
        return "false";
    }

    //4-1：跳转：新增标签页面
    @RequestMapping("/after/tagAddPage")
    public String tagAddPage(){
        return "after/tag-add";
    }

    //4-2：正式添加：tag
    @RequestMapping("/after/tagAdd")
    public String tagAdd(Model model, @RequestParam String tagName){
        //传值过来的：tagName， 需要进行以下判断
        //state == 1   说明：tagName已存在， 无法添加.   ==>>（跳转after/tag-add）新增页面
        //state == 2   说明：添加标签（成功）             ==>> (跳转after/tag-list）类型列表页面
        //其余state    均为：添加标签（失败）             ==>> (跳转after/tag-list）类型列表页面


        int state = tagService.insTagByTagName(tagName);

        if(state == 1){
            model.addAttribute("tagMessage", "false");
            return "after/tag-add";
        }else if(state == 2) {
            model.addAttribute("tagMessage", "true");
            return "after/tag-add";
        }

        model.addAttribute("tagMessage", "no");
        return "after/tag-add";
    }


    //5、删除分类：通过tagId
    @RequestMapping("/after/delTag")
    @ResponseBody
    public String delType(Long tagId){
        //1：查询一下当前tagId所拥有的（博客数目）
        //1-1: 若博客数目为0 ， 表示可以删除，删除后返回：true
        //1-2: 若博客数目不为0， 表示不可以删除， 直接返回false
        boolean delTagByTagId = tagService.isDelTagByTagId(tagId);

        return delTagByTagId ? "true" : "false";
    }
}

