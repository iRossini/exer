package com.luoxin.sssp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "SSSP_CREDENTIAL")
@Entity
public class Credential {
	private Integer id;
	private CusInstrument cusInstrument;
	private Integer status;// 证书状态。0表示未完成，1表示已完成。默认为0

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "credential")
	public CusInstrument getCusInstrument() {
		return cusInstrument;
	}

	public void setCusInstrument(CusInstrument cusInstrument) {
		this.cusInstrument = cusInstrument;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", cusInstrument=" + cusInstrument
				+ ", status=" + status + "]";
	}

}
