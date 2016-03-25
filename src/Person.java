import java.util.ArrayList;

/**
 * Person.java
 *
 * Calvin Wong
 *
 * A class to represent each node/person in a tree
 *
 */

public class Person {

    Person parent;
    ArrayList<Person> children = new ArrayList<Person>();
    String name;
    int xPos, yPos;
    boolean draw = false;

    public Person(String name) {

        this.name = name;
        parent = null;
        children = new ArrayList<Person>();

    }

    public Person(String name, Person parent) {

        this.name = name;
        this.parent = parent;

    }

    public void addChild(Person pChild) {
        this.children.add(pChild);
        PersonsList.TreeList.get(PersonsList.TreeList.size() - 1).parent = this;

    }

    public void addChild(Person[] pChild) {
        for (Person p : pChild) {
            this.children.add(p);
            PersonsList.TreeList.get(PersonsList.TreeList.size() - 1).parent = this;
        }
    }
} // end of class