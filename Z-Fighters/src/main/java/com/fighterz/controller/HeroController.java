package com.fighterz.controller;


import com.fighterz.service.HeroServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/heroes")

public class HeroController {
    private final HeroServiceImpl heroService;

    public HeroController(HeroServiceImpl heroService) {
        this.heroService = heroService;
    }

    // Endpoint to get all heroes
    @GetMapping
    public ResponseEntity<?> getAllHeroes() {
        return ResponseEntity.ok(heroService.getAllHeroes());
    }

    // Endpoint to get a hero by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getHeroById(@PathVariable Long id) {
        return ResponseEntity.ok(heroService.getHeroById(id));
    }
}
