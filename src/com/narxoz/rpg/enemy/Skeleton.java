package com.narxoz.rpg.enemy;

import java.util.ArrayList;
import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

public class Skeleton implements Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities;
    protected LootTable lootTable;
    protected String element;

    public Skeleton(String name) {
        this.name = name;
        this.element = "NEUTRAL";
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
    }

    // ============== Getters ==============
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

    public void setElement(String element) {
        this.element = element;
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
        System.out.println("=== " + name + " (Skeleton) ===");
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
}
