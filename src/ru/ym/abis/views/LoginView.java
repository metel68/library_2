package views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controllers.UserController;
import models.User;
import utils.Constants;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/login")
public class LoginView extends BaseView {
	private static final long serialVersionUID = 1L;
	private GsonBuilder gsonb = new GsonBuilder();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 setAccessControlHeaders(response);
         response.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = request.getReader().lines().collect(Collectors.joining());
         
         try (PrintWriter out = response.getWriter()) {
 			Gson gson = this.gsonb.excludeFieldsWithoutExposeAnnotation().create();
            UserController userController = new UserController();
            User jsonUser = gson.fromJson(jsonObject, User.class);
            
            try {
            	User dbUser = userController.authorize(jsonUser);
	            if (dbUser != null) {
	            	out.print(gson.toJson(dbUser));
	            } else {
	            	out.print(Constants.JSON_NOT_AUTHORIZED);
	            	response.setStatus(401);
	            }
            } catch (NullPointerException e) {
            	out.print(String.format(Constants.JSON_ERROR, e.toString()));
            	response.setStatus(422);
            } catch (Exception e) {
            	out.print(String.format(Constants.JSON_ERROR, e.getMessage()));
            	response.setStatus(500);
            }
		}
         
	}

}
