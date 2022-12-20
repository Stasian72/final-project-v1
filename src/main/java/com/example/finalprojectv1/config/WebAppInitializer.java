package com.example.finalprojectv1.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    // описывает dispatcher servlet
        return new Class<?>[]{WebConfig.class};         // <servlet> tag in web.xml, возвращаем WebConfig
    }

    @Override
    protected String[] getServletMappings() {           // <servlet-mapping> tag in web.xml
        return new String[]{"/"};
    }
}


