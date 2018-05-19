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
import controllers.FavoritesController;
import controllers.UserController;
import models.Book;
import models.FavoritesItem;
import models.User;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/favorites/all")
public class FavoritesView extends BaseView {
	private static final long serialVersionUID = 1L;
	private FavoritesController controller;
	private BookController books;
	private UserController users;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoritesView() {
		super();
		this.controller = new FavoritesController();
		this.books = new BookController();
		this.users = new UserController();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				int bookId = Integer.parseInt(request.getParameter("book"));
				int userId = Integer.parseInt(request.getParameter("user"));
				User user = this.users.getUser(userId);
				Book book = this.books.selectById(bookId);
				
				FavoritesItem res = controller.get(new FavoritesItem(book, user));
					
				out.print(gson.toJson(res));
			} catch (PersistenceException e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(422);
				e.printStackTrace();
			}
		}
	}
}
