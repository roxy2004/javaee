package cn.edu.zjut.app;

import cn.edu.zjut.dao.*;
import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;

import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {
        Customer loginUser = new Customer();
        loginUser.setCustomerId(1);
        loginUser.setAccount("zjut");
        loginUser.setPassword("Zjut");
        UserService uService =new UserService();
        if(uService.login(loginUser))
            System.out.println(loginUser.getAccount()+" loginSuccess!");
        else
            System.out.println(loginUser.getAccount()+" loginFail!");
        // 测试显示所有商品信息功能
//        ItemService itemService = new ItemService();
//        List<Item> items = itemService.getAllItems();
//        for (Item item : items) {
//            System.out.println("Item ID: " + item.getIpk().getItemID());
//            System.out.println("Title: " + item.getIpk().getTitle());
//            System.out.println("Description: " + item.getDescription());
//            System.out.println("Cost: " + item.getCost());
//            System.out.println();
//        }
        // 测试显示所有商品信息功能Hql
        ItemService itemService = new ItemService();
//        List<Item> items = itemService.findByHql();
//        for (Item item : items) {
//            System.out.println("Item ID: " + item.getIpk().getItemID());
//            System.out.println("Title: " + item.getIpk().getTitle());
//            System.out.println("Description: " + item.getDescription());
//            System.out.println("Cost: " + item.getCost());
//            System.out.println();
        List<Object[]> items = itemService.findByHql();
        for (Object[] item : items) {
            System.out.println("Title: " + item[0]);
            System.out.println("Cost: " + item[1]);
            System.out.println();
        }

        // 测试用户注册功能
//        Customer newUser = new Customer();
//        newUser.setCustomerId(2);
//        newUser.setAccount("newUser");
//        newUser.setPassword("newPassword");
//        if (uService.register(newUser))
//            System.out.println(newUser.getAccount() + " registerSuccess!");
//        else
//            System.out.println(newUser.getAccount() + " registerFail!");

    }
}