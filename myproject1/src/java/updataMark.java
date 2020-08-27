/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Mark.StudentInfo;
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
public class updataMark extends HttpServlet {

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
      
         String num=request.getParameter("ztext");
        String cname= request.getParameter("ftext");
        String de= request.getParameter("dept");
        String sclass= request.getParameter("r1");
        String  hob= request.getParameter("chh");
        
           String Tid= request.getParameter("Ttext");
                String Mark= request.getParameter("chhh");
 String sid= request.getParameter("ytext");
      
       ArrayList allvalid=StudentInfo.isValidForUpdata(cid, cname, de);
       
       if(allvalid.isEmpty())
       {
              int id= Integer.parseInt(cid);
       
       StudentInfo st=new StudentInfo( id, cname, de, sclass, hob, Mark, sid,num);
       st.updateStd();
       response.sendRedirect("http://localhost:8085/Myproject1/addMark_1.jsp?search="+Tid+"&send=add+marks");
       }
       else
       {
           session.setAttribute("valid", allvalid);
           response.sendRedirect("http://localhost:8085/Myproject1/updataMark.jsp?"+num+"=updata");
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
