import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class All_UserRecord {

	public void Dis(String User_ID, String User_Pw, String User_Name, String User_Role, String Birth, String Remark) throws IOException {
		JFrame Frmdis;
		String filename = "G07User.csv";
		File use= new File(filename);
		
		Frmdis = new JFrame("display user");
		Frmdis.setTitle("Display User");
		Frmdis.setBounds(100, 100, 450, 300);
		Frmdis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frmdis.setVisible(true);
		Frmdis.getContentPane().setLayout(null);
		
		Scanner scanner = new Scanner(new File(filename));
		
		BufferedReader rd = new BufferedReader(new FileReader(use));
		int lines = 0;
		while (rd.readLine() != null) lines++;
		rd.close();
		
		String[] userinfo = new String[lines];
		for(int i = 0; i < lines; i++) {
			userinfo[i] = scanner.nextLine();
		}
		scanner.close();
		
		JComboBox comboBox = new JComboBox(userinfo);
		comboBox.setBounds(37, 107, 368, 23);
		Frmdis.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempFile = "try.csv";
				File newFile = new File(tempFile);
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(use));
				} catch (IOException e2) {
				}
				int lines = 0;
				try {
					while (reader.readLine() != null) lines++;
				} catch (IOException e2) {
				}
				try {
					reader.close();
				} catch (IOException e2) {
				}
				int i = 0;
				String getstring = comboBox.getSelectedItem().toString();
				
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(tempFile,true);
				} catch (IOException e1) {
				}
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				Scanner scan = null;
				try {
					scan = new Scanner(use);
				} catch (IOException e1) {
				}
				
				while(i<lines) {
					String str = scan.nextLine();
					if(!getstring.equals(str)) {
						pw.println(str);
					}
					i++;	
				}
				
				scan.close();
				pw.flush();
				pw.close();
				use.delete();
				File dump = new File("G07User.csv");
				newFile.renameTo(dump);
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				new User(null,null,null,null,null,null).userinfo(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
				Frmdis.setVisible(false);
			}
			});
		btnNewButton.setBounds(37, 228, 87, 23);
		Frmdis.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User(null,null,null,null,null,null).userinfo(User_ID, User_Pw, User_Name, User_Role, Birth, Remark);
				Frmdis.setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(202, 228, 87, 23);
		Frmdis.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblUidencryptedpwdunameuroleyearofbirthremarks = new JLabel("User_ID, Encrypted_Password, User_Name, User_Role, Year_of_Birth, Remarks");
		lblUidencryptedpwdunameuroleyearofbirthremarks.setBounds(24, 82, 378, 15);
		Frmdis.getContentPane().add(lblUidencryptedpwdunameuroleyearofbirthremarks);
		Frmdis.setVisible(true);
	}
}
