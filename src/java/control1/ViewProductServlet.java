package control1;

import DAO.StoreDAO;
import daos.CategoryDAO;
import daos.ProductDAO;
import dtos.CategoryDTO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dtos.ProductDTO;
import entity.Product;
import entity.Store;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ViewProductServlet", urlPatterns = {"/view-product"})
public class ViewProductServlet extends HttpServlet {

    private final String ERROR = "seller-dashboard.jsp";
    private final String SUCCESS = "seller-dashboard.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if (u!=null) {
            if (u.getRoles()==2) {
                String url = ERROR;
                try {
                    String nameSearch = request.getParameter("txtProductNameSearch");
                    String priceFrom = request.getParameter("txtPriceFrom");
                    String priceTo = request.getParameter("txtPriceTo");
                    String categoryName = request.getParameter("txtCategorySearch");

                    CategoryDAO categoryDAO = new CategoryDAO();
                    List<CategoryDTO> listCategory = categoryDAO.getCategory();
                    request.setAttribute("LIST_CATEGORY", listCategory);

                    Store st = (Store) session.getAttribute("mystore");
                    StoreDAO storeDAO = new StoreDAO();
                    List<Product> listProduct = storeDAO.getAllProduct(st.getStoreID());
                    request.setAttribute("LIST_PRODUCT", listProduct);
                    url = SUCCESS;
                } catch (Exception ex) {
                    ex.getMessage();
                } finally {
                    request.getRequestDispatcher(url).forward(request, response);
                }
            }
            else {
                request.setAttribute("email", u.getEmail().getEmail());
                request.setAttribute("username", u.getAcc());
                request.getRequestDispatcher("createStore.jsp").forward(request, response);
            }
        }
        else {
            response.sendRedirect("login.jsp");
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
