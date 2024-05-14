package com.maissa.songs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.maissa.songs.entities.Categorie;
import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.CategorieRepository;
import com.maissa.songs.repos.SongRepository;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	SongRepository songRepository;

	@Override
	public Song saveSong(Song s) {
		return songRepository.save(s);
	}

	@Override
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}

	@Override
	public void deleteSong(Song s) {
		songRepository.delete(s);
		
	}

	@Override
	public void deleteSongById(Long id) {
		songRepository.deleteById(id);
		
	}

	@Override
	public Song getSong(Long id) {
		return songRepository.findById(id).get();
	}

	@Override
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}

	@Override
	public Page<Song> getAllSongsParPage(int page, int size) {
	return songRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Song> findByNomSong(String nom) {
		return songRepository.findByNomSong(nom);
	}

	@Override
	public List<Song> findByNomSongContains(String nom) {
		return songRepository.findByNomSongContains(nom);
	}

	@Override
	public List<Song> findByNomTime(String nom, Double time) {
		return songRepository.findByNomTime(nom, time);
	}

	@Override
	public List<Song> findByCategorie(Categorie categorie) {
		return songRepository.findByCategorie(categorie);
	}

	@Override
	public List<Song> findByCategorieIdCat(Long id) {
		return songRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Song> findByOrderByNomSongAsc() {
		return songRepository.findByOrderByNomSongAsc();
	}

	@Override
	public List<Song> trierSongsNomsTime() {
		return songRepository.trierSongsNomsTime();
	}
	
	@Override
	public List<Categorie> getAllCategories() {
	return categorieRepository.findAll();
	}
}
