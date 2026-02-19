package com.gym.servlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse ;
import com.gym.dao.MemberDAO;
import com.gym.dao.MemberDAOImpl;
@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 try {
 String idParam = request.getParameter("memberid");
 if (idParam == null || idParam.isEmpty()) {
 response.getWriter().println("Member ID is missing!");
 return;
 }
 int id = Integer.parseInt(idParam);
 MemberDAO dao = new MemberDAOImpl();
 dao.deleteMember(id);
 response.sendRedirect(request.getContextPath() + "/viewMember");
 } catch (NumberFormatException e) {
 e.printStackTrace();
 response.getWriter().println("Invalid Member ID format.");
 } catch (Exception e) {
 e.printStackTrace();
 response.getWriter().println("Error deleting member.");
 }
 }
}
