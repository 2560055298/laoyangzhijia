/**
 * Author: 老洋
 * Date:  2021/7/5 20:22
 */
package com.yyy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客 和 标签 （ID）表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndTag {
    private Long blogId;
    private Long tagId;
}