package com.yellow.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yellow.domain.Category;
import com.yellow.domain.Product;
import com.yellow.service.CategoryService;
import com.yellow.service.ServiceServlet;

public class WebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceServlet serviceServlet = new ServiceServlet();
		List<Product> list = null;
		try {
			list = serviceServlet.getAllProduction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryService categoryService = new CategoryService();
        List<Category> listCate = categoryService.getAllCategory();

		request.setAttribute("product", list);
        request.setAttribute("category", listCate);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response);
	}

}
