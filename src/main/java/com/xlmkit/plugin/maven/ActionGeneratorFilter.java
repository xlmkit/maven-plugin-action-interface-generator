package com.xlmkit.plugin.maven;

public interface ActionGeneratorFilter {
	void beforeMethod(ActionVO actionVO, ActionMethodVO methodVO);
}
