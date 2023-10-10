/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import entity.CardProduct;
import entity.Category;
import entity.Product;
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
@WebServlet(name = "HomeContrl", urlPatterns = {"/home"})
public class HomeContrl extends HttpServlet {

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
        
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        String categoryID = request.getParameter("categoryID");
        if (categoryID == null) { //On Load: User hasn't choosen Category
            categoryID = "0";
        }
        int cateID = Integer.parseInt(categoryID);

        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        if (cateID == 4) {
            String sex = "MAN";
            int count = productDAO.getTotalProductBySex(sex);
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            List<Product> listProductBySex = productDAO.pagingProductBySex(sex, index);
            request.setAttribute("listProductInPage", listProductBySex);
            request.setAttribute("endPage", endPage); //danh sách trang
        } else if (cateID == 5) {
            String sex = "WOMEN";
            int count = productDAO.getTotalProductBySex(sex);
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            List<entity.Product> listProductBySex = productDAO.pagingProductBySex(sex, index);
            request.setAttribute("listProductInPage", listProductBySex);
            request.setAttribute("endPage", endPage); //danh sách trang
        } else {
            int count = productDAO.getTotalProductByCategory(cateID);
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            List<CardProduct> listProduct = productDAO.pagingByCategory(index, cateID);
            request.setAttribute("listProductInPage", listProduct);
            request.setAttribute("endPage", endPage); //danh sách trang
        }

        List<Category> listCategory = categoryDAO.getAllCategory();
        List<CardProduct> listTop = productDAO.getTopProduct();


        request.setAttribute("listTop", listTop); //top sản phẩm bán chạy
        
        request.setAttribute("listAllCategory", listCategory);

        request.setAttribute("tagCategory", cateID);

        request.setAttribute("tag", index); //đang ở trang nào thì đánh dấu trang đó

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
