package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.ArrayList;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};
	


	private int numOfStudents;
	private int numOfCourses;
	//private Student[] students;
	//private Course[] courses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;

	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		
		//students = new Student[numOfStudents];
		//courses = new Course[numOfCourses];
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		ArrayList<Student>students = new ArrayList<Student>(numOfStudents);
	
		int num = 0 ;
		
		for(int i=0; ; i++) {
			String s = lines[i].split(",")[1].trim() ;
			
			
			if(studentExist(students,new Student(s)) == false) {
				students.add(num,new Student(s));
				num++;
			}
			if(num == numOfStudents) {
				return students;
			}
		}
		
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		
		// TODO: implement this method
	
		
	for(Student a :students) {
		if(a != null) {
			if(a.getName() .equals( student.getName())) {
				return true;
			}
		}
	}
	
	return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		int num = 0 ;
		ArrayList<Course>courses = new ArrayList<Course>(numOfCourses);
		
		for(int i=0; ; i++) {
			String s = lines[i].split(",")[2].trim() ;
			
			
			if(courseExist(courses,new Course(s)) == false) {
				courses.add(num,new Course(s));
				num++;
			}
			if(num == numOfCourses) {
				return courses;
			}
		} 
		
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		// TODO: implement this method
		
		
		for(Course b :courses) {
			
			if(b != null) {
				if(b.getCourseName() .equals( course.getCourseName())) {
					return true;
				}
			}
		}
		
		return false;
	}

}
