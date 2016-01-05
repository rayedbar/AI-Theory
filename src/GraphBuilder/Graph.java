/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class Graph {

    private final String file;
    private int [][] map;
    
    public Graph(String file) {
        this.file = file;
    }
    
    public int [][] build() {
        try {
            try (Scanner sc = new Scanner(new File(file))) {
                int cities = sc.nextInt();
                map = new int [cities][cities];
                int links = sc.nextInt();
                for (int i = 0; i < links; ++i){
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int c = sc.nextInt();
                    map[a][b] = c;
                    map[b][a] = c;
                }
            }
            return map;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
    
    
    public void printGraph(){
        for(int i = 0; i < map.length; ++i){
            for(int j = 0; j < map[0].length; ++j){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}
