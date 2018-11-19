package news.service;

import news.model.User;

public interface IUserService {
    public User selectUserById(long id);
    public User selectUserByUserName(String userName);
}
