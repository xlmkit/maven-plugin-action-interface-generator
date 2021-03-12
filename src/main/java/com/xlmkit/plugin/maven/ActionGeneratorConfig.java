package com.xlmkit.plugin.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

@Data
public class ActionGeneratorConfig {

    private String groupUrl = "https://gateway.openno.cn/API/fastcode.prod/groups";
    private String no;
    private String packageName;
    private File distDirectory;
    private Class<?> sessionClass = Object.class;
    private boolean generateReturn;
    private Map<String, Class<?>> sessionClassMap = new HashMap<String, Class<?>>();
    private List<ActionGeneratorFilter> filters = new ArrayList<ActionGeneratorFilter>();
    private String exceptionName = "com.xlmkit.springext.sdk.SDKException";
    private String resultHelperName = "ResultHelper";

    public void validate() {
        Assert.isTrue(!StringUtils.isEmpty(groupUrl), "[url] is empty!");
        Assert.isTrue(!StringUtils.isEmpty(no), "[no] is empty!");
        Assert.isTrue(!StringUtils.isEmpty(packageName), "[packageName] is empty!");
        Assert.isTrue(distDirectory != null, "[distDirectory] is empty!");
    }

    public Class<?> getSessionClass(String name) {
        return sessionClassMap.getOrDefault(name, sessionClass);
    }

}
