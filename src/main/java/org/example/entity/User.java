package org.example.entity;

import org.example.enums.Roles;

public class User {
    private String name;
    private Roles role;
    private String id;
    private Store store;

    public User(String name, Roles role, String id, Store store) {
        this.name = name;
        this.role = role;
        this.id = id;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", id='" + id + '\'' ;
    }
}
