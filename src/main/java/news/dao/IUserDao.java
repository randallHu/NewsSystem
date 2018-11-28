package news.dao;

import news.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    User selectUserById(Long id);

    User selectUserByUserName(String username);

    void addUser(User user);
}
