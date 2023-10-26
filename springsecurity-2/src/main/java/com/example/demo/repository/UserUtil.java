package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class UserUtil {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String finduserByUsername(String username) {
		String password;
		try {
			//String sql = "SELECT password FROM user1 where username ='" +username+ "';" ;
			String sql = "SELECT userpwd FROM tm_user where user_id ='" +username + "'";
			password = jdbcTemplate.queryForObject(sql, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return password;

	}

}
