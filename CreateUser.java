import java.io.*;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	String createInfo;
	
	public CreateUser(String id, String pw, String name, String role, String birth, String remark) {
		createInfo = (id +","+pw+','+name+","+role+","+birth+","+remark);
	}

	public void create(String User_ID, String User_Pw, String User_Name, String User_Role, String birth, String Remark) throws IOException {
		JFrame FrmCreate;
		String filename = "User.csv";
		File use= new File(filename);
		use.createNewFile();
		PrintWriter write = new PrintWriter(new FileWriter(use, true));
		Scanner scanner = new Scanner(new File(filename));
		
		BufferedReader reader = new BufferedReader(new FileReader(use));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		
		String[] userinfo = new String[lines];
		String u[] = new String[lines];
		String P[] = new String[lines];
		String N[] = new String[lines];
		String R[] = new String[lines];
		String B[] = new String[lines];
		String r[] = new String[lines];
		final int Lines = lines;
		for(int i = 0; i < lines; i++) {
			userinfo[i] = scanner.nextLine();
			String[] userinfos = userinfo[i].split(",");
			u[i] = userinfos[0];
			P[i] = userinfos[1];
			N[i] = userinfos[2];
			R[i] = userinfos[3];
			B[i] = userinfos[4];
			r[i] = userinfos[5];
		}
		scanner.close();
		
		FrmCreate = new JFrame("Create User");
		FrmCreate.setTitle("Create User");
		FrmCreate.setBounds(100, 100, 450, 300);
		FrmCreate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrmCreate.setVisible(true);
		FrmCreate.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PW:");
		lblNewLabel.setBounds(10, 65, 46, 15);
		FrmCreate.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 90, 46, 15);
		FrmCreate.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(10, 38, 46, 15);
		FrmCreate.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Role:");
		lblNewLabel_3.setBounds(10, 115, 46, 15);
		FrmCreate.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Birth year:");
		lblNewLabel_4.setBounds(10, 142, 74, 15);
		FrmCreate.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Remark:");
		lblNewLabel_5.setBounds(10, 171, 57, 15);
		FrmCreate.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(83, 35, 96, 21);
		FrmCreate.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(83, 62, 96, 21);
		FrmCreate.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(83, 87, 96, 21);
		FrmCreate.getContentPane().add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(83, 168, 96, 21);
		FrmCreate.getContentPane().add(textField_5);
		
		String[] chooseRole = { "Admin", "GUser"};
		JComboBox comboBox = new JComboBox(chooseRole);
		comboBox.setBounds(83, 111, 96, 23);
		FrmCreate.getContentPane().add(comboBox);
		
		String[] chooseYear = new String[70];
		int[] intArray = IntStream.rangeClosed(1950, 2019).toArray();
		
		for(int i = 0; i < intArray.length; i++) {
			chooseYear[i] = Integer.toString(intArray[i]);
		}
		
		JComboBox comboBox_1 = new JComboBox(chooseYear);
		comboBox_1.setBounds(83, 138, 96, 23);
		FrmCreate.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String remark = textField_5.getText();
				String role = comboBox.getSelectedItem().toString();
				String name = textField_2.getText();
				String pw = textField_1.getText();
				String ID = textField.getText();
				String Birth = comboBox_1.getSelectedItem().toString();
				Boolean success = true;
				if(remark.isEmpty()){
					remark = ("-");
				}
				for(int i = 0; i < Lines; i ++ )
				if(ID.equals(u[i])) {
					JOptionPane.showMessageDialog(FrmCreate, "The ID is already used by others");
					success = false;
				}
				if(success != false) {
				CreateUser us = new CreateUser(ID, pw, name, role, Birth, remark);
				write.println(us.createInfo);
				JOptionPane.showMessageDialog(FrmCreate, "Create Successfully");
				write.close();
				FrmCreate.setVisible(false);
				new User(null, null, null, null, null, null).userinfo(User_ID, User_Pw, User_Name, User_Role, birth, Remark);
			
			}
			}
		});
		btnNewButton.setBounds(256, 199, 87, 23);
		FrmCreate.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User(null, null, null, null, null, null).userinfo(User_ID, User_Pw, User_Name, User_Role, birth, Remark);
				FrmCreate.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(325, 30, 87, 23);
		FrmCreate.getContentPane().add(btnNewButton_1);
	}
}
