package main;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {

        SpaceObject Earth = new Planet("Earth", 3, 0, Math.PI/2);
        SpaceObject Mars = new Planet("Mars", 4, 0, 0);
        System.out.println("Distance between Earth and Mars is " + Math.sqrt(Earth.distanceSquaredTo(Mars)));

    }
}