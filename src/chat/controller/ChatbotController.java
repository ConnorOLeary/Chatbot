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
		appFrame = new ChatFrame();
	}
	public void start() {
		String response = display.getResponse("What do you want to talk about?");
		
		while(chatbot.lengthChecker(response) && !chatbot.quitChecker(response)) {
			response = popupChat(response);
			response = display.getResponse(response);
		}
	}
	
	public String interactWithChatbot(String input) {
		if(input != null && input.length() > 5) {
			return input;
		}
		return "What are you trying to say?";
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