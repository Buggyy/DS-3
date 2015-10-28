/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestudents;

/**
 *
 * @author duytran
 */
public class QuadraticProbing<Key, Value> {

    private int N;
    private int M = 13;
    private Key[] keys;
    private Value[] vals;
    private int cols = 0;

    public QuadraticProbing() {
        
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];

    }

    private int hash(Key key) {
        
        String ldap = key.toString();

        int hash = 0;
        
        for (int i = 0; i < ldap.length(); i++) {
            
              hash = (31 *  hash + ldap.charAt(i)) % M;

        }

        return (hash & 0x7fffffff) % M;

    }

    public void put(Key key, Value val) {

        int i;
        int j = 1, k = 0;

        
        for (i = hash(key); keys[i] != null; i = (int) (i + Math.pow(j, 2)) % M) {

            k++;
            j++;
            
        }
        
        if (k > 0) cols++;
        
        keys[i] = key;
        vals[i] = val;
        N++;

    }
    

    public int size() {
        return N;
    }

    public Value get(Key key) {
        
        int j = 1;

        for (int i = hash(key); keys[i] != null; i = (int) (i + Math.pow(j, 2)) % M) {

            if (keys[i].equals(key)) {
                return vals[i];
            }

        }
        return null;

    }

    public void printCol() {
        System.out.println("Quadratic Probing Collisions: " + cols);
    }

}
