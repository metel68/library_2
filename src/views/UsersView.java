package views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utils.Constants;
import controllers.UserController;
import models.User;

@WebServlet(name = "UsersList", urlPatterns = { "/users" })
public class UsersView extends BaseView {

	private static final long serialVersionUID = 5705929666227862893L;
	private UserController controller;
	private GsonBuilder gsonb = new GsonBuilder();

	public UsersView() {
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
				Gson gson = this.gsonb.excludeFieldsWithoutExposeAnnotation().create();
				List<User> users = this.controller.getUserAll();
				out.print(gson.toJson(users));
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		String jsonObject = request.getReader().lines().collect(Collectors.joining());

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = this.gsonb.excludeFieldsWithoutExposeAnnotation().create();
				User user = gson.fromJson(jsonObject, User.class);

				User newUser = this.controller.insert(user, false);
				out.print(gson.toJson(newUser));
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

}
