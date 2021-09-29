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
        String blockchainFilter = req.getParameter("blockchainFilter");
        String averageMarkFilter = req.getParameter("averageMarkFilter");
        List<Student> studentList;

        if (averageMarkFilter != null && blockchainFilter != null)
            studentList = StudentDAO.getExelStudentsWithBlockchain();
        else if (averageMarkFilter != null)
            studentList = StudentDAO.getExcellentStudents();
        else if (blockchainFilter != null)
            studentList = StudentDAO.getStudentsBlockchain();
        else
            studentList = StudentDAO.getStudents();
            out.write("<br>");
            out.write("<br>");
            out.write("<h2 align=\"center\">List of students</h2>");
            out.write("<br>");
            out.write("<div align=\"center\">");
            out.write("<table cellpadding='10' bordercolor='black' border='2'>");
                out.write("<thead>");
                    out.write("<tr>");
                        out.write("<th>Имя</th>");
                        out.write("<th>Средняя оценка</th>");
                        out.write("<th>Blockchain</th>");
                    out.write("</tr>");
                out.write("</thead>");
                out.write("<tbody>");
            for (Student s: studentList) {
                out.write("<tr>");
                    out.write("<td align='center'>" + s.getName() + "</td>");
                    out.write("<td align='center'>" + s.getAvrMark() + "</td>");
                    out.write("<td align='center'>" + s.isBlockChain() + "</td>");
                out.write("</tr>");
            }
                out.write("</tbody>");
            out.write("</table>");
            out.write("<br>");
            out.write("<br>");
            out.write("<a href=\"main-servlet\">Come back</a>");
            out.write("</div>");
    }
}
