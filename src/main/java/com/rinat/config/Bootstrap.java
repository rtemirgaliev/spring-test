package com.rinat.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class Bootstrap implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootCtxCfg.class);
        container.addListener(new ContextLoaderListener(rootContext));

        ServletRegistration.Dynamic dispatcher;
                
        AnnotationConfigWebApplicationContext jspContext = new AnnotationConfigWebApplicationContext();
        jspContext.register(JspServletCtxCfg.class);
        dispatcher = container.addServlet("jspDispatcher", new DispatcherServlet(jspContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.setMultipartConfig(new MultipartConfigElement(null, 20_971_520L, 41_943_040L, 512_000));
        dispatcher.addMapping("/jsp/*");

        AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
        restContext.register(RestServletCtxCfg.class);
        DispatcherServlet restDispatcherServlet = new DispatcherServlet(restContext);
        //by default dispatcher servlet ignores OPTIONS request
        //here we tell him to dispatch OPTIONS requests to our Rest endpoint methods
        restDispatcherServlet.setDispatchOptionsRequest(true);
        dispatcher = container.addServlet("springRestDispatcher", restDispatcherServlet);
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/rest/*");


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
