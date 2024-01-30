package FilterPrograms;

import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String args[])
    {
        BigRectangleFilter filter = new BigRectangleFilter();
        ArrayList<Rectangle> listRect = new ArrayList<>();
        listRect.add(new Rectangle(1,3));
        listRect.add(new Rectangle(100,3));
        listRect.add(new Rectangle(10,10));
        listRect.add(new Rectangle(1,90));
        listRect.add(new Rectangle(1,1));
        listRect.add(new Rectangle(2,2));
        listRect.add(new Rectangle(2,3));
        listRect.add(new Rectangle(10,5));
        listRect.add(new Rectangle(8,3));
        listRect.add(new Rectangle(3,5));
        System.out.println("Big Rectangles:");
        for (Rectangle recToTest : listRect)
        {
            boolean isBigRect = false;
            isBigRect = filter.accept(recToTest);
            if (isBigRect == true)
            {
                System.out.println("Height: " + recToTest.getHeight() + " | Width: " + recToTest.getWidth());
                Collector.collectsAll(recToTest);
            }
        }

    }
}
