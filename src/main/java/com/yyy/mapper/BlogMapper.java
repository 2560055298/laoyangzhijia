package com.yyy.mapper;
import com.yyy.pojo.Blog;
import com.yyy.vo.SearchBlogInfo;
import com.yyy.vo.SwitchVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
    //1、查询：（最新推荐）的num篇文章
    List<Blog> selRecoUpdTitle(int num);

    //2、查询：（最新、不推荐）的num篇文章
    List<Blog> selNewUpdTile(int num);

    //3、查询：（博客ID） 查询博客信息
    Blog selBlogById(Long id);

    //4、查询所有的博客
    List<Blog> selAllBlog();

    //5、查询：通过（typeId）查询到（博客信息）
    List<Blog> selBlogsByTypeId(Long id);

    //6、查询：博客所有的年份
    List<Integer> selAllBlogYears();

    //7、查询：通过（博客年份）， 查询所有博客
    List<Blog> selAllBlogByYear(Integer year);

    //8、查询：通过（搜索字符串），模糊查询（标题、内容、描述）包含的所有博客
    List<Blog> selAllBlogByQueryStr(String query);

    //7、更新：通过（博客id）， 更新博客（访问次数+1）
    int updViewsNumById(Long id);


    //8、查询：通过Search对象（title、typeName, recommend）, 查询博客信息
    List<Blog> selBlogsBySearchInfo(SearchBlogInfo searchInfo);

    //9、添加: 通过Blog对象, 并返回博客（自增ID）
    Long insertBlog(Blog blog);

    //10、更新：通过Blog对象
    int updateBlogByBlog(Blog blog);

    //11、删除博客：通过blogId
    int deleteBlogById(Long id);

    //12、更新博客按钮：通过(SwitchVO 按钮切换类)
    int updateBlogBySwitchVO(SwitchVO switchVO);

    //13、查询：通过（tagId）查询到（博客的数目）
    int selBlogsByTagId(Long id);

    //15、查询：博客总数目
    Long selBlogNums();

}
