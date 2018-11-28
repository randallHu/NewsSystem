package news.service;

import news.model.Article;

import java.util.List;

public interface IArticleService {
    void addArticle(Article article);
    Article selectById(Long id);

    void deleteArticleById(Long id);

    List<Article> getAll();
}
