package control1;

import daos.ReportDAO;
import dtos.ReportDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateReportServlet", urlPatterns = {"/create-report"})
public class CreateReportServlet extends HttpServlet {

    private final String SUCCESS1 = "product-of-store.jsp";
    private final String SUCCESS2 = "store-page.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS1;
        try {
            
            int productID = 0;
            if (request.getParameter("productIDReport") != null) {
                productID = Integer.parseInt(request.getParameter("productIDReport"));
            }
            int storeID = 0;
            if (request.getParameter("storeIDReport") != null) {
                storeID = Integer.parseInt(request.getParameter("storeIDReport"));
            }
            String content = request.getParameter("txtContent");
            ReportDAO reportDAO = new ReportDAO();
            ReportDTO report = new ReportDTO(1, productID, storeID, content);
            boolean result = reportDAO.createReport(report);
            request.setAttribute("RESULT", result);
            if (storeID != 0) {
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
