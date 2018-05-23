package com.ray.controller;

import com.ray.entity.User;
import com.ray.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @RequestMapping 请求路径
     * @ResponseBody 返回JSON数据
     */
    @RequestMapping("insertUser")
    @ResponseBody
    public boolean insertUser(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        boolean result = userService.checkRegister(username,password,email);
        if(result){
            return true;
        }
        return false;
    }

    /**
     * 用户登录
     * @RequestMapping 请求路径
     * @ResponseBody 返回JSON数据
     */
    @RequestMapping("loginUser")
    @ResponseBody
    public boolean loginUser(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //控制台输出 -> 测试
        System.out.println("login_username: " + username);
        System.out.println("login_password: " + password);

        HttpSession session = request.getSession();

        User user = userService.checkLogin(username, password);
        if(user != null){
            session.setAttribute("username", user.getUserName());
            return true;
        }
        return false;
    }

    /**
     * Session在线状态
     */
    @RequestMapping("online")
    @ResponseBody
    public String online(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("username");

        if(user != null){
            System.out.println("Session_user: " + user.toString());
            return user.toString();
        }else{
            return null;
        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("updateUserPwd")
    @ResponseBody
    public boolean updateUserPwd(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("username");
        String password = request.getParameter("password");
        System.out.println("当前用户: " + user.toString() + " 的新密码为: " + password);

        userService.updatePwd(password, user.toString());
        request.getSession().removeAttribute("username");
        return true;
    }

    /**
     * 退出登录
     */
    @RequestMapping("logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("username");

        if(user != null){
            request.getSession().removeAttribute("username");
            return true;
        }
        return false;
    }
}
