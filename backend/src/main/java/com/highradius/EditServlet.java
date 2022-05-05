package com.highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin","*");
		try {
			String field=request.getParameter("sl_no");
			int sl_no=Integer.parseInt(field);
			String invoice_currency = request.getParameter("invoice_currency");
			String cust_payment_terms = request.getParameter("cust_payment_terms");
			
			Connection con = DBconnection.createConnect();
			String sql="";
			
			if (invoice_currency  != null)
				sql += "invoice_currency= '" + invoice_currency + "',";
			if ( cust_payment_terms!= null)
				sql += "cust_payment_terms = '" + cust_payment_terms + "',";

		
			
			String query = "UPDATE winter_internship  SET "+sql.substring(0,sql.length()-1)+" where sl_no = "+request.getParameter("sl_no");
			System.out.println(request.getParameter("sl_no"));
			System.out.println(sql.substring(0,sql.length()-1));
		Statement st = con.createStatement();
			
			
			
			st.executeUpdate(query);
			con.close();
			st.close();
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
