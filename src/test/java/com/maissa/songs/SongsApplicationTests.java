package com.maissa.songs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.maissa.songs.entities.Categorie;
import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.SongRepository;
import com.maissa.songs.service.SongService;

@SpringBootTest
class SongsApplicationTests {

	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private SongService songService;
	
	@Test
	public void testCreateSong() {
		Song sn = new Song("Happy Nation",04.47,new Date());
		songRepository.save(sn);
	}
	
	@Test
	public void testFindSong()
	{
		Song s = songRepository.findById(1L).get();
		System.out.println(s);
	}
	
	@Test
	public void testUpdateSong()
	{
		Song s = songRepository.findById(1L).get();
		s.setTimeSong(10.13);
		songRepository.save(s);
		System.out.println(s);
	}
	
	@Test
	public void testDeleteSong()
	{
		songRepository.deleteById(1L);
	}

	@Test
	public void testListerTousSongs()
	{
		List<Song> sns = songRepository.findAll();
		for (Song s : sns)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindByNomSongContains()
	{
	Page<Song> sns = songService.getAllSongsParPage(0,2);
	System.out.println(sns.getSize());
	System.out.println(sns.getTotalElements());
	System.out.println(sns.getTotalPages());
	sns.getContent().forEach(s -> {System.out.println(s.toString());
	 });
	/*ou bien
	for (Song s : sns.getContent())
	{
	System.out.println(s);
	} */
	}
	
	
	@Test
	public void testFindSongByNom()
	{
	List<Song> sns = songRepository.findByNomSong("Betty");
	for (Song s : sns)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testFindSongByNomContains()
	{
	List<Song> sns=songRepository.findByNomSongContains("e");
	for (Song s : sns)
	{
	System.out.println(s);
	} }
	
	
	@Test
	public void testfindByNomTime()
	{
	List<Song> sns = songRepository.findByNomTime("Betty", 3.43);
	for (Song s : sns)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Song> sns = songRepository.findByCategorie(cat);
	for (Song s : sns)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Song> sns = songRepository.findByCategorieIdCat(1L);
	for (Song s : sns)
	{
	System.out.println(s);
	}
	 }
	
	@Test
	public void testfindByOrderByNomSongAsc()
	{
	List<Song> sns = songRepository.findByOrderByNomSongAsc();
	for (Song s : sns)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testTrierSongsNomsTime()
	{
	List<Song> sns = songRepository.trierSongsNomsTime();
	for (Song s : sns)
	{
	System.out.println(s);
	}
	}
	
}
