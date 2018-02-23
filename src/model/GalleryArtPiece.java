package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artwork")
public class GalleryArtPiece {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ARTIST_NAME")
	private String artistName;
	@Column(name="MEDIA")
	private String media;
	@Column(name="YEAR")
	private String year;
	@Column(name="VALUE")
	private double value;
		
	public GalleryArtPiece() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GalleryArtPiece(String title, String artistName) {
		super();
		this.title = title;
		this.artistName = artistName;
	}
	
	public GalleryArtPiece(String title, String artistName, String media, String year, double value) {
		//added based on class feedback
		super();
		this.title = title;
		this.artistName = artistName;
		this.media = media;
		this.year = year;
		this.value = value;
	}

	/*
	public GalleryArtPiece(String title2, String artistName2, String media2, String year2, String value2) {
		// TODO Auto-generated constructor stub
	}
	*/

	public String returnArtPieceDetails() {
		return "The ID for this piece of art: " + id + "\nArtist: " + artistName + "\nTitle of art piece: " + title + "\nThe media format is: " + media + 
				"\nYear art created: " + year + "\nThe value of the piece: " + value + "\n";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}*/

	@Override
	public String toString() {
		return "GalleryArtList [title=" + title + ", artistName=" + artistName + ", media=" + media + ", year=" + year
				+ ", value=" + value + ", id=" + id + "]";
	}

	public String print() {
		DecimalFormat df = new DecimalFormat("$###.##");
		return "The title of your artwork piece is " + title + ".\nTthe artist is " + artistName + " and was created on " + media + " in " + year + "." 
				+ "\n The Value is "+ df.format(value);
				
	}
	
	
	
}
