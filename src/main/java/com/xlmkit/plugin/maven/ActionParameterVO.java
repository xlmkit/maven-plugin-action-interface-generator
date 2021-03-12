package com.xlmkit.plugin.maven;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActionParameterVO {
    private String className;
    private String id;
    private String name;
    private int level;
    private String pid;
    private String type;
    private boolean required;
    private String des;
    private List<ActionParameterVO> children = new ArrayList<ActionParameterVO>();
    private boolean isObject;
    private String objectClass;
    private boolean isArray;
    private String validations;
}