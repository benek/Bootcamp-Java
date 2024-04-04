package org.benek.codigofacilito.model;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 42L;

    private static int counter = 1;
    private int id;
    private String title;
    private transient boolean available = true;

    public Book(String title) {
        this.title = title;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
