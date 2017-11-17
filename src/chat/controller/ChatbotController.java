package chat.controller;

import chat.model.*;
import chat.view.*;

public class ChatbotController {
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController() {
		display = new PopupDisplay();
		chatbot = new Chatbot("Connor");
		appFrame = new ChatFrame(this);
	}
	public void start() {
		display.displayText("Welcome to Chatbot");
		//String response = display.getResponse("What do you want to talk about?");
		
		//while(chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
		//	response = popupChat(response);
		//	response = display.getResponse(response);
		//}
		
	}
	
	public String interactWithChatbot(String input) {
		String chatbotSays = "";
		if(chatbot.quitChecker(input)) {
			close();
		}
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close() {
		display.displayText("Goodbye");
		System.exit(0);
	}
	private String popupChat(String chat) {
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		return chatbotSays;
	}
	
	public ChatFrame getChatFrame() {
		return appFrame;
	}
	
	public Object getDisplay() {
		return display;
	}
	
	public Chatbot getChatbot() {
		return chatbot;
	}
}