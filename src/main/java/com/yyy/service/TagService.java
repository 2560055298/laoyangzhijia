/**
 * Author: 老洋
 * Date:  2021/6/6 10:20
 */
package com.yyy.service;


import com.yyy.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 标签：业务类
 */
public interface TagService {
    //1、添加（标签）
    Tag saveTag(Tag tag);

    //2.1: 获取1个（标签）
    Tag getTag(Long id);

    //2.2：分页获取，所有（标签）
    Page<Tag> listTag(Pageable pageable);

    //2.3: 通过name查询到标签
    Tag getTagByName(String name);

    //3、更新（标签）
    Tag updateTag(Long id, Tag tag);

    //4、删除（标签）
    void deleteTag(Long id);

}