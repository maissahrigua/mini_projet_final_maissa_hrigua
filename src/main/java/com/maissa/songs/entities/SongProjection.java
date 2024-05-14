package com.maissa.songs.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSon", types = { Song.class })
public interface SongProjection {
	public String getNomSong();
}
