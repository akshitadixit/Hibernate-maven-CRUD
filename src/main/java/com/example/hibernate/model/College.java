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
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE")
public class College implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "state", nullable = false)
	private String state;

    @Column(name = "city", nullable = false)
	private String city;

	@Column(name = "strength", nullable = false)
	private int strength;

    @Column(name = "subjects")
    @ManyToMany (cascade = CascadeType.PERSIST)
	private List<Subjects> subjects = new ArrayList<>();


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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    @Override
    public String toString() {
        return "College [city=" + city + ", id=" + id + ", name=" + name + ", state=" + state + ", strength=" + strength
                + ", subjects=" + subjects + "]";
    }

    public College(int id, String name, String state, String city, int strength, List<Subjects> subjects) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.city = city;
        this.strength = strength;
        this.subjects = subjects;
    }

    public College(int id, String name, String state, String city, int strength) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.city = city;
        this.strength = strength;
        this.subjects = new ArrayList<Subjects>();
    }

    public College() {
        this.id = 1;
        this.name = "";
        this.state = "";
        this.city = "";
        this.strength = 0;
        this.subjects = new ArrayList<Subjects>();
    }
}
