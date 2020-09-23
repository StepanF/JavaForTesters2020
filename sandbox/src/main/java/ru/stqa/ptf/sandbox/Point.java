package ru.stqa.ptf.sandbox;

public class Point {
  double x;
  double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  double distance2 (Point p) {
    return distance2(p.x, p.y);
  }

  public double distance2(double x, double y) {
    return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
  }
}
