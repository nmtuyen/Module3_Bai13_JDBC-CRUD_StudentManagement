package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    SQLConnection sqlConnection = new  SQLConnection();
    Connection connection = sqlConnection.getConnection();

    private final String SHOW_LIST = "SELECT * FROM student;";
    private final String INSERT_STUDENT = "INSERT INTO student VALUES ?,?,?,?,?,?;";

    public StudentDao() throws SQLException, ClassNotFoundException {
    }


    public List<Student> showList() throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            String conduct = resultSet.getString("conduct");
            students.add(new Student(id, name, age, gender, address, conduct));
        }

        return students;
    }


    public void addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getGender());
        preparedStatement.setString(5, student.getAddress());
        preparedStatement.setString(6, student.getConduct());
        preparedStatement.executeUpdate();
    }


    public void update(Object o) {

    }


    public void delete(int id) {

    }

    public Object find(int id) {
        return null;
    }


    public List<Student> findByName(String name) {
        return null;
    }
}
