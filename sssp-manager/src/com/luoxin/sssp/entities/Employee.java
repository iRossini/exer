package com.luoxin.sssp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "SSSP_EMPLOYEE")
@Entity
public class Employee {
	private Integer id;
	private String name;
	private String phone;
	private Date birth;
	private Date joinTime;
	private String password;
	private Department department;

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JOIN_TIME")
	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// ”≥…‰µ•œÚn-1
	@JoinColumn(name = "DEPARTMENT_ID")
	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", birth=" + birth + ", joinTime=" + joinTime + ", password="
				+ password + ", department=" + department + "]";
	}

}
