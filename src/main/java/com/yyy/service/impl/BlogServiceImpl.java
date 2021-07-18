/**
 * Author: 老洋
 * Date:  2021/6/28 22:19
 */
package com.yyy.service.impl;

import com.yyy.mapper.BlogMapper;
import com.yyy.mapper.CommentMapper;
import com.yyy.mapper.TagMapper;
import com.yyy.mapper.TypeMapper;
import com.yyy.pojo.Blog;
import com.yyy.pojo.BlogAndTag;
import com.yyy.pojo.Type;
import com.yyy.pojo.User;
import com.yyy.service.BlogService;
import com.yyy.service.TypeService;
import com.yyy.vo.BlogInfo;
import com.yyy.vo.BlogVO;
import com.yyy.vo.SearchBlogInfo;
import com.yyy.vo.SwitchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客：业务层
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;              //博客：持久层

    @Autowired
    CommentMapper commentMapper;        //评论：持久层

    @Autowired
    TypeMapper typeMapper;

    @Value("${recommendsize}")
    private Integer recommentBlogNum;   //设置首页：最新最近的（博客数目）

    Logger logger = LoggerFactory.getLogger(getClass());

    //1、查询：最新推荐的（recommentBlogNum）篇文章 （默认为：5篇）
        // 当（推荐文章）不足（recommentBlogNum）篇， 则选取：最新文章 （补齐recommentBlogNum篇）
    @Override
    public List<Blog> queryRecoUpdFive() {
        List<Blog> blogs = blogMapper.selRecoUpdTitle(recommentBlogNum);   //查询5篇：最新推荐文章

        for (Blog b : blogs){
            logger.info("推荐文章 ===>>> " + b.getTitle() + "====>>> " +  b.getUser());
        }


        if(blogs.size() < recommentBlogNum){       //当：当（推荐文章）不足recommentBlogNum篇（默认为5）
            List<Blog> temp = blogMapper.selNewUpdTile(recommentBlogNum - blogs.size());

            for(Blog b1:temp){
                logger.info("最新文章 ===>>> " + b1.getTitle() + "====>>> " + b1.getUser());
            }
            blogs.addAll(temp);     //查询：（最新、非推荐）的文章补齐
        }

        for(Blog blog : blogs)      //为博客：设置总评论次数
            blog.setCommentNum(commentMapper.selComNumByBlogId(blog.getId()));

        return blogs;
    }

    //2、查询：通过（博客ID） 查询到（博客信息）
    @Override
    public Blog queryBlogInfoById(Long id) {
        return blogMapper.selBlogById(id);
    }

    @Override
    //3、查询：通过（typeId）查询到（博客信息）
    public List<Blog> queryBlogsByTypeId(Long id){
        List<Blog> blogs = blogMapper.selBlogsByTypeId(id);
        for (Blog blog:blogs){
            blog.setCommentNum(commentMapper.selComNumByBlogId(blog.getId()));
        }
        return blogs;
    }

    //4、查询：博客所有的年份
    @Override
    public List<Integer> queryBlogYears() {
        return blogMapper.selAllBlogYears();
    }

    //5、查询：通过（博客年份）， 查询所有博客
    @Override
    public List<Blog> queryBlogsByYear(Integer year) {
        return blogMapper.selAllBlogByYear(year);
    }

    //6、查询：通过（搜索字符串），模糊查询（标题、内容、描述）包含的所有博客
    @Override
    public List<Blog> queryBlogsByQueryStr(String query) {
        List<Blog> blogs = blogMapper.selAllBlogByQueryStr(query);

        for(Blog blog : blogs)      //为博客：设置总评论次数
            blog.setCommentNum(commentMapper.selComNumByBlogId(blog.getId()));

        return blogs;
    }

    //7、更新：通过（博客id）， 更新博客（访问次数+1）
    @Override
    public int updateBlogViewsNumById(Long id) {
        return blogMapper.updViewsNumById(id);
    }


    //8、查询：通过Search对象（title、typeName, recommend）, 查询博客信息
    @Override
    public List<Blog> queryBlogInfoBySearch(SearchBlogInfo searchInfo) {
        return blogMapper.selBlogsBySearchInfo(searchInfo);
    }

    //9、添加: 通过BlogInfo对象, 添加一个Blog, 返回博客（自增ID）
    @Override
    public Long addBlog(BlogInfo blogInfo) {
        Blog blog = new Blog(blogInfo.getTitle(), blogInfo.getContent(), blogInfo.getFirstPicture(), blogInfo.getFlag(), blogInfo.getDescription());


        logger.info("打印一下：发布信息 ====>>>> " + blogInfo.getPublished());

        //设置：发布状态
        if(blogInfo.getPublished() == null || blogInfo.getPublished().equals("")){
            blog.setPublished(true);         //发布
        }else if(blogInfo.getPublished().equals("false")){
            blog.setPublished(false);        //不发布
        }


        //设置：推荐
        if(blogInfo.getRecommend() == null || blogInfo.getRecommend().equals("")){
            blog.setRecommend(false);
        }else if(blogInfo.getRecommend().equals("on")){
            blog.setRecommend(true);
        }

        //设置：评论
        if(blogInfo.getCommentabled() == null || blogInfo.getCommentabled().equals("")){
            blog.setCommentabled(false);
        }else if(blogInfo.getCommentabled().equals("on")){
            blog.setCommentabled(true);
        }

        //设置：赞赏
        if(blogInfo.getAppreciation() == null || blogInfo.getAppreciation().equals("")){
            blog.setAppreciation(false);
        }else if(blogInfo.getAppreciation().equals("on")){
            blog.setAppreciation(true);
        }

        //设置版权
        if(blogInfo.getShareStatement() == null || blogInfo.getShareStatement().equals("")){
            blog.setShareStatement(false);
        }else if(blogInfo.getShareStatement().equals("on")){
            blog.setShareStatement(true);
        }


        Type type = new Type();                 //设置：类型id
        type.setId(blogInfo.getTypeId());
        blog.setType(type);

        User user = new User();                 //设置：用户id
        user.setId(blogInfo.getUid());
        blog.setUser(user);
        blogMapper.insertBlog(blog);
        return blog.getId();
    }


    //10、更新：通过BlogInfo对象
    @Override
    public int updBlog(BlogInfo blogInfo) {
        Blog blog = new Blog();
        blog.setId(blogInfo.getBid());
        blog.setTitle(blogInfo.getTitle());
        blog.setContent(blogInfo.getContent());
        blog.setFlag(blogInfo.getFlag());
        blog.setFirstPicture(blogInfo.getFirstPicture());
        blog.setDescription(blogInfo.getDescription());

        Type type = new Type();                 //设置：类型id
        type.setId(blogInfo.getTypeId());
        blog.setType(type);
        blog.setUpdateTime(new Date());

        //设置：发布状态
        if(blogInfo.getPublished() == null || blogInfo.getPublished().equals("")){
            blog.setPublished(true);         //发布
        }else if(blogInfo.getPublished().equals("false")){
            blog.setPublished(false);        //不发布
        }


        //设置：推荐
        if(blogInfo.getRecommend() == null || blogInfo.getRecommend().equals("")){
            blog.setRecommend(false);
        }else if(blogInfo.getRecommend().equals("on")){
            blog.setRecommend(true);
        }

        //设置：评论
        if(blogInfo.getCommentabled() == null || blogInfo.getCommentabled().equals("")){
            blog.setCommentabled(false);
        }else if(blogInfo.getCommentabled().equals("on")){
            blog.setCommentabled(true);
        }

        //设置：赞赏
        if(blogInfo.getAppreciation() == null || blogInfo.getAppreciation().equals("")){
            blog.setAppreciation(false);
        }else if(blogInfo.getAppreciation().equals("on")){
            blog.setAppreciation(true);
        }

        //设置版权
        if(blogInfo.getShareStatement() == null || blogInfo.getShareStatement().equals("")){
            blog.setShareStatement(false);
        }else if(blogInfo.getShareStatement().equals("on")){
            blog.setShareStatement(true);
        }


        return blogMapper.updateBlogByBlog(blog);
    }


    //11、删除博客：通过blogId
    @Override
    public int delBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }

    //12、查询：所有博客信息
    @Override
    public List<Blog> queryAll() {
        return blogMapper.selAllBlog();
    }

    //13、查询：所有的BlogVO
    @Override
    public List<BlogVO> queryAllBlogVO(SearchBlogInfo searchBlogInfo) {
        List<Blog> blogs = blogMapper.selBlogsBySearchInfo(searchBlogInfo);
        List<BlogVO> blogVOs = new ArrayList<>();

        for(Blog blog:blogs){
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(blog, blogVO);
            blogVO.setTypeName(blog.getType().getName());
            blogVOs.add(blogVO);
        }
        return blogVOs;
    }

    //14、更新博客按钮：通过(SwitchVO 按钮切换类)
    @Override
    public int updBlogSwitch(SwitchVO switchVO) {
        return blogMapper.updateBlogBySwitchVO(switchVO);
    }

    //15、查询：博客总数目
    @Override
    public Long queryBlogsNum() {
        return blogMapper.selBlogNums();
    }

}

