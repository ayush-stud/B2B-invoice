 package com.highradius;

import java.io.IOException;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
    static java.sql.Date parseDate(String date) throws ParseException {
		try {
			if (date == null || date == "")
				return null;
			System.out.println(date);
			Date format = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			java.sql.Date d = new java.sql.Date(format.getTime());
			return d;
		} catch (ParseException error) {
			throw error;
		}
	}
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin","*");
		
		try {
			
			
			String business_code=request.getParameter("business_code");
			int cust_number=Integer.parseInt(request.getParameter("cust_number"));
			
			String invoice_currency=request.getParameter("invoice_currency");
			String document_type=request.getParameter("document_type");
			String doc_id=request.getParameter("doc_id");
			String cust_payment_terms=request.getParameter("cust_payment_terms");
			double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));
		    int posting_id=Integer.parseInt(request.getParameter("posting_id"));
		    int invoice_id=Integer.parseInt(request.getParameter("invoice_id"));
		    String buisness_year=request.getParameter( "buisness_year");
		    String document_create_dateS=request.getParameter("document_create_date");
		    Date document_create_date=parseDate(document_create_dateS); 
			String posting_dateS=(request.getParameter("posting_date"));
		    Date posting_date=parseDate(posting_dateS);  
		    String baseline_create_dateS=request.getParameter("baseline_create_date");
			Date baseline_create_date=parseDate(baseline_create_dateS);  
			String due_in_dateS=request.getParameter("due_in_date");
			Date due_in_date=parseDate(due_in_dateS);  
		    String clear_dateS=request.getParameter("clear_date");
		    Date clear_date=parseDate(clear_dateS);  
		    
		    //connection
		    Connection con = DBconnection.createConnect();
		    
			String query = "INSERT INTO winter_internship (business_code,cust_number,clear_date, buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date, cust_payment_terms, invoice_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);
			
			//setting in the database
			st.setString(1,business_code );
			st.setInt(2,cust_number );
			st.setDate(3,(java.sql.Date) clear_date);
			st.setString(4, buisness_year );
			st.setString(5, doc_id);
			st.setDate(6, (java.sql.Date) posting_date);
			st.setDate(7,(java.sql.Date) document_create_date);
			st.setDate(8,(java.sql.Date)due_in_date);
			st.setString(9,invoice_currency);
			st.setString(10,document_type);
			st.setInt(11, posting_id);
			st.setDouble(12,total_open_amount);
			st.setDate(13,(java.sql.Date) baseline_create_date);
			st.setString(14, cust_payment_terms);
			st.setInt(15, invoice_id);
			
			st.executeUpdate();
			
		st.close();
			con.close();
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