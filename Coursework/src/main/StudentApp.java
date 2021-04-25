package main;

import lib.Student;
import lib.StudentTree;

public class StudentApp {

	public static void main(String[] args) {
		StudentTree head = new StudentTree();
		
		// Set level 6 students.
		Student P2531111 = new Student("P2531111");
		Student P2530001 = new Student("P2530001");
		
		// Set level 5 students.
		Student P2531120 = new Student("P2531120");
		Student P2532211 = new Student("P2532211");
		Student P2534141 = new Student("P2534141");
		Student P2530230 = new Student("P2530230");
		
		// Set level 4 students.
		Student P2530201 = new Student("P2530201");
		Student P2530150 = new Student("P2530150");
		Student P2530190 = new Student("P2030190");
		Student P2530210 = new Student("P2530210");
		Student P2530229 = new Student("P2530229");
		Student P2530250 = new Student("P2530250");
		
		// Set mentors for level 6 students. (Head - used for equality)
		P2531111.setMentor(head);
		P2530001.setMentor(head);
		
		// Set mentors for level 5 students.
		P2531120.setMentor(P2531111);
		P2532211.setMentor(P2531111);
		
		P2534141.setMentor(P2530001);
		P2530230.setMentor(P2530001);
		
		// Set mentors for level 4 students.
		P2530201.setMentor(P2531120);
		
		P2530150.setMentor(P2532211);
		P2530190.setMentor(P2532211);
		P2530210.setMentor(P2532211);
		
		P2530229.setMentor(P2534141);
		P2530250.setMentor(P2534141);
		
		// Welcomes the user.
		System.out.println("======PROGRAM DEMONSTRATION======\n");
		
		System.out.println("Has Mentees...");
		System.out.println("P2531120 has mentees = " + P2531120.hasMentees()); // Level 5 student.
		System.out.println("P2530201 has mentees = " + P2530201.hasMentees() + "\n"); // Level 4 student.
		
		System.out.println("Has Mentor...");
		System.out.println("P2531120 has mentees = " + P2531111.hasMentor()); // Level 6 student.
		System.out.println("P2530201 has mentees = " + P2530230.hasMentor() + "\n"); // Level 4 student.
		
		System.out.println("Set Mentor...");
		System.out.println("P2530190's old mentor = " + P2530190.getMentor().getPNumber()); // Level 5 student.
		P2530190.setMentor(P2534141);
		System.out.println("P2530190's new mentor = " + P2530190.getMentor().getPNumber() + "\n"); // Level 5 student.
		
		System.out.println("Remove Mentor...");
		System.out.println("P2530150's mentor = " + P2530150.getMentor().getPNumber());
		P2530150.removeMentor();
		System.out.println("P2530150's mentor = " + P2530150.getMentor() + "\n");
		
		System.out.println("Get Mentees...");
		System.out.println("P2530001's mentees = " + P2530001.getMentees());
		System.out.println("P2531120's mentees = " + P2531120.getMentees());
	}
}
