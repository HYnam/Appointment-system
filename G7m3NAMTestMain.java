import java.io.* ;
import java.util.* ;
import javax.swing.* ;
import java.text.* ;
import java.awt.* ;
import java.awt.event.* ;

public class G7m3NAMTestMain
{

	
	private JFrame fMain;
	private JPanel pMain;
	private JButton b1,b2,b3,b4;
// Frame 2 - Course Information Frame
	private JFrame intro = new JFrame("Introduction") ;
	private JPanel pMath = new JPanel(new GridBagLayout()) ;
	private JLabel lab = new JLabel("This is a appointment system for Database Course.") ;
	private JLabel lab2 = new JLabel("There are courses like ER diagram, report, form , basic sql... Let's begin and explore!!") ;
	
// Frame 3 - Myself Frame
	private JFrame aboutme = new JFrame("About Me") ;
	private JPanel pAbtMe = new JPanel(new GridBagLayout()) ;
	private ImageIcon icon = new ImageIcon(getClass().getResource("individual_photo.jpeg")) ;
	private JLabel lab3 = new JLabel(icon) ;
	private JLabel lab4 = new JLabel("Hi! I am NAM HIU YI, Mila") ;
	
	public G7m3NAMTestMain()
	{
		G7m3gui() ;
	}

	public void G7m3gui()
	{
	// Main Frame	
		fMain = new JFrame("Database") ;
		fMain.setVisible(true) ;
		fMain.setSize(6000,4000) ;
		// fMain.setBackground(Color.GREEN);
		fMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		
		pMain = new JPanel(new GridBagLayout()) ;
		// pMain.setBackground(new Color(150,230,255));
		
		b1 = new JButton("Introduction") ;
		b2 = new JButton("About Me") ;
		b3 = new JButton("Appointment") ;
		b4 = new JButton("Display Appointment") ;
		
		GridBagConstraints c = new GridBagConstraints() ;
		c.insets = new Insets(10,10,10,10) ;
		
		pMain.add(b1,c) ;

		GridBagConstraints c2 = new GridBagConstraints() ;
		c2.insets = new Insets(10,10,10,10) ;
		
	// Frame 2
		intro.setSize(600,400) ;
		c2.gridx = 0 ;
		c2.gridy = 1 ;
		pMath.add(lab,c2) ;
		c2.gridx = 0 ;
		c2.gridy = 2 ;
		pMath.add(lab2,c2) ;
		c2.gridx = 0 ;
		c2.gridy = 3 ;
		pMath.add(lab3,c2) ;
		intro.add(pMath) ;
		//button 1 for a) - A sub-system Main
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				intro.setVisible(true) ;
			}
		}) ;
		pMain.add(b2,c) ;
		
		GridBagConstraints c3 = new GridBagConstraints() ;
		c3.insets = new Insets(10,10,10,10) ;
		
	// Frame 3
		aboutme.setSize(12000,10000) ;
		pAbtMe.add(lab4,c3) ;
		pAbtMe.add(lab3) ;
		aboutme.add(pAbtMe) ;
		//button 2 for b) - About Me
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				aboutme.setVisible(true) ;
			}
		}) ;
		
		//button 3 for c) - Make Vaild Appointment
		pMain.add(b3,c) ;
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id = JOptionPane.showInputDialog(null, "What is your user id?") ;
				String Date = JOptionPane.showInputDialog(null, "Provide a date to take the course in dd.mm.yyyy format please.") ;
				String Filepath = "G7m3NAM.csv" ;
				G7m3saveAR(id,Date,Filepath) ; // write-in
			}
		}) ;
		
		//button 4 for d) - Display Appointment
		pMain.add(b4) ;
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id = JOptionPane.showInputDialog(null, "What is your user id?") ;
				String Filepath = "G7m3NAM.csv" ;
				// write-out
				String[] data = new String[9] ;
				data = (G7m3readAR(id,Filepath)) ;
				String message = "\nID, ARID, Appointment Date, Course, AR Date\n" ;
				for (String print:data){
					message += print + "\n" ;
				}
				JOptionPane.showMessageDialog(null, message) ;
			}
		}) ;
		fMain.add(pMain) ;
	}
	
	//store the data into data file
	public static void G7m3saveAR(String ID, String date, String filepath){
		String dateStr = "" ;
		String datetimeStr = "" ;
		Date today = new Date() ;
		SimpleDateFormat CurrD = new SimpleDateFormat("yyyyMMdd") ;
		SimpleDateFormat CurrDT = new SimpleDateFormat("yyyyMMddHH-mm-ss") ;
		try{
			dateStr = CurrD.format(today) ;
			datetimeStr = CurrDT.format(today) ;
			FileWriter fw = new FileWriter(filepath,true) ;
			BufferedWriter bw = new BufferedWriter(fw) ;
			PrintWriter pw = new PrintWriter(bw) ;
			pw.println(ID + "," + "AR" + ID + dateStr + "," + date + "," + "Database" + "," + datetimeStr);
			pw.flush() ;
			pw.close() ;
			JOptionPane.showMessageDialog(null,"New Appointment Record saved") ;
		} catch(Exception E){
		}
	}
	
	//change the data from data file to arrylist
	public static String[] G7m3readAR(String ID, String filepath){
		ArrayList<String> records = new ArrayList<String>() ;
		boolean found = false ;
		String uID = ""; String arID = ""; String uDate = ""; String uCourse = ""; String uDateTime = ""; String record = "";
		try{
			Scanner x ;
			x = new Scanner(new File(filepath)) ;
			x.useDelimiter("[,\n]") ;
			while(x.hasNext()){
				uID = x.next() ;
				if(uID.equals(ID)){
					arID = x.next() ;
					uDate = x.next() ;
					uCourse = x.next() ;
					uDateTime = x.next() ;
					record = uID + "," + arID + "," + uDate + "," + uCourse + "," + uDateTime ;
					records.add(record) ;
					found = true ;
				} else {
					x.next() ;
					x.next() ;
					x.next() ;
					x.next() ;
				}
			} 
			if (!found){
				JOptionPane.showMessageDialog(null, "No records found") ;
			}
		} catch(Exception e){
		}
		String[] recordsArray = new String[records.size()] ;
		records.toArray(recordsArray) ;
		return recordsArray ;
	}
	
	//Main
	public static void main(String[] args){
		new G7m3NAMTestMain() ;
	}
}