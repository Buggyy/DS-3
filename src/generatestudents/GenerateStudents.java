package generatestudents;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author breud
 */
public class GenerateStudents {

    public static int hash(Student st) {

        int M = 13;

        String ldap = st.getLdap();

        int hash = 0;

        for (int i = 0; i < ldap.length(); i++) {

            hash = (31 * hash + ldap.charAt(i)) % M;

        }

        return (hash & 0x7fffffff) % M;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //In de Student klas zit een hashCode method die we zelf moesten schrijven.
        //Hiermee halen we de Integer waarde op van een String literal.
        //De klasses GenerateStudents, StudentList en Student werden cadeau gegeven door school.
        StudentList students = new StudentList(13);

//        System.out.println(students);
        //Haalt de array op van het object students.
        Student[] studentArray = students.getList();

        List<Integer> hashValues = new ArrayList();

        //Math.abs voor de absolute waarde van de hashcode die niet altijd positief is.
        //Modulo 97 staat in de opdracht waarom we dat doen.
        for (int i = 0; i < studentArray.length; i++) {
            int value = hash(studentArray[i]) % 97;
            hashValues.add(value);

        }

        //Maakt een (Hash)Set aan met unieke waardes
        Set<Integer> uniqueValues = new HashSet(hashValues);

        //De frequentie
        int freq = 0;

//        for (int value : uniqueValues) {
//
//            System.out.print("Hashvalue: " + value);
//            for (int i = 0; i < hashValues.size(); i++) {
//                if (value == hashValues.get(i)) {
//                    freq++;
//                }
//
//            }
//
//            System.out.println("\t freq " + freq);
//
//            //De frequentie moet weer op 0 zodat we opnieuw kunnen tellen bij de andere values.
//            freq = 0;
//
//        }

        SeparateChainingHashST sp = new SeparateChainingHashST();
        LinearProbing lp = new LinearProbing();
        QuadraticProbing qp = new QuadraticProbing();

        for (int i = 0; i < studentArray.length; i++) {

            sp.put(studentArray[i].getLdap(), studentArray[i].getEcts());
            lp.put(studentArray[i].getLdap(), studentArray[i].getEcts());
            qp.put(studentArray[i].getLdap(), studentArray[i].getEcts());

        }

        for (int i = 0; i < studentArray.length; i++) {

            System.out.println(sp.get(studentArray[i].getLdap()));
//            System.out.println(lp.get(studentArray[i].getLdap()));
//            System.out.println(qp.get(studentArray[i].getLdap()));

        }

//        sp.printCol();
//        lp.printCol();
//        qp.printCol();
        
    }

}
