/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.UserDAO;
import entity.Email;
import entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegisterControl", urlPatterns = {"/register"})
public class RegisterControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public class EmailValidator {
        private final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        public boolean validateEmail(String email) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        String email = request.getParameter("email");
        String role = "1";
        UserDAO dao = new UserDAO();
        User u = dao.checkUserName(username);
        if (u==null) {
            u = dao.checkEmail(email);
            EmailValidator validate = new EmailValidator();
            boolean check = validate.validateEmail(email);
            if(u == null){
                if (check) {
                        if (password.length()>=6) {
                        if (password.equals(repassword)) {
                        entity.SendEmail sm = new entity.SendEmail();
                        String code = sm.getRandom();
                        Email mail = new Email(email, code);
                        sm.sendEmail(mail);
                        User user = new User(username, password, mail, Integer.parseInt(role));
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
                        } else {
                            request.setAttribute("messages", "Password Không trùng khớp!");
                            request.getRequestDispatcher("register.jsp").forward(request, response);
                        } 
                    } else {
                        request.setAttribute("passWarning", "Password chưa đủ độ dài!");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }
                }
                {
                    request.setAttribute("messe", "Email không hợp lệ!");
                    request.getRequestDispatcher("register.jsp").forward(request, response); 
                }
                
            } else {
                request.setAttribute("messe", "Email đã được sử dụng!");
                request.getRequestDispatcher("register.jsp").forward(request, response);     
            }
        }
        else {
            request.setAttribute("messe", "UserName đã được sử dụng!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
