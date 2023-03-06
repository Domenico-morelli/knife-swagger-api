package it.its.nttdata.demo.database;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "o_id")
	long id;
	
	@Column(name = "o_knifeId")
	long knifeId;
	
	@Column(name = "o_quantity")
	Integer quantity;
	
	@Column(name = "o_shipDate")
	Date shipDate;
	
	@Column(name = "o_status")
	String status;
	
	@Column(name = "o_complete")
	Boolean complete;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getKnifeId() {
		return knifeId;
	}

	public void setKnifeId(Long knifeId) {
		this.knifeId = knifeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

public Order() {}

public Order(long id, long knifeId, Integer quantity, Date shipDate, String status, Boolean complete) {
	super();
	this.id = id;
	this.knifeId = knifeId;
	this.quantity = quantity;
	this.shipDate = shipDate;
	this.status = status;
	this.complete = complete;
}



}
