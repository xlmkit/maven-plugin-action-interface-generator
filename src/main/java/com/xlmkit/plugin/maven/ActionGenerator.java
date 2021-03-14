package com.xlmkit.plugin.maven;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import jodd.http.HttpRequest;
import jodd.io.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.logging.Log;

/**
 *
 */
public class ActionGenerator {


    private ActionGeneratorConfig config;
    private Log log;

    public ActionGenerator(ActionGeneratorConfig config, Log log) {
        super();
        this.config = config;
        this.log = log;
    }

    public void log(String message) {
        log.info(message);
    }

    public void run() throws Exception {
        log("start");

        config.validate();
        HttpRequest request = HttpRequest.post(config.getGroupUrl() + "?no=" + config.getNo());
        log.info(request.toString());
        String body = new String(request.send().bodyBytes(), StandardCharsets.UTF_8);
        List<ActionVO> actionVOList = JSONArray.parseArray(body,ActionVO.class);
//        JSONArray.parse

        for (ActionVO actionVo: actionVOList) {
            if (actionVo.getItems() == null || actionVo.getItems().size() == 0) {
                continue;
            }
            actionVo.setJavaClassName(actionVo.getName().endsWith("Action") ? actionVo.getName() : (actionVo.getName() + "Action"));

            for (ActionMethodVO methodVo : actionVo.getItems()) {
                methodVo.setParams(CodeUtil.toParams(methodVo.getParams()));
                methodVo.setOutParams(CodeUtil.toParams(methodVo.getOutParams()));
                methodVo.setJavabBodyName(Util.upperFirstLatter(methodVo.getName()) + "Body");
                methodVo.setJavaResultName(Util.upperFirstLatter(methodVo.getName()) + "Result");

                methodVo.setParamsCode(CodeUtil.getParamsCode(2, false, methodVo.getJavabBodyName(),
                        methodVo.getParams(), null));


                if (config.isGenerateReturn()) {
                    methodVo.setReturnParamsCode(CodeUtil.getParamsCode(2, false, methodVo.getReturnParamsCode(),
                            methodVo.getOutParams(), config.getResultHelperName()));
                }


            }
            String javaCode = modelJavaCode(actionVo);
            String absName = config.getPackageName().replaceAll("\\.", "/") + "/" + actionVo.getJavaClassName() + ".java";
            File file = new File( config.getDistDirectory(),absName);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            log.info("write java file,file:" + file);
            FileUtil.writeString(file, javaCode);

        }
        log("end");
    }

    public String modelJavaCode(ActionVO actionVO) throws Exception {
        XStringBuilder sb = new XStringBuilder();
        sb.append("package {};", config.getPackageName());
        sb.append("import com.xlmkit.springboot.action.Result;");
        sb.append("import lombok.Getter;");
        sb.append("import lombok.Data;");
        sb.append("import javax.servlet.http.*;");
        sb.append("import java.util.List;");
        sb.append("import com.alibaba.fastjson.JSONObject;");
        sb.append("import com.alibaba.fastjson.JSONArray;");
        sb.append("import java.util.Map;");
        sb.append("import java.util.Date;");
        sb.append("import javax.validation.constraints.*;");
        sb.append("import java.math.BigInteger;");
        sb.append("import java.math.BigDecimal;");
        sb.append("import javax.validation.Valid;");
        sb.append("/**");
        sb.append(" * ");
        sb.append(" * ");
        sb.append(" *");
        sb.append(" */");
        sb.append("public interface {} {", actionVO.getJavaClassName());
        for (ActionMethodVO methodVO : actionVO.getItems()) {


            sb.append("	/**");
            sb.append("	*{}", methodVO.getJavabBodyName());
            sb.append("	*/");
            sb.append("    {}", methodVO.getParamsCode());
            if (config.isGenerateReturn()) {
                sb.append("    {}", methodVO.getReturnParamsCode());
            }
            sb.append("	/**");
            sb.append("	 * {}", methodVO.getDes());
            sb.append("	 */");
            if (config.isGenerateReturn()) {
                sb.append("	{}", methodVO.getJavaResultName());
            } else {
                sb.append("	Result");
            }
            sb.append(" {} 	(", methodVO.getName());
            if (!StringUtils.isEmpty(config.getCustomParameters())) {
                sb.append("{},", config.getCustomParameters());
            }

            if (methodVO.getOptions() != null && methodVO.getOptions().contains(config.getSessionOptionName())) {

                sb.append("{},", config.getSessionParameters());
            }
            sb.append("		{} body", methodVO.getJavabBodyName());
            sb.append("		) throws {} ;", config.getExceptionName());
        }

        sb.append("}");
        return sb.toStringUseJavaFormat();
    }
}
