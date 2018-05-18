package views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.gson.Gson;

import utils.Constants;
import controllers.FavoritesController;
import models.Book;
import models.FavoritesItem;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/favorites")
public class FavoritesViewWithData extends BaseView {
	private static final long serialVersionUID = 1L;
	private FavoritesController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoritesViewWithData() {
		super();
		this.controller = new FavoritesController();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);

		try (PrintWriter out = response.getWriter()) {
			try {
				int bookId = Integer.parseInt(request.getParameter("book"));
				String userId = request.getParameter("user");
				int res;
				if (userId != null) {
					res = controller.check(bookId, Integer.parseInt(userId));
				} else {
					res = controller.count(bookId);
				}
				out.print(res);
			} catch (PersistenceException e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(422);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);

		try (PrintWriter out = response.getWriter()) {
			try {
				int bookId = Integer.parseInt(request.getParameter("book"));
				int userId = Integer.parseInt(request.getParameter("user"));
				int res = controller.link(bookId, userId);
				out.print(res);
			} catch (PersistenceException e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(422);
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);

		try (PrintWriter out = response.getWriter()) {
			try {
				String bookIds = request.getParameter("book");
				int userId = Integer.parseInt(request.getParameter("user"));
				int result = -91;
				if (bookIds != null && bookIds.length() > 0) {
					int bookId = Integer.parseInt(bookIds);
					result = controller.unlink(bookId, userId);
				} 
				if (bookIds != null && bookIds.equals("0")) {
					result = controller.deleteAll(userId);
				}
				out.println(result);
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

}
