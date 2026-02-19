package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.factory.EnemyBehavior;

import java.util.*;

/**
 * Builder interface for constructing complex enemies.
 *
 * The Builder pattern solves the "Telescoping Constructor" anti-pattern.
 * Instead of:
 *     new DragonBoss("Fire Dragon", 50000, 500, 200, 50, "FIRE", ...)
 * 
 * You can write:
 *     new BossEnemyBuilder()
 *         .setName("Fire Dragon")
 *         .setHealth(50000)
 *         .setDamage(500)
 *         .build();
 *
 * Benefits:
 *   - Every parameter is labeled (no confusion about order)
 *   - Easy to add new parameters later (no breaking changes)
 *   - Fluent API is readable and self-documenting
 *   - Validation happens in build() — not in constructor
 *   - Supports optional fields out of the box
 *
 * KEY DESIGN DECISION: Fluent Interface
 *   Each setter returns 'this', enabling method chaining:
 *   builder.setName("X").setHealth(100).setDamage(50).build();
 */
public interface EnemyBuilder {
    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setDefense(int defense);
    EnemyBuilder setSpeed(int speed);
    EnemyBuilder addAbility(Ability ability);
    EnemyBuilder setAbilities(List<Ability> abilities);
    EnemyBuilder setLootTable(LootTable lootTable);
    EnemyBuilder setAI(EnemyBehavior aiBehavior);
    Enemy build();
}

