package Task10;
import java.util.Comparator;

public class Comp implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getGPA()-o1.getGPA();
    }
}
