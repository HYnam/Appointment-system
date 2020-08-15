import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User {
	String user_ID;
	String user_pw;
	String user_Name;
	String user_Role;
	String birth;
	String remark;
public User(String User_ID, String User_Pw, String User_Name, String User_Role, String Birth, String Remark){
		user_ID = User_ID;
		user_pw = User_Pw;
		user_Name = User_Name;
		user_Role = User_Role;
		birth = Birth;
		remark = Remark;
	}
		public static void loginsys() throws IOException{
		JFrame frmLogin;
		JTextField Lname;
		JTextField Passw;
		String filename = "User.csv";
		File use= new File(filename);
		Scanner scanner = new Scanner(new File(filename));
		
		BufferedReader reader = new BufferedReader(new FileReader(use));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		
		String[] userinfo = new String[lines];
		String User_ID[] = new String[lines];
		String User_Pw[] = new String[lines];
		String User_Name[] = new String[lines];
		String User_Role[] = new String[lines];
		String Birth[] = new String[lines];
		String Remarks[] = new String[lines];
		final int Lines = lines;
		for(int i = 0; i < lines; i++) {
			userinfo[i] = scanner.nextLine();
			String[] userinfos = userinfo[i].split(",");
			User_ID[i] = userinfos[0];
			User_Pw[i] = userinfos[1];
			User_Name[i] = userinfos[2];
			User_Role[i] = userinfos[3];
			Birth[i] = userinfos[4];
			Remarks[i] = userinfos[5];
		}
scanner.close();
frmLogin = new JFrame("login window");
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);
		frmLogin.getContentPane().setLayout(null);
		JLabel Logname = new JLabel("Login Name:");
		Logname.setBounds(77, 92, 75, 23);
		frmLogin.getContentPane().add(Logname);
		
		Lname = new JTextField();
		Lname.setBounds(157, 93, 141, 21);
		Lname.setBackground(Color.WHITE);
		frmLogin.getContentPane().add(Lname);
		Lname.setColumns(10);
		
		JLabel Passwd = new JLabel("Password:");
		Passwd.setBounds(77, 120, 75, 23);
		frmLogin.getContentPane().add(Passwd);
		
		Passw = new JTextField();
		Passw.setBounds(157, 120, 141, 21);
		Passw.setBackground(Color.WHITE);
		frmLogin.getContentPane().add(Passw);
		Passw.setColumns(10);
JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ac = Lname.getText();
				String passValue = Passw.getText();
				for(int i = 0; i < Lines; i++) {
					if((ac.equals(User_ID[i])) && (passValue.equals(User_Pw[i]))) {
						JOptionPane.showMessageDialog(null, "Login Successfully");
						long recorded_time = System.currentTimeMillis();
						String Recorded_time = Long.toString(recorded_time);
						try {
							new My_LoginRecord(null,null,null,null).recordwri(ac, Recorded_time);
						} catch (IOException e1) {
						}
						userinfo(User_ID[i], User_Pw[i], User_Name[i], User_Role[i], Birth[i], Remarks[i]);
						frmLogin.setVisible(false);
						break;
					}
					else if( (i == (Lines-1)) && ((!ac.equals(User_ID[i])) || (!passValue.equals(User_Pw[i]))))
						JOptionPane.showMessageDialog(null, "Please input valid Account and Password");
					}
			}});
		btnLogin.setBounds(178, 181, 87, 23);
		frmLogin.getContentPane().add(btnLogin);
	}

	public static void userinfo(String User_ID, String User_Pw, String User_Name, String User_Role, String Birth, String Remark) {
		User user = new User(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
		
		JFrame disUser;
		disUser = new JFrame("User information");
		disUser.setTitle("User");
		disUser.setBounds(100, 100, 450, 300);
		disUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		disUser.setVisible(true);
		disUser.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PW:");
		lblNewLabel.setBounds(10, 65, 46, 15);
		disUser.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 90, 46, 15);
		disUser.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(10, 38, 46, 15);
		disUser.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Role:");
		lblNewLabel_3.setBounds(10, 115, 46, 15);
		disUser.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Birth:");
		lblNewLabel_4.setBounds(10, 142, 46, 15);
		disUser.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Remark:");
		lblNewLabel_5.setBounds(10, 171, 57, 15);
		disUser.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(user.user_ID);
		lblNewLabel_6.setBounds(54, 38, 227, 15);
		disUser.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(user.user_pw);
		lblNewLabel_7.setBounds(54, 65, 206, 15);
		disUser.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(user.user_Name);
		lblNewLabel_8.setBounds(54, 90, 193, 15);
		disUser.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(user.user_Role);
		lblNewLabel_9.setBounds(54, 115, 206, 15);
		disUser.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(user.birth);
		lblNewLabel_10.setBounds(54, 142, 216, 15);
		disUser.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(user.remark);
		lblNewLabel_11.setBounds(65, 171, 205, 15);
		disUser.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("User information");
		lblNewLabel_12.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(10, 10, 216, 15);
		disUser.getContentPane().add(lblNewLabel_12);
		
		if(!user.user_Role.equals("Admin")) {
			JButton programme = new JButton("Programme");
			programme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
new programme().programme(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
						disUser.setVisible(false);
				}
			});
			programme.setBounds(270, 10, 130, 23);
			disUser.getContentPane().add(programme);}
			JButton History = new JButton("My Login History");
		History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new My_LoginRecord(null,null,null,null).recordcall(User_ID);
				} catch (IOException e1) {}
			}
		});
		History.setBounds(270, 50, 130, 23);
		disUser.getContentPane().add(History);
		JButton Aboutus = new JButton("AboutUs");
		Aboutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs().aboutus();
					
			}
		});
		Aboutus.setBounds(46, 211, 87, 23);
		disUser.getContentPane().add(Aboutus);
		
		if(user.user_Role.equals("Admin")) {
			JButton createBut = new JButton("Create new User account");
			createBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							new CreateUser(null, null, null,
							null ,null ,null).create(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
						} catch (IOException e1) {
						}
disUser.setVisible(false);
				}
			});	
			createBut.setBounds(230, 100, 200, 23);
			disUser.getContentPane().add(createBut);
			
			JButton DisUser = new JButton("Display all user");
			DisUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							new All_UserRecord().Dis(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
						} catch (IOException e1) {
						}
				disUser.setVisible(false);
				}
			});	
			DisUser.setBounds(230, 150, 200, 23);
			disUser.getContentPane().add(DisUser);
			
			JButton LogRe = new JButton("Display all user's login record");
			LogRe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							new All_LoginRecord(null, null, null, null).Display_AllRecord();
						} catch (IOException e1) {
						}
				}
			});	
			LogRe.setBounds(180, 200, 250, 23);
			disUser.getContentPane().add(LogRe);
		}
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String option[] = {"Logout", "Back"};
				int choice = JOptionPane.showOptionDialog(null, "Remember to save your unrecorded updates", null,
														JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
				if(choice == 0) {
					try {
						loginsys();
						disUser.setVisible(false);
					} catch (IOException e1) {
					}
				}
				
			}
		});
		btnNewButton.setBounds(270, 230, 130, 23);
		disUser.getContentPane().add(btnNewButton);
	}
}








		

