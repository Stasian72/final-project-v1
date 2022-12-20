package com.example.finalprojectv1.controller;

import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.service.BookService;
import com.example.finalprojectv1.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//@RequestMapping("/api/v3")
@Controller
public class AuthController {

    @Autowired                      // внедряем ранее созданный бин userService
    private OwnerService service;

    @GetMapping("/api/v3/sign_up")    // возвращает страницу, заполнив которую мы вызовем метод POST
    public String getSignUp(Model model) {
        model.addAttribute("owner",new Owner());
        return "/auth/sign_up";          // View для вызова метода POST
    }

    @PostMapping("/api/v3/sign_up")                         // handler по регистрации
    public String signUp(@ModelAttribute Owner owner) {   // блягодаря @ModelAttribute мы создаем нового USER
        // с параметрами, которые указали в sign_up.ftl
        service.addOwner(owner);                              // добавляем в БД через service
        return "redirect:/api/v3/login";                       // повторно вызываем метод GET getUsers() по endpoint ("/users")
        // и возвращает новый список
    }

    @RequestMapping("/api/v3/login")
    public String login(){
        return "/auth/sign_in";                          // возвращает страничку для логина или аутентификации
    }
}
