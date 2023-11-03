/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.AdminDAO;
import entity.CardProduct;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "listP", urlPatterns = {"/listProduct"})
public class listP extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        List<CardProduct> listP = dao.getListProduct();
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("admin/listP.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int accept = Integer.parseInt(request.getParameter("accept"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        AdminDAO dao = new AdminDAO();
        dao.acceptProduct(productID, accept);
        response.sendRedirect("listProduct");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
