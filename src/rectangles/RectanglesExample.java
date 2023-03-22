package rectangles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RectanglesExample {

    private static void printRectanglesList(List<Rectangle> list){
        System.out.println("List");
        for(Rectangle rectangle : list){
            System.out.println(rectangle);
        }
    }

    private static void printRectanglesSet(Set<Rectangle> list){
        for(Rectangle rectangle : list){
            System.out.println(rectangle);
        }
    }
    public static void main(String[] args) {
        List<Rectangle> list = List.of( new Rectangle(5,2),
                                        new Rectangle(12,8),
                                        new Rectangle(8,9),
                                        new Rectangle(8,16),
                                        new Rectangle(8,8),
                                        new Rectangle(4,5));

        printRectanglesList(list);
        System.out.println();

        Set<Rectangle> treeSet = new TreeSet<>(list);

        System.out.println("Tree Set");
        printRectanglesSet(treeSet);
        System.out.println();

        System.out.println("Hash Set");
        Set<Rectangle> hashSet = new HashSet<>(list);
        printRectanglesSet(hashSet);
        System.out.println();

    }
}
