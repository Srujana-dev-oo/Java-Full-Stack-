import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int m1,m2,m3;
    
    Student(int id,String name, int m1, int m2, int m3){
        this.id=id;
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    int getTotal(){
        return m1+m2+m3;
    }
    double getAvg(){
        return getTotal()/3.0;
    }
    String getGrade(){
        double g=getAvg();
        if(g>90) return "A+";
        else if(75<g && g<90) return "B";
        else if(65<g && g<75) return "C";
        else return "Fail";
        
        
    }
    void display(){
        System.out.println("---------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Total: " + getTotal());
        System.out.println("Average: " + getAvg());
        System.out.println("Grade: " + getGrade());
    }
}
public class SMP{
    public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    ArrayList<Student>list=new ArrayList<>();
    while (true) {

        System.out.println("\n===== Student Marks Processing App =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            // Add Student
            case 1:
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks 1: ");
                int m1 = sc.nextInt();

                System.out.print("Enter Marks 2: ");
                int m2 = sc.nextInt();

                System.out.print("Enter Marks 3: ");
                int m3 = sc.nextInt();

                list.add(new Student(id, name, m1, m2, m3));
                System.out.println("Student Added Successfully!");
                break;

            // Display All
            case 2:
                if (list.isEmpty()) {
                    System.out.println("No student records found!");
                } else {
                    for (Student s : list) {
                        s.display();
                    }
                }
                break;

            // Search Student
            case 3:
                System.out.print("Enter Student ID to Search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Student s : list) {
                    if (s.id == searchId) {
                        s.display();
                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("Student Not Found!");
                break;

            // Exit
            case 4:
                System.out.println("Thank You!");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
        }
    }
}

}