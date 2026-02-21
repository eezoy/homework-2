package com.narxoz.rpg.prototype;

import java.util.*;

import com.narxoz.rpg.enemy.Enemy;

public class EnemyRegistry {
    private Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        return template.clone();
    }

    public Set<String> listTemplates() {
        return templates.keySet();
    }
}