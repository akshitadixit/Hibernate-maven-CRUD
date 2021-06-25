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
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "classes")
    @ManyToMany (cascade = CascadeType.PERSIST)
	private List<Clas> classes = new ArrayList<>();

    @JoinColumn(name = "subject")
    @OneToOne (cascade = CascadeType.PERSIST)
	private Subjects subject;

    @JoinColumn(name = "college")
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

    public List<Clas> getClasses() {
        return classes;
    }

    public void setClasses(List<Clas> classes) {
        this.classes = classes;
    }

    public void addClass(Clas clas){
        getClasses().add(clas);
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Teacher [classes=" + classes + ", id=" + id + ", name=" + name + ", subject=" + subject + ", college=" + college +"]";
    }

    public Teacher(int id, String name, List<Clas> classes, Subjects subject, College college) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.subject = subject;
        this.college = college;
    }

    public Teacher(int id, String name, Subjects subject, College college) {
        this.id = id;
        this.name = name;
        this.classes = new ArrayList<Clas>();
        this.subject = subject;
        this.college = college;
    }

    public Teacher() {
        this.id = 1;
        this.name = "";
        this.classes = new ArrayList<Clas>();
        this.subject = new Subjects();
        this.college = new College();
    }

}
