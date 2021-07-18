/**
 * Author: 老洋
 * Date:  2021/7/5 20:37
 */
package com.yyy.service.impl;

import com.yyy.mapper.BlogMapper;
import com.yyy.mapper.TagMapper;
import com.yyy.pojo.Blog;
import com.yyy.pojo.BlogAndTag;
import com.yyy.pojo.Tag;
import com.yyy.pojo.Type;
import com.yyy.service.TagService;
import com.yyy.vo.TagInfo;
import com.yyy.vo.TagVO;
import com.yyy.vo.TypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogMapper blogMapper;

    //1、添加：通过blogId、tags[] 一组id, 添加到blog_tag表中
    @Override
    public void addBlogAndTag(Long blogId, Long[] tags) {

        BlogAndTag blogAndTag = new BlogAndTag();
        blogAndTag.setBlogId(blogId);

        for (Long tagId:tags){
            blogAndTag.setTagId(tagId);
            tagMapper.insertBlogAndTagById(blogAndTag);//通过blogAndTag， 添加blogAndTag表数据
        }
    }

    //2、查询：所有的tag
    @Override
    public List<TagInfo> queryAllTag() {
        return tagMapper.selAllTag();
    }

    //3、查询：根据blogId, 查询对应tagId数组
    @Override
    public List<Integer> queryTagIdByBlogId(Long id) {
        List<Integer> integers = tagMapper.selTagsByBlogId(id);

        System.out.println(integers);

        return integers;
    }

    //4、删除：通过blogId,删除（对应）所有标签
    @Override
    public int delTagByBlogId(Long id) {
        return tagMapper.deleteTagsById(id);
    }


    //5、查询：标签的数目
    @Override
    public Long queryTagNums() {
        return tagMapper.selTagCount();
    }

    //6、查询：tag的（前端传输对象）typeVO集合
    @Override
    public List<TagVO> queryAllTagVO() {
        List<TagVO> tagVOS = new ArrayList<>();            //创建：返回值
        List<Tag> tags = tagMapper.selAllTagNotBlogs();  //查询到：单表查询到tag集合

        for(Tag tag:tags){                               //遍历：tags
            TagVO tagVo = new TagVO();
            BeanUtils.copyProperties(tag, tagVo); //将type值注入：typeVo
            tagVo.setBlogNums(blogMapper.selBlogsByTagId(tag.getId()));   //为typeVo设置：blog的数目
            tagVOS.add(tagVo);
        }

        //需要对：List<TagVO> 集合, 按照 (blogs数目进行排序)
        //排序：需要blogs返回的是int的值, 那么只需要将typeVO中的（blogNums修改为int）
        Collections.sort(tagVOS, new Comparator<TagVO>() {
            @Override
            public int compare(TagVO o1, TagVO o2) {
                return o2.getBlogNums() - o1.getBlogNums();
            }
        });

        return tagVOS;
    }

    //7、修改：标签（名称）
    @Override
    public int updateTagName(Long tagId, String newTagName) {
        Tag tag = new Tag();
        tag.setId(tagId);
        tag.setName(newTagName);                  //新的：标签名称

        return tagMapper.updateTagByTag(tag);
    }

    //8、添加：标签
    @Override
    public int insTagByTagName(String tagName) {
        //1： 通过tagName查询，是否存在type
        Tag tag = tagMapper.selTagByTagName(tagName);

        if(tag == null){
            int i = tagMapper.insertTagByTagName(tagName);
            if(i > 0){
                return 2;        //分类添加：成功, 返回（数字2）
            }else{
                return 3;        //分类添加：失败, 返回（数字3）
            }
        }else{
            return 1;            //tagName已存在：返回（数字1）
        }
    }

    //9、判断：标签是否可以进行删除
    @Override
    public boolean isDelTagByTagId(Long tagId) {
        int blogNums = blogMapper.selBlogsByTagId(tagId);

        if(blogNums == 0){   //此时没有博客：使用该标签， 可以删除该标签
            tagMapper.deleteTagByTagId(tagId);  //通过tagId删除tag标签
            return true;     //删除：返回true
        }

        return false;       //否则：不可删除
    }

    //10、给博客：显示标签 (可选)
    @Override
    public List<Tag> queryTagsByBlogId(Long blogId) {
        List<Tag> tags = new ArrayList<>();     //创建：需要返回的tags集合
        List<Integer> integers = tagMapper.selTagsByBlogId(blogId); //通过blogId获取到：tags的id集合
        for(Integer tagId:integers){            //遍历tags的id集合
            Tag tag = tagMapper.selTagNameByTagId((long) tagId);    //由tagId集合查询到tag
            tags.add(tag);                      //将查询的到tag：放入tags中
        }

        return tags;                            //将tags返回给：业务层
    }

}