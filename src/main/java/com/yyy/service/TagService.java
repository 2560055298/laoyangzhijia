package com.yyy.service;


import com.yyy.pojo.Tag;
import com.yyy.pojo.Type;
import com.yyy.vo.TagInfo;
import com.yyy.vo.TagVO;
import com.yyy.vo.TypeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签表：持久层
 */
public interface TagService {
    //1、添加：通过blogId、tags[] 一组id
    void addBlogAndTag(Long blogId, Long[] tags);


    //2、查询：所有的tag
    List<TagInfo> queryAllTag();

    //3、查询：根据blogId, 查询对应tagId数组
    List<Integer> queryTagIdByBlogId(Long id);

    //4、删除：通过blogId,删除（对应）所有标签
    int delTagByBlogId(Long id);

    //5、查询：标签的数目
    Long queryTagNums();

    //6、查询：tag的（前端传输对象）typeVO集合
    List<TagVO> queryAllTagVO();

    //7、修改：标签（名称）
    int updateTagName(Long tagId, String newTagName);

    //8、添加：标签
    int insTagByTagName(String typeName);

    //9、判断：标签是否可以进行删除
    boolean isDelTagByTagId(Long tagId);

    //10、给博客：显示标签 (可选)
    List<Tag> queryTagsByBlogId(Long blogId);
}
