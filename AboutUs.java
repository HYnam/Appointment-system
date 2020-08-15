import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class AboutUs{
	
	public void aboutus(){
		
				JFrame Aboutus = new JFrame();
				Aboutus.setBounds(100, 100, 450, 300);
				Aboutus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Aboutus.setVisible(true);
				Aboutus.setTitle("About Us: G07 CL02, 2019-2020, OOP");
				Aboutus.getContentPane().setLayout(null);
				
				Image photo =new ImageIcon(AboutUs.class.getResource("/About.jpg")).getImage();
				JLabel image =new JLabel();
				image.setIcon(new ImageIcon(photo));
				image.setBounds(10, 10, 250, 184);
				Aboutus.getContentPane().add(image);
				
				JLabel Member = new JLabel("Members (Right to Left):");
				Member.setBounds(276, 10, 148, 23);
				Aboutus.getContentPane().add(Member);
				
				JLabel M1 = new JLabel("Lo Ka Fung");
				M1.setBounds(270, 43, 148, 23);
				Aboutus.getContentPane().add(M1);
				
				JLabel M2 = new JLabel("Lam Ho Yin Harry");
				M2.setBounds(270, 76, 148, 23);
				Aboutus.getContentPane().add(M2);
				
				JButton Close = new JButton("OK");
				Close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						Aboutus.setVisible(false);
					}
				});
				Close.setBounds(166, 214, 87, 23);
				Aboutus.getContentPane().add(Close);
				
				JLabel lblNewLabel = new JLabel("Nam Hiu Yi");
				lblNewLabel.setBounds(270, 109, 114, 15);
				Aboutus.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Lau Yin Tung");
				lblNewLabel_1.setBounds(270, 134, 114, 15);
				Aboutus.getContentPane().add(lblNewLabel_1);
				
				JLabel lblLoCheukYin = new JLabel("Lo Cheuk Yin");
				lblLoCheukYin.setBounds(270, 159, 129, 15);
				Aboutus.getContentPane().add(lblLoCheukYin);
				
				
	}
} 
