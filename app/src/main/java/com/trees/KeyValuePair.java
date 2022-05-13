package com.trees;

import javax.annotation.Nonnull;

//TODO add getters and setters and change field access modifiers

public class KeyValuePair<K, V> implements Comparable<V>{

    public K key;
    public V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key == null? value.toString() : key + ": " + value.toString();
    }

    @Override
    public int compareTo(@Nonnull Object o) {
        if (this.value instanceof Integer) return (Integer) this.value - (Integer) o;
        else if (this.value instanceof String) return this.value.toString().compareTo(o.toString());
        else throw new TypeNotPresentException(this.value.getClass().getTypeName(),
                    new Exception("KVP value doesn't support this generic type :("));
    }
}
