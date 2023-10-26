package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedular {
	
	private int schedular_id;
	private Date timestamp;
	private int status;
	private int total_transactions;
	private int success_count;
	private int failure_count;
	private String log_file_path;
	private String execution_time;
	public int getSchedular_id() {
		return schedular_id;
	}
	public void setSchedular_id(int schedular_id) {
		this.schedular_id = schedular_id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		
		SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
		mdyFormat.format(timestamp);
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotal_transactions() {
		return total_transactions;
	}
	public void setTotal_transactions(int total_transactions) {
		this.total_transactions = total_transactions;
	}
	public int getSuccess_count() {
		return success_count;
	}
	public void setSuccess_count(int success_count) {
		this.success_count = success_count;
	}
	public int getFailure_count() {
		return failure_count;
	}
	public void setFailure_count(int failure_count) {
		this.failure_count = failure_count;
	}
	public String getLog_file_path() {
		return log_file_path;
	}
	public void setLog_file_path(String log_file_path) {
		this.log_file_path = log_file_path;
	}
	public String getExecution_time() {
		return execution_time;
	}
	public void setExecution_time(String execution_time) {
		this.execution_time = execution_time;
	}
	@Override
	public String toString() {
		return "Schedular [schedular_id=" + schedular_id + ", timestamp=" + timestamp + ", status=" + status
				+ ", total_transactions=" + total_transactions + ", success_count=" + success_count + ", failure_count="
				+ failure_count + ", log_file_path=" + log_file_path + ", execution_time=" + execution_time + "]";
	}
	
	
	
	

}
