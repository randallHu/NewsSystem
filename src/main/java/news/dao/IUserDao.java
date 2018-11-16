package news.dao;

import news.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    User selectUserById(long id);
}
