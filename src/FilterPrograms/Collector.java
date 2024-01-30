package FilterPrograms;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;

public class Collector {
    static ArrayList<Object> collected = new ArrayList<>();
    public static ArrayList collectsAll(Object x){
        collected.add(x);
        return collected;
    }

}
