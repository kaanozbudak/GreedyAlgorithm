package Greedy;

import java.util.ArrayList;

public class Paths implements Comparable<Paths>{
    private int x, y, distance;
    private boolean check;
    static ArrayList<Paths> arrayList = new ArrayList<>();
    Paths(int x, int y, int distance, boolean check) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.check = check;
    }
    int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    boolean getCheck() {
        return check;
    }
    void setCheck(boolean check) {
        this.check = check;
    }
    static ArrayList<Paths> getList(){
        arrayList.add(new Paths(1, 4, 100, false));
        arrayList.add(new Paths(1, 2, 200, false));
        arrayList.add(new Paths(1, 5, 225, false));
        arrayList.add(new Paths(1, 3, 250, false));
        arrayList.add(new Paths(2, 1, 200, false));
        arrayList.add(new Paths(2, 3, 225, false));
        arrayList.add(new Paths(2, 4, 225, false));
        arrayList.add(new Paths(2, 5, 400, false));
        arrayList.add(new Paths(3, 5, 450, false));
        arrayList.add(new Paths(3, 4, 50,  false));
        arrayList.add(new Paths(3, 2, 225, false));
        arrayList.add(new Paths(3, 1, 250, false));
        arrayList.add(new Paths(4, 1, 100, false));
        arrayList.add(new Paths(4, 3, 50,  false));
        arrayList.add(new Paths(4, 2, 225, false));
        arrayList.add(new Paths(4, 5, 200, false));
        arrayList.add(new Paths(5, 4, 200, false));
        arrayList.add(new Paths(5, 1, 225, false));
        arrayList.add(new Paths(5, 2, 400, false));
        arrayList.add(new Paths(5, 3, 450, false));
        return arrayList;
    }
    @Override
    public int compareTo(Paths path) {
        return this.distance > path.getDistance() ? 1 : this.distance < path.distance ? -1:0;
    }

}
