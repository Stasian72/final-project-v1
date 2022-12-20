package com.example.finalprojectv1.config;

import com.example.finalprojectv1.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration      // поскольку это конфигурационный файл
@EnableWebSecurity  // для того, чтобы работал Spring Security
@ComponentScan("com.example.finalprojectv1.security")
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired      // внедряем бин authProvider
    private AuthProviderImpl authProvider;



    @Override
    protected void configure(HttpSecurity http) throws Exception {  // описываем разделение доступа к различным хендлерам
        http.authorizeRequests()
//                .antMatchers("/api/v3/sign_up", "/api/v3/login","/api/v1","/api/v2").anonymous()// адрема для неавторизованных пользователей
                .antMatchers("/api/v3/sign_up", "/api/v3/login").anonymous()
                .antMatchers("/api/v3/books/all", "/api/v3/books/new","/api/v3/books", "/api/v3", "/api/v3/").authenticated()           // адрема для авторизованных пользователей
                .and().csrf().disable()                                     // отключаем временно csrf
                .formLogin()                                                // указываем форму логина
                .loginPage("/api/v3/login")                                        // указываем страницу логина
//                .loginPage("/login")
                .loginProcessingUrl("/api/v3/login/process")// адрес для обработки
//                .loginProcessingUrl("/login/process")
                .failureUrl("/api/v3/sign_up")
                .usernameParameter("email")// используем email вместо username
//                .failureUrl("/api/v3/sign_up")
                .and().logout(); // добавляем возможность разлогиниться


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  // конфигурируется AuthenticationProvider
        auth.authenticationProvider(authProvider);                                  // предоставляем authProvider
    }
}
