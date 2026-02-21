package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    public Enemy createMinion(EnemyComponentFactory componentFactory) {
        return new BasicEnemyBuilder()
            .setName("Minion")
            .setHealth(50)
            .setDamage(10)
            .setDefense(2)
            .setSpeed(25)
            .setAbilities(componentFactory.createAbilities())
            .setLootTable(componentFactory.createLootTable())
            .setAI(componentFactory.createAIBehavior())
            .build();
    }

    public Enemy createElite(EnemyComponentFactory componentFactory) {
        return new BasicEnemyBuilder()
            .setName("Elite Enemy")
            .setHealth(200)
            .setDamage(35)
            .setDefense(10)
            .setSpeed(30)
            .setAbilities(componentFactory.createAbilities())
            .setLootTable(componentFactory.createLootTable())
            .setAI(componentFactory.createAIBehavior())
            .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory componentFactory) {
        return new BossEnemyBuilder()
            .setName("Mini Boss")
            .setHealth(1000)
            .setDamage(100)
            .setDefense(30)
            .setSpeed(40)
            .addPhase(1, 1000)
            .addPhase(2, 500)
            .setAbilities(componentFactory.createAbilities())
            .setLootTable(componentFactory.createLootTable())
            .setAI(componentFactory.createAIBehavior())
            .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory componentFactory) {
        return new BossEnemyBuilder()
            .setName("Raid Boss")
            .setHealth(52000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(50)
            .addPhase(1, 52000)
            .addPhase(2, 30000)
            .addPhase(3, 10000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(20)
            .setAbilities(componentFactory.createAbilities())
            .setLootTable(componentFactory.createLootTable())
            .setAI(componentFactory.createAIBehavior())
            .build();
    }
}
