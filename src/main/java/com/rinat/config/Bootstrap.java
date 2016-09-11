package com.rinat.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Bootstrap extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootCtxCfg.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {ServletCtxCfg.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
