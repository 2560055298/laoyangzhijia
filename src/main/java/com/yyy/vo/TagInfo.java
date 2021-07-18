/**
 * Author: 老洋
 * Date:  2021/7/6 8:53
 */
package com.yyy.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * 用于后端：（博客添加、博客更新）时，标签多选框，用axios的异步传输封装数据所用
 */
public class TagInfo {
    private String  name;
    private Integer value;
}