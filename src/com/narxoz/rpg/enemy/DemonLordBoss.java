package com.narxoz.rpg.enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.factory.EnemyBehavior;
import com.narxoz.rpg.loot.LootTable;

public class DemonLordBoss implements Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities;
    protected Map<Integer, Integer> phases;
    protected LootTable lootTable;
    protected EnemyBehavior aiBehavior;
    protected boolean canFly;
    protected boolean hasBreathAttack;
    protected int wingspan;
    protected String element;

    public DemonLordBoss(String name, int health, int damage, int defense, int speed, List<Ability> abilities, int phase1Threshold, int phase2Threshold, int phase3Threshold, LootTable lootTable, EnemyBehavior aiBehavior, boolean canFly, boolean hasBreathAttack, int wingspan, String element) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
        this.element = element;
    }

    public String getName() {
        return name;
    }

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

    public void displayInfo() {
        System.out.println("=== " + name + " (Demon Lord Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability.getName() + " (Damage: " + ability.getDamage() + ")");
        }
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey()
                    + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly
                + " | Breath Attack: " + hasBreathAttack
                + " | Wingspan: " + wingspan);
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        DemonLordBoss copy = new DemonLordBoss(
            this.name,
            this.health,
            this.damage,
            this.defense,
            this.speed,
            null,
            0, 0, 0,
            null,
            this.aiBehavior,
            this.canFly,
            this.hasBreathAttack,
            this.wingspan,
            this.element
        );

        copy.abilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            copy.abilities.add(ability.clone());
        }

        copy.phases = new HashMap<>(this.phases);

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

    public void addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
    }
}
