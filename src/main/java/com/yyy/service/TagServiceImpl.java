/**
 * Author: 老洋
 * Date:  2021/6/6 10:26
 */
package com.yyy.service;

import com.yyy.NotFoundException;
import com.yyy.dao.TagRepository;
import com.yyy.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    //2.5: 通过String(1,2,3 等) tag的ID字符串， 查询到List<Tag>的集合
    @Override
    public List<Tag> listTag(String ids) {
        List<Tag> tags = new ArrayList<>();     //用于存放：所有博客标签


        //根据前端的（tags的ID字符串），转为Tag集合，存入博客对象中
        if(!"".equals(ids) && ids != null){
            String[] tag = ids.split(",");
            for(int i = 0; i < tag.length; i++){
                if(!tag[i].equals(""))
                    tags.add(tagRepository.getById(Long.parseLong(tag[i])));
            }

            return tags;
        }
        return null;
    }

    //2.6：指定数目， 查询标签（条数）
    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagRepository.findTop(pageable);
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