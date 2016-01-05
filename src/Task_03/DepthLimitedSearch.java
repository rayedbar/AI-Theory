/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task_03;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author moham
 */
public class DepthLimitedSearch {

    private static final int N = 13;
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
    }
    private final int [][] map;
    private final int [] color;
    private final int [] parent;
    
    public DepthLimitedSearch(int [][] map){
        this.map = map;
        color = new int [N];
        parent = new int [N];
    }
    
    void run() {
        parent[0] = -1;
        System.out.println("At:" + dictionary.get(0));
        for (int i = 0; i < N; ++i){
            if (color[i] == 0){
                dfs(i);
            }
        }
        printPath();
    }

    private void dfs(int i) {
        color[i] = 1;
        for (int j = 0; j < N; ++j){
            if (map[i][j] != 0 && color[j] == 0){
                System.out.println("At:" + dictionary.get(j));
                parent[j] = i;
                dfs(j);
            }
        }
    }

    private void printPath() {
        int i = 12;
        while (parent[i] != -1){
            System.out.println(dictionary.get(i));
            i = parent[i];
        }
        System.out.println(dictionary.get(0));
    }
    
}
