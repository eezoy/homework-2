package com.narxoz.rpg.builder;

import java.util.*;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyBehavior;
import com.narxoz.rpg.loot.LootTable;

public class BossEnemyBuilder extends BasicEnemyBuilder{
    private Map<Integer, Integer> phases = new HashMap<>();
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public BossEnemyBuilder setAI(EnemyBehavior aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public BossEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BossEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public BossEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public BossEnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public BossEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BossEnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    @Override
    public BossEnemyBuilder setAbilities(List<Ability> abilities) {
        if (abilities != null) {
            this.abilities = new ArrayList<>(abilities);
        }
        return this;
    }

    @Override
    public BossEnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public Enemy build() {
        int phase1 = phases.getOrDefault(1, health);
        int phase2 = phases.getOrDefault(2, health / 2);
        int phase3 = phases.getOrDefault(3, health / 4);

        DragonBoss boss = new DragonBoss(name, health, damage, defense, speed, new ArrayList<>(abilities), phase1, phase2, phase3, lootTable, aiBehavior, canFly,hasBreathAttack, wingspan, element);

        return boss;
    }
}
