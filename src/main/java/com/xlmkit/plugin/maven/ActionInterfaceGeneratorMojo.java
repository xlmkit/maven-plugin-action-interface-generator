package com.xlmkit.plugin.maven;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 *
 * @author 蔡小龙
 *
 */
@Data
@Mojo(name = "generate")
public class ActionInterfaceGeneratorMojo extends AbstractMojo {

    public static final String GROUP_URL = "https://gateway.openno.cn/API/fastcode.prod/groups";
    public static final String DIST_PATH = "src/main/java";
    public static final String EXCEPTION_NAME = "com.xlmkit.springext.sdk.SDKException";
    public static final String RESULT_HELPER_NAME = "ResultHelper";
    public static final String GENERATERE_TURN = "false";

    @Parameter
    private String distPath = System.getProperty("distPath",DIST_PATH);
    @Parameter
    private String groupUrl = System.getProperty("groupUrl",GROUP_URL);
    @Parameter
    private String no = System.getProperty("no");
    @Parameter
    private String packageName = System.getProperty("packageName");
    @Parameter
    private String exceptionName = System.getProperty("exceptionName",EXCEPTION_NAME);
    @Parameter
    private String resultHelperName = System.getProperty("resultHelperName",RESULT_HELPER_NAME);
    @Parameter
    private boolean generateReturn = Boolean.parseBoolean(System.getProperty("generateReturn",GENERATERE_TURN));
    @Override
    public void execute() throws MojoExecutionException {

        String basePath = new File("").getAbsolutePath();
        getLog().info("execute");
        System.out.println("execute");
        ActionGeneratorConfig config = new ActionGeneratorConfig();
        config.setGroupUrl(groupUrl);
        config.setNo(no);
        config.setPackageName(packageName);
        config.setDistDirectory(new File(basePath, distPath));
        config.setExceptionName(exceptionName);
        config.setResultHelperName(resultHelperName);
        config.setGenerateReturn(generateReturn);
        try {
            getLog().info("config=" + JSON.toJSONString(config, true));
            new ActionGenerator(config, getLog()).run();
            System.out.println("execute");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
