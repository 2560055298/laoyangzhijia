/**
 * Author: 老洋
 * Date:  2021/7/7 21:55
 */
package com.yyy.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 按钮：状态切换类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwitchVO {
    private Long blogId;            //blogId
    private String switchName;      //按钮名称
    private Boolean switchState;    //切换：按钮状态
}