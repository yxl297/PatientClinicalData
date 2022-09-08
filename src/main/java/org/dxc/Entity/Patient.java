package org.dxc.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String firstname;
	private String lastname;
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private List<ClinicalData> clinicalData;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<ClinicalData> getClinicalData() {
		return clinicalData;
	}
	public void setClinicalData(List<ClinicalData> clinicalData) {
		this.clinicalData = clinicalData;
	}

	






}
