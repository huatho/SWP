/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.LoginDAO;
import DAO.StoreDAO;
import DAO.UserDAO;
import entity.Account;
import entity.Custom;
import entity.NoAdmin;
import entity.Store;
import entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author MSII
 */
@WebServlet(name = "LoginController", urlPatterns = {"/loginController"})
public class LoginController extends HttpServlet {

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
        request.getRequestDispatcher("login.jsp").forward(request, response);// đừng xóa cái này
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("account");
        String password = request.getParameter("pass");
        UserDAO userDAO = new UserDAO();
        User u = userDAO.login(userName, password);
//        Account a = loginDAO.checkLogin(username, password);
//        Custom c = loginDAO.checkCustomer(username);
//        NoAdmin s = loginDAO.checkSeller(username);
//        Store t = loginDAO.checkStore(username);
//        AdminProfile ad = loginDAO.checkAdmin(username);
        if (u == null) {
            request.setAttribute("mess", "Wrong UserName or Password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (u.getRoles() == 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("load");
        } else if (u.getRoles() == 2) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u);
                StoreDAO storeDAO = new StoreDAO();
                Store s = storeDAO.getByUserID(u.getId());
                session.setAttribute("mystore", s);
                response.sendRedirect("home");
        } else if (u.getRoles() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u);             
                response.sendRedirect("home");
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
