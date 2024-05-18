package control1;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import entity.Product;
import entity.Store;
import java.io.File;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/update-product"})
public class UpdateProductServlet extends HttpServlet {

    private final String ERROR = "create-update-product.jsp";
    private final String SUCCESS = "seller-dashboard.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Store store = (Store) session.getAttribute("mystore");
            ProductDAO productDAO = new ProductDAO();
            StoreDAO storeDAO = new StoreDAO();
                    
            int productID = Integer.parseInt(request.getParameter("txtProductID"));
            String productName = request.getParameter("txtProductName");
            String descriptions = request.getParameter("txtDescription");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            int categoryID = Integer.parseInt(request.getParameter("txtCategory"));
            Part filePart = request.getPart("txtImageLink");
            String image;
            if (getFileName(filePart).equals("")) {
                image = request.getParameter("txtImageLinkHide");
            } else {
                String imageLink = uploadFile() + File.separator + getFileName(filePart);
                filePart.write(imageLink);
                image = "images" + File.separator + getFileName(filePart);
            }
            CategoryDAO cateDAO = new CategoryDAO();
            String cateName = cateDAO.getCateNameByID(categoryID);
            Product product = new Product(productID, productName, descriptions, image, price, categoryID, cateName);
            boolean result = productDAO.updateProduct(product);
            if (result) {
                List<Product> listProduct = storeDAO.getAllProduct(store.getStoreID());
                request.setAttribute("LIST_PRODUCT", listProduct);
                url = SUCCESS;
            }
        } catch (NumberFormatException ex) {
            ex.getMessage();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    private String uploadFile() {
        String uploadPath = getServletContext().getRealPath("") + "images";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        return uploadPath.replace("\\build", "");
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
