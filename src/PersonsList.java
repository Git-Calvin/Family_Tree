import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.SortedSet;

/**
 * PersonsList.java
 *
 * Calvin Wong
 *
 * A class that holds all the persons in a list
 *
 */

public class PersonsList {

    public static ArrayList<Person> TreeList = new ArrayList<>(); // array that holds all family members

    public static Person isExist(String name) { // function to check whether family is already present in list

        Iterator it = TreeList.iterator();
        while (it.hasNext()) {
            Person t = (Person) it.next();
            if (t.name.equals(name)) {
                return t;
            }
        }
        return null;
    }

    public static Set<Person> getSiblingsList(Person parent) { // function to get sibling node of a parent

        Set<Person> siblings = new HashSet<Person>();

        int i = 1;

        while (i < TreeList.size()) {
            try {
                if (TreeList.get(i).parent.name.equals(parent.name)) {
                    siblings.add(TreeList.get(i));
                }
            } catch (Exception e) {
                //System.out.println("Exception in siblings "+ e);
            } finally {
                i++;
            }
        }
        return siblings;
    }

    public static void addParent(Person p) {

        Iterator it = TreeList.iterator();

        while (it.hasNext()) {
            Person t = (Person) it.next();
            if (t.name.equals(p.name)) {
                return;
            }
        }
        TreeList.add(p);
    }

    public static void printList() {

        ArrayList<Person> siblings = new ArrayList<Person>();

        int i = 0;

        while (i < TreeList.size()) {

            try {
                //System.out.println("Me:"+TreeList.get(i).name+"\n position:"+TreeList.get(i).xPos+","+TreeList.get(i).xPos);
            } catch (Exception e) {
                ////System.out.println("Exception in siblings "+ e);
            } finally {
                i++;
            }
        }
    }
} // end of class