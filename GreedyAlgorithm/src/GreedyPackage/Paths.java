package GreedyPackage;


import java.awt.Point;

public class Paths implements Comparable<Paths>{
    int x, y, distance;
    boolean check;
    public Paths(int x, int y, int distance, boolean check) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.check = check;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public boolean getCheck() {
        return check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }
    @Override
    public int compareTo(Paths path) {
        return this.distance > path.getDistance() ? 1 : this.distance < path.distance ? -1:0;
    }

}