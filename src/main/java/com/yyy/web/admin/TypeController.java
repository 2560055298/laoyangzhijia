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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;


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

        Page<Type> types = typeService.listType(pageable);

        model.addAttribute("page", types);
        return "admin/types";
    }

    /**
     * 跳转到：添加分类页面
     * @return
     */
    @GetMapping("/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/types_input";
    }

    /**
     * 分类信息：添加到数据库
     * @return
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, HttpSession session){
        Type temp = typeService.getTypeByName(type.getName());

        if(temp != null){       //添加分类名称：已存在了
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if(result.hasErrors()){
            return "admin/types_input";
        }

        Type resultType = typeService.saveType(type);

        if(resultType == null){
            session.setAttribute("info", "分类：添加失败");
        }else{
            session.setAttribute("info", "分类：添加成功");
        }

        return "redirect:/admin/types";
    }


    /**
     * 跳转到：修改分类页面
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "admin/types_input";
    }

    /**
     * 需修改的分类信息：在数据库中更新
     * @return
     */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id ,HttpSession session){
        Type temp = typeService.getTypeByName(type.getName());

        if(temp != null){       //更新的名称：已存在了
            result.rejectValue("name", "nameError", "更新分类名：已存在");
        }

        if(result.hasErrors()){
            return "admin/types_input";
        }

        Type resultType = typeService.updateType(id, type);

        if(resultType == null){
            session.setAttribute("info", "分类：更新失败");
        }else{
            session.setAttribute("info", "分类：更新成功");
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, HttpSession session){
        typeService.deleteType(id);
        session.setAttribute("info", "分类：删除成功");
        return "redirect:/admin/types";
    }


}