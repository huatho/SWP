/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlHau;

import DAO.CartDAO;
import DAO.DetailDAO;
import DAO.ProductDAO;
import entity.Cart;
import entity.CartDetail;
import entity.Custom;
import entity.Customer;
import entity.User;
import entity.store1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/add-cart"})
public class AddToCart extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("login.jsp").forward(request, response);
      
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
        User u = (User) request.getSession().getAttribute("user");
        if(u == null) {
            response.sendRedirect("loginController");
        } else{
            String productId = request.getParameter("productID");
            String storeID = request.getParameter("storeID");
            
//            ProductDAO productDAO = new ProductDAO();
//            store1 st = productDAO.showStore(productId);
            String size = request.getParameter("txtsize");
            String color = request.getParameter("txtcolor");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            CartDAO cartDAO = new CartDAO();
//            Cart c = dao.showCart1(productId, 2, size, color, cid);
            Cart cart = cartDAO.getCartByUserId(u.getId());
                if(cart == null) {
                    Cart newCart = cartDAO.createCart(u.getId(), "");
                    cartDAO.addToCart(newCart.getCartID(), Integer.parseInt(productId), size, color, quantity, Integer.parseInt(storeID));
                    response.sendRedirect("home");
                }else {
                    CartDetail cdetail = cartDAO.getDetail(cart.getCartID(), Integer.parseInt(productId), size, color, Integer.parseInt(storeID));
                    if (cdetail == null) {
                        cartDAO.addToCart(cart.getCartID(), Integer.parseInt(productId), size, color, quantity, Integer.parseInt(storeID));
                    }
                    else {
                        cartDAO.updateCart(cdetail.getCartDetailID(), cdetail.getAmount()+quantity);
                    }
//                    int quan = c.getAmount() + quantity;
//                    dao.updateCart(quan, c.getCartID());
                    response.sendRedirect("home"); }
//                } else {
//                    dao.insertCart(cid, st.getStoreId(), productId, size, color, quantity);
//                    request.getRequestDispatcher("detail?productID=" + productId).forward(request, response);
//                }
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
