package com.xlmkit.plugin.maven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodParameter {
    private String className;
    private String name;
}