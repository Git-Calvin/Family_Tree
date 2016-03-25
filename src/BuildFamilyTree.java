import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * BuildFamilyTree.java
 *
 * Created by Calvin Wong on 11/18/2014
 *
 * Builds family tree
 */

public class BuildFamilyTree {

    // recursive method to travel through tree
    public void treeTravel(Person person) {

        if (person != null) {
            //System.out.println(person.name);
        }
        if (person.children == null) {
            return;
        } else {
            Iterator child = person.children.listIterator();

            while (child.hasNext()) {
                treeTravel((Person) child.next());
            }
        }
    }

    public void addListPersons(Person plist[]) {

        for (Person child : plist) {
            PersonsList.TreeList.add(child);
        }
    }

    public static void main(String[] args) {

        BuildFamilyTree tree = new BuildFamilyTree();
        BufferedReader diskInput;
        FileProcess fileRead = new FileProcess();

        String word;

        // Uses a scanner class object to read input from text file and call method to seperate parent and child.
        try {
            // read from file
            diskInput = new BufferedReader(new InputStreamReader(new FileInputStream( new File("TreeInput.txt"))));
            Scanner input = new Scanner(diskInput);

            while (input.hasNext()) {
                word = input.nextLine();
                ////System.out.println("Word :::" + word);
                Person temp_p = fileRead.getPerson(word);

                PersonsList.addParent(temp_p);

                Person[] list_child = fileRead.getChildren(word, temp_p);

                tree.addListPersons(list_child);
                temp_p.addChild(list_child);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tree.treeTravel(PersonsList.TreeList.get(0));

        // building 
        Person parent = PersonsList.TreeList.get(0);
        //int xChange = 160, yChange = 170;
        parent.xPos = 350;
        parent.yPos = 80;
        //int lastParentXPos = parent.xPos;
        int lastParentYPos = parent.yPos;
        //PersonsList.printList();
        int pCount = 1;
        int size = PersonsList.TreeList.size();

        /**
         * Iterate through all the nodes in the tree list and assign xPos,yPos coordinate to each node based on their
         * relationship; once assigned coordinate, set draw value as true to indicate it coordinate values has been
         * assigned
        */
        while (pCount < size) {
            //System.out.println("Parent :" + parent.name);
            Set siblings = PersonsList.getSiblingsList(parent);

            int temp = 0;

            Iterator it = siblings.iterator();

            while (it.hasNext()) {

                Person te = (Person) it.next();

                if (te.draw == false) {

                    te.xPos = (temp + 1) * 100;
                    te.yPos = lastParentYPos + 150;
                    te.draw = true;
                    //System.out.println(it.name + "(" + it.xPos + "," + it.yPos + ") -- draw line from (" + parent.xPos + "," + parent.yPos + ")");
                    LineInfo edgeTemp = new LineInfo(te.xPos, te.yPos, parent.xPos, parent.yPos, te.name, parent.name);
                    LineInfo.edgeList.add(edgeTemp);
                }
                //  //System.out.println(it.name);
                temp++;
            }

            parent = PersonsList.TreeList.get(pCount);
            lastParentYPos = lastParentYPos + 80;
            //70lastPrentXpos = lastParentXPos + 80 ;

            pCount++;

        }
        //System.out.println("======================================");
        // PersonsList.printList();
        DrawTree dr = new DrawTree();
        dr.setTitle("A Funny-Looking Family Tree Diagram");
        dr.setSize(700, 750);
        dr.setVisible(true);
        dr.setBackground(Color.LIGHT_GRAY);
        Font font = new Font("Courier New", Font.BOLD, 10);
        dr.setFont(font);
        dr.setLocationRelativeTo(null);



        //System.out.println("Tree Transversal using recursion");

        tree.treeTravel(PersonsList.TreeList.get(0));
    }
} // end of class
