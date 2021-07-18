package com.yyy.mapper;

import com.yyy.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类型表：持久层
 */
@Repository
public interface TypeMapper {
    //1、查询：所有（博客类型）
    List<Type> selAllTypes();

    //2、通过：typeId查询， type
    Type selTypeById(Long id);

    //3、查询：所有type（不包含blog）
    List<Type> selAllTypeNotBlogs();

    //4、查询：分类的数目
    Long selTypeCount();

    //5、修改：分类（名称）
    int updateTypeByType(Type type);


    //6、查询：通过分类名称
    Type selTypeByTypeName(String typeName);


    //7、添加：分类
    int insertTypeByTypeName(String typeName);

    //8、删除分类：通过typeId
    int deleteTypeByTypeId(Long typeId);


    //9、查询所有的Type：不用排序
    List<Type> selAllTypesNotSort();
}
