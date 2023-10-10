package controlBao;

import daos.ChatDAO;
import dtos.ChatDTO;
import dtos.CustomerDTO;
import dtos.SellerDTO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateChatServlet", urlPatterns = {"/create-chat"})
public class CreateChatServlet extends HttpServlet {

    private final String ERROR = "chat-page.jsp";
    private final String SUCCESS1 = "chat-page.jsp";
    private final String SUCCESS2 = "chat-user-page.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS1;
        try {
            String customerID = request.getParameter("txtCustomerID");
            String sellerID = request.getParameter("txtSellerID");
            String message = request.getParameter("txtMessage");
            boolean isCustomer = Boolean.parseBoolean(request.getParameter("isCustomer"));

            ChatDTO chat = new ChatDTO(new CustomerDTO(Integer.parseInt(customerID), "", "", "", "", 0), new SellerDTO(Integer.parseInt(sellerID), "", "", "", "", 0), isCustomer, message);
            ChatDAO chatDAO = new ChatDAO();
            chatDAO.createChat(chat);

            List<CustomerDTO> listCustomerChat = chatDAO.getCustomerChat(sellerID);
            request.setAttribute("LIST_CUSTOMER_CHAT", listCustomerChat);

            List<ChatDTO> listChat = chatDAO.getListMessageChat(customerID, sellerID);
            request.setAttribute("LIST_MESSAGE", listChat);

            if (isCustomer) {
                List<SellerDTO> listSellerChat = chatDAO.getSellerChat(customerID);
                request.setAttribute("LIST_SELLER_CHAT", listSellerChat);
                listChat = chatDAO.getListMessageChatUser(customerID, sellerID);
                request.setAttribute("LIST_MESSAGE", listChat);
                url = SUCCESS2;
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
