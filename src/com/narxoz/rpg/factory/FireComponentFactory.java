package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Fire.FireShield;
import com.narxoz.rpg.combat.Fire.FlameBreath;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.FireLootTable;

import java.util.*;

public class FireComponentFactory implements EnemyComponentFactory {
    FireLootTable lootTable = new FireLootTable();

    @Override
    public List<Ability> createAbilities() {
        List<Ability> list = new ArrayList<>();
        list.add(new FlameBreath());
        list.add(new FireShield());
        return list;
    }

    @Override
    public LootTable createLootTable() {
        return lootTable;
    }

    @Override
    public EnemyBehavior createAIBehavior() {
        return EnemyBehavior.AGGRESSIVE;
    }
}
