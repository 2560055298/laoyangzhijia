/**
 * Author: 老洋
 * Date:  2021/7/9 6:48
 */
package com.yyy.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于后台：显示（分类）数据表格（传输json信息所用）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeVO{
    private Long id;                //分类的：ID
    private String name;            //分类的：名称
    private Integer blogNums;        //该分类拥有的：博客数目
}