package ru.ym.abis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.gson.Gson;

import ru.ym.abis.Constants;
import ru.ym.abis.controllers.AuthorController;
import ru.ym.abis.models.Author;

/**
 * Servlet implementation class AuthorView
 */
@WebServlet("/author")
public class AuthorView extends BaseView {
	private static final long serialVersionUID = 1L;
	private AuthorController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorView() {
		super();
		this.controller = new AuthorController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Author author = controller.selectById(id);
				String jsonOutput = gson.toJson(author);
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
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		String jsonObject = request.getReader().lines().collect(Collectors.joining());
		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Author author = gson.fromJson(jsonObject, Author.class);
				if (author.getId() == 0) {
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					author.setId(id);
				}
				int res = controller.update(author);
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
