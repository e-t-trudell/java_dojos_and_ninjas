package com.erictrudell.java_dojos_and_ninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninja")
public class NinjaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ninja_id;
	@NotNull(message="First name is required.")
	@Size(min=3, max=20, message="Name too small or too large")
	private String fName;
	@NotNull(message="Last name is required.")
	@Size(min=3, max=20, message="Name too small or too large")
	private String lName;
	@NotNull(message="Age is required.")
	@Min(value=18, message="Must be older than 18")
	@Max(value=99, message="Must be younger than 99")
	private int age;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private DojoModel dojo;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public NinjaModel() {
        
    }
   
	
	public Long getNinja_id() {
		return ninja_id;
	}
	public void setNinja_id(Long ninja_id) {
		this.ninja_id = ninja_id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public DojoModel getDojo() {
		return dojo;
	}
	public void setDojo(DojoModel dojo) {
		this.dojo = dojo;
	}
    
}
