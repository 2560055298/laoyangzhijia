/**
 * Author: 老洋
 * Date:  2021/6/6 10:54
 */
package com.yyy.web.admin;

import com.yyy.pojo.Tag;
import com.yyy.service.TagService;
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
public class TagController {
    @Autowired
    private TagService tagService;


    /**
     * 查询：标签页面的（所有标签）
     * @param pageable  分页后的：标签
     * @param model     用于传递：标签内容
     * @return
     */
    @GetMapping("/tags")
    public String tags(
            @PageableDefault(
                    size = 3,
                    sort = {"id"}, direction = Sort.Direction.DESC)
                    Pageable pageable,
                    Model model){

        Page<Tag> tags = tagService.listTag(pageable);
        System.out.println("/tags ==>>" + tags);

        model.addAttribute("page", tags);
        return "admin/tags";
    }

    /**
     * 跳转到：添加标签页面
     * @return
     */
    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags_input";
    }

    /**
     * 标签信息：添加到数据库
     * @return
     */
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, HttpSession session){
        Tag temp = tagService.getTagByName(tag.getName());

        if(temp != null){       //添加标签名称：已存在了
            result.rejectValue("name", "nameError", "不能添加：重复的标签");
        }

        if(result.hasErrors()){
            return "admin/tags_input";
        }

        Tag resultTag = tagService.saveTag(tag);

        if(resultTag == null){
            session.setAttribute("info", "标签：添加失败");
        }else{
            session.setAttribute("info", "标签：添加成功");
        }

        return "redirect:/admin/tags";
    }


    /**
     * 跳转到：修改标签页面
     */
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags_input";
    }

    /**
     * 需修改的（标签）信息：在数据库中更新
     * @return
     */
    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result,@PathVariable Long id ,HttpSession session){
        Tag temp = tagService.getTagByName(tag.getName());

        if(temp != null){       //更新的标签名：已存在了
            result.rejectValue("name", "nameError", "更新（标签名）：已存在");
        }

        if(result.hasErrors()){
            return "admin/tags_input";
        }

        Tag resultTag = tagService.updateTag(id, tag);

        if(resultTag == null){
            session.setAttribute("info", "标签：更新失败");
        }else{
            session.setAttribute("info", "标签：更新成功");
        }

        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, HttpSession session){
        tagService.deleteTag(id);
        session.setAttribute("info", "标签：删除成功");
        return "redirect:/admin/tags";
    }
}