/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task_03;

import GraphBuilder.Graph;

/**
 *
 * @author moham
 */
public class Main {
    
    private int [][] map;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().go();
    }
    
    
    private void go() {
        Graph graph = new Graph("C:\\Users\\moham\\Documents\\NetBeansProjects\\AI Theory\\src\\Task_03\\input.txt");
        map = graph.build();
        //graph.printGraph();
        //AStarSearch aStarSearch = new AStarSearch(map);
        //aStarSearch.run();
        DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(map);
        depthLimitedSearch.run();
        

    }
    
    

}
