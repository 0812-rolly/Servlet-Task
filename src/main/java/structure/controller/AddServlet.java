package structure.controller;

import structure.DAO.StudentDAO;
import structure.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String averageMark = req.getParameter("averageMark");
        String blockchain = req.getParameter("blockchain");
        addStudent(name, averageMark, blockchain);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void addStudent(String name, String averageMark, String blockchain) {
        Student student = new Student();
        student.setName(name);
        student.setAvrMark(Float.parseFloat(averageMark));
        if (blockchain != null)
            student.setBlockChain(true);
        else
            student.setBlockChain(false);
        StudentDAO.addStudent(student);
    }
}
