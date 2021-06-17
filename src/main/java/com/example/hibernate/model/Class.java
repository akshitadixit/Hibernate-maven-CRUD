package com.example.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS")
public class Class implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int section;

	@Column(name = "STRENGTH", nullable = false)
	private int strength;

	@Column(name = "TEACHER", nullable = false)
	private String teacher;

	public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + section;
        result = prime * result + strength;
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        return result;
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Class other = (Class) obj;
        if (section != other.section)
            return false;
        if (strength != other.strength)
            return false;
        if (teacher == null) {
            if (other.teacher != null)
                return false;
        } else if (!teacher.equals(other.teacher))
            return false;
        return true;
    }
    
	@Override
    public String toString() {
        return "Class [section=" + section + ", strength=" + strength + ", teacher=" + teacher + "]";
    }

}
