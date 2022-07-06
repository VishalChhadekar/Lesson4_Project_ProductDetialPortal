package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Product;
import com.hibernate.util.HibernateUtil;

/**
 * Servlet implementation class AddNewProduct
 */
@WebServlet("/add_product")
public class AddNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-product.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String pName = request.getParameter("prd_name");
		String pBrand = request.getParameter("prd_brand");
		String pModel = request.getParameter("prd_model");
		String pPrice = request.getParameter("prd_price");

		Product pr = new Product();
		pr.setpName(pName);
		pr.setpBrand(pBrand);
		pr.setpModel(pModel);
		pr.setpPrice(Double.parseDouble(pPrice));

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(pr);
		tx.commit();

		session.close();
		out.append("Product added successfully!");

	}

}
