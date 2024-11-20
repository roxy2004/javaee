package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;

import java.util.List;

public interface IUserService {
    boolean login(UserBean loginUser);
    public List<UserBean> getAllUsers();
    boolean addUser(UserBean user);

}
