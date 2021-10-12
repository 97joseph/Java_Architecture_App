package hacs;

public class Instructor extends Person {
	public Instructor() {
		type = 1;// type=1 :instructor
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		if (theLevel == 0)/// 0: Highlevel defined in CourseSeletDlg.
		{
			theCourseMenu = new HighLevelCourseMenu();
		} else/// 1: LowLevel
		{
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}