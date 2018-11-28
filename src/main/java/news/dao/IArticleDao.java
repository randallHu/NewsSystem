package news.dao;

import news.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleDao {
    void addArticle(Article article);
    void deleteArticleById(Long id);
    List<Article> getAll();
    Article selectById(Long id);
}
