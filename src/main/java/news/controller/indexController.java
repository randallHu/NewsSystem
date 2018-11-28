package news.controller;

import news.model.Article;
import news.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class indexController {
    @Autowired
     private ArticleServiceImpl articleService;



    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
       List<Article> all = articleService.getAll();
       model.addAttribute("arts",all);
        System.out.println(all);
       return "index";
    }

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "add")
    public String add(){
        return "back/addArt";
    }
    }
