package com.example.tools.qa;

import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    private static KeyValueStore instance;
    private Map<String, String> store;

    private KeyValueStore() {
        store = new HashMap<>();
    }

    public static KeyValueStore getInstance() {
        if (instance == null) {
            instance = new KeyValueStore();
        }
        return instance;
    }

    public String get(String key) {
        return store.get(key);
    }

    public void set(String key, String value) {
        store.put(key, value);
    }

    public void remove(String key) {
        store.remove(key);
    }

    public boolean containsKey(String key) {
        return store.containsKey(key);
    }

    public void clear() {
        store.clear();
    }
}
