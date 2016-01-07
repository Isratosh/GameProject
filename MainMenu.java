package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements  ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton playButt, exitButt;
	JPanel buttPanel, exitPanel, totalGUI, picPanel;
	JLabel picLabel;
	TextDemo game;
	Image BackgroundFirst;
	static String dir = System.getProperty("user.dir");
	static int visibleCheck;
	static boolean isActive = false;
	
	static JFrame frame = new JFrame("Kingdom Fall Launcher");

	/**
	 * @param args
	 * @throws IOException 
	 */
    
	public void visible() 
	{
		frame.setVisible(false);		
	}
	public static void textDemoVisible() 
	{
		frame.setVisible(true);
	}
	 public JPanel createContentPane () throws IOException{
	        JPanel totalGUI = new JPanel();
	        totalGUI.setLayout(null);
	        buttPanel = new JPanel();
	        buttPanel.setLayout(null);
	        buttPanel.setLocation(860,440);
	        buttPanel.setSize(300,100);
	        totalGUI.add(buttPanel);
	        
	        exitPanel = new JPanel();
	        exitPanel.setLayout(null);
	        exitPanel.setLocation(860,550);
	        exitPanel.setSize(300,100);
	        totalGUI.add(exitPanel);
	        
	        playButt = new JButton("PLAY");
	        playButt.setLocation(0,0);
	        playButt.setSize(300,100);
	        playButt.addActionListener(this);
	        buttPanel.add(playButt);
	        
	        exitButt = new JButton("EXIT");
	        exitButt.setLocation(0,0);
	        exitButt.setSize(300,100);
	        exitButt.addActionListener(this);
	        exitPanel.add(exitButt);
		    
		    picPanel = new JPanel();
	       	picPanel.setSize(1920,1080);
	       	picPanel.setLocation(0,0);
	       	picPanel.setVisible(true);
	       	totalGUI.add(picPanel);
	       	
	       	picLabel = new JLabel();
	       	picLabel.setSize(1920,1080);
	       	picLabel.setLocation(0,0);
	       	picLabel.setVisible(true);
	       	picLabel.setIcon(new ImageIcon(dir + "\\Pictures\\menuPicture.png"));
	       	picPanel.add(picLabel);
			return totalGUI;
	
	 }

	 private static void createAndShowGUI1() throws IOException {

	        JFrame.setDefaultLookAndFeelDecorated(true);
	        MainMenu demo = new MainMenu();
	        frame.setContentPane(demo.createContentPane());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1920,1080);
	        frame.setVisible(true);
	        frame.setBackground(Color.BLACK);        
	 }
	public static void main(String[] args) throws IOException {
		System.out.println(dir + "\\Pictures\\test.png");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					createAndShowGUI1();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	if(e.getSource() == playButt) 
    	{
        	visible();
        	game = new TextDemo();
        	javax.swing.SwingUtilities.invokeLater(new Runnable() 
        	{
        		public void run() 
        		{
        			TextDemo.createAndShowGUI();
            }
            
        });
	}
    if(e.getSource() == exitButt) 
    {
    	System.exit(0);
    }

}
}
