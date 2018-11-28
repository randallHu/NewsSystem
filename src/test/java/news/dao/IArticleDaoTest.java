package news.dao;

import news.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_mybatis.xml"})
public class IArticleDaoTest {
    @Autowired
    private IArticleDao articleDao;

    @Test
    public void addArticleTest (){
        Article article = new Article();
        article.setArticleName("my first blog");
        article.setArticleDate(new Date());
        article.setArticleContent("finally, i love you more");
       articleDao.addArticle(article);
    }

    @Test
    public void getAllArticleT(){
        Long id = new Long(1);

        Article article = articleDao.selectById(id);
        System.out.println(article.getArticleContent());

    }
}
