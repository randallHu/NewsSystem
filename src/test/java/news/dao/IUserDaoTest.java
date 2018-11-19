package news.dao;


import news.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_mybatis.xml"})
public class IUserDaoTest {
    @Autowired
    private IUserDao dao;

    @Test
    public void testSelectUserById(){
        long id = 1;
        User user = dao.selectUserById(id);
        System.out.println(user.getUserName());
        System.out.println(user.getPwd());
    }

    @Test
    public  void selectUserName(){
        String username = "1501020415";
        User user = dao.selectUserByUserName(username);
        System.out.println(user.getNickName());
        System.out.println(user.getPwd());
    }
}
