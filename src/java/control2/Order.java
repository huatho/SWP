

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control2;

import DAO.CartDAO;
import DAO.DetailDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import entity.CartDetail;
import entity.StoreDetail;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "Order", urlPatterns = {"/order"})
public class Order extends HttpServlet {

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
        String[] listCheckout = (String[]) request.getSession().getAttribute("listCheckout");
        User u = (User) request.getSession().getAttribute("user");
        DetailDAO detailDAO = new DetailDAO();
       
        ProductDAO dao = new ProductDAO();
        CartDAO cartDAO = new CartDAO();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String payWay = request.getParameter("pay");
        int total = (int) Double.parseDouble(request.getParameter("total"));
        detailDAO.insertOrder(u.getId(), address, payWay, phone, name, total);
        int orderID = detailDAO.getIdNewestOrder();
//        String[] orid  = request.getParameterValues("orid");
        for (String s: listCheckout) {
            int cid = Integer.parseInt(s);
            int storeID = cartDAO.getStoreID(cid);
            CartDetail cd = cartDAO.getCartDetail(cid);
            detailDAO.checkout(orderID, cd.getProductID(), cd.getAmount(), storeID);
            detailDAO.deleteCart(cid);
        }
//        for(int i = 0; i < orid.length; i++) {
                
                
//                System.out.println("order: " + orid[i] + address + payWay);
//        }
        response.sendRedirect("home");
//            request.getRequestDispatcher("vnpay.jsp")
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
