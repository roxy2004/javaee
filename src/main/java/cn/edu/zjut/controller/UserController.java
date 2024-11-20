package cn.edu.zjut.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.IUserService;
import com.sun.org.apache.xml.internal.serializer.AttributesImplSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userServ")
    private IUserService userServ;
//    public void setUserServ(IUserService userServ) {
//        this.userServ=userServ; }
    @RequestMapping("/login")
    public String login( HttpServletRequest req, Model model) {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if (username.equals(password)) {
            model.addAttribute("uname", username);
            return "loginSuccess";
        }
        else return "login";
    }
    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public String addUser(@ModelAttribute UserBean user, Model model) {
        boolean isAdded = userServ.addUser(user);
        if (isAdded) {
            model.addAttribute("message", "用户添加成功!");
            model.addAttribute("users", userServ.getAllUsers());
            return "addUserSuccess";
        } else {
            model.addAttribute("message", "用户添加失败。");
            return "addUser";
        }
    }
}