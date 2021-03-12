package com.xlmkit.plugin.maven;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 蔡小龙
 * @Date: 2021/3/12 14:13
 * @Description: 接口组单个方法VO类
 */
@Data
public class ActionMethodVO {


    /**
     * 方法名称
     */
    private String name;

    /**
     * 请求参数
     */
    private List<ActionParameterVO> params;

    /**
     * 相应参数
     */
    private List<ActionParameterVO> outParams;


    /**
     * 参数名
     */
    private String javabBodyName;

    /**
     * 返回值名称
     */
    private String javaResultName;

    /**
     * 方法参数解析后代码
     */
    private String paramsCode;
    /**
     * 方法返回值解析后代码
     */
    private String returnParamsCode;
    /**
     * 方法描述
     */
    private String des;
    /**
     * 方法其他配置
     */
    private List<String> options = new ArrayList<>();
    /**
     * 自定义增加的参数
     */
    private List<MethodParameter> customParameters = new ArrayList<>();

}
