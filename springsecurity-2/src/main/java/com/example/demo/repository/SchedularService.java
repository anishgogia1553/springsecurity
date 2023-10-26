package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Schedular;


@Service
public class SchedularService implements SchedularRepository {
	
	
	public class SchedularRowMapper implements RowMapper<Schedular> {
	    @Override
	    public Schedular mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Schedular schedular = new Schedular();

	        schedular.setExecution_time(rs.getString("EXECUTION_TIME"));
	        schedular.setLog_file_path(rs.getString("LOG_FILE_PATH"));
	        schedular.setTimestamp(rs.getDate("STATUS_DATE"));
	        schedular.setStatus(rs.getInt("STATUS"));
	        schedular.setSchedular_id(rs.getInt("SCHEDULAR_ID"));
	        schedular.setFailure_count(rs.getInt("FAILURE_COUNT"));
	        schedular.setSuccess_count(rs.getInt("SUCCESS_COUNT"));
	        schedular.setTotal_transactions(rs.getInt("TRANSACTIONS_TOTAL"));
	       
	        return schedular;
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
			String sql = "SELECT * FROM t_efrroschedulars_logs";
			return jdbcTemplate.query(sql,new SchedularRowMapper());			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	

}
