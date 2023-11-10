package Task10;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SortingStudentsByGPA{
    public static void Sortr(List<Student> students, int leftBorder, int rightBorder, Comp comp){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Student pivot = students.get((leftMarker + rightMarker) / 2);
        do {
            while (comp.compare(students.get(leftMarker),pivot)<0) {
                leftMarker++;
            }
            while (comp.compare(students.get(rightMarker),pivot)>0) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Student tmp = students.get(leftMarker);
                    students.set(leftMarker, students.get(rightMarker));
                    students.set(rightMarker, tmp);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            Sortr(students, leftMarker, rightBorder,comp);
        }
        if (leftBorder < rightMarker) {
            Sortr(students, leftBorder, rightMarker,comp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Comp comp = new Comp();
        System.out.print("Number of students: ");
        int n = sc.nextInt();
        setArray(n,students);
        System.out.println("Изначальный список:");
        outArray(students);
        Sortr(students,0,students.size()-1,comp);
        System.out.println("Сортированный список:");
        outArray(students);
        //несколько списков
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        setArray(2,students2);
        setArray(3,students3);
        List<Student> multistudents = new ArrayList<>();
        multistudents.addAll(students2);
        multistudents.addAll(students3);
        Sortr(multistudents,0,multistudents.size()-1,comp);
        outArray(multistudents);
    }
    public static void setArray(int n,List<Student> students){
        Scanner sc = new Scanner(System.in);
        String name;
        String surname;
        int co;
        String spec;
        int group;
        int GPA;
        String lol;
        for(int i = 0;i<n;i++){
            int e = i+1;
            System.out.println("This is setArray, write something: ");
            lol = sc.nextLine();
            System.out.println("Name of "+ e +" student:");
            name = sc.nextLine();
            System.out.println("Surname of "+ e +" student:");
            surname = sc.nextLine();
            System.out.println("Spec of "+ e +" student:");
            spec = sc.nextLine();
            System.out.println("Course of "+ e +" student:");
            co = sc.nextInt();
            System.out.println("Group of "+ e +" student:");
            group = sc.nextInt();
            System.out.println("GPA of "+ e +" student:");
            GPA = sc.nextInt();
            students.add(new Student(name,surname,spec,co,group,GPA));
        }
    }
    public static void outArray(List<Student> students){
        for(int e = 0;e< students.size();e++){
            System.out.println(students.get(e).toString());
        }
    }
}
