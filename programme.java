import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class programme{
	
	public void programme(String User_ID, String User_Pw, String User_Name, String User_Role, String Birth, String Remark)  {
		
		JFrame programme = new JFrame();
		programme.setTitle("Functions List");
		programme.setBounds(100, 100, 450, 300);
		programme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		programme.getContentPane().setLayout(null);
		programme.setVisible(true);
		
		JButton programme_1 = new JButton("1");
		programme_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		programme_1.setBounds(10, 10, 110, 44);
		programme.getContentPane().add(programme_1);
		
		
		JButton programme_3 = new JButton("2");
		programme_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		programme_3.setBounds(10, 101, 110, 44);
		programme.getContentPane().add(programme_3);
		
		
		JButton programme_5 = new JButton("3");
		programme_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		programme_5.setBounds(10, 184, 110, 44);
		programme.getContentPane().add(programme_5);
		
		
		JButton programme_2 = new JButton("4");
		programme_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		programme_2.setBounds(144, 10, 110, 44);
		programme.getContentPane().add(programme_2);
		
		
		JButton programme_4 = new JButton("5");
		programme_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		programme_4.setBounds(144, 101, 110, 44);
		programme.getContentPane().add(programme_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new User(null, null, null, null, null, null).userinfo(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
				programme.setVisible(false);
			}
		});
		btnBack.setBounds(270, 9, 130, 23);
		programme.getContentPane().add(btnBack);
	}
}