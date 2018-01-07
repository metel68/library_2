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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.ym.abis.controllers.UserController;
import ru.ym.abis.models.User;

@WebServlet(name = "UsersList", urlPatterns = {"/users"})
public class UsersView extends HttpServlet {
   
	private static final long serialVersionUID = 5705929666227862893L;
	
	public UsersView() {
		super();
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//        // Параметр
//        String parameter = request.getParameter("parameter");
//
//        // Старт HTTP сессии
//        HttpSession session = request.getSession(true);
//        session.setAttribute("parameter", parameter);

		response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
        		GsonBuilder b = new GsonBuilder();
        		Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
    			UserController contoller = new UserController();
    			List<User> users = contoller.getUserAll();
    			out.print(gson.toJson(users));
        }
    } 

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 response.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = request.getReader().lines().collect(Collectors.joining()); //BANG! But servlets are mede for form-urlencoded, not for JSON
         
         try (PrintWriter out = response.getWriter()) {
			GsonBuilder b = new GsonBuilder();
			Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
            User user = gson.fromJson(jsonObject, User.class);
            user.hashPassword();
            UserController userController = new UserController();
            int res = userController.insert(user);
            out.print(res);
         }
	}

	@Override
    public String getServletInfo() {
        return "Пример сервлета";
    }

}
