package news.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import news.model.User;
import news.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;


    @RequestMapping("/showUser.do")
    public void selectUserById(HttpServletRequest request,HttpServletResponse response )throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUserById(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user.getId()+" username: "+user.getUserName()+" nickName: "+user.getNickName()));
        response.getWriter().close();
    }

    @RequestMapping(value = "/test")
        public String test(){
            return "test";
        }


    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd, Model model) {
        User user = this.userService.selectUserByUserName(userName);
        if(user.getPwd().equals(pwd)){
            return "redirect:/index";
        }
        else {
           model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }
    }
