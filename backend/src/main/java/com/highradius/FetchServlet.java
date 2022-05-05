package com.highradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setHeader("Access-Control-Allow-Origin","*");
		try {

			List<Pojo>AllCustomer =new ArrayList<Pojo>();
		
			int sl_no;
			int cust_number;
			String buisness_year;
			String doc_id;
			int posting_id;
			String business_code;
			
//		    String clear_dateS;
		    Date clear_date;
//		    String posting_dateS
		    Date posting_date;
//		    String document_create_dateS;
		    Date document_create_date;
		
//		    String document_create_dateS1
		    Date document_create_date1;
//			String due_in_dateS
			Date due_in_date;
			String invoice_currency;
			String document_type;
			int invoice_id;
			double total_open_amount;
			
		    Connection con= DBconnection.createConnect();
		    String query="SELECT * from winter_internship";
		   Statement st = con.createStatement();

			
			 ResultSet rs = st.executeQuery(query);
			
while(rs.next())
			 {

	 Pojo p = new Pojo(); 
	
	
				 	sl_no = rs.getInt("sl_no");
				 	cust_number = rs.getInt("cust_number");
				 	buisness_year = rs.getString("buisness_year");
				 	doc_id = rs.getString("doc_id");
				 	posting_id = rs.getInt("posting_id");
				 	
				 	business_code = rs.getString("business_code");
				 	clear_date = rs.getDate("clear_date");
				 	posting_date = rs.getDate("posting_date");
				 	document_create_date = rs.getDate("document_create_date");
				 	document_create_date1 = rs.getDate("document_create_date1");
				 	due_in_date = rs.getDate("due_in_date");
				 	invoice_currency = rs.getString("invoice_currency");
				 	document_type = rs.getString("document_type");
				 	total_open_amount=rs.getDouble("total_open_amount");
				 	invoice_id=rs.getInt("invoice_id");
				 	
				 	p.setSl_no(sl_no);
					p.setCust_number(cust_number);
					p.setBuisness_year(buisness_year);
					p.setDoc_id(doc_id);
					p.setPosting_id(posting_id);		
					p.setBusiness_code(business_code);
					p.setClear_date(clear_date);
					p.setPosting_date(posting_date);
					p.setDocument_create_date(document_create_date);
					p.setDue_in_date(due_in_date);
					p.setInvoice_currency(invoice_currency);
					p.setDocument_type(document_type);
					p.setTotal_open_amount(total_open_amount);
					p.setDocument_create_date1(document_create_date1);
					p.setInvoice_id(invoice_id);
					//1 pojo object 
					
					AllCustomer.add(p);
					
					
			 }
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String invoices  = gson.toJson(AllCustomer);
response.setContentType("application/json");
response.getWriter().write(invoices.toString());
con.close();
st.close();
rs.close();
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
