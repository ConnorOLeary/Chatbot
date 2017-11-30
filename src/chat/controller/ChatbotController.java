package chat.controller;

import chat.model.*;
import chat.view.*;

/**
 * Controller for the Chatbot
 * @author cole9798
 * @version 21/11/17
 */
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
	public String chatbotIntro() {
		return chatbot.getIntro();
	}
	
	public String useCheckers(String text) {
		String response = "";
		
		if(chatbot.contentChecker(text)) {
			response += "This text is greater than 5 characters\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text)) {
			response += "Awww thats a cute animal meme";
		}
		if(chatbot.userNameChecker(text)) {
			response += "That is a functioning username";
		}
		if(chatbot.shoppingListChecker(text)) {
			response += "Hey! Thats on my shopping list";
		}
		if(chatbot.keyboardMashChecker(text)) {
			response += "Please type with your fingers and not your fists";
		}
		if(chatbot.movieTitleChecker(text)) {
			response += "OH I KNOW THAT ONE";
		}
		if(chatbot.movieGenreChecker(text)) {
			response += "I have a personal opinion over that genre";
		}
		if(chatbot.lengthChecker(text)) {
			response += "This text is an appropriate length";
		}
		if(chatbot.htmlTagChecker(text)) {
			response += "Oh cool HTML, I prefer java though";
		}
		return response;
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