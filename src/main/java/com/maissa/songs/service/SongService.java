package com.maissa.songs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maissa.songs.entities.Categorie;
import com.maissa.songs.entities.Song;

public interface SongService {
	Song saveSong(Song s);
	Song updateSong(Song s);
	void deleteSong(Song s);
	void deleteSongById(Long id);
	Song getSong(Long id);
	List<Song> getAllSongs();
	List<Song> findByNomSong(String nom);
	List<Song> findByNomSongContains(String nom);
	List<Song> findByNomTime (String nom, Double time);
	List<Song> findByCategorie (Categorie categorie);
	List<Song> findByCategorieIdCat(Long id);
	List<Song> findByOrderByNomSongAsc();
	List<Song> trierSongsNomsTime();
	
	List<Categorie> getAllCategories();
	
	Page<Song> getAllSongsParPage(int page, int size);
}
