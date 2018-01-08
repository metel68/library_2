package ru.ym.abis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.gson.Gson;

import ru.ym.abis.Constants;
import ru.ym.abis.controllers.PublisherController;
import ru.ym.abis.models.Publisher;

/**
 * Servlet implementation class PublisherView
 */
@WebServlet("/publishers")
public class PublishersView extends BaseView {
	private static final long serialVersionUID = 1L;
	PublisherController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublishersView() {
		super();
		this.controller = new PublisherController();
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
				List<Publisher> publishers = controller.selectAll();
				out.print(gson.toJson(publishers));
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		String jsonObject = request.getReader().lines().collect(Collectors.joining());

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Publisher publisher = gson.fromJson(jsonObject, Publisher.class);
				int res = controller.insert(publisher);
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

}
