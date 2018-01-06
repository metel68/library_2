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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import ru.ym.abis.Constants;
import ru.ym.abis.DAL.BaseDAL;
import ru.ym.abis.DAL.UserDAL;
import ru.ym.abis.controllers.UserController;
import ru.ym.abis.models.User;

@WebServlet(name = "UsersList", urlPatterns = {"/UsersList"})
public class UserView extends HttpServlet {
   
	private static final long serialVersionUID = 5705929666227862893L;
	
	public UserView() {
		super();
		BaseDAL.initSqlSessionFactory();
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        // Параметр
//        String parameter = request.getParameter("parameter");
//
//        // Старт HTTP сессии
//        HttpSession session = request.getSession(true);
//        session.setAttribute("parameter", parameter);

		resp.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = resp.getWriter()) {
        		Gson gson = new Gson();
    			UserDAL userdal = new UserDAL();
    			List<User> users = userdal.selectAll();
    			out.print(gson.toJson(users));
        }
    } 

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	 resp.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = req.getReader().lines().collect(Collectors.joining()); //BANG! But servlets are mede for form-urlencoded, not for JSON
         
         try (PrintWriter out = resp.getWriter()) {
        	Gson gson = new Gson();
            User user = gson.fromJson(jsonObject, User.class);
            UserController  userController = new UserController();
            int res = userController.insertUser(user);
            out.print(res);
         }
	}

	@Override
    public String getServletInfo() {
        return "Пример сервлета";
    }

}
