package news.controller;


import news.model.Article;
import news.service.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Resource
    private IArticleService articleService;

    @GetMapping(value="/{id}")
    public String getArticle(@PathVariable(name = "id")Long id, Model model){
        Article article = articleService.selectById(id);
        model.addAttribute("article",article);
        return "article";
    }

    @PostMapping(value = "/add")
    public String addArticle(Article article,Model model){
        article.setArticleDate(new Date());
        articleService.addArticle(article);
        model.addAttribute("msg","添加成功");
        return "redirect:/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteArticle(@PathVariable(name = "id")Long id,Model model){
        articleService.deleteArticleById(id);
        return "redirect:/index";
    }

}
