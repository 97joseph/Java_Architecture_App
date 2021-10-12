package hacs;

import java.util.Iterator;
import java.util.*;

/

/*
 * this class will iterate the course list attatched to on student and in turn
 * iterate the assignments of a course. after Function Visit(CourseList) it will
 * point to the location before the fist class, hasNext will retrun 
 * there is next item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends NodeVisitor {

	Reminder mReminder;

	public ReminderVisitor() {
	}

	public ReminderVisitor(Reminder reminder) {
		mReminder = reminder;
	}

	public void visitFacade(Facade facade) {
		CourseIterator courseList = new CourseIterator(facade.theCourseList);
		while (courseList.hasNext()) {
			Course course = (Course) courseList.next();
			course.accept(this);
		}
	}

	public void visitCourse(Course course) {
		Iterator<Assignment> assignmentList = course.getAssignmentList().listIterator();
		while (assignmentList.hasNext()) {
			Assignment assignment = assignmentList.next();
			assignment.accept(this);
		}
	}

	public void visitAssignment(Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.getDueDate());
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			mReminder.listUpcoming.add("today is " + today.toString() + " " + assignment.getAssignName() + " Due Date is "
					+ assignment.getDueDateString());
		}
		if (nDueDate < ntoday) {
			// put to the
			mReminder.listOverdue.add(assignment.getAssignName() + " Due Date is " + assignment.getDueDateString());
		}

	}

}