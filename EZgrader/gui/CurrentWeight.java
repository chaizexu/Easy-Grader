package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.Category;
import objects.Course;

public class CurrentWeight {

	protected JFrame frame;


	public CurrentWeight(Course course) {
		initialize(course);
	}


	private void initialize(Course course) {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 78, 821, 443);
		panel.setLayout(null);
		JLabel label_type = new JLabel();
		label_type.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		label_type.setBounds(72, 31, 200, 50);
		label_type.setText("UnderGraduate");
		panel.add(label_type);

		
		JLabel lblGraduate = new JLabel();
		lblGraduate.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblGraduate.setText("Graduate");
		lblGraduate.setBounds(300, 48, 200, 16);
		panel.add(lblGraduate);
		frame.getContentPane().add(panel);
		List<Category> categoryList = course.getCategoryList();
		int increment = 0;
		for (Category category : categoryList) {
			JLabel label_sw = new JLabel();
			label_sw.setText(category.getCategoryName() + " :" + category.getUgWeight());


			
			label_sw.setBounds(72, 100+increment, 200, 30);

			
			JLabel label_g = new JLabel();
			label_g.setText(category.getCategoryName() + " :" + category.getGWeight());

			
			label_g.setBounds(300, 100+increment, 200, 30);

			

			
			panel.add(label_sw);

			panel.add(label_g);

			
			increment += 50;

		}
		JButton changeUG = new JButton();
		changeUG.setBounds(68, 100+increment, 100, 30);
		changeUG.setText("change");
		changeUG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeWeightU change = new ChangeWeightU(course);
				frame.dispose();
				change.frame.setVisible(true);
			}});
		panel.add(changeUG);
		
		JButton changeG = new JButton();
		changeG.setBounds(300, 100+increment, 100, 30);
		changeG.setText("change");
		changeG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeWeightG change = new ChangeWeightG(course);
				frame.dispose();
				change.frame.setVisible(true);
			}});
		panel.add(changeG);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(520, 100 + increment, 100, 30);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CourseDetail c = new CourseDetail();
				c.run(course.getCourseId());
			}});
		panel.add(btnCancel);
		
	}

}
