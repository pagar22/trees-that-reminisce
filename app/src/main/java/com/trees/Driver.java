package com.trees;

public class Driver {
    public String getGreeting() {
        return "Gradle ftw! :')";
    }

    public static void main(String[] args) {
        System.out.println(new Driver().getGreeting());
    }
}
