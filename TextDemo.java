
package project;

/* TextDemo.java requires no other files. */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JPanel implements ActionListener {
	int order = 0;
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public TextDemo() {
        super(new GridBagLayout());

        textField = new JTextField(20);
        textField.addActionListener(this);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0; 
        c.weighty = 1.0;
        add(scrollPane, c);
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        if (text.contains("Bob") && order == 0) {
        	textArea.append("Hey there Ivan!" + newline);
        	textField.selectAll();
        	//Make sure the new text is visible, even if there
        	//was a selection in the text area.
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        	order = 1;
        }
        if (text.contains("better") && order == 1 || text.contains("feeling") && order == 1) 
        {
        	textArea.append("Yeah, enough to work at least! \n How is your wife doing?");
        	textField.selectAll();
        	textArea.setCaretPosition(textArea.getDocument().getLength());
        	order = 2;
        }
        if(text.contains("EXIT")) 
        {
        	MainMenu.textDemoVisible();
        }
    }
    static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new TextDemo());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */

    

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });
	}
}
