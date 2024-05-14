package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maissa.songs.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
