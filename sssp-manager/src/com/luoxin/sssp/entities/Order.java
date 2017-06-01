package com.luoxin.sssp.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "SSSP_ORDER")
@Entity
public class Order {
	private Integer id;
	private Date date;
	private Customer customer;
	private Set<CusInstrument> cusInstruments;

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JoinColumn(name = "CUSTOMER_ID")
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToMany(mappedBy = "order")
	public Set<CusInstrument> getCusInstruments() {
		return cusInstruments;
	}

	public void setCusInstruments(Set<CusInstrument> cusInstruments) {
		this.cusInstruments = cusInstruments;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", customer=" + customer
				+ ", cusInstruments=" + cusInstruments + "]";
	}

}
