/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control3;

import DAO.OrderDAO;
import DAO.StoreDAO;
import entity.OrderSeller;
import entity.Store;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author trung
 */
@WebServlet(name = "EditControl", urlPatterns = {"/edit"})
public class EditControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        

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
        Store store = (Store) request.getSession().getAttribute("mystore");
        OrderDAO dao = new OrderDAO();
        List<OrderSeller> list = dao.getOrderSeller(store.getStoreID());
        request.setAttribute("list", list);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
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
      
        String status = request.getParameter("status");
        int od = Integer.parseInt(request.getParameter("od"));
        OrderDAO dao = new OrderDAO();
        StoreDAO storeDAO = new StoreDAO();
        Store store = (Store) request.getSession().getAttribute("mystore");
        if ("2".equals(status)) {
            int pid = dao.getProductIDByOD(od);
            int amountOrder = Integer.parseInt(request.getParameter("amount"));
            int amountStore = storeDAO.getAmount(store.getStoreID(), pid);
            if (amountStore>=amountOrder) {
                request.setAttribute("msg", "Cập nhật thành công!");
                storeDAO.updateAmount(store.getStoreID(), pid, amountStore-amountOrder);
                dao.editOrderStatus(status, od);
            }
            else {
                request.setAttribute("msg","Không đủ số lượng sản phẩm để duyệt đơn!");
            }
        }
        if (status.equals("3")) {
            dao.editOrderStatus(status, od);
        }
        List<OrderSeller> list = dao.getOrderSeller(store.getStoreID());
        request.setAttribute("list", list);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
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
