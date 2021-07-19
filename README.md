<p align="center">
    <img width="130" src="https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/111.jpg">
</p>
<h1 align="center" style="color:#99d9ea">老洋之家</h1>
<p>
  <a href="https://www.laoyangzhijia.com"><img src="https://img.shields.io/badge/%E8%80%81%E6%B4%8B%E4%B9%8B%E5%AE%B6-%E4%B8%AA%E4%BA%BA%E7%AB%99%E7%82%B9-brightgreen" alt="网站地址"></a>
  <a href="www.laoyangzhijia.com"><img src="https://img.shields.io/badge/%E8%80%81%E6%B4%8B%E4%B9%8B%E5%AE%B6-%E9%A1%B9%E7%9B%AE%E5%B1%95%E7%A4%BA-blueg" alt="项目展示"></a>
    <a href="https://gitee.com/sheep-are-flying-in-the-sky/laoyangzhijia"><img src="https://img.shields.io/badge/gitHub-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-red" alt="gitHub"></a>
  <a href="https://gitee.com/sheep-are-flying-in-the-sky/laoyangzhijia"><img src="https://img.shields.io/badge/%E7%A0%81%E4%BA%91-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-orange" alt="码云"></a>
</p>


## 友情提示

> 1. **项目部署教程**：[在线访问地址](http://www.macrozheng.com/admin/index.html)。
> 2. **项目部署文档**：[在线访问地址](http://www.macrozheng.com/admin/index.html)。
> 3. **项目开发文档**：[在线访问地址](http://www.macrozheng.com/admin/index.html)。



## 创建背景

之前在：CSDN、博客园写博客。<br/>
写了2年多后，有了想自己搭建博客的冲动。 毕竟 "租房"总是让人感到没有"归属感"。<br/>
于是我尝试过：用Hexo搭建静态博客，托管到GitHub上, 虽然轻巧炫酷，但体验后，才知：文章管理之不便。<br/>
因此：便开始创建（老洋之家）个人博客的征途。






## 项目介绍

`老洋之家`项目是一个（个人博客系统），包括前台博客页面及后台管理系统，基于SpringBoot+MyBatis实现，采用Tomcat容器部署。<br/>

前台博客页面包含：首页、博客分类、归档页面、关于我页面、搜索页面、登录页面。<br/>

后台管理系统包含：博客管理、分类管理、标签管理、用户管理 <br/>



### 项目演示

项目演示地址： [http://www.macrozheng.com/admin/index.html](http://www.macrozheng.com/admin/index.html)  

> 前台：博客页面

<img src="https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/image-20210716205355695.png" alt="image-20210716205355695" style="zoom: 80%;" />

> 后台：管理系统

![image-20210717094356930](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/image-20210717094356930.png)



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
| LayUi       | 路由框架        | https://www.layui.com/                               |
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

<img src="https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/image-20210719222014411.png" alt="image-20210719222014411" style="zoom: 80%;" />





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

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 5.0    | https://redis.io/download                                    |
| MongoDB       | 4.2.5  | https://www.mongodb.com/download-center                      |
| RabbitMQ      | 3.7.14 | http://www.rabbitmq.com/download.html                        |
| Nginx         | 1.10   | http://nginx.org/en/download.html                            |
| Elasticsearch | 7.6.2  | https://www.elastic.co/downloads/elasticsearch               |
| Logstash      | 7.6.2  | https://www.elastic.co/cn/downloads/logstash                 |
| Kibana        | 7.6.2  | https://www.elastic.co/cn/downloads/kibana                   |



### 搭建步骤

> Windows环境部署

- Windows环境搭建请参考：[mall在Windows环境下的部署](http://www.macrozheng.com/#/deploy/mall_deploy_windows);
- 注意：只启动mall-admin,仅需安装Mysql、Redis即可;
- 克隆`mall-admin-web`项目，并导入到IDEA中完成编译：[前端项目地址](https://github.com/macrozheng/mall-admin-web);
- `mall-admin-web`项目的安装及部署请参考：[mall前端项目的安装与部署](http://www.macrozheng.com/#/deploy/mall_deploy_web)。

> Docker环境部署

- 使用虚拟机安装CentOS7.6请参考：[虚拟机安装及使用Linux，看这一篇就够了](http://www.macrozheng.com/#/reference/linux_install);
- Docker环境的安装请参考：[开发者必备Docker命令](http://www.macrozheng.com/#/reference/docker);
- 本项目Docker镜像构建请参考：[使用Maven插件为SpringBoot应用构建Docker镜像](http://www.macrozheng.com/#/reference/docker_maven);
- 本项目在Docker容器下的部署请参考：[mall在Linux环境下的部署（基于Docker容器）](http://www.macrozheng.com/#/deploy/mall_deploy_docker);
- 本项目使用Docker Compose请参考： [mall在Linux环境下的部署（基于Docker Compose）](http://www.macrozheng.com/#/deploy/mall_deploy_docker_compose);
- 本项目在Linux下的自动化部署请参考：[mall在Linux环境下的自动化部署（基于Jenkins）](http://www.macrozheng.com/#/deploy/mall_deploy_jenkins);





## 许可证

[Apache License 2.0](https://github.com/macrozheng/mall/blob/master/LICENSE)

Copyright (c) 2018-2021 macrozheng
