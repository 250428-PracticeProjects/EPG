package com.fighterz.service;

import com.fighterz.dto.HeroDTO;

import java.util.List;

public interface HeroService {
    List<HeroDTO> getAllHeroes();
    HeroDTO getHeroById(Long id);
    HeroDTO transformHero(Long heroId);
    boolean createHero(HeroDTO newHero);
}
