package com.erictrudell.java_dojos_and_ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="dojo")
public class DojoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dojo_id;
	@NotNull(message="name is required.")
	@Size(min=3, max=20, message="Name too small or too large")
	private String name;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    @OneToMany(mappedBy="dojo",fetch=FetchType.LAZY)
	private List<NinjaModel> ninjas;
    public DojoModel() {}
	
	public Long getDojo_id() {
		return dojo_id;
	}
	public void setDojo_id(Long dojo_id) {
		this.dojo_id = dojo_id;
	}
	public List<NinjaModel> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<NinjaModel> ninjas) {
		this.ninjas = ninjas;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
    
}
