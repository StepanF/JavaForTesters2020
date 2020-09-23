package ru.stqa.ptf.sandbox;


public class Zapysk {

  public static void main(String[] args) {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(4, 4);
    System.out.println("Расстояние между точками вычисленное по функции ="+ distance(p1, p2));
    System.out.println("Расстояние между точками вычисленное по методу ="+ p2.distance2(p1));
    System.out.println("расстояние между точками вычисленное в методе (пример)= " + p1.distance2(4,4));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));


  }

}
