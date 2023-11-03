package control1;

import daos.ChatDAO;
import dtos.ChatDTO;
import dtos.CustomerDTO;
import entity.NoAdmin;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "GetChatServlet", urlPatterns = {"/get-chat"})
public class GetChatServlet extends HttpServlet {

    private final String ERROR = "chat-page.jsp";
    private final String SUCCESS = "chat-page.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            NoAdmin s = (NoAdmin) session.getAttribute("seller");
            ChatDAO chatDAO = new ChatDAO();
            String customerID = request.getParameter("customerID");

            List<CustomerDTO> listCustomerChat = chatDAO.getCustomerChat(String.valueOf(s.getId()));
            request.setAttribute("LIST_CUSTOMER_CHAT", listCustomerChat);
            if (customerID == null) {
                List<ChatDTO> listChat = chatDAO.getListMessageChat(String.valueOf(listCustomerChat.get(0).getCustomerID()), String.valueOf(s.getId()));
                request.setAttribute("LIST_MESSAGE", listChat);
               
            } else {
                List<ChatDTO> listChat = chatDAO.getListMessageChat(customerID, String.valueOf(s.getId()));
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
