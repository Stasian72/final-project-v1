package com.example.finalprojectv1.security;

import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.repository.BookRepository;
import com.example.finalprojectv1.repository.OwnerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class AuthProviderImpl implements AuthenticationProvider {
    @Autowired  // внедряем бин userRepository
    private OwnerRepository repository;

    private Owner owner;


    @Override   // метод обрабатывает данные на аутентификацию email and passworf from sign_in.ftl
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();    // получаем параметр email
        Owner owner = repository.findByEmail(email);  // пытаемся достать пользователя по email
        if (owner == null) {                         // смотрим нашёлся ли пользователь
            throw new UsernameNotFoundException("Owner not found");  // если пользователя нет, то выбрасываем исключение
        }
        String password = authentication.getCredentials().toString();   // если есть, то береём пароль из формы
        if (!password.equals(owner.getPassword())) {                     // сравниваем пароль из формы с паролем из базы
            throw new BadCredentialsException("Bad credentials");       // если не совпадают, то выбрасываем исключение
        }
        this.owner = owner;
        List<GrantedAuthority> authorities = new ArrayList<>();         // пользователи, прошедшие аутентификацию
        return new UsernamePasswordAuthenticationToken(owner, null, authorities);    // пользователь авторизован
    }

    @Override
    public boolean supports(Class<?> authentication) {                                       // служебный метод
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
