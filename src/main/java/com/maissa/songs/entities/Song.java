package com.maissa.songs.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSong;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomSong;
	
	@Min(value = 1)
	 @Max(value = 12)
	private Double timeSong;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Song() {
		super();
	}
	
	public Song(String nomSong, Double timeSong, Date dateCreation) {
		super();
		this.nomSong = nomSong;
		this.timeSong = timeSong;
		this.dateCreation = dateCreation;
	}
	
	public Long getIdSong() {
		return idSong;
	}
	
	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}
	
	public String getNomSong() {
		return nomSong;
	}
	
	public void setNomSong(String nomSong) {
		this.nomSong = nomSong;
	}
	
	public Double getTimeSong() {
		return timeSong;
	}
	
	public void setTimeSong(Double timeSong) {
		this.timeSong = timeSong;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", nomSong=" + nomSong + ", timeSong=" + timeSong + ", dateCreation=" + dateCreation + "]";
	}
	
}
