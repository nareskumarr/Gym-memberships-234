package com.gym.servlet;
import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.gym.dao.MemberDAO;
import com.gym.dao.MemberDAOImpl;
import com.gym.model.Member;
@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 try {
 int id = Integer.parseInt(request.getParameter("memberid"));
 String name = request.getParameter("name");
 String membershipType = request.getParameter("membershiptype");
 LocalDate startDate = LocalDate.parse(request.getParameter("startdate"));
 LocalDate endDate = LocalDate.parse(request.getParameter("enddate"));
 Member member = new Member();
 member.setMemberId(id);
 member.setName(name);
 member.setMembershipType(membershipType);
 member.setStartDate(startDate);
 member.setEndDate(endDate);
 MemberDAO dao = new MemberDAOImpl();
 dao.updateMember(member);
 response.sendRedirect("viewMember");
 } catch (Exception e) {
 e.printStackTrace();
 response.getWriter().println("Error while updating member");
 }
 }
}
