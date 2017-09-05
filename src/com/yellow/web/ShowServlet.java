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
import com.yellow.service.ShowService;


public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		ShowService showService = new ShowService();
		Product pro = showService.showProduct(pid);
		CategoryService categoryService = new CategoryService();
        List<Category> list = categoryService.getAllCategory();
        request.setAttribute("category", list);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
