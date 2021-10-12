package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



@SuppressWarnings("serial")
public class StudentAssignmentMenu extends AssignmentMenu {

////  class AssignmentMenu
	private boolean boolSubmit = false;
	private Solution theSolution;

	JLabel lAssignmentName = new JLabel();
	JLabel lDueDate = new JLabel();
	JTextField tbSolution = new JTextField();
	JLabel lSuggestedSolution = new JLabel();
	JLabel lGrade = new JLabel();
	JButton bSubmit = new JButton();
	JButton bCancel = new JButton();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();

	public StudentAssignmentMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Assignment : ");
		jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
		this.getContentPane().setLayout(null);
		lAssignmentName.setText("jLabel2");
		lAssignmentName.setBounds(new Rectangle(258, 35, 282, 18));
		jLabel3.setText("Due Date");
		jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
		lDueDate.setText("jLabel4");
		lDueDate.setBounds(new Rectangle(254, 82, 294, 18));
		jLabel5.setText("Solution");
		jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
		tbSolution.setText("jTextField1");
		tbSolution.setBounds(new Rectangle(251, 127, 211, 22));
		jLabel6.setText("Suggested Solution");
		jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
		jLabel7.setText("Grade");
		jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
		lSuggestedSolution.setText("jLabel8");
		lSuggestedSolution.setBounds(new Rectangle(259, 169, 201, 18));
		lGrade.setText("jLabel9");
		lGrade.setBounds(new Rectangle(258, 226, 41, 18));
		bSubmit.setText("Submit");
		bSubmit.setBounds(new Rectangle(476, 124, 79, 29));
		bSubmit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bSubmitActionPerformed(e);
			}
		});
		bCancel.setText("Cancel");
		bCancel.setBounds(new Rectangle(475, 164, 79, 29));
		bCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bCancelActionPerformed(e);
			}
		});
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(lAssignmentName, null);
		this.getContentPane().add(lDueDate, null);
		this.getContentPane().add(tbSolution, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(lSuggestedSolution, null);
		this.getContentPane().add(lGrade, null);
		this.getContentPane().add(bSubmit, null);
		this.getContentPane().add(bCancel, null);
	}

	/*
	 * check if the student has already had a solution or not. if not , create a new
	 * solution for the student. after showing the solution attatch the soluiton;
	 */
	public void showMenu(Assignment assignment, Person thePerson) {
		//this.theAssignment = assignment;
		if (assignment != null) {
		SolutionIterator theIter = assignment.getSolutionIterator();
		theSolution = theIter.next(thePerson.getUserName());
		if (theSolution == null) {
			tbSolution.setText("");
			lGrade.setText("-1");
		} else {
			tbSolution.setText(theSolution.getSolutionFileName());
			lGrade.setText(theSolution.getGradeString());

		}

		lAssignmentName.setText(assignment.getAssignName());
		lDueDate.setText(assignment.getDueDate().toString());
		lSuggestedSolution.setText(assignment.getSugSolution().getSolutionFileName());

		setVisible(true);

		if (boolSubmit == true) {
			if (theSolution == null) {
				theSolution = new Solution();
				assignment.addSolution(theSolution);
			}
			theSolution.setTheAuthor(thePerson.userName);
			theSolution.setSolutionFileName(tbSolution.getText());
			theSolution.theSubmitData = new Date();
		
		  }
		}
	}

	void bSubmitActionPerformed(ActionEvent e) {
		boolSubmit = true;
		setVisible(false);
	}

	void bCancelActionPerformed(ActionEvent e) {
		boolSubmit = false;
		setVisible(false);
	}

}