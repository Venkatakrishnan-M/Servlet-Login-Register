package com.venkatakrishnan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String urlString = "jdbc:postgresql://localhost:5432/miniproject";
	static String DBusername = "postgres";
	static String DBpassword = "postgres";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error at 31");
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(urlString, DBusername, DBpassword)) {
			String usernameString = request.getParameter("user");
			String passString = request.getParameter("password");

			retrieve(connection, usernameString, passString, request,response);
		} catch (Exception e) {
			System.out.println("Error at 41");
			e.printStackTrace();
		}
	}

	private void retrieve(Connection connection, String username, String password, HttpServletRequest request,HttpServletResponse response) {
		String queryString = "SELECT username,password FROM users WHERE username= ? AND password =?;";

		try (PreparedStatement statement = connection.prepareStatement(queryString);) {
			statement.setString(1, username);
			statement.setString(2, password);

			try (ResultSet resultSet = statement.executeQuery()) {
				PrintWriter out = response.getWriter();
				if (resultSet.next()) {
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					request.setAttribute("name", username);
					rd.forward(request, response);
					
				} else {
					out.println("<h2>Hard Luck</h2>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error at 64");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR in line 67");
		}
	}

}
