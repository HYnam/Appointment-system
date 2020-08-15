import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;

public class My_LoginRecord extends User{
	String LoginRecord_ID;
	String Login_Time;
	String LogRemarks;
	String rec;
	String filename = "G07LoginRecord.csv";
	File fileRe= new File(filename);
	
	public My_LoginRecord(String loginrecord_ID, String ac, String Recorded_time, String logremarks) {
		super(ac, null, null, null, null, null);
		LoginRecord_ID = loginrecord_ID;
		Login_Time = Recorded_time;
		LogRemarks = logremarks;
		
	}

	public void recordcall (String User_ID) throws IOException{
		Scanner scanner = new Scanner(fileRe);
		BufferedReader reader = new BufferedReader(new FileReader(fileRe));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		String[] rocinfos = new String[lines];
		String loginrecord_ID[] = new String[lines];
		String user_id[] = new String[lines];
		String login_time[] = new String[lines];
		String remarks[] = new String[lines];
		
		for(int i = 0; i < lines; i++) {
			rocinfos[i] = scanner.nextLine();
			String[] roc = rocinfos[i].split(",");
			loginrecord_ID[i] = roc[0];
			user_id[i] = roc[1];
			login_time[i] = roc[2];
			remarks[i] = roc[3];
		}
		scanner.close();
		
		int j = 0;
		for(int i = 0; i < lines; i++) {
					if (user_id[i].equals(User_ID)){
						j++;
					}
				}
		String myRec[] = new String[j];
		int z = 0;
		while(z<j)
		for(int i = 0; i < lines; i++){
		   if(user_id[i].equals(User_ID)){
		       myRec[z] = rocinfos[i];
		       z++;
		   }
		}
		JFrame recordwin;
		recordwin = new JFrame();
		recordwin.setBounds(100, 100, 363, 304);
		recordwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recordwin.setVisible(true);
		recordwin.getContentPane().setLayout(null);
		
		JLabel lblYourAppointment = new JLabel("Your History");
		lblYourAppointment.setBounds(10, 10, 104, 15);
		recordwin.getContentPane().add(lblYourAppointment);
		
		JButton Close = new JButton("Close this window");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				recordwin.setVisible(false);
			}
		});
		Close.setBounds(104, 192, 137, 33);
		recordwin.getContentPane().add(Close);
		
		JComboBox comboBox = new JComboBox(myRec);
		comboBox.setBounds(33, 66, 283, 23);
		recordwin.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("LoginRecord_ID, ID, Login Time, Remark");
		lblNewLabel.setBounds(33, 41, 272, 15);
		recordwin.getContentPane().add(lblNewLabel);
		
	}
	
	public void recordwri (String ac, String Recorded_time) throws IOException{
		fileRe.createNewFile();
		Date dateNow = new Date();
		SimpleDateFormat ee = new SimpleDateFormat ("YYYYMM");
		String datenow = (ee.format(dateNow));
		Random rand = new Random();
		int random = rand.nextInt(100);
		String loginrecord_ID = randomnum(ac, datenow, random);
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
		
		for(int i = 0; i < lines; i++) {
			rocinfos[i] = scanner.nextLine();
			String[] roc = rocinfos[i].split(",");
			loginrecord_id[i] = roc[0];
			user_id[i] = roc[1];
			login_time[i] = roc[2];
			remarks[i] = roc[3];
		}
		scanner.close();
		int acnum = 0;
		for(int i = 0; i < lines; i++) {
			if(ac.equals(user_id[i])) {
				acnum++;
			}
		}
		String logremarks = null;
		if(acnum == 0) {
			logremarks = ("First Login");
		}
		if(acnum != 0 ) {
			logremarks = ("-");
		}
		My_LoginRecord logrecord = new My_LoginRecord(loginrecord_ID, ac, Recorded_time, logremarks);
		String recordstr = (logrecord.LoginRecord_ID+","+logrecord.user_ID+","+logrecord.Login_Time+","+logrecord.LogRemarks);
		
		PrintWriter write = new PrintWriter(new FileWriter(fileRe, true));
		
		write.println(recordstr);
		write.close();
		
		
	}
	
	public String randomnum(String User_ID, String dnow, int random) {
		String LoginRecord_ID = ("LR"+User_ID+dnow+random);
		return LoginRecord_ID;
	}
}
