package com.highradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class newaddservlet
 */
@WebServlet("/newaddservlet")
public class newaddservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newaddservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin","*");
	     try {
	       HashMap<Object, Object> Response = new HashMap<Object, Object>();

	       //String sl_no=request.getParameter("sl_no");
	       String business_code=request.getParameter("business_code");
	       String cust_number=request.getParameter("cust_number");
	       String clear_date=request.getParameter("clear_date");
	       String buisness_year=request.getParameter("buisness_year");
	       String doc_id=request.getParameter("doc_id");
	       String posting_date=request.getParameter("posting_date");
	       String due_in_date=request.getParameter("due_in_date");
	       String invoice_currency=request.getParameter("invoice_currency");
	       String document_type=request.getParameter("document_type");
	       String posting_id=request.getParameter("posting_id");
	       int total_open_amount=Integer.parseInt(request.getParameter("total_open_amount"));
	       String baseline_create_date=request.getParameter("baseline_create_date");
	       String cust_payment_terms=request.getParameter("cust_payment_terms");
	       String invoice_id=request.getParameter("invoice_id");
	       
	       String document_create_date = request.getParameter("document_create_date");
	   
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Ayush@123");
	       String sql = "INSERT INTO winter_internship (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	       PreparedStatement ps = con.prepareStatement(sql);
	       Pojo data = new Pojo();
	       
	       PrintWriter out = response.getWriter();
	       
	       
	       ps.setString(1, business_code);
	         out.println(business_code);
	       ps.setString(2, cust_number);
	         out.println(cust_number);
	       ps.setString(3, clear_date);
	         out.println(clear_date);
	       ps.setString(4, buisness_year);
	         out.println(buisness_year);
	       ps.setString(5, doc_id);
	         out.println(doc_id);
	       ps.setString(6,  posting_date);
	         out.println(posting_date);
	       ps.setString(7, document_create_date);
	         out.println(document_create_date);
	         ps.setString(8, due_in_date);
	           out.println(due_in_date);
	         ps.setString(9, invoice_currency);
	           out.println(invoice_currency);
	       ps.setString(10, document_type);
	         out.println(document_type);
	         ps.setString(11, posting_id);
	           out.println(posting_id);
	       ps.setDouble(12, total_open_amount);
	         out.println(total_open_amount);
	       ps.setString(13, baseline_create_date);
	          out.println(baseline_create_date);
	       ps.setString(14, cust_payment_terms);
	         out.println(cust_payment_terms);
	       ps.setString(15, invoice_id);
	         out.println(invoice_id);
	       

	       if(ps.executeUpdate()>0) {
	         out.println("IF");
	       Response.put("insert", true);
	       }else {
	         out.println("ELSE");
	       Response.put("insert", false);
	       //Out.println(Response);
	       }
	       
	       Gson gson = new Gson();
	       String JSONresponse = gson.toJson(Response);
	       //response.setHeader("Access-Control-Allow-Origin", "*");
	       response.getWriter().append(JSONresponse);
	       }
	     catch(Exception e) {
	         PrintWriter out = response.getWriter();
	         out.println("CATCH");
	       e.printStackTrace();
	         out.println(e);
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
