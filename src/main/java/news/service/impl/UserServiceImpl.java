package news.service.impl;

import news.dao.IUserDao;
import news.model.User;
import news.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User selectUserById(long id) {
            return this.userDao.selectUserById(id);
    }

    @Override
    public User selectUserByUserName(String userName){
        return this.userDao.selectUserByUserName(userName);
    }
}
