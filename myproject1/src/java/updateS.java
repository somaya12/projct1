/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import StudentsServies.StudentInfo;
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
public class updateS extends HttpServlet {

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
        String sid=request.getParameter("stext");
        
        String fullname= request.getParameter("ftext");
        String de= request.getParameter("dept");
        String email= request.getParameter("r");
        String password= request.getParameter("chh");
       
       
       ArrayList allvalid=StudentsServies.StudentInfo.isValidForUpdata(sid, fullname, de);
       
       if(allvalid.isEmpty())
       {
           int id= Integer.parseInt(sid);
       StudentInfo st=new StudentInfo(id,fullname,de,email,password);
       st.updateStd();
       st.updatePass();
       response.sendRedirect("http://localhost:8085/Myproject1/ShowAllStudent.jsp");
       }
       else
       {
           session.setAttribute("valid", allvalid);
           response.sendRedirect("http://localhost:8085/Myproject1/updataAndDeleteStudent.jsp"+sid+"=update");
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
