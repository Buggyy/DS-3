
package generatestudents;

/**
 *
 * @author breud
 */
public class GenerateStudents {

    /**
     * Bij practicumopdracht 3 moet je drie hash tables maken. Voor HT1 en HT2 
     * kun je natuurlijk gewoon de algoritmes en code uit (Sedgewick & Wayne, 2011) 
     * gebruiken. Zorg dan wel dat je het 'resizing gedeelte' verwijdert, en je eigen verzonnen hashfunctie toevoegt
     */
    public static void main(String[] args) {
        StudentList students = new StudentList(10000);
        
        System.out.println(students);
    }
    
}
