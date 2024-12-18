package com.collegeapp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserLogOutServlet")
public class UserLogOutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("UserLogOutServlet is running.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/json");
		try
		{
			HttpSession session = request.getSession(false);

			// Invalidate the session to log out the user.
			if (session != null)
			{
				session.invalidate();
			}

			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(new Gson().toJson("Logged out successfully."));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(new Gson().toJson("An error occurred."));
		}
	}
}
