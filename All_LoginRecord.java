import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class All_LoginRecord extends My_LoginRecord {

	public All_LoginRecord(String loginrecord_ID, String ac, String Recorded_time, String logremarks) {
		super(loginrecord_ID, ac, Recorded_time, logremarks);
	}

	public void Display_AllRecord() throws IOException {
		Scanner scanner = new Scanner(fileRe);
		BufferedReader reader = new BufferedReader(new FileReader(fileRe));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		String[] rocinfos = new String[lines];
		String loginrecord_id[] = new String[lines];
		String user_id[] = new String[lines];
		String login_time[] = new String[lines];
		String remarks[] = new String[lines];
		String WholeLine[] = new String [lines];
		
		for(int i = 0; i < lines; i++) {
			rocinfos[i] = scanner.nextLine();
			String[] roc = rocinfos[i].split(",");
			loginrecord_id[i] = roc[0];
			user_id[i] = roc[1];
			login_time[i] = roc[2];
			remarks[i] = roc[3];
		}
		scanner.close();
		
		JFrame recordwin;
		recordwin = new JFrame();
		recordwin.setBounds(300, 300, 421, 255);
		recordwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recordwin.setVisible(true);
		recordwin.getContentPane().setLayout(null);
		
		JLabel lblYourAppointment = new JLabel("All User History");
		lblYourAppointment.setBounds(10, 10, 104, 15);
		recordwin.getContentPane().add(lblYourAppointment);
		
		JLabel lblLriduidlogintimeremarks = new JLabel("LoginRecord_ID, User_ID, Login_Time, Remarks");
		lblLriduidlogintimeremarks.setBounds(10, 26, 385, 15);
		recordwin.getContentPane().add(lblLriduidlogintimeremarks);
		for (int i = 0; i < lines; i++) {
			All_LoginRecord ALLre = new All_LoginRecord(loginrecord_id[i], user_id[i], login_time[i], remarks[i]);
			WholeLine[i] = (ALLre.LoginRecord_ID+","+ALLre.user_ID+","+ALLre.Login_Time+","+ALLre.LogRemarks);
		}
		
		JComboBox comboBox = new JComboBox(WholeLine);
		comboBox.setBounds(10, 51, 385, 23);
		recordwin.getContentPane().add(comboBox);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempFile = "try.csv";
				File newFile = new File(tempFile);
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(fileRe));
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
					scan = new Scanner(fileRe);
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
				fileRe.delete();
				File dump = new File("G07LoginRecord.csv");
				newFile.renameTo(dump);
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				recordwin.setVisible(false);
				
			}
		});
		btnDelete.setBounds(53, 164, 87, 23);
		recordwin.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordwin.setVisible(false);
			}
		});
		btnNewButton.setBounds(223, 164, 87, 23);
		recordwin.getContentPane().add(btnNewButton);
		
		
	}
}
