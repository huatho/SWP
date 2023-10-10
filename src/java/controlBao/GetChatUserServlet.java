package controlBao;

import daos.ChatDAO;
import daos.StoreDAO;
import dtos.ChatDTO;
import dtos.SellerDTO;
import dtos.StoreDTO;
import entity.Custom;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "GetChatUserServlet", urlPatterns = {"/get-chat-user"})
public class GetChatUserServlet extends HttpServlet {

    private final String ERROR = "chat-user-page.jsp";
    private final String SUCCESS = "chat-user-page.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            StoreDAO storeDAO = new StoreDAO();

            String sellerID = "";
            if (request.getParameter("sellerID") != null) {
                sellerID = request.getParameter("sellerID");
            } else {
                String storeID = request.getParameter("storeID");
                if (storeID != null) {
                    StoreDTO store = storeDAO.getStoreById(storeID);
                    sellerID = String.valueOf(store.getSellerDTO().getSellerID());
                }
            }
            Custom customer = (Custom) session.getAttribute("custom");
            request.setAttribute("SELLER_ID", sellerID);
            ChatDAO chatDAO = new ChatDAO();
            List<SellerDTO> listSellerChat = chatDAO.getSellerChat(customer.getCustomerID());
            request.setAttribute("LIST_SELLER_CHAT", listSellerChat);
            if (sellerID.equals("")) {
                List<ChatDTO> listChat = chatDAO.getListMessageChatUser(customer.getCustomerID(), String.valueOf(listSellerChat.get(0).getSellerID()));
                request.setAttribute("LIST_MESSAGE", listChat);
            } else {
                List<ChatDTO> listChat = chatDAO.getListMessageChatUser(customer.getCustomerID(), sellerID);
                request.setAttribute("LIST_MESSAGE", listChat);
            }
            

            url = SUCCESS;
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
