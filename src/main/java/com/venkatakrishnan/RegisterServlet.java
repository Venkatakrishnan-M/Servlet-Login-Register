package com.venkatakrishnan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String urlString = "jdbc:postgresql://localhost:5432/miniproject";
	static String DBusername = "postgres";
	static String DBpassword = "postgres";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error at 27");
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(urlString, DBusername, DBpassword)) {
			String usernameString = request.getParameter("username");
			String passString = request.getParameter("password");
			String conPassString = request.getParameter("conPassword");
			String emailString = request.getParameter("email");
			String phoneString = request.getParameter("phone");

			insert(connection, usernameString, passString, conPassString, emailString, phoneString, request, response);
		} catch (Exception e) {
			System.out.println("Error at 40 ");
			e.printStackTrace();
		}
	}

	private void insert(Connection connection, String usernameString, String passString, String conPassString,
			String emailString, String phoneString, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

			if(passString.equals(conPassString)) {
				String insertQuery = "INSERT INTO users (username,password,email,phone) VALUES(?,?,?,?);";
				try(PreparedStatement statement = connection.prepareStatement(insertQuery)) {
					statement.setString(1, usernameString);
					statement.setString(2, passString);
					statement.setString(3, emailString);
					statement.setString(4, phoneString);
					int rowAffected = statement.executeUpdate();
					statement.close();
					connection.close();
					RequestDispatcher resDispatcher = request.getRequestDispatcher("login.jsp");
					resDispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error at 59");
				}
			}
			else {
				connection.close();
				RequestDispatcher resDispatcher = request.getRequestDispatcher("register.jsp");
				request.setAttribute("error","Password did not match!");
				resDispatcher.forward(request, response);
			}
			
		
		
	}

}
