package com.example.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.hibernate.model.Clas;
import com.example.hibernate.model.College;
import com.example.hibernate.model.Student;
import com.example.hibernate.model.Subjects;
import com.example.hibernate.model.Teacher;

/**
 * Class used to perform CRUD operation on database with Hibernate API's
 * 
 */
public class Demo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Demo application = new Demo();

		/*
		 * Save few objects with hibernate
		 */

		College college1 = new College(34221, "IIIT", "WB", "Kalyani", 360);
		College college2 = new College(10438, "IIT", "UP", "Kanpur", 1000);

		Subjects sub1 = new Subjects("CS101", "Operating System");
		Subjects sub2 = new Subjects("EC203", "Signals and System");
		Subjects sub3 = new Subjects("MA112", "Statistics");
		Subjects sub4 = new Subjects("CS301", "Algorithms I");

		college1.addSubject(sub1);
		college1.addSubject(sub2);
		college1.addSubject(sub3);
		college1.addSubject(sub4);
		college2.addSubject(sub1);
		college2.addSubject(sub3);
		college2.addSubject(sub4);

		sub1.addCollege(college1);
		sub2.addCollege(college1);
		sub3.addCollege(college1);
		sub4.addCollege(college1);

		sub1.addCollege(college2);
		sub3.addCollege(college2);
		sub4.addCollege(college2);

		Teacher t1 = new Teacher(245, "Dr. Bhaskar", sub2, college1);
		Teacher t2 = new Teacher(246, "Mr. Mukherjee", sub3, college1);
		Teacher t3 = new Teacher(247, "Dr. Jain", sub2, college1);
		Teacher t4 = new Teacher(248, "Dr. Pratihar", sub1, college1);

		Teacher t5 = new Teacher(930, "Mr. Gupta", sub1, college2);
		Teacher t6 = new Teacher(932, "Mr. Vishwas", sub3, college2);
		Teacher t7 = new Teacher(930, "Dr. Giridas", sub1, college2);

		Clas c1 = new Clas(23, 75, college1);
		Clas c2 = new Clas(19, 106, college1);
		Clas c3 = new Clas(24, 212, college2);
		c1.addTeacher(t1);
		c1.addTeacher(t2);
		c1.addTeacher(t3);
		c1.addTeacher(t4);
		c2.addTeacher(t3);
		c2.addTeacher(t2);
		c3.addTeacher(t5);
		c3.addTeacher(t6);
		c3.addTeacher(t7);

		List<Subjects> subs1 = new ArrayList<>();
		subs1.add(sub1);
		subs1.add(sub2);

		List<Subjects> subs2 = new ArrayList<>();
		subs2.add(sub1);
		subs1.add(sub2);
		subs2.add(sub3);

		List<Subjects> subs3 = new ArrayList<>();
		subs3.add(sub1);
		subs3.add(sub4);
		subs3.add(sub3);

		Student s1 = new Student(19009, "Akshita", c1, subs1, college1);
		Student s2 = new Student(19012, "Medhir", c2, subs2, college1);
		Student s3 = new Student(19034, "Isha", c3, subs3, college2);

		saveColl(college1);
		saveColl(college2);
		saveSubj(sub1);
		saveSubj(sub2);
		saveSubj(sub3);
		saveSubj(sub4);
		saveStud(s1);
		saveStud(s2);
		saveStud(s3);
		//save(s3);
		
		saveTeach(t1);
		saveTeach(t2);
		saveTeach(t3);
		saveTeach(t4);
		saveTeach(t5);
		saveTeach(t6);
		saveTeach(t7);
		saveClas(c1);
		saveClas(c2);
		saveClas(c3);
		

	}

	public static void saveStud(Student s){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	//common method to save

	public static void save(Object entityObject){
		if(entityObject!=null){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(entityObject);
		session.getTransaction().commit();
		session.close();


		//session.createQuery("select * from student;")
		}

	}

	public static void saveSubj(Subjects s){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveTeach(Teacher s){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveClas(Clas s){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveColl(College s){
		Session session = Util.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

}
