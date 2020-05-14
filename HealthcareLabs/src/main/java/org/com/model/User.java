package org.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user1")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private String gender;
	private String email;
	private int age;
	private String userRole;
	private long phoneno;
	
//	@JsonManagedReference
//	@OneToOne(mappedBy = "user")
//    private Appointment appointment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Appointment getAppointment() {
//		return appointment;
//	}
//	public void setAppointment(Appointment appointment) {
//		this.appointment = appointment;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", email="
				+ email + ", age=" + age + ", userRole=" + userRole + ", phoneno=" + phoneno + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPassword()=" + getPassword() + ", getGender()=" + getGender()
				+ ", getEmail()=" + getEmail() + ", getAge()=" + getAge() + ", getUserRole()=" + getUserRole()
				+ ", getPhoneno()=" + getPhoneno() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
