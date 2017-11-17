package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chat.model.Chatbot;

public class ChatPanel extends JPanel{
	
	private Chatbot chatbot;
	private ChatbotController appController;
	private SpringLayout baseLayout;
	
	private JButton firstButton;
	private JTextArea textArea;
	private JTextField inputField;
	private JLabel fjormNormal;
	private JLabel fjormOther;
	private JLabel fjormOther2;

	
	public ChatPanel(ChatbotController appController) {
		super();
		chatbot = new Chatbot("Connor");
		this.appController = appController;
		baseLayout = new SpringLayout();
		
		firstButton = new JButton("Enter");
		textArea = new JTextArea(10,25);
		inputField = new JTextField(25);
		fjormNormal = new JLabel();
		fjormOther = new JLabel();
		fjormOther2 = new JLabel();
		
		textArea.setEditable(false);
		textArea.setEnabled(false);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel() {
		this.setBackground(Color.GRAY);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(textArea);
		this.add(inputField);
	}

	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -39, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, textArea);
		baseLayout.putConstraint(SpringLayout.NORTH, textArea, 85, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textArea, 305, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 57, SpringLayout.SOUTH, textArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -40, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 1, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 24, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
	}

	private void setupListeners() {
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				textArea.append("\n" + displayText);
				inputField.setText("");
				
			}
		});
	}
	

	
}
