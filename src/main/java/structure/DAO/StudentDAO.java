package structure.DAO;

import structure.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDAO {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        students.add(student);
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Student> getStudentsBlockchain(){
        return students.stream()
                .filter(x -> x.isBlockChain())
                .collect(Collectors.toList());
    }

    public static List<Student> getExcellentStudents(){
        return students.stream()
                .filter(x -> x.getAvrMark() >= 4)
                .collect(Collectors.toList());
    }

    public static List<Student> getExelStudentsWithBlockchain(){
        return students.stream()
                .filter(x -> x.getAvrMark() >= 4 && x.isBlockChain())
                .collect(Collectors.toList());
    }

    public static Student getStudent(String name){
        List<Student> studentList = students.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
        if (studentList.size() != 0){
            return studentList.get(0);
        }
        else
            return new Student("", -1, true);
    }

    public static void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/students.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");

                addStudent(tokens[0], tokens[1], tokens[2]);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(String name, String avrMark, String blockChain){
        Student stud = new Student();
        stud.setName(name);
        stud.setAvrMark(Float.parseFloat(avrMark));
        stud.setBlockChain(Boolean.valueOf(blockChain));
        students.add(stud);
    }
}
