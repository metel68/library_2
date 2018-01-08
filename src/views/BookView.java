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
import controllers.BookController;
import models.Book;

/**
 * Servlet implementation class BookView
 */
@WebServlet("/book")
public class BookView extends BaseView {
	private static final long serialVersionUID = 1L;
	BookController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookView() {
		super();
		this.controller = new BookController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				String ids = request.getParameter("id");
				Book book;
				if (ids != null) {
					int id = Integer.parseInt(ids);
					book = controller.selectById(id);
				} else {
					book = controller.selectByName(request.getParameter("name"));
				}
				if (book == null) {
					response.setStatus(404);
				}
				String jsonOutput = gson.toJson(book);
				out.println(jsonOutput);
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");

		String jsonObject = request.getReader().lines().collect(Collectors.joining());

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Book book = gson.fromJson(jsonObject, Book.class);
				if (book.getId() == 0) {
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					book.setId(id);
				}
				int res = controller.update(book);
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
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);

		try (PrintWriter out = response.getWriter()) {
			try {
				int result = controller.delete(id);
				out.println(result);
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

}
