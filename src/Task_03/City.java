/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task_03;

/**
 *
 * @author moham
 */
public class City {
    
    public int Fn, Gn, id;
    public City parent;
    
    public City(City parent, int id){
        this.parent = parent;
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof City) {
            City c;
            c = (City) o;
            return c.id == this.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
    }
}
