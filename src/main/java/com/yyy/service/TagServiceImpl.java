/**
 * Author: 老洋
 * Date:  2021/6/6 10:26
 */
package com.yyy.service;

import com.yyy.NotFoundException;
import com.yyy.dao.TagRepository;
import com.yyy.pojo.Tag;
import com.yyy.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    //1、添加（标签）
    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    //2.1: 获取1个（标签）
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getById(id);
    }

    //2.2：分页获取，所有（标签）
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    //2.3: 通过name查询到标签
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    //2.4: 不分页，获取到所有的（标签）
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    //3、更新（标签）
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag temp = tagRepository.getById(id);
        if(temp == null){
            throw new NotFoundException("不存在，该标签。");
        }

        BeanUtils.copyProperties(tag, temp);
        return tagRepository.save(temp);
    }

    //4、删除（标签）
    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}