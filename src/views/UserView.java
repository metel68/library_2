package views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utils.Constants;
import controllers.UserController;
import models.User;

@WebServlet(name = "UserProfile", urlPatterns = { "/user" })
public class UserView extends BaseView {

	private static final long serialVersionUID = 5705929666227862893L;
	private UserController controller;
	private GsonBuilder gsonb = new GsonBuilder();

	public UserView() {
		super();
		this.controller = new UserController();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// // Параметр
		// String parameter = request.getParameter("parameter");
		//
		// // Старт HTTP сессии
		// HttpSession session = request.getSession(true);
		// session.setAttribute("parameter", parameter);

		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			try {
				String ids = request.getParameter("id");
				int id = Integer.parseInt(ids);
				Gson gson = this.gsonb.excludeFieldsWithoutExposeAnnotation().create();
				User user = this.controller.getUser(id);

				if (user == null) {
					response.setStatus(404);
				}
				
				out.print(gson.toJson(user));
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
				User user =  gson.fromJson(jsonObject, User.class);
				if (user.getId() == 0) {
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					user.setId(id);
				}
				int res = controller.update(user);
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
