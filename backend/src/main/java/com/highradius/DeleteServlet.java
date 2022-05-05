package com.highradius;

import java.io.BufferedReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteServlet
 */

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//	System.out.println(response.getWriter().append("Served at: ").append(request.getContextPath()));
		response.setHeader("Access-Control-Allow-Origin","*");
		try {
			Connection con = DBconnection.createConnect();
			String sl=request.getParameter("sl_no");
			String[] split = sl.split(",");
			
			for(int i=0;i<split.length;i++) {
				int temp=Integer.parseInt(split[i]);
				String q="DELETE FROM winter_internship WHERE sl_no=?";
				PreparedStatement st = con.prepareStatement(q);
				st.setInt(1,temp);
				st.executeUpdate();
				
			}

			
			System.out.println("Deleted Record.");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
