package chat.model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * Chatbot which contains how it interacts with the user
 * @author cole9798
 * @version 21/11/17
 */
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String[10];
		this.username = username;
		this.content = "Content";
		this.intro = "Hello mortal, I am your god now";
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildVerbs();
		buildFollowups();
		buildTopics();
		buildQuestions();
	}
		
	private void buildVerbs() {
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am not sure about";
		verbs[3] = "am not interested in";
	}
	
	private void buildFollowups() {
		followUps[0] = "";
		followUps[1] = "";
		followUps[2] = "";
		followUps[3] = "";
		followUps[4] = "";
	}
	
	private void buildMovieList()
	{
		Movie noGameNoLife = new Movie("No Game No Life");
		Movie yourName = new Movie("Your Name");
		Movie silentVoice= new Movie("Silent Voice");
		Movie heavensFeel = new Movie("Heavens Feel");
		Movie iChooseYou = new Movie("Pokemon the movie: I choose you");
		Movie spiderman = new Movie("Spiderman");
		Movie hiddenFigures = new Movie("Hidden Figures");
		movieList.add(noGameNoLife);
		movieList.add(yourName);
		movieList.add(silentVoice);
		movieList.add(heavensFeel);
		movieList.add(iChooseYou);
		movieList.add(spiderman);
		movieList.add(hiddenFigures);
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("protein");
		shoppingList.add("Nilla waifers");
		shoppingList.add("veggies");
		shoppingList.add("snacks");
		shoppingList.add("5 cases of Dr. Pepper");
		shoppingList.add("Xenoblade 2 Controller");
		shoppingList.add("Xenobalde 2");
		shoppingList.add("Xenoblade 2 Season Pass");
		shoppingList.add("Xenoblade 2 Japanese voice DLC");
		shoppingList.add("Xenoblade 2: Xenoblade 2 edition");
		shoppingList.add("XENOBLADE 2");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("Pupper");
		cuteAnimalMemes.add("Doge");
		cuteAnimalMemes.add("Otter");
		cuteAnimalMemes.add("Floofer");
		cuteAnimalMemes.add("Kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your favorite Anime?";
		questions[2] = "What is your favorite Color?";
		questions[3] = "How many souls have you gifted to lucifer?";
		questions[4] = "What is your favorite food?";
		questions[5] = "How many computers does it take to screw in a lightbulb?";
		questions[6] = "Wanna hear the best joke ever?";
		questions[7] = "Whats your social security number?";
		questions[8] = "How old are you?";
		questions[9] = "What is your favorite passtime?";
	}
	
	private void buildTopics() {
		topics[0] = "Cats";
		topics[1] = "Dogs";
		topics[2] = "Food";
		topics[3] = "Homework";
		topics[4] = "Computers";
		topics[5] = "Work";
		topics[6] = "Video Games";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse() {
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		response += verbs[random];
		
		random = (int)(Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += questions[random];
		
		random = (int)(Math.random()*2);
		if(random % 2 == 0)
		{
			random = (int)(Math.random()*movieList.size());
			response += "\n" + movieList.get(random).getTitle() +" is a greate movie!";
		}
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		if(input != null && input.length() > 2) {
			validLength = true;
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean test = false;
		int firstBracket = input.indexOf('<');
		int secondBracket = input.indexOf('>');
		if(secondBracket > firstBracket) {
			String tagText = input.substring(firstBracket+1, secondBracket);
			if (tagText.toUpperCase().contains("A HREF=\"")) {
				tagText = "A";
			}
			String endingString = "</" + tagText + ">";
			if(input.toUpperCase().contains(endingString)) {
				test = true;
			}else if(tagText.equalsIgnoreCase("P") || tagText.equalsIgnoreCase("BR")) {
				test = true;
			}
		}
		return test;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean test = false;
		int symbolCount = 0;
		if(input != null) {
			if(input.startsWith("@")) {
				test = true;
				if(input.contains(".com")) {
					test = false;
				}
				for(int i = 0; i< input.length(); i++) {
					if(input.charAt(i) == '@') {
						symbolCount++;
					}
					if(symbolCount == 2) {
						test = false;
						break;
					}
				}
			}
		}
		return test;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		boolean test = false;
		if(contentCheck.length() > 5) {
			test = true;
		}
		return test;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String i:cuteAnimalMemes) {
			if(i.equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		
		for(String i:shoppingList) {
			if(i.equals(shoppingItem)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if(title.equals("")) {
			return false;
		}
		for(Movie i:movieList) {
			if(i.getTitle().contains(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		Boolean test = false;
		List<String> genreList = new ArrayList<String>();
		genreList.add("Documentary");
		genreList.add("Thriller");
		for (String i:genreList) {
			if(genre.equalsIgnoreCase(i)) {
				test = true;
			}
		}
		return test;
	}

	public boolean quitChecker(String exitString)
	{
		boolean quit = false;
		if (exitString != null && exitString.toLowerCase().equals("quit") && exitString.length() < 5) {
			quit = true;
		}
		return quit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		Boolean test = true;
		if(sample.contains("a") ||
				sample.contains("e") ||
				sample.contains("i") ||
				sample.contains("o") ||
				sample.contains("u") ||
				sample.contains("y")
				 ) {
			test = false;
		}else if(sample.contains(".")) {
			int periodCount = 0;
			int currentPlace = 0;
			for(int place = 1; place < sample.length(); place++) 
			{
				if(sample.substring(currentPlace, place).contains(".")) 
				{
					periodCount++;
					
				}
				currentPlace++;
			}
			if (periodCount > 1) 
			{
				test = false;
			}
		}
		return test;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String[] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public String toString() {
		String message = "Greetings " + username + ", I am Chatbot";
		message.replace("@", "");
		return message;
	}
}
