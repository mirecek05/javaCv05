package cviceni05;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Osoba[] poleOsob = new Osoba[100000];
        for (int i = 0; i < poleOsob.length; i++) {
            poleOsob[i] = new Osoba(); //sem davam tridu Osoba nebo jeji dedene tridy a sleduji rychlost
        }

        Set<Osoba> mnozinaOsob = new HashSet<>();

        long start, stop;
        start = System.currentTimeMillis();
        for (int i = 0; i < poleOsob.length; i++) {
            mnozinaOsob.add(poleOsob[i]);
        }
        stop = System.currentTimeMillis();
        System.out.println("Vkladani prvku trvalo " + (stop - start) + " ms.");
        System.out.println("Mnozina obsahuje " + mnozinaOsob.size() + " prvku.");

        start = System.currentTimeMillis();
        for (int i = 0; i < poleOsob.length; i++) {
            mnozinaOsob.contains(poleOsob[i]);
        }
        stop = System.currentTimeMillis();
        System.out.println("Vkladani prvku trvalo " + (stop - start) + " ms.");

    }
}
