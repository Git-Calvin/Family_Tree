import java.util.ArrayList;

/**
 * LineInfo.java
 *
 * Calvin Wong
 *
 * A class to represent coordinates and adjusts nodes coordinate posistions
 *
 */
public class LineInfo {

    int x1, y1, x2, y2;
    String name1, name2;

    public static ArrayList<LineInfo> edgeList = new ArrayList<LineInfo>();

    public LineInfo(int x1, int y1, int x2, int y2, String name1, String name2) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.name1 = name1;
        this.name2 = name2;
    }
} // end of class
