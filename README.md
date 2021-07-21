<p align="center">
    <img width="130" src="https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/111.jpg">
</p>
<h1 align="center" style="color:#99d9ea">老洋之家</h1>
<p>
  <a href="https://www.laoyangzhijia.com"><img src="https://img.shields.io/badge/%E8%80%81%E6%B4%8B%E4%B9%8B%E5%AE%B6-%E4%B8%AA%E4%BA%BA%E7%AB%99%E7%82%B9-brightgreen" alt="网站地址"></a>
  <a href="https://www.bilibili.com/video/BV1Yv411E7Gf"><img src="https://img.shields.io/badge/%E8%80%81%E6%B4%8B%E4%B9%8B%E5%AE%B6-%E9%A1%B9%E7%9B%AE%E5%B1%95%E7%A4%BA-blueg" alt="项目展示"></a>
    <a href="https://github.com/2560055298/laoyangzhijia"><img src="https://img.shields.io/badge/gitHub-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-red" alt="gitHub"></a>
  <a href="https://gitee.com/sheep-are-flying-in-the-sky/laoyangzhijia"><img src="https://img.shields.io/badge/%E7%A0%81%E4%BA%91-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-orange" alt="码云"></a>
</p>




## 友情提示

> 1. **项目部署教程**：[在线访问地址](https://www.bilibili.com/video/BV1Yv411E7Gf)。
> 2. **项目部署文档**：[在线访问地址](https://2560055298.github.io/laoyangDeployDoc/#/)。
> 3. **项目开发文档**：[在线访问地址](https://2560055298.github.io/laoyangzhijiaDoc/)。
> 4. **开发过程遇到的（问题）**：[在线访问地址](https://2560055298.github.io/laoyangProblem/)。



## 创建背景

之前在：CSDN、博客园写博客。<br/>
写了2年多后，有了想自己搭建博客的冲动。 毕竟 "租房"总是让人感到没有"归属感"。<br/>
于是我尝试过：用Hexo搭建静态博客，托管到GitHub上, 虽然轻巧炫酷，但体验后，才知：文章管理之不便。<br/>
因此：便开始创建（老洋之家）个人博客的征途。






## 项目介绍

`老洋之家`项目是一个（个人博客系统），包括前台博客页面及后台管理系统，基于SpringBoot+MyBatis实现，采用Tomcat容器部署。<br/>

前台博客页面包含：首页、博客文章页面、博客分类、归档页面、关于我页面、搜索页面、登录页面。<br/>

后台管理系统包含：博客管理、分类管理、标签管理、用户管理 <br/>



### 项目演示

项目演示地址： 

> 前台：博客页面

![front_index](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/front_index.png)





> 后台：管理系统

![after_index](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/after_index.png)



### 组织结构

``` lua
laoyangzhijia
├── src -- 源代码
├── blog.sql -- 数据库表
├── pom.xml -- 依赖配置文件
```



### 技术选型


#### 前端技术

| 技术        | 说明            | 官网                                                 |
| ----------- | --------------- | ---------------------------------------------------- |
| Semantic UI | 前端框架        | https://semantic-ui.com/                             |
| LayUi       | 前端框架        | https://www.layui.com/                               |
| X-admin     | 后台模板        | https://gitee.com/daniuit/X-admin?_from=gitee_search |
| jQuery      | JavaScript 库   | https://github.com/jquery/jquery                     |
| Editormd    | Markdown 编辑器 | https://pandao.github.io/editor.md/                  |




#### 后端技术

| 技术       | 说明                | 官网                                           |
| ---------- | ------------------- | ---------------------------------------------- |
| SpringBoot | 容器+MVC框架        | https://spring.io/projects/spring-boo          |
| MyBatis    | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html |
| SLF4J      | 日志门面            | http://www.slf4j.org/                          |
| Logback    | 日志技术            | http://logback.qos.ch/                         |
| Lombok     | 简化对象封装工具    | https://github.com/rzwitserloot/lombok         |
| PageHelper | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |



#### 架构图



##### 业务架构图

![下载](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/%E4%B8%8B%E8%BD%BD.png)





##### 数据库E-R图

<img src="https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/image-20210717173057950.png" alt="image-20210717173057950" style="zoom: 50%;" />





## 环境搭建

### 开发工具

| 工具          | 说明                | 官网                                            |
| ------------- | ------------------- | ----------------------------------------------- |
| IDEA          | 开发IDE             | https://www.jetbrains.com/idea/download         |
| Navicat   | 数据库连接工具    | http://www.formysql.com/xiazai.html             |                                               |
| X-shell       | Linux远程连接工具   | http://www.netsarang.com/download/software.html |
| Xftp | Linux远程传输工具 | https://www.netsarang.com/zh/xftp/ |
| ProcessOn     | 流程图绘制工具      | https://www.processon.com/                      |
| Snipaste  | 屏幕截图工具      | https://www.snipaste.com/                       |
| Typora | Markdown编辑器 | https://typora.io/ |


### 开发环境

| 工具  | 版本号 | 下载                                                         |
| ----- | ------ | ------------------------------------------------------------ |
| JDK   | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql | 8.0    | https://www.mysql.com/                                       |


## 参考
- 李仁密老师：[博客教程](https://www.bilibili.com/video/BV1HE411N76x)

