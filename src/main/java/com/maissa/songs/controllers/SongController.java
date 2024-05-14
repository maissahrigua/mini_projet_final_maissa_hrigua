package com.maissa.songs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maissa.songs.entities.Categorie;
import com.maissa.songs.entities.Song;
import com.maissa.songs.service.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}
	
	@RequestMapping("/ListeSongs")
	public String listeSongs(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Song> sns = songService.getAllSongsParPage(page, size);
	modelMap.addAttribute("songs", sns);
	 modelMap.addAttribute("pages", new int[sns.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeSongs";
	}
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	List<Categorie> cats = songService.getAllCategories();
	modelMap.addAttribute("song", new Song());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("categories", cats);
	return "formSong";
	}

	
	@RequestMapping("/saveSong")
	public String saveSong(@Valid Song song, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())return "formSong";
		if (song.getIdSong() == null) // ajout
			isNew = true;
		songService.saveSong(song);
		if (isNew) // ajout
		{
			Page<Song> sns = songService.getAllSongsParPage(page, size);
			currentPage = sns.getTotalPages() - 1;
		} 
		else // modif
			currentPage=page;
			return ("redirect:/ListeSongs?page=" + currentPage + "&size=" + size);
	}
	
	@RequestMapping("/supprimerSong")
	public String supprimerSong(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	songService.deleteSongById(id);
	Page<Song> sns = songService.getAllSongsParPage(page,size);
	modelMap.addAttribute("songs", sns);
	modelMap.addAttribute("pages", new int[sns.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeSongs";
	}
	
	@RequestMapping("/modifierSong")
	public String editerSong(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	Song s= songService.getSong(id);
	List<Categorie> cats = songService.getAllCategories();
	modelMap.addAttribute("song", s);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("categories", cats);
	modelMap.addAttribute("page", page);
	modelMap.addAttribute("size", size);
	return "formSong";
	}


	@RequestMapping("/updateSong")
	public String updateSong(@ModelAttribute("song") Song
	song, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 song.setDateCreation(dateCreation);

	 songService.updateSong(song);
	 List<Song> sns = songService.getAllSongs();
	 modelMap.addAttribute("songs", sns);
	return "listeSongs";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}
}
