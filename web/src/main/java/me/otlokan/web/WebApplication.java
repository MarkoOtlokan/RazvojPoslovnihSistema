package me.otlokan.web;

import me.otlokan.web.controller.ArticleController;
import me.otlokan.web.domain.Article;
import me.otlokan.web.service.ArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }


}
