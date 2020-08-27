/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import StudentTable.ClassInfo;
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
public class MyTable extends HttpServlet {

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
        
        String fullname= request.getParameter("ftext");
        String de= request.getParameter("dept");
        String level= request.getParameter("r1");
        String teacher = request.getParameter("chh");
       String mark = request.getParameter("");
        String classNum = request.getParameter("xtext");
       
        String sid = request.getParameter("ytext");
        
       ArrayList allvalid=ClassInfo.isValid(sid, classNum);
        
       if(allvalid.isEmpty())
       {     
           int id = Integer.parseInt(sid);
 
         
       ClassInfo st=new ClassInfo(fullname,de,level,teacher,mark,id,classNum);
       st.updateStd();
       
       response.sendRedirect("http://localhost:8085/Myproject1/ShowClassesAndAdd.jsp");
       }
       else
       {
           session.setAttribute("valid", allvalid);
           response.sendRedirect("http://localhost:8085/Myproject1/addMyClass.jsp?"+cid+"=ADD");
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
