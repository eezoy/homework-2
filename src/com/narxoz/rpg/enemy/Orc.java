package com.narxoz.rpg.enemy;

import java.util.ArrayList;
import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

public class Orc implements Enemy{
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities;
    protected LootTable lootTable;
    protected String element;

    public Orc(String name) {
        this.name = name;
        this.health = 200;
        this.damage = 45;
        this.defense = 30;
        this.speed = 15;
        this.abilities = new ArrayList<>();
        this.element = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public void addAbility(Ability ability) {
        if (ability != null) {
            abilities.add(ability);
        }
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Orc) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + " (Damage: " + ability.getDamage() + ")");
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        Orc copy = new Orc(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.abilities = new ArrayList<>();

        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }
        
        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }
        
        return copy;
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
