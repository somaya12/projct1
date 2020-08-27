/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ClassServies.ClassInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anas
 */
public class updataAndDeleteClass extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        HttpSession session= request.getSession();
        String cid=request.getParameter("stext");
        String classNum=request.getParameter("xtext");
        String classname= request.getParameter("ftext");
        String de= request.getParameter("dept");
        String level= request.getParameter("r1");
        String teacher = request.getParameter("GPA");
       
       
       ArrayList allvalid=ClassInfo.isValidForUpdata(cid, classname, de);
       
       if(allvalid.isEmpty())
       {
           int id= Integer.parseInt(cid);
          
       ClassInfo st=new ClassInfo(id, classname, de, level, teacher, classNum);
       st.updateStd();
       
       response.sendRedirect("http://localhost:8085/Myproject1/ShowAllClasses.jsp");
       }
       else
       {
           session.setAttribute("valid", allvalid);
           response.sendRedirect("http://localhost:8085/Myproject1/updataAndDeletClass.jsp?"+classNum+"=update");
       }

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
