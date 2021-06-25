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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS")
public class Clas implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int batch;

	@Column(name = "strength", nullable = false)
	private int strength;

    @JoinColumn(name = "college")
    @OneToOne (cascade = CascadeType.PERSIST)
	private College college;

	@Column(name = "teachers")
    @ManyToMany (mappedBy = "classes", cascade = CascadeType.PERSIST)
	private List<Teacher> teachers = new ArrayList<>();

	public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher){
        getTeachers().add(teacher);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Clas other = (Clas) obj;
        if (batch != other.batch)
            return false;
        if (strength != other.strength)
            return false;
        if (teachers == null) {
            if (other.teachers != null)
                return false;
        } else if (!teachers.equals(other.teachers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Class [batch=" + batch + ", strength=" + strength + ", teachers=" + teachers + "]";
    }

    public Clas(int batch, int strength, College college, List<Teacher> teachers) {
        this.batch = batch;
        this.strength = strength;
        this.college = college;
        this.teachers = teachers;
    }

    public Clas(int batch, int strength, College college) {
        this.batch = batch;
        this.strength = strength;
        this.college = college;
        this.teachers = new ArrayList<Teacher>();
    }

    public Clas() {
        this.batch = 1;
        this.college = new College();
        this.strength = 0;
        this.teachers = new ArrayList<Teacher>();
    }
}