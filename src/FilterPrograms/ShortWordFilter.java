package FilterPrograms;

public class ShortWordFilter implements Filters {
    @Override
    public boolean accept(Object x) {
        String testedString = (String) x;

        if (testedString.length() < 5){
            return true;
        }
        return false;
    }
}
