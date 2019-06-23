import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//class inherits the properties of a JFrame
@SuppressWarnings("serial")
public class BasicBrowser extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public BasicBrowser() {
		//creates a new (invisible) frame with the specified title
		super("Basic Browser");
		
		//address bar of the browser
		addressBar = new JTextField("Enter a URL");
		addressBar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					loadContent(event.getActionCommand());
				}
			}
		);
		//add the address bar to the top of the JFrame
		add(addressBar, BorderLayout.NORTH);
		
		//display of the browser
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent event) {
					if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						loadContent(event.getURL().toString());
					}
				}
			}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	//load the content to display on the screen
	private void loadContent(String userText) {
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		} catch (Exception e) {
			System.out.println("Invalid Address");
		}
	}
}