/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N_Queen_Problem;

import java.util.ArrayList;

/**
 *
 * @author moham
 */
public class SimulatedAnnealing {

    private static final int N = 100;

    public void run() {
        boolean flag = false;
        double T = 1.0;
        double Tmin = 0.000001;
        double alpha = 0.99;
        
        double t = T;

        ArrayList<Queen> current = generateStart();

        while (t >= Tmin) {
            int i = 0;
            while (i <= 100) {
                int costCurrent = calculateCost(current);
                if (costCurrent == 0) {
                    System.out.println("Solution Found");
                    printBoard(current);
                    flag = true;
                    break;
                }
                ArrayList<Queen> next = generateNeighbor(current);
                int costNext = calculateCost(next);
                int change = costNext - costCurrent;
                if (change <= 0) {
                    current = next;
                } else {
                    double probability = acceptance_probability(costNext, costCurrent, t);
                    //System.out.println("probability is : " + probability);
                    if (Math.random() > probability) {
                        //System.out.println("probability is : " + probability);
                        current = next;
                    }
                }
               i++;
            }
            if (flag){
                break;
            }
            t = alpha * t;
            //System.out.println("value of t: " + t);
        }
    }

    private ArrayList<Queen> generateStart() {
        ArrayList<Queen> start = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            Queen q = new Queen(i, i);
            start.add(q);
        }
        return start;
    }

    private ArrayList<Queen> generateNeighbor(ArrayList<Queen> current) {
        ArrayList<Queen> next = new ArrayList<>();
        next.addAll(current);
        int a = (int) (Math.random() * N);
        int b = a;
        while (a == b) {
            b = (int) (Math.random() * N);
            Queen q1 = next.get(a);
            Queen q2 = next.get(b);
            next.set(a, q2);
            next.set(b, q1);
        }
        return next;
    }

    private void printBoard(ArrayList<Queen> current) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (current.get(i).col != j) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print('Q' + " ");
                }
            }
            System.out.println("");
        }
    }

    private int calculateCost(ArrayList<Queen> board) {
        int cost = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if ((i + board.get(i).col == j + board.get(j).col) || (i - board.get(i).col == j - board.get(j).col)) {
                    cost++;
                }
            }
        }
        System.out.println(cost);
        return cost;
    }

    private double acceptance_probability(int costNext, int costCurrent, double t) {
        return Math.exp((costNext - costCurrent) / t);
    }

}
