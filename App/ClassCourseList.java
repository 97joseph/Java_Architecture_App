package hacs;

import java.util.ArrayList;
import java.io.*;


@SuppressWarnings("serial")
public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	String courseFile = "CourseInfo.txt";
	//// initialize the list by reading from the file.
	@SuppressWarnings("resource")
	public void initializeFromFile() {
		try {
			BufferedReader file;
			String strCourseName = null;
			file = new BufferedReader(new FileReader(courseFile));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			;
		}
	}

	 public Course findCourseByCourseName(String CourseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			Course theCourse;
			theCourse = (Course) get(i);
			if (theCourse.getCourseName().compareTo(CourseName) == 0)
				return theCourse;
		}
		return null;
	}

}