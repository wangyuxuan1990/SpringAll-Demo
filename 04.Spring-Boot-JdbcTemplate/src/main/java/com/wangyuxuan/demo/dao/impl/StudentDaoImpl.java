package com.wangyuxuan.demo.dao.impl;

import com.wangyuxuan.demo.bean.Student;
import com.wangyuxuan.demo.dao.StudentDao;
import com.wangyuxuan.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 14:31
 * @Description:
 */

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into student(sno,sname,ssex) values(?,?,?)";
        Object[] args = {student.getSno(), student.getName(), student.getSex()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
        //当插入的表字段较多的情况下，推荐使用NamedParameterJdbcTemplate。
//        String sql = "insert into student(sno,sname,ssex) values(:sno,:name,:sex)";
//        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
//        return npjt.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int update(Student student) {
        String sql = "update student set sname = ?,ssex = ? where sno = ?";
        Object[] args = {student.getName(), student.getSex(), student.getSno()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int deleteBysno(String sno) {
        String sql = "delete from student where sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        String sql = "select * from student";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        String sql = "select * from student where sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        List<Student> studentList = this.jdbcTemplate.query(sql, args, argTypes, new StudentMapper());
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
