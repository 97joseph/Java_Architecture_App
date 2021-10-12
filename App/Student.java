package hacs;

public class Student extends Person {

	public Student() {
		type = 0; // type=0: student
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		if (theLevel == 0) // 0: Highlevel defined in CourseSelectDlg.
		{
			theCourseMenu = new HighLevelCourseMenu();
		} else // 1: LowLevel
		{
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}