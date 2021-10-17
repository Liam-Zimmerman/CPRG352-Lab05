
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {
    
    HttpSession session;
    User user;
    String sessionUsername;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
              
        if (request.getParameter("logout") != null) 
        {
            session.invalidate();
            sessionUsername = null;
            request.setAttribute("message", "Successfully logged out.");
        }
        
        if (sessionUsername == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        else
        {
            response.sendRedirect("home"); 
        }
            
       
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
        
        user = service.login(loginUsername, loginPassword);
        
        if(user == (null))
        {
            request.setAttribute("message", "Username or password are incorrect, please re-enter information.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        session = request.getSession(true);

        session.setAttribute("sessionUsername", user.getUsername());
        
        sessionUsername = (String) session.getAttribute("sessionUsername");
       
        response.sendRedirect("home");     
    }
}
