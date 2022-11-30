package com.candpapp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import com.candpapp.dao.CouponDAO;
import com.candpapp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiry Date");

		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);
		
		dao.save(coupon);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Created.</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}

}
