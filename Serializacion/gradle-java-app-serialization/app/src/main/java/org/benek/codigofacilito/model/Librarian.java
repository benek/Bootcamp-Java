package org.benek.codigofacilito.model;

public class Librarian extends User {

    public Librarian(String name) {
        super(name);
    }

    @Override
    public void requestBook(Library library, int bookId) {
        System.out.println("Librarian doesn't need to request a book!");
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }
}
