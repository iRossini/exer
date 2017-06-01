package com.luoxin.sssp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "SSSP_CUSINSTRUMENT")
@Entity
public class CusInstrument {
	private Integer id;
	private String name;
	private String factory;
	private String type;
	private Date inspectTime;
	private Department department;
	private Order order;
	private Customer customer;
	private Credential credential;

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

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSPECT_TIME")
	public Date getInspectTime() {
		return inspectTime;
	}

	public void setInspectTime(Date inspectTime) {
		this.inspectTime = inspectTime;
	}

	@JoinColumn(name = "DEPARTMENT_ID")
	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@JoinColumn(name = "ORDER_ID")
	@ManyToOne
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@JoinColumn(name = "CUSTOMER_ID")
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JoinColumn(name = "CREDENTIAL_ID", unique = true)
	@OneToOne
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	@Override
	public String toString() {
		return "CusInstrument [id=" + id + ", name=" + name + ", factory="
				+ factory + ", type=" + type + ", inspectTime=" + inspectTime
				+ ", department=" + department + ", order=" + order
				+ ", customer=" + customer + ", credential=" + credential + "]";
	}

}
