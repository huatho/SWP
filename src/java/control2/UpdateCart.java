package control2;

import DAO.CartDAO;
import entity.CartDetail;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateCart", urlPatterns = {"/update-cart"})
public class UpdateCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process request here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("UpdateCart.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process cart update request here
        String detailID = request.getParameter("cbid");
        String quantityStr = request.getParameter("amount");
        
        // Check if detailID and quantity are not null or empty
        if (detailID != null && !detailID.isEmpty() && quantityStr != null && !quantityStr.isEmpty()) {
            try {
                int cdetailID = Integer.parseInt(detailID);
                int amount = Integer.parseInt(quantityStr);
                
                // Update cart detail with new quantity
                CartDAO cartDAO = new CartDAO();
                cartDAO.updateCart(cdetailID, amount);
                
                // Redirect back to cart page or any other appropriate page
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                // Handle parsing errors
                e.printStackTrace();
                // Redirect back to cart page with error message
                response.sendRedirect("cart.jsp?error=Invalid quantity");
            }
        } else {
            // Redirect back to cart page with error message
            response.sendRedirect("cart.jsp?error=Missing detailID or quantity");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
