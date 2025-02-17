/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.ejemplo;

import java.io.*;
import org.benek.codigofacilito.model.Book;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/path/to//serialized-book.txt"); //Update path accordingly
        ObjectInputStream ois = new ObjectInputStream(fis);

        Book bookFromAnotherApp = (Book) ois.readObject();
        ois.close();

        System.out.println(bookFromAnotherApp.getId());
        System.out.println(bookFromAnotherApp.getTitle());
        System.out.println(bookFromAnotherApp.isAvailable());
    }
}
