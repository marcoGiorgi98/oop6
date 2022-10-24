package it.unibo.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int elemento= 1_000_000;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     * 
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> lista=new ArrayList<>();
        for (int a=1000;a<2000;a++) {
           lista.add(a);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> listaLinkata= new LinkedList<>();
        listaLinkata.addAll(lista);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int swap= lista.get(0);  //save the first elem
        lista.set(0, lista.size()-1);
        lista.set(lista.size()-1, swap);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int p=0;p<lista.size();p++) {
            System.out.println(lista.get(p));

        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        //final Set<String> set = new TreeSet<>();
        /*
         * Prepare a variable for measuring time
         */
        lista.clear();   //elimino la lista precedente
        listaLinkata.clear();
        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= elemento; i++) {
            lista.add(i);
            listaLinkata.addFirst(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + lista.size()
                + " inserting them in a Arraylist took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        System.out.println(// NOPMD
            "Converting "
                + listaLinkata.size()
                + " inserting them in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        for (int mid=0;mid<1000;mid++){

        }
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> Mappa=new HashMap<String,Long>();
        Mappa.put("Africa",1_110_635_000L );
        Mappa.put("America",972_005_000L);
        Mappa.put("Antarctica",0L);
        Mappa.put("Asia", 4_298_723_000L);
        Mappa.put("Europe",742_452_000L);
        Mappa.put("Oceania",38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        Long somma;
        somma=Mappa.get("Africa");
       somma=somma+Mappa.get("America");
       somma=somma+Mappa.get("Antarctica");
       somma=somma+Mappa.get("Asia");
       somma=somma+Mappa.get("Europe");
       somma=somma+Mappa.get("Oceania");
       System.out.println(somma);
    }
}
