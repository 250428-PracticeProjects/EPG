package com.fighterz.service;

import com.fighterz.dto.HeroDTO;
import com.fighterz.model.Hero;

import java.util.List;

public interface HeroService {
    List<HeroDTO> getAllHeroes();
    HeroDTO getHeroById(Long id);
    HeroDTO transformHero(Long heroId);
    Hero createHero(HeroDTO newHero);
}
