/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control2;

import DAO.CategoryDAO;
import DAO.DetailDAO;
import DAO.OrderDAO;
import entity.OrderCustomer;
import entity.User;
import java.io.IOException;

import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "ShowOrder", urlPatterns = {"/showOrder"})
public class ShowOrder extends HttpServlet {

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
        DetailDAO sor = new DetailDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<entity.Category> listCategory = categoryDAO.getAllCategory();
        request.setAttribute("listAllCategory", listCategory);
        User user = (User) request.getSession().getAttribute("user");
        int sod = user.getId();
        List<OrderCustomer> os = sor.ShowOrder(sod);
        List<OrderCustomer> listConfirm = sor.getListConfirm(sod);
        request.setAttribute("listConfirm", listConfirm);
        request.setAttribute("listShowOrder", os);
        request.getRequestDispatcher("order.jsp").forward(request, response);

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
        int odid = Integer.parseInt(request.getParameter("odid"));
        OrderDAO dao = new OrderDAO();
        dao.editOrderStatus("3", odid);
        response.sendRedirect("showOrder");
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
