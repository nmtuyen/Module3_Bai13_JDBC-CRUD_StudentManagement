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
    private final String INSERT_STUDENT = "INSERT student(id, name, age, gender, address, conduct) value(?,?,?,?,?,?);";
    private final String FIND_BY_ID = "SELECT * FROM student WHERE id = ?;";
    private final String DELETE_BY_ID = "DELETE FROM student WHERE id = ?;";
    private final String UPDATE_STUDENT = "UPDATE student SET id = ?, name = ?, age = ?, gender = ?, address = ?, conduct =? where id = ?";

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


    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public Student findById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int idStudent = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            String conduct = resultSet.getString("conduct");
            return new Student(idStudent, name, age, gender, address, conduct);
        }
        return null;
    }


    public void Update(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(4, student.getGender());
        preparedStatement.setString(5, student.getAddress());
        preparedStatement.setString(6, student.getConduct());
        preparedStatement.executeUpdate();
    }
}
