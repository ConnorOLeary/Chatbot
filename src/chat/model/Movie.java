package chat.model;

import java.time.LocalDate;
/**
 * Movies that the chatbot can reference are instantiated here
 * @author cole9798
 * @version 21/11/17
 */
public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	

	public Movie(String title)
	{
		if(title.length() < 5) {
			this.title = title + "title";
		}
		else {
			this.title = title;
		}
		this.genre = "Weeaboo";
		this.ratingMPAA = "R";
		this.review = "Hontoni Hontoni Sugoi des";
		this.length = 90;
		this.releaseDate = LocalDate.of(2001,9,11);
		this.starScore = 10/10;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String description = "";
		
		return description;
	}
}
