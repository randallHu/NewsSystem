package news.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import news.model.User;
import news.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd) {
        User user = this.userService.selectUserByUserName(userName);
        if(user.getPwd().equals(pwd))
        return "test";
        return "login";
    }
    }
