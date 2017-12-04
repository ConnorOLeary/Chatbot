package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chat.model.Chatbot;

/**
 * JPanel subclass that sets up our chatbot panel for use
 * @author cole9798
 * @version 21/11/17
 */
public class ChatPanel extends JPanel{
	
	private Chatbot chatbot;
	private ChatbotController appController;
	private SpringLayout baseLayout;
	
	private JButton firstButton;
	private JButton checkerButton;
	private JButton introButton;
	private JTextArea textArea;
	private JTextField inputField;
	private JScrollPane chatScrollPane;
	private JLabel pyra;
	
	
	public ChatPanel(ChatbotController appController) {
		super();
		chatbot = new Chatbot("Fjorm");
		this.appController = appController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Enter");
		checkerButton = new JButton("Check");
		introButton = new JButton("Intro");
		textArea = new JTextArea(10,25);
		pyra = new JLabel(new ImageIcon(getClass().getResource("images/Pyra.png")));
		inputField = new JTextField(25);
		
		
		textArea.setEditable(false);
		textArea.setEnabled(false);
		
		chatScrollPane = new JScrollPane();
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane(){
		chatScrollPane.setViewportView(textArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	private void setupPanel() {
		this.setBackground(Color.pink);
		this.setLayout(baseLayout);
		this.add(checkerButton);
		this.add(firstButton);
		this.add(introButton);
		this.add(textArea);
		this.add(inputField);
		this.add(pyra);
	}

	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.NORTH, pyra, 22, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, pyra, -8, SpringLayout.WEST, textArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, textArea, -66, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.EAST, introButton);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 367, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, textArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -62, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textArea, 81, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 67, SpringLayout.SOUTH, textArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, textArea);
		baseLayout.putConstraint(SpringLayout.WEST, checkerButton, 683, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, introButton, 23, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, introButton, 567, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, introButton, 0, SpringLayout.SOUTH, checkerButton);
		baseLayout.putConstraint(SpringLayout.EAST, introButton, -13, SpringLayout.WEST, checkerButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 683, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -61, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 23, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -28, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 336, SpringLayout.WEST, this);
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
		checkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				textArea.append("\n" + displayText);
				inputField.setText("");
				
			}
		});
		introButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String displayText = appController.chatbotIntro();
				textArea.setText("\n" + displayText);
			}
		});
	}
	

	
}
