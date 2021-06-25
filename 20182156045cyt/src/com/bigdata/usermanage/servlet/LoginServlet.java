package com.bigdata.usermanage.servlet;

import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.RootService;
import com.bigdata.usermanage.service.UserService;
import com.bigdata.usermanage.service.impl.RootServiceimpl;
import com.bigdata.usermanage.service.impl.UserServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取map
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
        //5.调用service查询
        RootService service = new RootServiceimpl();
        User user1 = service.userLogin(user);

        //6.判断是否登录成功
        if (user1 != null) {
            //登录成功
            //response.getWriter().print("登录成功");
            //跳转页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            //登录失败
            //提示信息
            //response.getWriter().print("登录失败");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
