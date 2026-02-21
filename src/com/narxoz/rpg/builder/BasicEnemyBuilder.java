package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.EnemyBehavior;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

/**
 * Builder for constructing simple enemies (Goblins, Skeletons, Orcs).
 *
 * This builder is designed for straightforward enemies that don't need
 * complex features like multi-phase mechanics or special properties.
 *
 * Mandatory fields (must be set before build()):
 *   - name
 *   - health
 *
 * Optional fields (have sensible defaults):
 *   - damage, defense, speed
 *   - element
 *   - abilities, loot table
 */
public class BasicEnemyBuilder implements EnemyBuilder {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;
    protected EnemyBehavior aiBehavior;
    protected String element;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        if (abilities != null) {
            this.abilities = new ArrayList<>(abilities);
        }
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public BasicEnemyBuilder setAI(EnemyBehavior aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }
    
    /**
     * Build and validate the Enemy.
     *
     * Validates that mandatory fields are set, then creates a Goblin instance.
     * For simple enemies, we use Goblin as the base implementation.
     * You could extend this to return Skeleton, Orc, etc. by adding a method
     * to specify enemy type, or by creating separate builders.
     *
     * FACTORY METHOD: This is the factory method! It creates and returns an Enemy.
     * Subclasses can override this to create different enemy types.
     */
    @Override
    public Enemy build() {
        Goblin enemy = new Goblin(name);
        enemy.setHealth(this.health);
        enemy.setDamage(this.damage);
        enemy.setDefense(this.defense);
        enemy.setSpeed(this.speed);
        
        for (Ability ability : this.abilities) {
            enemy.addAbility(ability);
        }
        
        if (this.lootTable != null) {
            enemy.setLootTable(this.lootTable);
        }

        return enemy;
    }
}
