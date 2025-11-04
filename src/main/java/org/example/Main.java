package org.example;
import java.util.Scanner;
import java.sql.*;

public class Main {
    //Database connection settings
    static final String URL  = "jdbc:postgresql://localhost:5432/studentsdb";
    static final String USER = "postgres";
    static final String PASS = "cS20020414-";

    //Ask user to select a function to test
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("This is a student database! Select a function which you want to test!!!");
            System.out.println("1. Show all students");
            System.out.println("2. Add student");
            System.out.println("3. Update student email");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getAllStudents();
                    break;
                case 2:
                    addStudent("Shuo","Chen","shuochen@gmail.com", Date.valueOf("2025-11-01"));
                    break;
                case 3:
                    updateStudentEmail(1,"john.doe@gmail.com");
                    break;
                case 4:
                    deleteStudent(1);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    //This is the function which print the student table
    public static void getAllStudents() {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeQuery("SELECT student_id, first_name, last_name, email, enrollment_date " +
                    "FROM students ORDER BY student_id");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Students Table");
            while(rs.next()){
                System.out.print(rs.getInt("student_id") + " ");
                System.out.print(rs.getString("first_name") + " ");
                System.out.print(rs.getString("last_name") + " ");
                System.out.print(rs.getString("email") + " ");
                System.out.println(rs.getDate("enrollment_date"));
            }
            System.out.println("------------------------------------------------------------");
            System.out.println(" ");
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //This is the function which insert a student into the student table
    public static void addStudent(String first_name, String last_name, String email, Date enrollment_date){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('Shuo', 'Chen', 'shuochen@gmail.com', '2025-11-01')";
            stmt.executeUpdate(insertSQL);
            getAllStudents();

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //This is the function which update the specific student email based on student id
    public static void updateStudentEmail(int student_id, String new_email){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String updateSQL = "UPDATE students SET email = 'john.doe@gmail.com' WHERE student_id = 1";
            stmt.executeUpdate(updateSQL);
            getAllStudents();

            stmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //This is a function which delete a student based on student id
    public static void deleteStudent(int student_id){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String deleteSQL = "DELETE FROM students WHERE student_id = 1";
            stmt.executeUpdate(deleteSQL);
            getAllStudents();

            stmt.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}

