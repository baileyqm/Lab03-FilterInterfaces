package FilterPrograms;

import java.awt.*;

class BigRectangleFilter implements Filters{
    @Override
    public boolean accept(Object x) {
        Rectangle recToTest = (Rectangle) x;
        if (((recToTest.width+recToTest.height) * 2 ) > 10)
        {
            return true;
        }
        return false;
    }
}
