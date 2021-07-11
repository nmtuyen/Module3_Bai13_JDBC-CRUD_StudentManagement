package dao;

import java.sql.SQLException;
import java.util.List;
import model.Student;

public interface IDao <Student> {
    List<Student> showList() throws SQLException;
    void create(Student student) throws SQLException;
    void update(Student student);
    void delete(int id);
    Student find(int id);
    List<Student> findByName(String name);
}
