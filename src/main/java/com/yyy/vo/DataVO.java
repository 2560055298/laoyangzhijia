/**
 * Author: 老洋
 * Date:  2021/7/6 22:13
 */
package com.yyy.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 用于：Layui数据表格（异步传输：显示数据）
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

}
