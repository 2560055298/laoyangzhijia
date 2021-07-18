/**
 * Author: 老洋
 * Date:  2021/7/9 17:18
 */
package com.yyy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于后台：显示（标签）数据表格（传输json信息所用）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVO {
    private Long id;                //标签的：ID
    private String name;            //标签的：名称
    private Integer blogNums;       //该标签拥有的：博客数目
}