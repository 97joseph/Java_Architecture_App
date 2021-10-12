package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class SolutionGradingDlg extends JDialog {
	Solution theSolution;
	JLabel jLabel1 = new JLabel();
	JTextField tfGrad = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelSolutionFileName = new JLabel();

	public SolutionGradingDlg() {
		try {
			jbInit();
			setSize(316, 186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Solution File Name");
		jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
		this.getContentPane().setLayout(null);
		tfGrad.setBounds(new Rectangle(25, 66, 100, 22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOkActionPerformed(e);
			}
		});
		labelSolutionFileName.setBounds(new Rectangle(212, 34, 163, 18));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tfGrad, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Solution solution) {
		theSolution = solution;
		tfGrad.setText("" + theSolution.getGradeInt());
		labelSolutionFileName.setText(theSolution.getSolutionFileName());
		setVisible(true);
	}

	void buttonOkActionPerformed(ActionEvent e) {
		theSolution.setTheGrade(Integer.parseInt(tfGrad.getText()));
		setVisible(false);
	}

}