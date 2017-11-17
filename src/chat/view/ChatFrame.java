package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import chat.view.ChatPanel;

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
		this.setSize(500, 500); 
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController() {
		return appController;
	}

}
