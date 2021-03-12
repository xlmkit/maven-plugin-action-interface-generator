package com.xlmkit.plugin.maven;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 蔡小龙
 * @Date: 2021/3/12 14:13
 * @Description: 接口组VO类
 */
@Data
public class ActionVO {
    /**
     * 名称
     */
    private String name;


    /**
     * java类名
     */
    private String javaClassName;

    /**
     * 方法列表
     */
    private List<ActionMethodVO> items = new ArrayList<>();

}
