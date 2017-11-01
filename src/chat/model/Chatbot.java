package chat.model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
		this.questions = new String[5];
		this.username = username;
		this.content = "";
		this.intro = "Hello mortal, I am your god now";
		this.currentTime = null;
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
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
		shoppingList.add("NintendoSwitch");
		shoppingList.add("Super Mario Odyssey");
		shoppingList.add("Legend of Zelda: Breath of the wild");
		shoppingList.add("Xenoblade Chronicles 2");
		shoppingList.add("5 cases of Dr. Pepper");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("Pupper");
		cuteAnimalMemes.add("Doge");
		cuteAnimalMemes.add("Cat Breading");
		cuteAnimalMemes.add("Autism");
		cuteAnimalMemes.add("Satanic sacrifice");
	}
	
	private void buildQuestions()
	{
		
	}
	
	public String processConversation(String input)
	{
		return null;
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
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean test = false;
		if(input.equals(null)) {
			
		}else {
			if(input.contains("@")) {
				test = true;
				if(input.contains("@@") ||input.contains(".com")) {
					test = false;
				}
			}
		}

	
		return test;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		boolean test = true;
		if(title.equals("")) {
			test = false;
		}
		for(Movie i:movieList) {
			if(title.equals(i.getTitle())) {
				test = true;
				break;
			}else {
				test = false;
			}
		}
		return test;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
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

	public String [] getQuestions()
	{
		return null;
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
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
