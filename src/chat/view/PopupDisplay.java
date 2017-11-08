package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay {
	private ImageIcon icon;
	private ImageIcon zeroth;
	private String windowTitle;
	
	public PopupDisplay() {
		icon = new ImageIcon(getClass().getResource("images/Mega.jpg"));
		zeroth = new ImageIcon(getClass().getResource("images/Zeroth.png"));
		windowTitle = "Sample";
	}
	public void displayText(String message) {
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	public String getResponse(String question) {
		String response = "";
		//prompts a display window with an input dialog, the input being what is stored in response
		response += JOptionPane.showInputDialog(null,question, windowTitle,JOptionPane.QUESTION_MESSAGE, icon, null, "");
		return response;
	}
	public void displayZeroth() {
		JOptionPane.showMessageDialog(null, null, windowTitle, JOptionPane.INFORMATION_MESSAGE, zeroth);
	}
}
