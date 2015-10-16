package generatestudents;

/**
 * Dennis: Bij practicumopdracht 3 moet je drie hash tables maken. Voor HT1 en
 * HT2 kun je natuurlijk gewoon de algoritmes en code uit (Sedgewick & Wayne,
 * 2011) gebruiken. Zorg dan wel dat je het 'resizing gedeelte' verwijdert, en
 * je eigen verzonnen hashfunctie toevoegt.
 *
 * @author Stefan Lobato [IS204] 500707274
 */
public class LinearProbingHashST<Key, Value> {

    private int N; // number of key-value pairs in the table
    private int M = 16; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values
    private int collisions = 0; //  Amount of collisions

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    /**
     *
     * @param key
     * @return
     */
    private int hash(Key key) {
        String ldap = (String) key;

      
        return 0;

    }

//    public void put(Key key, Value val) {
//        if (N >= M / 2) {
//            resize(2 * M); // double M (see text)
//        }
//        int i;
//        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
//            if (keys[i].equals(key)) {
//                vals[i] = val;
//                return;
//            }
//        }
//        keys[i] = key;
//        vals[i] = val;
//        N++;
//    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
}
