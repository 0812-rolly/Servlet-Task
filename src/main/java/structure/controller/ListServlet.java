package structure.controller;

import structure.DAO.StudentDAO;
import structure.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        log("init");
        StudentDAO.loadData();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        List<Student> studentList;
        studentList = StudentDAO.getStudents();

        out.write("<div align=\"center\">");
        for (Student s: studentList){
            out.write(s.toString() + "<br/>");
        }
        out.write("</div>");
    }
}
