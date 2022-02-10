import java.util.*;
import java.util.stream.Collectors;

class Student
{
    int id;
    String name;
    int age;
    String gender;
    String engDept;
    int yearOfEnrollment;
    double perTillDate;
    Student(int id, String name, int age, String gender, String engDept, int yearOfEnrollment, double perTillDate)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDept = engDept;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    int getId()
    {
        return id;
    }

    String getName()
    {
        return name;
    }

    int getAge()
    {
        return age;
    }

    String getGender()
    {
        return gender;
    }

    String getDepartment()
    {
        return engDept;
    }
    int getYearOfEnrollment()
    {
        return yearOfEnrollment;
    }
    double getTillDate()
    {
        return perTillDate;
    }
    public String PrintDetails()
    {
        return "Id : "+id +", Name : "+name +", age : "+age +", Gender : "+gender +", Department : "+engDept +", Year Of Joining : "+yearOfEnrollment +", PerTillDate : "+perTillDate;
    }
}
public class MyClass {
    public static void main(String[] args){
        List<Student> mylist=new ArrayList<>();

        mylist.add(new Student(111,"Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        mylist.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        mylist.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        mylist.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        mylist.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        mylist.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        mylist.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        mylist.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        mylist.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        mylist.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        mylist.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        mylist.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        mylist.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        mylist.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        mylist.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        mylist.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        mylist.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        System.out.println("Name of all departments");
        mylist.stream().map(Student::getDepartment).distinct().forEach(System.out::println);

        System.out.println("\nstudents enrolled after 2018");
        mylist.stream().filter(e -> e.getYearOfEnrollment() > 2018).map(Student::getName).forEach(System.out::println);

        System.out.println("\n Details od Male students in computer sci department");
        mylist.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Computer Science").map(Student::PrintDetails).forEach(System.out::println);

        System.out.println("\n Number males and females");
        Map<String, Long> noOfMaleAndFemaleStudents= mylist.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleStudents);

        System.out.println("\n Average males and females");
        Map<String, Double> avgAgeOfMaleAndFemaleStudents= mylist.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleStudents);

        System.out.println("\n details of highest student having highest percentage");
        Optional<Student> highPercentList=mylist.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Student::getTillDate)));
        
        Student highestPercentage = highPercentList.get();
        System.out.println("Details Of Highest percent Student : ");
        System.out.println("---------------------------------------");
        System.out.println("ID : "+highestPercentage.getId());
        System.out.println("Name : "+highestPercentage.getName());
        System.out.println("Age : "+highestPercentage.getAge());
        System.out.println("Gender : "+highestPercentage.getGender());
        System.out.println("Department : "+highestPercentage.getDepartment());
        System.out.println("Year Of Joining : "+highestPercentage.getYearOfEnrollment());
        System.out.println("Salary : "+highestPercentage.getTillDate());
        
        System.out.println("\n Count of students in each department");
        Map<String, Long> StudentCountByDepartment= mylist.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet =StudentCountByDepartment.entrySet();
        for (Map.Entry<String, Long> entry : entrySet)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
        System.out.println("\n The average percentage achieved in each department");
        Map<String, Double> avgPercentOfDepartments= mylist.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getTillDate)));
        Set<Map.Entry<String, Double>> entrySetAverage = avgPercentOfDepartments.entrySet();
        for (Map.Entry<String, Double> entry : entrySetAverage)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
        System.out.println("\n the details of youngest male student in the Electronic department");
        Optional<Student> youngestMaleStudentInElectronicWrapper= mylist.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Electronic").min(Comparator.comparingInt(Student::getAge));
        Student youngestMaleStudentInElectronic = youngestMaleStudentInElectronicWrapper.get();
        System.out.println("Details Of Youngest Male Student In Electronic");
        System.out.println("----------------------------------------------");
        System.out.println("ID : "+youngestMaleStudentInElectronic.getId());
        System.out.println("Name : "+youngestMaleStudentInElectronic.getName());
        System.out.println("Age : "+youngestMaleStudentInElectronic.getAge());
        System.out.println("Year Of Joining : "+youngestMaleStudentInElectronic.getYearOfEnrollment());
        System.out.println("Salary : "+youngestMaleStudentInElectronic.getTillDate());
    }
}