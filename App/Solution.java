package hacs;

import java.util.*;


public class Solution {
	protected String theAuthor = "";
	protected String solutionFileName = "";
	Date theSubmitData = new Date();
	protected int theGrade;
	protected boolean reported = false;

	public Solution() {
	}

	@Override
	public String toString() {
		String string;
		string = theAuthor + "  " + solutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return (string);
	}

	public String getTheAuthor() {
		return theAuthor;
	}

	public void setTheAuthor(String theAuthor) {
		this.theAuthor = theAuthor;
	}

	public String getSolutionFileName() {
		return solutionFileName;
	}

	public void setSolutionFileName(String solutionFileName) {
		this.solutionFileName = solutionFileName;
	}

	public int getTheGrade() {
		return theGrade;
	}

	public void setTheGrade(int theGrade) {
		this.theGrade = theGrade;
	}

	String getGradeString() {
		if (isReported())
			return "" + theGrade;
		else
			return "-1";
	}

	int getGradeInt() {
		return theGrade;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isReported() {
		return reported;
	}
}