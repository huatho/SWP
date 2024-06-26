package control1;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.StoreDAO;
import entity.Category;
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
@WebServlet(name = "CreateProductServlet", urlPatterns = {"/create-product"})
public class CreateProductServlet extends HttpServlet {
    
    private final String ERROR = "create-update-product.jsp";
    private final String SUCCESS = "seller-dashboard.jsp";
    ProductDAO productDAO = new ProductDAO();
    StoreDAO storeDAO = new StoreDAO();
    CategoryDAO cateDAO = new CategoryDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        HttpSession session = request.getSession();
        Store st = (Store) session.getAttribute("mystore");
        List<Product> listProduct = storeDAO.getAllProduct(st.getStoreID());
        List<Category> listCate = cateDAO.getAllCategory();
        request.setAttribute("LIST_CATEGORY", listCate);
        request.setAttribute("LIST_PRODUCT", listProduct);
        request.getRequestDispatcher("create-update-product.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            

            String productName = request.getParameter("txtProductName");
            String descriptions = request.getParameter("txtDescription");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            String categoryID = request.getParameter("txtCategory");
            Part filePart = request.getPart("txtImageLink");
            String imageLink = uploadFile() + File.separator + getFileName(filePart);
            filePart.write(imageLink);
            
            
            HttpSession session = request.getSession();
            Store st = (Store) session.getAttribute("mystore");
            
            
            String cateName = cateDAO.getCateNameByID(Integer.parseInt(categoryID));
            Product product = new Product(0, productName, descriptions, "images" + File.separator + getFileName(filePart), price, Integer.parseInt(categoryID), cateName);
            Product newProduct = productDAO.createProduct(product);
            if (newProduct != null) {
                storeDAO.addProductToStore(st.getStoreID(), newProduct.getProductID());
                List<Product> listProduct = storeDAO.getAllProduct(st.getStoreID());
                List<Category> listCate = cateDAO.getAllCategory();
                request.setAttribute("LIST_CATEGORY", listCate);
                request.setAttribute("LIST_PRODUCT", listProduct);
                url = SUCCESS;
            }
            
            
      
        } catch (Exception ex) {
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
