package com.gym.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.gym.model.Member;
import com.gym.util.DBConnection;
public class MemberDAOImpl implements MemberDAO {
 private Connection conn = DBConnection.getConnection();
 @Override
 public void addMember(Member member) {
 String sql = "INSERT INTO members (name, membershiptype, startdate, enddate) VALUES (?, 
?, ?, ?)";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, member.getName());
 ps.setString(2, member.getMembershipType());
 ps.setDate(3, Date.valueOf(member.getStartDate()));
 ps.setDate(4, Date.valueOf(member.getEndDate()));
   ps.executeUpdate();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 @Override
 public List<Member> getAllMembers() {
 List<Member> list = new ArrayList<>();
 String sql = "SELECT * FROM members";
 try (PreparedStatement ps = conn.prepareStatement(sql);
 ResultSet rs = ps.executeQuery()) {
 while (rs.next()) {
 Member m = new Member();
 m.setMemberId(rs.getInt("memberid"));
 m.setName(rs.getString("name"));
 m.setMembershipType(rs.getString("membershiptype"));
 m.setStartDate(rs.getDate("startdate").toLocalDate());
 m.setEndDate(rs.getDate("enddate").toLocalDate());
 list.add(m);
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 return list;
 }
 @Override
 public void updateMember(Member member) {
 String sql = "UPDATE members SET name=?, membershiptype=?, startdate=?, enddate=? 
WHERE memberid=?";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setString(1, member.getName());
 ps.setString(2, member.getMembershipType());
 ps.setDate(3, Date.valueOf(member.getStartDate()));
   ps.setDate(4, Date.valueOf(member.getEndDate()));
 ps.setInt(5, member.getMemberId());
 ps.executeUpdate();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 @Override
 public void deleteMember(int id) {
 String sql = "DELETE FROM members WHERE memberid=?";
 try (PreparedStatement ps = conn.prepareStatement(sql)) {
 ps.setInt(1, id);
 ps.executeUpdate();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}
