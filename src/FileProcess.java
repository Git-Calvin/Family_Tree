/**
 * FileProcess.java
 *
 * Created by Calvin Wong on 11/18/2014
 *
 */

public class FileProcess {

    public Person getPerson(String input) {

        /**
         * Retrieves parent from input string (element before "-") and creates person node for that node
         */

        String temp[] = input.split("-");
        Person op = PersonsList.isExist(temp[0]);
        if (op == null) {
            return new Person(temp[0]);
        } else {
            //System.out.println("exists"+op.name);
            return op;
        }
    }

    public Person[] getChildren(String input, Person p) {

        /**
         * Retrieve child nodes from input string (element after "-" and seperated by *) and creates person node
         * and each child node
         */

        String cText[] = input.split("-");
        String cName[] = cText[1].split(";");

        Person[] child = new Person[cName.length];

        for (int i = 0; i < child.length; i++) {

            Person temp = PersonsList.isExist(cName[i]);
            if (temp == null) {
                child[i] = new Person(cName[i], p);
            } else {
                //System.out.println("no creating");
                child[i] = temp;
            }
        }
        return child;
    }
} // end of class