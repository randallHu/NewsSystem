package news.service.impl;

import news.dao.IArticleDao;
import news.model.Article;
import news.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private IArticleDao articleDao;

    @Override
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    @Override
    public Article selectById(Long id) {
        return articleDao.selectById(id);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleDao.deleteArticleById(id);
    }


    public List<Article> getAll(){
        return this.articleDao.getAll();
    }
}
