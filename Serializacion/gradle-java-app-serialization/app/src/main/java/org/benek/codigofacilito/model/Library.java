package org.benek.codigofacilito.model;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void lendBook(User user, int bookId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            System.out.println(user.getName() + " borrowed " + book.getTitle());
            book.setAvailable(false);
        } else {
            System.out.println("Book is not available!");
        }
    }
}
