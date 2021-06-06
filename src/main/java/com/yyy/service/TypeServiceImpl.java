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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.getById(id);
    }

    //2.2：分页获取，所有（分类）
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    //3、更新（分类）
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
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}