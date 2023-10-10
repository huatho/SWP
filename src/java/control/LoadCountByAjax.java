/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.DetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "LoadCountByAjax", urlPatterns = {"/loadCount"})
public class LoadCountByAjax extends HttpServlet {

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
        DetailDAO detailDAO = new DetailDAO();
        String ID  = request.getParameter("productID");
        String Size = request.getParameter("txtsize");
        String Color = request.getParameter("txtcolor");
        int productID = Integer.parseInt(ID);
        int countProduct = detailDAO.getCountProduct(Color, Size, productID);
        
        PrintWriter out = response.getWriter();       
            out.println("<div id=\"count\" class=\"product__details-status\">\n" +
"                                    <ul>\n" +
"                                        <li><b>Tình trạng</b> <span>Còn "+countProduct+" sản phẩm</span></li>\n" +
"                                        <li><b>Giao hàng</b> <span>Từ 02 - 03 ngày. <samp>Miễn phí giao hàng</samp></span></li>\n" +
"                                        <li><b>Trọng lượng</b> <span>0.5 kg</span></li>\n" +
"                                        <li><b>Chia sẻ</b>\n" +
"                                            <div class=\"share\">\n" +
"                                                <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n" +
"                                                <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n" +
"                                                <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n" +
"                                                <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n" +
"                                            </div>\n" +
"                                        </li>\n" +
"                                    </ul>\n" +
"                                </div>");                
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
