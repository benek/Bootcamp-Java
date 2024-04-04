package org.benek.codigofacilito.model;

public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void requestBook(Library library, int bookId);
}
