package Greedy;
// created by Kaan Ozbudak at 23.12.2018
// greedy algorithm is not best option for travel sales man problem
// permute 1 - 2 - 3
import java.util.ArrayList;
import java.util.Collections;
public class Algorithm {
    private static ArrayList<Paths> arrayList;
    private static ArrayList<Integer> GreedyWay = new ArrayList<>();
    private static ArrayList<Integer> permute1Way = new ArrayList<>();
    private static ArrayList<Integer> permute2Way = new ArrayList<>();
    private static ArrayList<Integer> permute2 = new ArrayList<>();
    private static ArrayList<Integer> permute3 = new ArrayList<>();
    private static ArrayList<Integer> permuteAll = new ArrayList<>();
    private static int distance = 0;
    private static void pushData(){
        arrayList = Paths.getList();
        Collections.sort(arrayList); // sort array list by using their distance because we need to follow path which shortest
    }
    private static void startWay(int cityNumber){
        GreedyWay.add(cityNumber);
        for (Paths paths : arrayList) {
            if (paths.getY() == cityNumber) {
            paths.setCheck(true); // if somebody visit that city please change change as true so nobody can not visit one more
            }
        }
        for (Paths paths : arrayList) {
            if (paths.getX() == cityNumber) {
                if (!paths.getCheck()) {
                    distance += paths.getDistance();  // add distance to distance
                    startWay(paths.getY());
                    break;
                }
            }
        }
    }
    private static void setInitial(){
        distance = 0;
        for (Paths paths : arrayList) {
            paths.setCheck(false);
        }
        GreedyWay.clear();  // initialize everything for another path
    }
    private static void permute1(){
        startPermute1();
        System.out.println(permute1Way + " -----> " + getDistance(permute1Way));
        distance = 0;
    }
    private static void startPermute1(){
        setPermute1Path();
        permute1Way.add(permute1Way.get(0));
    }
    private static void setPermute1Path(){
        while (permute1Way.size()<5){
            int randomNumber = createRandomNumber(1,5);
            if (checkPath(randomNumber)){
                permute1Way.add(randomNumber);
            }
            else {
                setPermute1Path();
            }
        }
    }
    private static boolean checkPath(int randomNumber){
        for (Integer integer : permute1Way) {
            if (integer == randomNumber) {
                return false;
            }
        }
        return true;
    }
    private static int getDistance(ArrayList<Integer> temp){
        for (int i=0;i<temp.size()-1;i++){
            for (Paths paths:arrayList){
                if (temp.get(i) == paths.getX() && temp.get(i+1) == paths.getY()){
                    distance += paths.getDistance();
                }
            }
        }
        return distance;
    }
    private static void permute2(){
        for (int i=1;i<=5;i++){
            permute2.add(i);
        }
        int n = 5;
        while (n>0){
            int removeItemNumber = createRandomNumber(1,n) - 1;
            permute2Way.add(permute2.get(removeItemNumber));
            popPermute2(removeItemNumber);
            n--;
        }
        permute2Way.add(permute2Way.get(0));
        System.out.println(permute2Way + " -----> " + getDistance(permute2Way));
        distance = 0;
    }
    private static void popPermute2(int removeItemNumber){
        permute2.remove(removeItemNumber);
    }
    private static int createRandomNumber(int min, int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
    private static void permute3(){
        for (int i=1;i<=5;i++){
            permute3.add(i);
        }
        int n =5;
        int startNumber = 1;
        while (n>0){
            int changeItemNumber = createRandomNumber(startNumber,5)-1;
            int temp1 = permute3.get(0);
            int temp2 = permute3.get(changeItemNumber);
            permute3.set(changeItemNumber,temp1);
            permute3.set(0, temp2);
            startNumber++;
            n--;
        }
        permute3.add(permute3.get(0));
        System.out.println(permute3 + " -----> " + getDistance(permute3));
        distance = 0;
    }
    private static void Greedy(){
        for (int j=1;j<=5;j++){
            startWay(j);
            System.out.println("if you select to start from "+ j + " with Greedy algorithm: ");
            GreedyWay.add(GreedyWay.get(0));
            for (Paths paths : arrayList) {
                if (paths.getX() == GreedyWay.get(GreedyWay.size() - 2) && paths.getY() == j) {
                    distance += paths.getDistance();
                }
            }
            System.out.println(GreedyWay + " -----> " + distance);
            setInitial();
        }
    }
    private static void permuteAll(){
        String str = "12345";
        int n = str.length();
        permute(str, 0, n-1);
    }
    private static void permute(String str, int l, int r){
        if (l == r){
            for (int i=0;i<str.length();i++){
                permuteAll.add(Integer.parseInt(str.substring(i,i+1)));
            }
            permuteAll.add(permuteAll.get(0));
            System.out.println(permuteAll+" -----> "+getDistance(permuteAll));
            permuteAll.clear();
            distance = 0;
        }
        else {
            for (int i=l;i<=r;i++){
                str = swap(str,l,i);
                permute(str,l+1,r);
                str = swap(str,l,i);
            }
        }

    }
    private static String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void main(String[] args) {
        pushData();
        System.out.println("Greedy algorithm");
        Greedy();
        System.out.println("start with random and if you choose Permute-1 algorithm: ");
        permute1();
        System.out.println("start with random and if you choose Permute-2 algorithm: ");
        permute2();
        System.out.println("start with random and if you choose Permute-3 algorithm:");
        permute3();
        System.out.println("Permute All");
        permuteAll();
    }
}
