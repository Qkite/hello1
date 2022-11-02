package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    /*
    POST /user - user 등록하는 기능 -> add
    DELETE /user/{id} - 1명 유저 지우는 기능 -> delete from user where id = ?
    DELETE /user/all - 전체 유저 지우는 기능 -> delete from user

     */

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;


    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user){
        this.jdbcTemplate.update("insert into users(id, name, password) values(?, ?, ?)", user.getId(), user.getName(), user.getPassword());

    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }

    public void deleteById(String id){
        this.jdbcTemplate.update("delete from users where id = ?", id);
    }

    public List<User> select(){
        return this.jdbcTemplate.query("select * from users;", new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet rs, int num) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        });
    }
}
