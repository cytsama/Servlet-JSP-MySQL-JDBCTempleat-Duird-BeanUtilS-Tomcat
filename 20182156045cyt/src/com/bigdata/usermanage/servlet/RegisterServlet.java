package com.bigdata.usermanage.servlet;

import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.RootService;
import com.bigdata.usermanage.service.impl.RootServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //service查询
        //String img = request.getParameter("img");
        //创建session对象
        //HttpSession session = request.getSession();
        //String code = (String)session.getAttribute("code");
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (
                InvocationTargetException e) {
            e.printStackTrace();
        }
        //进行判断用户名和密码不能为空
        if(user.getUsername()==null||user.getPassword()==null||user.getUsername()==""||user.getPassword()==""){
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        //进行判断该用户是否存在
        RootService Service = new RootServiceimpl();
        Boolean flag = Service.registerUser(user);
        if (flag) {
            System.out.println("添加成功");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            System.out.println("添加失败");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
