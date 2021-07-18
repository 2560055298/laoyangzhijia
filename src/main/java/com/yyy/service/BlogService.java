package com.yyy.service;

import com.yyy.pojo.Blog;
import com.yyy.vo.BlogInfo;
import com.yyy.vo.BlogVO;
import com.yyy.vo.SearchBlogInfo;
import com.yyy.vo.SwitchVO;

import java.util.List;

public interface BlogService {
    //1、查询：最新推荐的5篇文章， 若推荐文章不足5篇， 则选取：最新文章 （补齐5篇）
    List<Blog> queryRecoUpdFive();

    //2、查询：通过（博客ID） 查询到（博客信息）
    Blog queryBlogInfoById(Long id);

    //3、查询：通过（typeId）查询到（博客信息）
    List<Blog> queryBlogsByTypeId(Long id);

    //4、查询：博客所有的年份
    List<Integer> queryBlogYears();

    //5、查询：通过（博客年份）， 查询所有博客
    List<Blog> queryBlogsByYear(Integer year);

    //6、查询：通过（搜索字符串），模糊查询（标题、内容、描述）包含的所有博客
    List<Blog> queryBlogsByQueryStr(String query);

    //7、更新：通过（博客id）， 更新博客（访问次数+1）
    int updateBlogViewsNumById(Long id);


    //8、查询：通过Search对象（title、typeName, recommend）, 查询博客信息
    List<Blog> queryBlogInfoBySearch(SearchBlogInfo searchInfo);

    //9、添加博客: 通过BlogInfo对象, 添加一个Blog
    Long addBlog(BlogInfo blogInfo);


    //10、更新博客：通过BlogInfo对象
    int updBlog(BlogInfo blogInfo);

    //11、删除博客：通过blogId
    int delBlogById(Long id);            //删除：blog


    //12、查询：所有博客信息
    List<Blog> queryAll();

    //13、查询：所有的BlogVO
    List<BlogVO> queryAllBlogVO(SearchBlogInfo searchBlogInfo);

    //14、更新博客按钮：通过(SwitchVO 按钮切换类)
    int updBlogSwitch(SwitchVO switchVO);

    //15、查询：博客总数目
    Long queryBlogsNum();
}
