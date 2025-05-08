package com.fighterz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "attackId")
@Entity
@Table(name = "attack")
public class Attack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attack_id")
    private long attackId;

    @Column(name = "attack_name")
    private String attackName;

    @OneToMany(mappedBy = "attack")
    @JsonBackReference
    private List<Hero> heroes;

    public Attack() {
    }

    public long getAttackId() {
        return attackId;
    }

    public void setAttackId(long attackId) {
        this.attackId = attackId;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
