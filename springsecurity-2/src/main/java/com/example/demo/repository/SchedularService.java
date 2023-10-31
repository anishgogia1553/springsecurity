package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Schedular;
import com.example.demo.model.SchedularCategory;
import com.example.demo.model.SchedularMain;

@Service
public class SchedularService implements SchedularRepository {

	public class SchedularRowMapper implements RowMapper<Schedular> {
		@Override
		public Schedular mapRow(ResultSet rs, int rowNum) throws SQLException {
			Schedular schedular = new Schedular();
			schedular.setExecution_time(rs.getString("EXECUTION_TIME"));
			schedular.setLog_file_path(rs.getString("LOG_FILE_PATH"));
			schedular.setTimestamp(rs.getDate("STATUS_DATE"));
			schedular.setStatus(rs.getInt("STATUS") == 1 ? "Success" : "Fail");
			schedular.setSchedular_id(rs.getInt("SCHEDULAR_ID"));
			schedular.setFailure_count(rs.getInt("FAILURE_COUNT"));
			schedular.setSuccess_count(rs.getInt("SUCCESS_COUNT"));
			schedular.setTotal_transactions(rs.getInt("TRANSACTIONS_TOTAL"));
			schedular.setSchedular_name(rs.getString("schedular_name"));
			schedular.setSchedular_category(rs.getString("Schedular_category"));
			schedular.setExecution_schedule(rs.getString("execution_schedule"));
			return schedular;
		}

	}

	public class SchedularCategoryRowMapper implements RowMapper<SchedularCategory> {
		@Override
		public SchedularCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
			SchedularCategory schedularcategory = new SchedularCategory();
			schedularcategory.setSchedular_category(rs.getString("schedular_name"));
			schedularcategory.setSchedular_id(rs.getInt("schedular_id"));
			return schedularcategory;
		}

	}

	public class SchedularMainRowMapper implements RowMapper<SchedularMain> {
		@Override
		public SchedularMain mapRow(ResultSet rs, int rowNum) throws SQLException {
			SchedularMain schedularmain = new SchedularMain();
			schedularmain.setSchedular_name(rs.getString("schedular_name"));
			schedularmain.setSchedular_id(rs.getInt("schedular_id"));
			return schedularmain;
		}

	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Schedular> findAllSchedular() {

		try {
			String sql = "SELECT A.execution_schedule, A.schedular_id, B.schedular_name, A.status, A.status_date, A.transactions_total, A.FAILURE_COUNT, "
					+ "A.SUCCESS_COUNT, A.EXECUTION_TIME, A.LOG_FILE_PATH, C.schedular_name as Schedular_category  "
					+ "FROM t_efrroschedulars_logs A " + "join tm_efrroschedulars B on A.schedular_id = B.schedular_id "
					+ "join tm_efrroschedulars_category C on C.schedular_id = B.schedular_category";
			return jdbcTemplate.query(sql, new SchedularRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<SchedularMain> findAllSchedularMain() {
		try {
			String sql = "select * from tm_efrroschedulars";
			return jdbcTemplate.query(sql, new SchedularMainRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<SchedularCategory> findAllSchedularCategory() {
		try {
			String sql = "select * from tm_efrroschedulars_category";
			return jdbcTemplate.query(sql, new SchedularCategoryRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Schedular> findAllSchedularByFilter(String date, String name, int status, String category) {
		// TODO Auto-generated method stub
		try {
			StringBuilder sql = new StringBuilder("SELECT A.execution_schedule, A.schedular_id, B.schedular_name, A.status, A.status_date, A.transactions_total, A.FAILURE_COUNT, "
					+ "A.SUCCESS_COUNT, A.EXECUTION_TIME, A.LOG_FILE_PATH, C.schedular_name as Schedular_category  "
					+ "FROM t_efrroschedulars_logs A " + "join tm_efrroschedulars B on A.schedular_id = B.schedular_id "
					+ "join tm_efrroschedulars_category C on C.schedular_id = B.schedular_category WHERE 1=1 ");
			if (status!=0) {
				sql.append(" AND A.status = " + status);
			}
			if (date != null && !date.isEmpty()) {
				sql.append(" AND A.status_date = '" + date + "'");
			}
			if (name != null && !name.isEmpty() && !name.equals("0")) {
				sql.append(" AND B.schedular_name = '" + name + "'");
			}
			if (category != null && !category.isEmpty() && !category.equals("0")) {
				sql.append(" AND C.schedular_name = '" + category + "'");
			}
			System.out.println(sql.toString());
			return jdbcTemplate.query(sql.toString(), new SchedularRowMapper());
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
