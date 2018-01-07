package ru.ym.abis.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import ru.ym.abis.Constants;
import ru.ym.abis.controllers.UserController;
import ru.ym.abis.models.User;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/login")
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
         response.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = request.getReader().lines().collect(Collectors.joining());
         
         try (PrintWriter out = response.getWriter()) {
 			Gson gson = new Gson();
            UserController userController = new UserController();
            
            User jsonUser = gson.fromJson(jsonObject, User.class);
            User referenceUser = userController.getUser(jsonUser.getUsername());
            jsonUser.hashPassword();
            
            if (referenceUser.equals(jsonUser)) {
            	out.print(Constants.JSON_AUTHORIZED);
            } else {
            	out.print(Constants.JSON_NOT_AUTHORIZED);
            	response.setStatus(401);
            }
		}
         
	}

}
