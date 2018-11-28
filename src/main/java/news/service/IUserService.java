package news.service;

import news.model.User;

public interface IUserService {
     User selectUserById(Long id);

     User selectUserByUserName(String userName);


     void addUser(User user);
}
