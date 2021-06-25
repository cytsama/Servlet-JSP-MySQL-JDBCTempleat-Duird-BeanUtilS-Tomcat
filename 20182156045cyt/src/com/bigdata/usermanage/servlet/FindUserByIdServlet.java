package com.bigdata.usermanage.servlet;

import com.bigdata.usermanage.entity.User;
import com.bigdata.usermanage.service.UserService;
import com.bigdata.usermanage.service.impl.UserServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //调用service
        UserService service = new UserServiceimpl();
        User user = service.findUserById(id);

        //将user存入request
        request.setAttribute("user",user);
        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
