package com.yyy.service;
import com.yyy.pojo.Type;
import com.yyy.vo.TypeVO;

import java.util.List;

/**
 * 类型：业务层（接口）
 */
public interface TypeService {
    //1、查询：所有的types（包含blogs）
    List<Type> queryAllTypes();


    //2、查询：分类的数目
    Long queryTypeNums();

    //3、查询：type的（前端传输对象）typeVO集合
    List<TypeVO> queryAllTypeVO();

    //4、修改：分类（名称）
    int updateTypeName(Long typeId, String newTypeName);

    //5、添加：分类
    int insTypeByTypeName(String typeName);

    //6、判断：分类是否可以进行删除
    boolean isDelTypeByTypeId(Long typeId);

    //7、查询所有的Type：不用排序
    List<Type> queryAllTypesNotSort();
}
