/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.benek.codigofacilito;

import org.benek.CustomLib;

public class App {
    public String getGreeting() {
        return "CustomLib identifier is: " + CustomLib.identifier;
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
