package com.example.usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = (String) request.getSession().getAttribute("userEmail");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, oldPassword);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sql = "UPDATE users SET password = ? WHERE email = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, newPassword);
                stmt.setString(2, email);
                stmt.executeUpdate();
                response.getWriter().println("Password changed successfully! <a href='home.jsp'>Home</a>");
            } else {
                response.getWriter().println("Incorrect old password. <a href='changePassword.jsp'>Try Again</a>");
            }
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
