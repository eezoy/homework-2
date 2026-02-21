package com.narxoz.rpg;

import java.util.Arrays;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Fire.FireShield;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Skeleton;
import com.narxoz.rpg.enemy.Orc;
import com.narxoz.rpg.factory.EnemyBehavior;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("Fire Factory Components:");
        System.out.println("  Abilities: " + Arrays.toString(fireFactory.createAbilities().stream().map(a -> a.getName()).toArray()));
        System.out.println("  Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + fireFactory.createAIBehavior());

        System.out.println("\nIce Factory Components:");
        System.out.println("  Abilities: " + Arrays.toString(iceFactory.createAbilities().stream().map(a -> a.getName()).toArray()));
        System.out.println("  Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + iceFactory.createAIBehavior());

        System.out.println("\nShadow Factory Components:");
        System.out.println("  Abilities: " + Arrays.toString(shadowFactory.createAbilities().stream().map(a -> a.getName()).toArray()));
        System.out.println("  Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + shadowFactory.createAIBehavior());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // ============================================================
        // DRAGON BOSSES - Complex boss enemies with phases
        // ============================================================
        System.out.println("--- DRAGON BOSSES ---\n");

        Enemy fireDragon = new BossEnemyBuilder()
            .setName("Ancient Fire Dragon")
            .setHealth(50000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(50)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(20)
            .setAI(EnemyBehavior.AGGRESSIVE)
            .build();
        fireDragon.displayInfo();
        System.out.println();

        Enemy iceDragon = new BossEnemyBuilder()
            .setName("Frost Wyrm")
            .setHealth(48000)
            .setDamage(450)
            .setDefense(250)
            .setSpeed(45)
            .setElement("ICE")
            .setAbilities(iceFactory.createAbilities())
            .setLootTable(iceFactory.createLootTable())
            .addPhase(1, 48000)
            .addPhase(2, 28000)
            .addPhase(3, 12000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(18)
            .setAI(EnemyBehavior.DEFENSIVE)
            .build();
        iceDragon.displayInfo();
        System.out.println();

        Enemy shadowDragon = new BossEnemyBuilder()
            .setName("Shadow Dragon")
            .setHealth(52000)
            .setDamage(550)
            .setDefense(180)
            .setSpeed(60)
            .setElement("SHADOW")
            .setAbilities(shadowFactory.createAbilities())
            .setLootTable(shadowFactory.createLootTable())
            .addPhase(1, 52000)
            .addPhase(2, 32000)
            .addPhase(3, 16000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(22)
            .setAI(EnemyBehavior.TACTICAL)
            .build();
        shadowDragon.displayInfo();
        System.out.println();

        // ============================================================
        // GOBLINS - Basic enemies with different themes
        // ============================================================
        System.out.println("--- GOBLINS ---\n");

        Enemy fireGoblin = new BasicEnemyBuilder()
            .setName("Fire Goblin")
            .setHealth(100)
            .setDamage(15)
            .setDefense(5)
            .setSpeed(35)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .setAI(EnemyBehavior.AGGRESSIVE)
            .build();
        fireGoblin.displayInfo();
        System.out.println();

        Enemy iceGoblin = new BasicEnemyBuilder()
            .setName("Frost Goblin")
            .setHealth(120)
            .setDamage(12)
            .setDefense(8)
            .setSpeed(30)
            .setElement("ICE")
            .setAbilities(iceFactory.createAbilities())
            .setLootTable(iceFactory.createLootTable())
            .setAI(EnemyBehavior.DEFENSIVE)
            .build();
        iceGoblin.displayInfo();
        System.out.println();

        Enemy shadowGoblin = new BasicEnemyBuilder()
            .setName("Shadow Goblin")
            .setHealth(90)
            .setDamage(18)
            .setDefense(4)
            .setSpeed(40)
            .setElement("SHADOW")
            .setAbilities(shadowFactory.createAbilities())
            .setLootTable(shadowFactory.createLootTable())
            .setAI(EnemyBehavior.TACTICAL)
            .build();
        shadowGoblin.displayInfo();
        System.out.println();

        // Elite Goblin
        Enemy eliteGoblin = new BasicEnemyBuilder()
            .setName("Elite Goblin Chieftain")
            .setHealth(250)
            .setDamage(35)
            .setDefense(20)
            .setSpeed(45)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .setAI(EnemyBehavior.TACTICAL)
            .build();
        eliteGoblin.displayInfo();
        System.out.println();

        // ============================================================
        // SKELETONS - Undead enemies with different themes
        // ============================================================
        System.out.println("--- SKELETONS ---\n");

        Skeleton fireSkeleton = new Skeleton("Burning Skeleton");
        fireSkeleton.setHealth(150);
        fireSkeleton.setDamage(25);
        fireSkeleton.setDefense(10);
        fireSkeleton.setSpeed(30);
        fireSkeleton.setElement("FIRE");
        fireSkeleton.setLootTable(fireFactory.createLootTable());
        for (Ability ability : fireFactory.createAbilities()) {
            fireSkeleton.addAbility(ability);
        }
        fireSkeleton.displayInfo();
        System.out.println();

        Skeleton iceSkeleton = new Skeleton("Frozen Skeleton");
        iceSkeleton.setHealth(160);
        iceSkeleton.setDamage(20);
        iceSkeleton.setDefense(15);
        iceSkeleton.setSpeed(25);
        iceSkeleton.setElement("ICE");
        iceSkeleton.setLootTable(iceFactory.createLootTable());
        for (Ability ability : iceFactory.createAbilities()) {
            iceSkeleton.addAbility(ability);
        }
        iceSkeleton.displayInfo();
        System.out.println();

        Skeleton shadowSkeleton = new Skeleton("Shadow Skeleton");
        shadowSkeleton.setHealth(140);
        shadowSkeleton.setDamage(28);
        shadowSkeleton.setDefense(8);
        shadowSkeleton.setSpeed(35);
        shadowSkeleton.setElement("SHADOW");
        shadowSkeleton.setLootTable(shadowFactory.createLootTable());
        for (Ability ability : shadowFactory.createAbilities()) {
            shadowSkeleton.addAbility(ability);
        }
        shadowSkeleton.displayInfo();
        System.out.println();

        // ============================================================
        // ORCS - Strong enemies with different themes
        // ============================================================
        System.out.println("--- ORCS ---\n");

        Orc fireOrc = new Orc("Flame Orc Warrior");
        fireOrc.setHealth(200);
        fireOrc.setDamage(45);
        fireOrc.setDefense(30);
        fireOrc.setSpeed(15);
        fireOrc.setElement("FIRE");
        fireOrc.setLootTable(fireFactory.createLootTable());
        for (Ability ability : fireFactory.createAbilities()) {
            fireOrc.addAbility(ability);
        }
        fireOrc.displayInfo();
        System.out.println();

        Orc iceOrc = new Orc("Frost Orc Berserker");
        iceOrc.setHealth(220);
        iceOrc.setDamage(40);
        iceOrc.setDefense(35);
        iceOrc.setSpeed(12);
        iceOrc.setElement("ICE");
        iceOrc.setLootTable(iceFactory.createLootTable());
        for (Ability ability : iceFactory.createAbilities()) {
            iceOrc.addAbility(ability);
        }
        iceOrc.displayInfo();
        System.out.println();

        Orc shadowOrc = new Orc("Shadow Orc Assassin");
        shadowOrc.setHealth(180);
        shadowOrc.setDamage(50);
        shadowOrc.setDefense(25);
        shadowOrc.setSpeed(20);
        shadowOrc.setElement("SHADOW");
        shadowOrc.setLootTable(shadowFactory.createLootTable());
        for (Ability ability : shadowFactory.createAbilities()) {
            shadowOrc.addAbility(ability);
        }
        shadowOrc.displayInfo();
        System.out.println();

        // Elite Orc
        Orc eliteOrc = new Orc("Elite Orc Warlord");
        eliteOrc.setHealth(500);
        eliteOrc.setDamage(85);
        eliteOrc.setDefense(60);
        eliteOrc.setSpeed(20);
        eliteOrc.setElement("FIRE");
        eliteOrc.setLootTable(fireFactory.createLootTable());
        for (Ability ability : fireFactory.createAbilities()) {
            eliteOrc.addAbility(ability);
        }
        eliteOrc.displayInfo();
        System.out.println();

        // ============================================================
        // DEMON LORDS - Ultimate boss enemies with builder
        // ============================================================
        System.out.println("--- DEMON LORDS ---\n");

        Enemy fireDemonLord = new BossEnemyBuilder()
            .setName("Infernal Demon Lord")
            .setHealth(75000)
            .setDamage(800)
            .setDefense(300)
            .setSpeed(70)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .addPhase(1, 75000)
            .addPhase(2, 45000)
            .addPhase(3, 20000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(25)
            .setAI(EnemyBehavior.AGGRESSIVE)
            .build();
        fireDemonLord.displayInfo();
        System.out.println();

        Enemy iceDemonLord = new BossEnemyBuilder()
            .setName("Frozen Demon Lord")
            .setHealth(70000)
            .setDamage(750)
            .setDefense(350)
            .setSpeed(65)
            .setElement("ICE")
            .setAbilities(iceFactory.createAbilities())
            .setLootTable(iceFactory.createLootTable())
            .addPhase(1, 70000)
            .addPhase(2, 42000)
            .addPhase(3, 18000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(23)
            .setAI(EnemyBehavior.DEFENSIVE)
            .build();
        iceDemonLord.displayInfo();
        System.out.println();

        Enemy shadowDemonLord = new BossEnemyBuilder()
            .setName("Void Demon Lord")
            .setHealth(80000)
            .setDamage(900)
            .setDefense(250)
            .setSpeed(80)
            .setElement("SHADOW")
            .setAbilities(shadowFactory.createAbilities())
            .setLootTable(shadowFactory.createLootTable())
            .addPhase(1, 80000)
            .addPhase(2, 50000)
            .addPhase(3, 25000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(28)
            .setAI(EnemyBehavior.TACTICAL)
            .build();
        shadowDemonLord.displayInfo();
        System.out.println();

        // ============================================================
        // DIRECTOR PRESET ENEMIES - Using EnemyDirector
        // ============================================================
        System.out.println("--- DIRECTOR PRESET ENEMIES ---\n");

        EnemyDirector director = new EnemyDirector();

        Enemy fireMinion = director.createMinion(fireFactory);
        fireMinion.displayInfo();
        System.out.println();

        Enemy iceElite = director.createElite(iceFactory);
        iceElite.displayInfo();
        System.out.println();

        Enemy shadowMiniBoss = director.createMiniBoss(shadowFactory);
        shadowMiniBoss.displayInfo();
        System.out.println();

        Enemy fireRaidBoss = director.createRaidBoss(fireFactory);
        fireRaidBoss.displayInfo();
        System.out.println();


        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();

        Enemy baseGoblin = new BasicEnemyBuilder()
            .setName("Goblin")
            .setHealth(100)
            .setDamage(15)
            .setDefense(5)
            .setSpeed(35)
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .build();

        Enemy baseDragon = new BossEnemyBuilder()
            .setName("Ancient Dragon")
            .setHealth(50000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(50)
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(25)
            .setAbilities(fireFactory.createAbilities())
            .setLootTable(fireFactory.createLootTable())
            .build();

        Enemy baseSkeleton = new BasicEnemyBuilder()
            .setName("Skeleton Warrior")
            .setHealth(150)
            .setDamage(20)
            .setDefense(15)
            .setSpeed(20)
            .setAbilities(shadowFactory.createAbilities())
            .setLootTable(shadowFactory.createLootTable())
            .build();
        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("dragon", baseDragon);
        registry.registerTemplate("skeleton", baseSkeleton);
        System.out.println("Registered templates: " + registry.listTemplates());
        System.out.println();

        System.out.println("Original Goblin Template:");
        baseGoblin.displayInfo();
        System.out.println();

        System.out.println("Cloning into Elite Goblin (2x stats):");
        Enemy eliteGoblinEnemy = registry.createFromTemplate("goblin");
        Goblin eliteGoblin1 = (Goblin) eliteGoblinEnemy;
        eliteGoblin1.setName("Elite Goblin");
        eliteGoblin1.multiplyStats(2.0);
        eliteGoblinEnemy.displayInfo();
        System.out.println();

        System.out.println("Cloning into Champion Goblin (5x stats):");
        Enemy championGoblinEnemy = registry.createFromTemplate("goblin");
        Goblin championGoblin = (Goblin) championGoblinEnemy;
        championGoblin.setName("Champion Goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.addAbility(new FireShield());
        championGoblinEnemy.displayInfo();
        System.out.println();

        System.out.println("Cloning into Boss Variant (10x stats + phases):");
        Enemy bossVariantEnemy = registry.createFromTemplate("dragon");
        DragonBoss dragonBoss = (DragonBoss) bossVariantEnemy;
        dragonBoss.multiplyStats(10.0);
        dragonBoss.addPhase(4, 10000);
        bossVariantEnemy.displayInfo();
        System.out.println();


        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        System.out.println("Abilities: " + Arrays.toString(fireFactory.createAbilities().stream().map(a -> a.getName()).toArray()));
        System.out.println("Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("AI Behavior: " + shadowFactory.createAIBehavior());
        System.out.println();

        Enemy demonLord = new BossEnemyBuilder()
            .setName("Shadow Demon Lord")
            .setHealth(100000)
            .setDamage(800)
            .setDefense(250)
            .setSpeed(60)
            .addPhase(1, 100000)
            .addPhase(2, 75000)
            .addPhase(3, 50000)
            .addPhase(4, 25000)
            .setCanFly(true)
            .setHasBreathAttack(true)
            .setWingspan(30)
            .setAbilities(shadowFactory.createAbilities())
            .setLootTable(shadowFactory.createLootTable())
            .setAI(EnemyBehavior.AGGRESSIVE)
            .build();
        demonLord.displayInfo();
        System.out.println();

        registry.registerTemplate("demon-lord", demonLord);
        Enemy greaterDemonEnemy = registry.createFromTemplate("demon-lord");
        ((DragonBoss) greaterDemonEnemy).multiplyStats(1.5);
        
        Enemy ancientDemonEnemy = registry.createFromTemplate("demon-lord");
        ((DragonBoss) ancientDemonEnemy).multiplyStats(2.0);

        System.out.println("Greater Demon stats:");
        greaterDemonEnemy.displayInfo();
        System.out.println();

        System.out.println("Ancient Demon stats:");
        ancientDemonEnemy.displayInfo();
        System.out.println();
    }
}
