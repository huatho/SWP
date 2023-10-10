package control;

import DAO.LoginDAO;
import DAO.UserDAO;
import entity.Account;
import entity.SendEmail;
import entity.Email;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "TakeEmail", urlPatterns = {"/takeemail"})
public class TakeEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("username");
            String email = request.getParameter("useremail");

            UserDAO dao = new UserDAO();
            User a = dao.checkEmailAndUserName(email, userName);
            
            if(a != null){
                entity.SendEmail sm = new entity.SendEmail();
                String code = sm.getRandom();
                Email mail = new Email(email, code);
                sm.sendEmail(mail);
                HttpSession session = request.getSession();
                session.setAttribute("authcode", mail);
                session.setAttribute("user", a);
                response.sendRedirect("testEmail.jsp");
            }else{
                request.setAttribute("message", "Email or UserName Incorrect!");
                request.getRequestDispatcher("take_email.jsp").forward(request, response);
               
             }
                           
           }          
    }

}
