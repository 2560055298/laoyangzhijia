/**
 * Author: 老洋
 * Date:  2021/6/30 9:12
 */
package com.yyy.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.mapper.BlogMapper;
import com.yyy.mapper.CommentMapper;
import com.yyy.mapper.TypeMapper;
import com.yyy.pojo.Blog;
import com.yyy.pojo.Type;
import com.yyy.service.TypeService;
import com.yyy.vo.DataVO;
import com.yyy.vo.TypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 前端（类型）： 业务层
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BlogMapper blogMapper;


    //1、查询：所有（博客类型）并排序
    @Override
    public List<Type> queryAllTypes() {
        //查询所有的类型：不包含博客
        List<Type> types = typeMapper.selAllTypeNotBlogs();

        //为类型：设置博客
        for(Type type : types){
            type.setBlogs(blogMapper.selBlogsByTypeId(type.getId()));
        }

        //按（博客数目， 从大到小）：排列types
        Collections.sort(types, new Comparator<Type>() {
            @Override
            public int compare(Type o1, Type o2) {
                return o2.getBlogs().size() - o1.getBlogs().size();
            }
        });

        return types;
    }

    //2、查询：分类的数目
    @Override
    public Long queryTypeNums() {
        return typeMapper.selTypeCount();
    }

    //3、查询：type的（前端传输对象）typeVO集合
    @Override
    public List<TypeVO> queryAllTypeVO() {

        List<TypeVO> typeVOS = new ArrayList<>();            //创建：返回值
        List<Type> types = typeMapper.selAllTypeNotBlogs();  //查询到：单表查询到type集合

        for(Type type:types){                       //遍历：types
            TypeVO typeVo = new TypeVO();
            BeanUtils.copyProperties(type, typeVo); //将type值注入：typeVo
            typeVo.setBlogNums(blogMapper.selBlogsByTypeId(typeVo.getId()).size());   //为typeVo设置：blog的数目
            typeVOS.add(typeVo);
        }

        //需要对：List<TypeVO> 集合, 按照 (blogs数目进行排序)
        //排序：需要blogs返回的是int的值, 那么只需要将typeVO中的（blogNums修改为int）
        Collections.sort(typeVOS, new Comparator<TypeVO>() {
            @Override
            public int compare(TypeVO o1, TypeVO o2) {
                return o2.getBlogNums() - o1.getBlogNums();
            }
        });

        return typeVOS;
    }


    //4、修改：分类（名称）
    @Override
    public int updateTypeName(Long typeId, String newTypeName) {
        Type type = new Type();
        type.setId(typeId);
        type.setName(newTypeName);                  //新的：类型名称

        return typeMapper.updateTypeByType(type);
    }


    /**
     * 5、添加：分类
     * @param typeName     分类名称
     * @return          返回 1：代表（分类名称，已存在）； 返回2：（添加分类成功）， 返回 3：（添加分类失败！）；
     */
    @Override
    public int insTypeByTypeName(String typeName) {
        //1： 通过title查询，是否存在type
        Type type = typeMapper.selTypeByTypeName(typeName);

        if(type == null){
            int i = typeMapper.insertTypeByTypeName(typeName);
            if(i > 0){
                return 2;        //分类添加：成功, 返回（数字2）
            }else{
                return 3;        //分类添加：失败, 返回（数字3）
            }
        }else{
            return 1;            //typeName已存在：返回（数字1）
        }
    }

    //6、判断：分类是否可以进行删除
    @Override
    public boolean isDelTypeByTypeId(Long typeId) {
        //如何判断：是否可以删除呢？ 只需通过id去查询blogs数目， 也就是调用之前的（typeId查询）
        List<Blog> blogs = blogMapper.selBlogsByTypeId(typeId);

        if(null != blogs && blogs.size() == 0){     //拥有该类型的博客数目：为0, 可以删除
            typeMapper.deleteTypeByTypeId(typeId);
            return true;
        }

        return false;           //不能删除
    }

    //7、查询所有的Type：不用排序
    @Override
    public List<Type> queryAllTypesNotSort() {
        return typeMapper.selAllTypesNotSort();
    }
}