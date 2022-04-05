package me.otlokan.web.service;

import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.Article;
import me.otlokan.web.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    @PostConstruct
    public void init() {
        add(new Article(1, "BMW", "automobil", 2000));
        add(new Article(2, "Mercedes", "automobil", 3000));
        add(new Article(3, "Audi", "automobil", 4000));
    }

    private final ArticleRepository repository;

    public Article add(final Article article) {
        return repository.save(article);
    }

    public List<Article> findAll() {
        return repository.findAll();
    }
}
