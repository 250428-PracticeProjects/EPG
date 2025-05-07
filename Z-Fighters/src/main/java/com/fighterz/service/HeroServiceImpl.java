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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
            Long pL = hero.getPowerLevel()*transformation.getMultiplier();
            heroDTO.setPowerLevel(pL);
            heroDTO.setForm(transformation.getFormName());
            heroDTO.setAttack(attack.getAttackName());

            heroDTOList.add(heroDTO);
        }
        return heroDTOList;
    }

    @Override
    public HeroDTO getHeroById(Long id) {
        Optional<Hero> optionalHero = heroRepository.findById(id);
        Hero returnedHero = optionalHero.get();
        Optional<Race> optionalRace = raceRepository.findById(returnedHero.getRace().getRaceId());
        Optional<Transformation> optionalTransformation = transformationRepository.findById(returnedHero.getForm().getFormId());
        Optional<Attack> optionalAttack = attackRepository.findById(returnedHero.getAttack().getAttackId());
        Race race = optionalRace.get();
        Transformation transformation = optionalTransformation.get();
        Attack attack = optionalAttack.get();

        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(returnedHero.getId());
        heroDTO.setName(returnedHero.getName());
        heroDTO.setRace(race.getRaceName());
        Long pL = returnedHero.getPowerLevel()*transformation.getMultiplier();
        heroDTO.setPowerLevel(pL);
        heroDTO.setForm(transformation.getFormName());
        heroDTO.setAttack(attack.getAttackName());

        return heroDTO;
    }

    @Override
    public HeroDTO transformHero(Long heroId) {
        Optional<Hero> optionalHero = heroRepository.findById(heroId);
        Hero returnedHero = optionalHero.get();
        Transformation newForm = new Transformation();
        Long newId = 0L;
        if(returnedHero.getForm().getFormId() == 1){
            switch ((int) returnedHero.getRace().getRaceId()){
                case 1:
                    newId = 2L;
                    break;
                case 2:
                    newId = 3L;
                    break;
                case 3:
                    newId = 4L;
                    break;
                default:
                    System.out.println("Not a valid race");
            }
        }
        else{
            newId = 1L;
        }
        Optional<Transformation> optionalTransformation = transformationRepository.findById(newId);
        newForm = optionalTransformation.get();
        returnedHero.setForm(newForm);
        Hero transformedHero = heroRepository.save(returnedHero);

        HeroDTO displayHero = new HeroDTO();
        displayHero.setAttack(transformedHero.getAttack().getAttackName());
        displayHero.setForm(transformedHero.getForm().getFormName());
        displayHero.setId(transformedHero.getId());
        displayHero.setName(transformedHero.getName());
        displayHero.setPowerLevel(transformedHero.getPowerLevel());
        displayHero.setRace(transformedHero.getRace().getRaceName());

        return displayHero;
    }

    @Override
    public boolean createHero(HeroDTO newHero) {
        return false;
    }
}
