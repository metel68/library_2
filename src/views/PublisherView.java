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
import controllers.PublisherController;
import models.Publisher;

/**
 * Servlet implementation class PublisherView
 */
@WebServlet("/publisher")
public class PublisherView extends BaseView {
	private static final long serialVersionUID = 1L;
	PublisherController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublisherView() {
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
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Publisher publisher = controller.selectById(id);
				if (publisher == null) {
					response.setStatus(404);
				}
				String jsonOutput = gson.toJson(publisher);
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
				Publisher publisher = gson.fromJson(jsonObject, Publisher.class);
				if (publisher.getId() == 0) {
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					publisher.setId(id);
				}
				int res = controller.update(publisher);
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
