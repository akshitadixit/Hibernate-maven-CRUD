package com.example.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTS")
public class Subjects implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "college")
	@ManyToMany (mappedBy = "subjects", cascade = CascadeType.PERSIST)
	private List<College> college = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<College> getCollege() {
		return college;
	}

	public void setCollege(List<College> college) {
		this.college = college;
	}

	public void addCollege(College college){
		getCollege().add(college);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", college=" + college + "]";
	}

	public Subjects(String id, String name, List<College> college) {
		this.id = id;
		this.name = name;
		this.college = college;
	}

	public Subjects(String id, String name) {
		this.id = id;
		this.name = name;
		this.college = new ArrayList<College>();
	}

	public Subjects(){
		this.id = "-";
		this.name = "";
		this.college = new ArrayList<College>();
	}

}
