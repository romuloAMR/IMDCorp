package main.java.br.ufrn.imdcorp.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import main.java.br.ufrn.imdcorp.dao.DAODatabase;
import main.java.br.ufrn.imdcorp.enums.Gender;
import main.java.br.ufrn.imdcorp.enums.Level;
import main.java.br.ufrn.imdcorp.enums.Postgraduate;
import main.java.br.ufrn.imdcorp.models.Person;
import main.java.br.ufrn.imdcorp.models.Teacher;
import main.java.br.ufrn.imdcorp.models.Address;
import main.java.br.ufrn.imdcorp.models.AdminTechnician;

public class Operations {
    private static DAODatabase database = DAODatabase.getInstance();

    public static void registerTeacher() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scan.nextLine();

        System.out.print("Enter CPF: ");
        String cpf = scan.nextLine();

        System.out.print("Enter birthdate (yyyy-mm-dd): ");
        LocalDate birthdate = LocalDate.parse(scan.nextLine());

        System.out.print("Enter gender (MALE, FEMALE, OTHER): ");
        Gender gender = Gender.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Enter street: ");
        String street = scan.nextLine();
        System.out.print("Enter number: ");
        int number = scan.nextInt();
        System.out.print("Enter neighborhood: ");
        String neighborhood = scan.nextLine();
        System.out.print("Enter city: ");
        String city = scan.nextLine();
        System.out.print("Enter CEP: ");
        String cep = scan.nextLine();
        Address address = new Address(street, number, neighborhood, city, cep);

        System.out.print("Enter registration: ");
        Long registration = Long.parseLong(scan.nextLine());

        System.out.print("Enter salary: ");
        Double salary = Double.parseDouble(scan.nextLine());

        System.out.print("Enter department: ");
        String department = scan.nextLine();

        System.out.print("Enter workload: ");
        int workload = scan.nextInt();

        System.out.print("Enter entry date (yyyy-mm-dd): ");
        LocalDate entryDate = LocalDate.parse(scan.nextLine());

        System.out.print("Enter level (I, II, III, IV, V, VI, VII, VIII): ");
        Level level = Level.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Enter postgraduate (SPECIALIZATION, MASTERS_DEGREE, PHD): ");
        Postgraduate postgraduate = Postgraduate.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Enter classes (comma separated): ");
        List<String> classes = List.of(scan.nextLine().split(","));

        scan.close();

        Teacher teacher = new Teacher(name, cpf, birthdate, gender, address, registration, salary, department, workload, entryDate, level, postgraduate, classes);
        database.getWorkers().add(teacher);
    }

    public static void registerAdminTechnician() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scan.nextLine();

        System.out.print("Enter CPF: ");
        String cpf = scan.nextLine();

        System.out.print("Enter birthdate (yyyy-mm-dd): ");
        LocalDate birthdate = LocalDate.parse(scan.nextLine());

        System.out.print("Enter gender (MALE, FEMALE, OTHER): ");
        Gender gender = Gender.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Enter street: ");
        String street = scan.nextLine();
        System.out.print("Enter number: ");
        int number = scan.nextInt();
        System.out.print("Enter neighborhood: ");
        String neighborhood = scan.nextLine();
        System.out.print("Enter city: ");
        String city = scan.nextLine();
        System.out.print("Enter CEP: ");
        String cep = scan.nextLine();
        Address address = new Address(street, number, neighborhood, city, cep);

        System.out.print("Enter registration: ");
        Long registration = Long.parseLong(scan.nextLine());

        System.out.print("Enter salary: ");
        Double salary = Double.parseDouble(scan.nextLine());

        System.out.print("Enter department: ");
        String department = scan.nextLine();

        System.out.print("Enter workload: ");
        int workload = scan.nextInt();

        System.out.print("Enter entry date (yyyy-mm-dd): ");
        LocalDate entryDate = LocalDate.parse(scan.nextLine());

        System.out.print("Enter level (I, II, III, IV, V, VI, VII, VIII): ");
        Level level = Level.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Enter postgraduate (SPECIALIZATION, MASTERS_DEGREE, PHD): ");
        Postgraduate postgraduate = Postgraduate.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Is the job unhealthy? (true/false): ");
        Boolean unhealthy = scan.nextBoolean();

        System.out.print("Does the technician receive a bonus? (true/false): ");
        Boolean bonus = scan.nextBoolean();

        scan.close();

        AdminTechnician technician = new AdminTechnician(name, cpf, birthdate, gender, address, registration, salary, department, workload, entryDate, level, postgraduate, unhealthy, bonus);
        database.getWorkers().add(technician);
    }

    public static void listTeachers() {
        for (Person p : database.getWorkers()) {
            if (p instanceof Teacher) {
                Teacher teacher = (Teacher) p;
                System.out.println("Name: " + teacher.getName() + "\nClasses: " + String.join(", ", teacher.getClasses()));
            }
        }
    }

    public static void listAdminTechnicians() {
        for (Person p : database.getWorkers()) {
            if (p instanceof AdminTechnician) {
                AdminTechnician technician = (AdminTechnician) p;
                System.out.println("Name: " + technician.getName() + "\nFunction: " + technician.getDepartment());
            }
        }
    }

    public static void deleteTeacher(int registration) {
        Person person = searchTeacher(registration);
        if (person != null) {
            database.getWorkers().remove(person);
        } else {
            System.out.println("Teacher doesn't exist");
        }
    }

    public static void deleteAdminTechnician(int registration) {
        Person person = searchAdminTechnician(registration);
        if (person != null) {
            database.getWorkers().remove(person);
        } else {
            System.out.println("Administrative technician doesn't exist");
        }
    }

    public static Teacher searchTeacher(int registration) {
        for (Person p : database.getWorkers()) {
            if (p instanceof Teacher && p.getRegistration() == registration) {
                return (Teacher) p;
            }
        }
        return null;
    }

    public static AdminTechnician searchAdminTechnician(int registration) {
        for (Person p : database.getWorkers()) {
            if (p instanceof AdminTechnician && p.getRegistration() == registration) {
                return (AdminTechnician) p;
            }
        }
        return null;
    }

    public static double calculateSalary(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter registration: ");
        int reg = scan.nextInt();

        System.out.print("Enter 0 to teacher or 1 to admin technician: ");
        int type = scan.nextInt();
        scan.close();

        double salary = -1;
        switch (type) {
            case 0: salary = searchTeacher(reg).calculateSalary(); break;
            case 1: salary = searchAdminTechnician(reg).calculateSalary(); break;
            default: System.out.println("Invalid argument!"); break;
        }
        return salary;
    }
}