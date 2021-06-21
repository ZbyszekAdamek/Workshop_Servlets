package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userMyUser = new User();
        userMyUser.setUserName(request.getParameter("userName"));
        userMyUser.setEmail(request.getParameter("userEmail"));
        userMyUser.setPassword(request.getParameter("userPassword"));
        UserDao userDao = new UserDao();
        userDao.create(userMyUser);
        response.sendRedirect(request.getContextPath() + "/user/list");
    }
}
