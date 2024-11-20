package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServ")
public class UserService implements IUserService{
    private List<UserBean> users = new ArrayList<>();
    public List<UserBean> getAllUsers() {
        return users;
    }
    public boolean login(UserBean loginUser) {
        if (loginUser.getUsername().equals(loginUser.getPassword())){
            return true;
        }
        return false;
    }
    public boolean addUser(UserBean user) {
        if (user.getUsername().equals(user.getPassword())) {
            users.add(user);
            return true;
        }
        return false;
    }
}
