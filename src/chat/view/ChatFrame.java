package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import chat.view.ChatPanel;

/**
 * JFrame subclass that defines the parameters of Chatpanel
 * @author cole9798
 * @version 21/11/17
 */
public class ChatFrame extends JFrame{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatbotController appController) {
		super();
		this.appController = appController;
		this.appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame() {
		this.setContentPane(appPanel);
		this.setTitle("EZ Chatbot");
		this.setSize(800, 500); 
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController() {
		return appController;
	}

}
