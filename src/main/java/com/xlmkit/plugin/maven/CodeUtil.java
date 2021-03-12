package com.xlmkit.plugin.maven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;

import com.alibaba.fastjson.JSON;

import formatter.java.org.eclipse.jface.text.Document;
import formatter.java.org.eclipse.jface.text.IDocument;
import formatter.java.org.eclipse.text.edits.TextEdit;

public class CodeUtil {


	public static String getParamsCode(int lomType, boolean valid, String rootClass, List<ActionParameterVO> list, String rootExtends) {

		StringBuilder code = new StringBuilder();
		doList(lomType, valid, code, rootClass, list, rootExtends);
		return code.toString();
	}

	public static List<ActionParameterVO> toParams(List<ActionParameterVO> list) {
		ActionParameterVO root = new ActionParameterVO();
		root.setClassName("Root");
		Map<String, ActionParameterVO> paramMap = new HashMap<>();
		paramMap.put("0", root);
		for (ActionParameterVO param : list) {
			param.setPid(StringUtils.isEmpty(param.getPid()) ? "0" : param.getPid());
			ActionParameterVO parent = paramMap.get(param.getPid());
			parent.getChildren().add(param);
			paramMap.put(param.getId(), param);

			if (param.getType().equals("{}")) {
				param.setObject(true);
				param.setClassName(Util.upperFirstLatter(param.getName()));
				param.setObjectClass(param.getClassName());
			} else if (param.getType().equals("[]")) {
				param.setArray(true);
				param.setObject(true);
				param.setObjectClass(Util.upperFirstLatter(param.getName()));
				param.setClassName("List<" + param.getObjectClass() + ">");
			} else if (param.getType().startsWith("[")) {
				param.setArray(true);
				param.setObjectClass(param.getType().substring(1, param.getType().length() - 1));
				param.setClassName("List<" + param.getObjectClass() + ">");
			} else {
				param.setObjectClass(param.getType());
				param.setClassName(param.getType());
			}
		}
		return paramMap.get("0").getChildren();
	}

	public static List<ActionParameterVO> toParams(String json) {
		return toParams(JSON.parseArray(json, ActionParameterVO.class));

	}

	private static void doList(int lomType, boolean valid, StringBuilder code, String parent, List<ActionParameterVO> list,
			String rootExtends) {
		if (lomType == 1) {
			code.append("@lombok.Getter\n");
		} else {
			code.append("@lombok.Data\n");
		}

		code.append("public static class " + parent);
		if (!StringUtils.isEmpty(rootExtends)) {
			code.append(" extends " + rootExtends + "<"+parent+"> ");
		}
		code.append(" {\n");
		// com.xlmkit.hrdn.sdk.ResultHelper

		for (ActionParameterVO param : list) {
			String validations = param.getValidations();
			if (valid && !StringUtils.isEmpty(validations)) {
				validations = validations.trim();
				for (String item : validations.split("\n")) {
					item = item.trim();
					if (!StringUtils.isEmpty(item)) {
						code.append(item + "\n");
					}
				}
			}
			if (param.getType().equals("{}")) {
				if (valid) {
					code.append("@Valid\n");
				}

			}
			if (param.getType().equals("[]")) {
				if (valid) {
					code.append("@Valid\n");
				}
			}
			code.append("private " + param.getClassName() + " " + param.getName() + ";\n");

		}
		for (ActionParameterVO param : list) {
			if (param.isObject()) {
				doList(lomType, valid, code, param.getObjectClass(), param.getChildren(), null);
			}
		}
		code.append("}\n");
	}



}
