package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedular {
	
	private String schedular_name;
	private String execution_schedule;
	private String Schedular_category;
	private int schedular_id;
	private Date timestamp;
	private String status;
	private int total_transactions;
	private int success_count;
	private int failure_count;
	private String log_file_path;
	private String execution_time;
	
	
	public String getExecution_schedule() {
		return execution_schedule;
	}
	public void setExecution_schedule(String execution_schedule) {
		this.execution_schedule = execution_schedule;
	}
	public String getSchedular_name() {
		return schedular_name;
	}
	public void setSchedular_name(String schedular_name) {
		this.schedular_name = schedular_name;
	}
	public String getSchedular_category() {
		return Schedular_category;
	}
	public void setSchedular_category(String schedular_category) {
		Schedular_category = schedular_category;
	}
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
		
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
		return "Schedular [schedular_name=" + schedular_name + ", Schedular_category=" + Schedular_category
				+ ", schedular_id=" + schedular_id + ", timestamp=" + timestamp + ", status=" + status
				+ ", total_transactions=" + total_transactions + ", success_count=" + success_count + ", failure_count="
				+ failure_count + ", log_file_path=" + log_file_path + ", execution_time=" + execution_time + "]";
	}
	
	
	
	
	

}
