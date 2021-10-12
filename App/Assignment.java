package hacs;

import java.util.*;
import java.text.DateFormat;

public class Assignment {

	protected String assignName;
	protected String strAssignmentFilename;
	protected Date dueDate = new Date();
	protected String assignSpec;
	protected SolutionList theSolutionList = new SolutionList();
	protected Solution suggestSolution = new Solution();

	public Assignment() {
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date theDueDate) {
		this.dueDate = theDueDate;
	}

	public void setAssSpec(String theSpec) {
		this.assignSpec = theSpec;
	}
	
	public String getAssignName() {
		return assignName;
	}

	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}

	public boolean isOverDue() {
		Date today = new Date();
		if (today.after(this.dueDate)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public Solution addSolution() { Solution mySolution = new Solution(); return
	 * mySolution; }
	 */

	//// add the theSolution to the Solutionlist
	public void addSolution(Solution theSolution) {
		theSolutionList.add(theSolution);
	}

	/*
	 * public void submitSolution() { }
	 */
	
	public SolutionList getTheSolutionList() {
		return theSolutionList;
	}

	public void setTheSolutionList(SolutionList theSolutionList) {
		this.theSolutionList = theSolutionList;
	}

	/*
	 * public void getSolutionList() { }
	 */

	/*
	 * return the solution of the give name
	 */
	public Solution getSolution(String studentname) {
		SolutionIterator Iterator = new SolutionIterator(theSolutionList);
		return Iterator.next(studentname);
	}

	public Solution getSugSolution() {
		return suggestSolution;
	}

	public void setSuggestSolution(Solution suggestSolution) {
		this.suggestSolution = suggestSolution;
	}

	public SolutionIterator getSolutionIterator() {
		SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
		return theSolutionIterator;
	}

	public String toString() {
		return assignName;
	}

	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitAssignment(this);
	}
}