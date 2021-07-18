package com.yyy.mapper;

import com.yyy.pojo.BlogAndTag;
import com.yyy.pojo.Tag;
import com.yyy.vo.TagInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标签：持久层
 */
@Repository
public interface TagMapper {
    //1、通过blogAndTag， 添加blogAndTag表数据
    int insertBlogAndTagById(BlogAndTag blogAndTag);

    //2、查询：所有的tagInfo信息
    List<TagInfo> selAllTag();

    //3、查询：tag集合通过blogId
    List<Integer> selTagsByBlogId(Long id);

    //4、删除：通过blogId,删除（对应）所有标签
    int deleteTagsById(Long id);

    //5、查询：标签的数目
    Long selTagCount();


    //6、查询：所有tag（不包含blog）
    List<Tag> selAllTagNotBlogs();

    //7、修改：标签（名称）
    int updateTagByTag(Tag tag);

    //8、查询：通过标签名称
    Tag selTagByTagName(String tagName);

    //9、添加：标签
    int insertTagByTagName(String tagName);

    //11、删除：通过tagId删除tag标签
    int deleteTagByTagId(Long tagId);

    //12、通过tagId查询：tag
    Tag selTagNameByTagId(Long tagId);
}
