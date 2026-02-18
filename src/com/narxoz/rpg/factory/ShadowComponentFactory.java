package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.Shadow.ShadowStrike;
import com.narxoz.rpg.combat.Shadow.Vanish;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.ShadowLootTable;
import java.util.*;


public class ShadowComponentFactory implements EnemyComponentFactory {
    ShadowLootTable lootTable = new ShadowLootTable();

    @Override
    public List<Ability> createAbilities() {
        List<Ability> list = new ArrayList<>();
        list.add(new ShadowStrike());
        list.add(new Vanish());
        return list;
    }

    @Override
    public LootTable createLootTable() {
        return lootTable;
    }

    @Override
    public EnemyBehavior createAIBehavior() {
        return EnemyBehavior.TACTICAL;
    }
}
