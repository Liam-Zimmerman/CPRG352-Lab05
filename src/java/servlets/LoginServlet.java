
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         return;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String loginUsername = request.getParameter("username");
        String loginPassword = request.getParameter("password");
        
        request.setAttribute("inputUsername", loginUsername);
        request.setAttribute("inputPassword", loginPassword);
        
        if(loginUsername.equals("") || loginPassword.equals(""))
        {
            request.setAttribute("message", "Please enter a username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        AccountService service = new AccountService();
        
        User user = service.login(loginUsername, loginPassword);
        
        if(user == (null))
        {
            request.setAttribute("message", "Username or password are incorrect, please re-enter information.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        
        session.setAttribute("sessionUsername", user.getUsername());
        
        response.sendRedirect("/MyLogin/home");     
    }
}
