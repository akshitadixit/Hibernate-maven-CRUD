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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@JoinColumn(name = "class")
	@ManyToOne (cascade = CascadeType.PERSIST)
	private Clas clas;

	@Column(name = "subjects")
	@ManyToMany (cascade = CascadeType.PERSIST)
	private List<Subjects> subjects = new ArrayList<>();

	@JoinColumn(name = "college")//, referencedColumnName = "id")
	@ManyToOne (cascade = CascadeType.PERSIST)
	private College college;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public Clas getClass() {
		return clas;
	}*/

	public void setClass(Clas clas) {
		this.clas = clas;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(Subjects subject){
		this.getSubjects().add(subject);
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [clas=" + clas + ", college=" + college + ", id=" + id + ", name=" + name + ", subjects="
				+ subjects + "]";
	}

	public Student(int id, String name, Clas clas, List<Subjects> subjects, College college) {
		this.id = id;
		this.name = name;
		this.clas = clas;
		this.subjects = subjects;
		this.college = college;
	}

	public Student() {
		this.id = 1;
		this.name = "";
		this.clas = new Clas();
		this.subjects = new ArrayList<Subjects>();
		this.college = new College();
	}

}
