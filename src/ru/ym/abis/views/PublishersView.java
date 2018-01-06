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

import ru.ym.abis.controllers.PublisherController;
import ru.ym.abis.models.Publisher;

/**
 * Servlet implementation class PublisherView
 */
@WebServlet("/publishers")
public class PublishersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishersView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
        		Gson gson = new Gson();
        		PublisherController contoller = new PublisherController();
    			List<Publisher> publishers = contoller.selectAll();
    			out.print(gson.toJson(publishers));
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = request.getReader().lines().collect(Collectors.joining()); //BANG! But servlets are mede for form-urlencoded, not for JSON
         
         try (PrintWriter out = response.getWriter()) {
        	Gson gson = new Gson();
        	Publisher publisher = gson.fromJson(jsonObject, Publisher.class);
            PublisherController contoller = new PublisherController();
            int res = contoller.insert(publisher);
            out.print(res);
         }
	}

}
