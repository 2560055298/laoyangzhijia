/**
 * Author: 老洋
 * Date:  2021/6/6 10:26
 */
package com.yyy.service;

import com.yyy.NotFoundException;
import com.yyy.dao.TypeRepository;
import com.yyy.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository typeRepository;

    //1、添加（分类）
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    //2.1: 获取1个（分类）
    @Override
    public Type getType(Long id) {
        return typeRepository.getById(id);
    }

    //2.2：分页获取，所有（分类）
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    //2.3: 通过name查询到分类
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    //2.4: 不分页，获取到所有的（分类）
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    //2.4：查询：获取type的条数
    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }

    //3、更新（分类）
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type temp = typeRepository.getById(id);
        if(temp == null){
            throw new NotFoundException("不存在，该类型。");
        }

        BeanUtils.copyProperties(type, temp);
        return typeRepository.save(temp);
    }

    //4、删除（分类）
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}