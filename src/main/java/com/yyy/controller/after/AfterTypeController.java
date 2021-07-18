/**
 * Author: 老洋
 * Date:  2021/7/8 22:57
 */
package com.yyy.controller.after;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.service.TypeService;
import com.yyy.vo.DataVO;
import com.yyy.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  分类（控制层）：controller
 */
@Controller
public class AfterTypeController {

    @Autowired
    private TypeService typeService;            //类型：业务层对象

    //1-1: 跳转到（分类列表）
    @RequestMapping("/after/typeList")
    public String typeList(){

        return "after/type-list";
    }


    //1-2、异步返回：分类（列表）数据
    @RequestMapping("/after/queryAllType")
    @ResponseBody
    public DataVO<TypeVO>  queryAllType(Integer page, Integer limit){
        DataVO<TypeVO> dataVO = new DataVO<>();
        //为dataVO设置：值
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(typeService.queryTypeNums());

        PageHelper.startPage(page, limit);
        List<TypeVO> typeVOS = typeService.queryAllTypeVO();
        PageInfo<TypeVO> pageInfo = new PageInfo<>(typeVOS);

        dataVO.setData(pageInfo.getList());

        return dataVO;
    }

    //2-1：跳转修改：分类页面
    @RequestMapping("/after/typeUpdForm")
    public String typeForm(){
        return "after/type-updForm";
    }

    //2-2：、正式修改（分类名称）
    @RequestMapping("/after/updType")
    @ResponseBody
    public String updType(Long typeId, String newTypeName){
        int i = typeService.updateTypeName(typeId, newTypeName);

        if(i > 0){
            return "success";
        }
        return "false";
    }

    //3-1：跳转新增type：页面
    @RequestMapping("/after/typeAddPage")
    public String typeAddPage(){
        return "after/type-add";
    }

    //3-2：正式添加：type
    @RequestMapping("/after/typeAdd")
    public String typeAdd(Model model, @RequestParam String typeName){
        //传值过来的：typeName， 需要进行以下判断
            //state == 1   说明：typeName已存在， 无法添加.   ==>>（跳转after/type-add）新增页面
            //state == 2   说明：添加分类（成功）             ==>> (跳转after/type-list）类型列表页面
            //其余state    均为：添加分类（失败）             ==>> (跳转after/type-list）类型列表页面


        int state = typeService.insTypeByTypeName(typeName);


        if(state == 1){
            model.addAttribute("typeMessage", "false");
            return "after/type-add";
        }else if(state == 2) {
            model.addAttribute("typeMessage", "true");
            return "after/type-add";
        }

        model.addAttribute("typeMessage", "no");
        return "after/type-add";
    }


    //4、删除分类：通过typeId
    @RequestMapping("/after/delType")
    @ResponseBody
    public String delType(Long typeId){
        //1：查询一下当前typeId所拥有的（博客数目）
            //1-1: 若博客数目为0 ， 表示可以删除，删除后返回：true
            //1-2: 若博客数目不为0， 表示不可以删除， 直接返回false
        boolean delTypeByTypeId = typeService.isDelTypeByTypeId(typeId);

        return delTypeByTypeId ? "true" : "false";
    }
}