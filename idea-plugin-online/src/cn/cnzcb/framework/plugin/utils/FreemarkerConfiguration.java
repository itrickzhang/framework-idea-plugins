package cn.cnzcb.framework.plugin.utils;

import freemarker.template.Configuration;

public class FreemarkerConfiguration extends Configuration {
    private String basePackagePath;

    public FreemarkerConfiguration() {
        this("");
    }

    public FreemarkerConfiguration(String basePackagePath) {
        super(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        setClassForTemplateLoading(getClass(), basePackagePath);
    }
}
