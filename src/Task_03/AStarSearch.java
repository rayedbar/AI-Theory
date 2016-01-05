/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task_03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author moham
 */
public class AStarSearch {

    private static final int[] heuristic;
    private static final Map<Integer, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put(0, "Arad");
        dictionary.put(1, "Zerind");
        dictionary.put(2, "Timisoara");
        dictionary.put(3, "Oradea");
        dictionary.put(4, "Lugoj");
        dictionary.put(5, "Sibiu");
        dictionary.put(6, "Mehadia");
        dictionary.put(7, "Fagaras");
        dictionary.put(8, "Dobreta");
        dictionary.put(9, "Rimnicu Vilcea");
        dictionary.put(10, "Craiova");
        dictionary.put(11, "Pitesti");
        dictionary.put(12, "Bucharest");

        heuristic = new int[]{
            366, 374, 329, 380,
            244, 253, 241, 176,
            242, 193, 160, 10, 0
        };
    }

    private final int[][] map;
    PriorityQueue<City> cityQueue;


    public AStarSearch(int[][] map) {
        this.map = map;
        cityQueue = new PriorityQueue<>(new CityComparator());
    }

    public void run() {
        City start = new City(null, 0);
        cityQueue.add(start);
        while (!cityQueue.isEmpty()) {
            City current = cityQueue.remove();
            //System.out.println(dictionary.get(current.id) + " - " + current.Fn);
            if (current.id == 12) {
                printPath(current);
                break;
            }
            for (int i = 0; i < map.length; ++i) {
                int cost = map[current.id][i];
                if (cost != 0) {
                    City next = new City(current, i);
                    next.Gn = current.Gn + cost;
                    next.Fn = next.Gn + heuristic[i];
                    if (!cityQueue.contains(next)) {
                        cityQueue.add(next);
                    }
                }
            }
        }

    }

    private void printPath(City city) {
        System.out.println("Destination Reached. Read bottom up.");
        while ((city.parent != null)) {
            System.out.println(dictionary.get(city.id) + ": " + "Total Cost: " + city.Gn);
            city = city.parent;
        }
        System.out.println(dictionary.get(city.id) + ": " + "Total Cost: " + city.Gn);
    }

    private class CityComparator implements Comparator<City> {

        public CityComparator() {
        }

        @Override
        public int compare(City c1, City c2) {
            if (c1.Fn > c2.Fn) {
                return 1;
            }
            if (c1.Fn < c2.Fn) {
                return -1;
            }
            return 0;
        }
    }

}
