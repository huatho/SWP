package control1;

import DAO.ProductDAO;
import DAO.StoreDAO;
import entity.Product;
import entity.Store;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/delete-product"})
public class DeleteProductServlet extends HttpServlet {

    private final String ERROR = "seller-dashboard.jsp";
    private final String SUCCESS = "seller-dashboard.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Store st = (Store) session.getAttribute("mystore");

            int productID = Integer.parseInt(request.getParameter("txtProductID"));
            ProductDAO productDAO = new ProductDAO();
            StoreDAO storeDAO = new StoreDAO();
            storeDAO.deleteProduct(st.getStoreID(), productID);
            boolean result = productDAO.deleteProduct(productID);
            if (result) {
                List<Product> listProduct = storeDAO.getAllProduct(st.getStoreID());
                session.setAttribute("LIST_PRODUCT", listProduct);
                url = SUCCESS;
            }
        } catch (NumberFormatException ex) {
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
