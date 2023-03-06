package it.its.nttdata.demo.database;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Knife")
public class Knife {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "k_id")
	private long id;

	@Column(name = "k_name")
	private String name;

	@Column(name = "k_photos")
	@ElementCollection	(fetch = FetchType.EAGER)
	private List<String> photoUrls;

	@Column(name = "k_availability")
	private String availability;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Knife(String name, List<String> photoUrls, String availability) {
		super();
		this.name = name;
		this.photoUrls = photoUrls;
		this.availability = availability;
	}

	public Knife(long id, String name, List<String> photoUrls, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.photoUrls = photoUrls;
		this.availability = availability;
	}

	public Knife() {
		super();
	}

}
