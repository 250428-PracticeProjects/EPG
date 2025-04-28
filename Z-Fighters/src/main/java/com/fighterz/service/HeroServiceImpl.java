package com.fighterz.service;

import com.fighterz.dto.HeroDTO;
import com.fighterz.model.Attack;
import com.fighterz.model.Hero;
import com.fighterz.model.Race;
import com.fighterz.model.Transformation;
import com.fighterz.repository.AttackRepository;
import com.fighterz.repository.HeroRepository;
import com.fighterz.repository.RaceRepository;
import com.fighterz.repository.TransformationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HeroServiceImpl implements HeroService{
    private final HeroRepository heroRepository;
    private final AttackRepository attackRepository;
    private final RaceRepository raceRepository;
    private final TransformationRepository transformationRepository;

    public HeroServiceImpl(HeroRepository heroRepository, AttackRepository attackRepository, RaceRepository raceRepository, TransformationRepository transformationRepository) {
        this.heroRepository = heroRepository;
        this.attackRepository = attackRepository;
        this.raceRepository = raceRepository;
        this.transformationRepository = transformationRepository;
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
        List<Hero> heroes = heroRepository.findAll();
        List<HeroDTO> heroDTOList = new ArrayList<>();
        for(Hero hero:heroes){
            Optional<Race> optionalRace = raceRepository.findById(hero.getRace().getRaceId());
            Optional<Transformation> optionalTransformation = transformationRepository.findById(hero.getForm().getFormId());
            Optional<Attack> optionalAttack = attackRepository.findById(hero.getAttack().getAttackId());
            Race race = optionalRace.get();
            Transformation transformation = optionalTransformation.get();
            Attack attack = optionalAttack.get();

            HeroDTO heroDTO = new HeroDTO();
            heroDTO.setId(hero.getId());
            heroDTO.setName(hero.getName());
            heroDTO.setRace(race.getRaceName());
            heroDTO.setPowerLevel(hero.getPowerLevel());
            heroDTO.setForm(transformation.getFormName());
            heroDTO.setAttack(attack.getAttackName());

            heroDTOList.add(heroDTO);
        }
        return heroDTOList;
    }

    @Override
    public HeroDTO getHeroById(Long id) {
        return null;
    }

    @Override
    public HeroDTO transformHero(Long heroId, Long formId) {
        return null;
    }

    @Override
    public boolean createHero(HeroDTO newHero) {
        return false;
    }
}
