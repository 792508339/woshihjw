package com.yellow.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vo.Condition;

import com.yellow.domain.Category;
import com.yellow.domain.Product;
import com.yellow.service.CategoryService;
import com.yellow.service.SearchService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]> search = request.getParameterMap();
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, search);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchService searchService = new SearchService();
		List<Product> product = null;
		try {
			product = searchService.findProductiesByCondition(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryService categoryService = new CategoryService();
        List<Category> listCate = categoryService.getAllCategory();
		request.setAttribute("product", product);
		request.setAttribute("category", listCate);
		request.setAttribute("condition", condition);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
