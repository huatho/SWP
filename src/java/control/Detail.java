/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CategoryDAO;
import DAO.DetailDAO;
import DAO.ProductDAO;
import DAO.ReviewDAO;
import entity.CardProduct;
import entity.Category;
import entity.Color;
import entity.Product;
import entity.Review;
import entity.Size;
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
 * @author PC
 */
@WebServlet(name = "Detail", urlPatterns = {"/detail"})
public class Detail extends HttpServlet {

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
        String ID  = request.getParameter("productID");
        String storeID = request.getParameter("storeID");
        
        CategoryDAO categoryDAO = new CategoryDAO();
        ProductDAO productDAO = new ProductDAO();
        DetailDAO detailDAO = new DetailDAO();
        
        int productID = Integer.parseInt(ID);
        
        Product productDetail = productDAO.getProductByID(productID);
        List<CardProduct> listProductSame = productDAO.getProductSame(productID);
        List<Category> listCategory = categoryDAO.getAllCategory();

        int countProduct = detailDAO.getCountProduct(Integer.parseInt(storeID), productID);
        ReviewDAO reviewDAO = new ReviewDAO();
        List<Review> listReview = reviewDAO.getReviewByProductID(productID);
        request.setAttribute("listReview", listReview);
        System.out.println(listReview.size());
        request.setAttribute("listProductSameID", listProductSame);
        request.setAttribute("listAllCategory", listCategory);
        request.setAttribute("countProduct", countProduct);
        request.setAttribute("detail", productDetail);
        request.setAttribute("storeID", storeID);
        request.getRequestDispatcher("Detail.jsp").forward(request, response);
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
        String content = request.getParameter("content");
        int pid = Integer.parseInt(request.getParameter("pid"));
        ReviewDAO reviewDAO = new ReviewDAO();
        User user = (User) request.getSession().getAttribute("user");
        reviewDAO.addReview(pid, user.getId(), content);
        response.sendRedirect("detail");
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
