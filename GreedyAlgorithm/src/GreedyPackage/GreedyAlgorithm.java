package GreedyPackage;
// created by Kaan Ozbudak at 23.12.2018
// greedy algorithm is not best option for travel sales man problem
import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm
{
    private static ArrayList<Paths> arrayList;
    private static ArrayList<Integer> way = new ArrayList<>();
    private static int length = 0;
    private static void pushData(){
        arrayList = new ArrayList<>();

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
        arrayList.add(new Paths(4, 3, 50, false));
        arrayList.add(new Paths(4, 2, 225, false));
        arrayList.add(new Paths(4, 5, 200, false));

        arrayList.add(new Paths(5, 4, 200, false));
        arrayList.add(new Paths(5, 1, 225, false));
        arrayList.add(new Paths(5, 2, 400, false));
        arrayList.add(new Paths(5, 3, 450, false));
        Collections.sort(arrayList);
        // sort array list by using their distance because we need to follow path which shortest
    }
    private static void startWay(int cityNumber){
        way.add(cityNumber);
        for (Paths paths : arrayList) {
            if (paths.getY() == cityNumber) {
                paths.setCheck(true);
                // if somebody visit that city please change change as true so nobody can not visit one more
            }
        }
        for (Paths paths : arrayList) {
            if (paths.getX() == cityNumber) {
                if (!paths.getCheck()) {
                    length += paths.getDistance();
                    // add distance to length
                    startWay(paths.getY());
                    break;
                }
            }
        }
    }

    private static void setInitial(){
        for (Paths paths : arrayList) {
            paths.setCheck(false);
        }
        // initialize everything for another path
        way.clear();
    }

    public static void main(String[] args) {
        pushData();
        for (int j=1;j<=5;j++){
            startWay(j);
            System.out.println("if you select to start from = "+j);
            way.add(way.get(0));
            System.out.print(way + " -----> ");
            for (Paths paths : arrayList) {
                if (paths.getX() == way.get(way.size() - 2) && paths.getY() == j) {
                    length += paths.getDistance();
                }
            }
            System.out.println(" " + length);
            setInitial();
        }
    }
}
