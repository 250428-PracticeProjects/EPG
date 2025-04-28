package com.fighterz.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hero_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "hero_race")
    private Race race;

    @Column(name = "power_level")
    private long powerLevel;

    @ManyToOne
    @JoinColumn(name = "form")
    private Transformation form;

    @ManyToOne
    @JoinColumn(name = "technique")
    private Attack attack;

    public Hero() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public long getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(long powerLevel) {
        this.powerLevel = powerLevel;
    }

    public Transformation getForm() {
        return form;
    }

    public void setForm(Transformation form) {
        this.form = form;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }
}
