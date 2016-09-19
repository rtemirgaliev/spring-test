package com.rinat.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class Bootstrap implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootCtxCfg.class);
        container.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(JspServletCtxCfg.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("springDispatcher", new DispatcherServlet(servletContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
}


//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//public class Bootstrap extends AbstractAnnotationConfigDispatcherServletInitializer {
//protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[] {RootCtxCfg.class};
//        }
//
//protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[] {ServletCtxCfg.class};
//        }
//
//protected String[] getServletMappings() {
//        return new String[] {"/"};
//        }
//}
