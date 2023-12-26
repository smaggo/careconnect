package com.samitamaggo.careconnect.web.dto;


public class AppointmentDto {
	
	private Long id;
	private String department;
	private String date;
	private String name;
	private String description;
	private String time;


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public AppointmentDto() {
		
	}

	public AppointmentDto(Long id, String department, String date, String name, String description, String time) {
		super();
		this.id = id;
		this.department = department;
		this.date = date;
		this.name = name;
		this.description = description;
		this.time = time;
	}

	

	
	
	
	

}
