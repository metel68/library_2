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
import controllers.SettingsController;
import models.Publisher;
import models.Setting;

/**
 * Servlet implementation class SettingView
 */
@WebServlet("/setting")
public class SettingView extends BaseView {
	private static final long serialVersionUID = 1L;
	SettingsController controller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettingView() {
		super();
		this.controller = new SettingsController();
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
				Setting setting = controller.selectLast();
				if (setting == null) {
					response.setStatus(404);
				}
				String jsonOutput = gson.toJson(setting);
				out.println(jsonOutput);
			} catch (Exception e) {
				out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
				response.setStatus(500);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json;charset=UTF-8");

		String jsonObject = request.getReader().lines().collect(Collectors.joining());

		try (PrintWriter out = response.getWriter()) {
			try {
				Gson gson = new Gson();
				Setting setting = gson.fromJson(jsonObject, Setting.class);
				setting = controller.upsert(setting);
				out.print(gson.toJson(setting));
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
