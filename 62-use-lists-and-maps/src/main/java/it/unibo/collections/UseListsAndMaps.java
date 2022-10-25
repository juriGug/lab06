package it.unibo.collections;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    final static int ELEMENTS = 100;
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = 0; i < ELEMENTS;i++){
            list.add( (int)( Math.random() * 1000 + 1000));
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int pos = list.indexOf(list.iterator().next());//pos 0
        final int first = list.iterator().next();
        list.set(pos, list.get(list.size()-1));
        list.set(list.size()-1, first);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int i : list){
            System.out.println(""+i);
        }
        System.out.println("");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0; i <100000; i++)
            list.add(0,i);
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println((""+millis));
        
        time = System.nanoTime();
        for(int i = 0; i <100000; i++)
            list2.addFirst(i);
        time = System.nanoTime() - time;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println((""+millis2));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        System.out.println("");
        int posizione = list.size()/2;
        time = System.nanoTime();
        for(int i = 0 ; i <1000; i++){
            list.get(posizione);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println((""+millis));

        posizione = list.size()/2;
        time = System.nanoTime();
        for(int i = 0 ; i <1000; i++){
            list2.get(posizione);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println((""+millis));

        //sjjs
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
        final Map<String, Long> mappa = new HashMap<>();
        mappa.put("Africa", 1_110_635_000L);
        mappa.put("Americas", 972_005_000L);
        mappa.put("Antarctica", 0L);
        mappa.put("Asia", 4_298_723_000L);
        mappa.put("Europe", 742_452_000L);
        mappa.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long popolazione = 0;
        for(final String nomeStringa : mappa.keySet()){
            popolazione += mappa.get(nomeStringa);
        }
        System.out.println(""+ popolazione);
    }
}
