package ru.ym.abis.views;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/publisher")
public class PublisherView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublisherView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		try (PrintWriter out = response.getWriter()) {
			Gson gson = new Gson();
			PublisherController сontroller = new PublisherController();
			Publisher publisher = сontroller.selectById(id);
	        String jsonOutput = gson.toJson(publisher);
	        out.println(jsonOutput);
	    }
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json;charset=UTF-8");
         
         String jsonObject = request.getReader().lines().collect(Collectors.joining()); //BANG! But servlets are mede for form-urlencoded, not for JSON
         
         try (PrintWriter out = response.getWriter()) {
        	Gson gson = new Gson();
        	Publisher publisher = gson.fromJson(jsonObject, Publisher.class);
        	if (publisher.getId() == 0) {
        		String ids = request.getParameter("id");
        		int id = Integer.parseInt(ids);
        		publisher.setId(id);
        	}
            PublisherController contoller = new PublisherController();
            int res = contoller.update(publisher);
            out.print(res);
         }
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		try (PrintWriter out = response.getWriter()) {
			PublisherController сontroller = new PublisherController();
			int result = сontroller.delete(id);
	        out.println(result);
	    }
	}

}
