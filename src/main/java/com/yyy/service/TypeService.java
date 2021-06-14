/**
 * Author: 老洋
 * Date:  2021/6/6 10:20
 */
package com.yyy.service;


import com.yyy.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 分类：业务类
 */
public interface TypeService {
    //1、添加（分类）
    Type saveType(Type type);

    //2.1: 获取1个（分类）
    Type getType(Long id);

    //2.2：分页获取，所有（分类）
    Page<Type> listType(Pageable pageable);

    //2.3: 通过name查询到分类
    Type getTypeByName(String name);

    //2.4: 不分页，获取到所有的（分类）
    List<Type> listType();

    //2.4：查询：获取type的条数
    List<Type> listTypeTop(Integer size);

    //3、更新（分类）
    Type updateType(Long id, Type type);

    //4、删除（分类）
    void deleteType(Long id);

}