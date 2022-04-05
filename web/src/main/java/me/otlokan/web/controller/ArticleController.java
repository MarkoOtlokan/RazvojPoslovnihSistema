package me.otlokan.web.controller;

import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.Article;
import me.otlokan.web.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @PostMapping
    public Article add(@RequestBody final Article article) {
        return service.add(article);
    }

    @GetMapping
    public List<Article> findAll() {
        return service.findAll();
    }

}
