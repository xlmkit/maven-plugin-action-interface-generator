package com.xlmkit.plugin.maven;

import formatter.java.org.eclipse.jface.text.Document;
import formatter.java.org.eclipse.jface.text.IDocument;
import formatter.java.org.eclipse.text.edits.TextEdit;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.slf4j.helpers.*;

/**
 * @Author: 蔡小龙
 * @Date: 2021/3/12 14:23
 * @Description: 代码构建器
 */
public class XStringBuilder {
	private StringBuilder code = new StringBuilder();

	/**
	 * 一行一行写入
	 * @param str
	 * @param args
	 */
	public void append(String str, Object... args) {
		code.append(MessageFormatter.arrayFormat(str, args).getMessage());
		code.append("\n");
	}
	@Override
	public String toString() {
		return code.toString();
	}

	/**
	 * java格式化输出
	 * @return
	 * @throws Exception
	 */
	public String toStringUseJavaFormat() throws Exception{
		String code = toString();
		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, code, 0, code.length(), 0, null);
		IDocument doc = new Document(code);
		textEdit.apply(doc);
		return doc.get();
	}

}
