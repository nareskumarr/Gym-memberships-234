package com.job.servlet;
import java.io.IOException; 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*;
import com.job.dao.*; 
@WebServlet("/deleteApplication")
public class DeleteApplicationServlet extends HttpServlet {
private static final long serialVersionUID = 1L; 
private ApplicationDAO applicationDAO;
public void init() {
applicationDAO = new ApplicationDAOImpl();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")); 
applicationDAO.deleteApplication(id);
response.sendRedirect("viewApplication");
}
}
