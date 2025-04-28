package com.fighterz.dto;

public class HeroDTO {
    private Long id;
    private String name;
    private String race;
    private Long powerLevel;
    private String form;
    private String attack;

    public HeroDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Long powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }
}
