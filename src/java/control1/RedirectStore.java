package control1;

import daos.ProductDAO;
import dtos.ProductDTO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "RedirectStore", urlPatterns = {"/redirect-store"})
public class RedirectStore extends HttpServlet {

    private final String ERROR = "store-page.jsp";
    private final String SUCCESS = "product-of-store.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String nameSearch = request.getParameter("txtProductNameSearch");
            String priceFrom = request.getParameter("txtPriceFrom");
            String priceTo = request.getParameter("txtPriceTo");
            String categoryName = request.getParameter("txtCategorySearch");
            if(priceFrom == null) {
                priceFrom = "";
            }
            if(priceTo == null) {
                priceTo = "";
            }
            if(nameSearch == null) {
                nameSearch = "";
            }
            if(categoryName == null) {
                categoryName = "";
            }
            
            String storeID = request.getParameter("store");
            String storeName = request.getParameter("storeName");
            HttpSession session = request.getSession();
            ProductDAO productDAO = new ProductDAO();
            List<ProductDTO> listProduct = productDAO.getListProduct(nameSearch, priceFrom, priceTo, categoryName, storeID);
            session.setAttribute("LIST_PRODUCT_STORE", listProduct);
            request.setAttribute("STORE_NAME", storeName);
            request.setAttribute("STORE_ID", storeID);

            url = SUCCESS;
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
