/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatestudents;

/**
 *
 * @author Sylvi-Fashion
 */
public class SequentialSearchST<Key, Value> {
 
    private int N;          
    private int M = 13;
    private Node first;     

 
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    private int hash(Key key) {
        
        String ldap = key.toString();

        int hash = 0;
        
        for (int i = 0; i < ldap.length(); i++) {
            
            hash = (31 *  hash + ldap.charAt(i)) % M;
            
        }

        return (hash & 0x7fffffff) % M;

    } 
    
    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }
    
    public int put(Key key, Value val) {

        int cols = 0, j = 0;
        
        for (Node x = first; x != null; x = x.next) {
            j++;
        }
        
        if (j > 0) cols++;
        
        first = new Node(key, val, first);
        N++;
        return cols;
    }
 
}
