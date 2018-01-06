package ru.ym.abis.views;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserView extends HttpServlet {
   
	private static final long serialVersionUID = 5705929666227862893L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Параметр
        String parameter = request.getParameter("parameter");

        // Старт HTTP сессии
        HttpSession session = request.getSession(true);
        session.setAttribute("parameter", parameter);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>3.5 юзера</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Список юзеров</h1>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 

    @Override
    public String getServletInfo() {
        return "Пример сервлета";
    }

}
