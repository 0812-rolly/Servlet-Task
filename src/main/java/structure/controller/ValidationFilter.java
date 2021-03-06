package structure.controller;

import structure.DAO.StudentDAO;
import javax.servlet.*;
import java.io.IOException;

public class ValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String averageMark = servletRequest.getParameter("averageMark");
        if (name == null && averageMark == null){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String errorMessage;

        if ("".equals(name) || averageMark.equals("")){
            errorMessage = "Some fields are empty.";

            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/error-page.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (!StudentDAO.getStudent(name).getName().equals("")){
            errorMessage = "Student with such name is already in the list.";
            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/error-page.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (Float.parseFloat(averageMark) < 0 || Float.parseFloat(averageMark) > 5){
            errorMessage = "Invalid average mark. Should be in range from 0 to 5.";
            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/error-page.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
