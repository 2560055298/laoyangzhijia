/**
 * Author: 老洋
 * Date:  2021/6/4 20:15
 */
package com.yyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章：标签类
 */

@Data                   //get、set、toString
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
public class Tag {
    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();   // 多个标签 <===> 多篇博客
}