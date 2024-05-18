package control1;

import DAO.CategoryDAO;
import dtos.CategoryDTO;
import dtos.ProductDTO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "RedirectUpdateProduct", urlPatterns = {"/redirect-update-product"})
public class RedirectUpdateProduct extends HttpServlet {

    
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ERROR = "seller-dashboard.jsp";
        String SUCCESS = "create-update-product.jsp";

        String url = ERROR;
        try {
            int productID = Integer.parseInt(request.getParameter("txtProductID"));
            String productName = request.getParameter("txtProductName");
            String description = request.getParameter("txtDescription");
            String imageLink = request.getParameter("txtImageLink");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            String categoryID = request.getParameter("txtCategoryID");
            String categoryName = request.getParameter("txtCategoryName");
//            int storeID = Integer.parseInt(request.getParameter("txtStoreID"));

            Product product = new Product(productID, productName, description, imageLink, price, Integer.parseInt(categoryID), categoryName);
            CategoryDAO dao = new CategoryDAO();
            List<Category> list = dao.getAllCategory();
            request.setAttribute("PRODUCT", product);
            request.setAttribute("LIST_CATEGORY", list);
            url = SUCCESS;
        } catch (NumberFormatException ex) {
            ex.getMessage();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
