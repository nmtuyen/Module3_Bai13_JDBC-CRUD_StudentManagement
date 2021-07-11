package controller;

import dao.StudentDao;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/Students")
public class StudentServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao();

    public StudentServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "creat":
                showFormAdd(request, response);
                break;
            default:
                try {
                    showListStudent(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createStudent(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }
    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Student/List.jsp");
        List<Student> students = studentDao.showList();
        request.setAttribute("listStudents", students);
        requestDispatcher.forward(request, response);
    }
    public void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Student/FormAdd.jsp");
        requestDispatcher.forward(request, response);
    }
    public void createStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String conduct = request.getParameter("conduct");
        Student newStudent = new Student(id, name, age, gender, address, conduct);
        studentDao.addStudent(newStudent);
        showListStudent(request, response);
    }
}
