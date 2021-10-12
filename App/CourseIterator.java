package hacs;

import java.util.Iterator;


public class CourseIterator implements Iterator<Course> {
	private ClassCourseList theCourseList;
	private int currentCourseNumber = -1;

	public CourseIterator() {
	}

	public CourseIterator(ClassCourseList courseList) {
		theCourseList = courseList;
	}

	public boolean hasNext() {
		if (currentCourseNumber >= theCourseList.size() - 1)
			return false;
		else
			return true;
	}

	public Course next() {
		if (hasNext() == true) {
			currentCourseNumber++;
			return theCourseList.get(currentCourseNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		int size = theCourseList.size();
		theCourseList.remove(size-1);
	}

// the next Course that fits the given CourseName
	public Course next(String CourseName) {
		Course theCourse;
		theCourse = (Course) next();
		while (theCourse != null) {
			if (CourseName.compareTo(theCourse.toString()) == 0) {
				return theCourse;
			}
			theCourse = (Course) next();
		}
		return null;
	}

}