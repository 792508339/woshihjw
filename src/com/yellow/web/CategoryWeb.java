package com.yellow.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yellow.domain.Category;
import com.yellow.service.CategoryService;

public class CategoryWeb extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         CategoryService categoryService = new CategoryService();
         List<Category> list = categoryService.getAllCategory();
         request.setAttribute("category", list);
         request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
