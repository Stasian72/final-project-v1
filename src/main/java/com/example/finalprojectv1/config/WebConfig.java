package com.example.finalprojectv1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;


@Configuration                                      // поскольку это конфигурационный файл
@EnableWebMvc                                       // соответствует <mvc:annotation-driven/> в dispatcher-servlet.xml
@ComponentScan("com.example.finalprojectv1")

public class WebConfig implements WebMvcConfigurer {
    @Bean                                                                   // создаём бин viewResolver
    public FreeMarkerViewResolver viewResolver() {                          // c типом FreeMarkerViewResolver
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver(); // создаём объект viewResolver
        viewResolver.setSuffix(".ftl");                                     // добавляем суффикс к viewResolver
        viewResolver.setContentType("text/html;charset=UTF-8");             // добавляем тип контента к viewResolver
        viewResolver.setCache(false);                                       // не кешируем запросы
        return viewResolver;                                                // возвращаем сконфигурированный объект
    }

    @Bean                                                                   // создаём бин freeMarkerConfigurer
    public FreeMarkerConfigurer freeMarkerConfigurer() {                    // c типом FreeMarkerConfigurer
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();       // создаём объект configurer
        configurer.setTemplateLoaderPath("/WEB-INF/templates");             // указываем путь к темплейтам
        configurer.setDefaultEncoding("UTF-8");                             // ставим конфигурацию по-умолчанию
        Properties properties = new Properties();
        properties.put("default_encoding", "UTF-8");
//        configurer.setFreemarkerSettings(new Properties(){{
//            this.put("default_encoding", "UTF-8");                          // настраиваем свойства через ключ-значение
//        }});
        configurer.setFreemarkerSettings(properties);
        return configurer;                                                  // возвращаем бин freeMarkerConfigurer
    }

}
