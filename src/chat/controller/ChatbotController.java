package chat.controller;

import chat.model.*;
import chat.view.*;
public class ChatbotController {
	private ChatFrame display;
	
	public ChatbotController() {
		display = new ChatFrame();
	}
	public void start() {
		display.displayText("Hi");
		String want = display.getResponse("what do you want to see?");
		if (want.contains("Zeroth")) {
			display.displayZeroth();
		}
	}
}