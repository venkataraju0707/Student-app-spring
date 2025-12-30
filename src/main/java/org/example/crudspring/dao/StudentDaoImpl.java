package org.example.crudspring.dao;

import org.example.crudspring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student(name, email, course) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getCourse());
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setCourse(rs.getString("course"));
            return s;
        }
    }
    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM student WHERE id=?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Student.class),
                id
        );
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name=?, email=?, course=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getId()
        );
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
