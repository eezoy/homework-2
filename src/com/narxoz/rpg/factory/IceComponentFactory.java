package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Ice.IceShield;
import com.narxoz.rpg.combat.Ice.FrostBreath;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.IceLootTable;


import java.util.*;

public class IceComponentFactory implements EnemyComponentFactory{
    IceLootTable lootTable = new IceLootTable();

    @Override
    public List<Ability> createAbilities() {
        List<Ability> list = new ArrayList<>();
        list.add(new FrostBreath());
        list.add(new IceShield());
        return list;
    }

    @Override
    public LootTable createLootTable() {
        return lootTable;
    }

    @Override
    public EnemyBehavior createAIBehavior() {
        return EnemyBehavior.DEFENSIVE;
    }
}
