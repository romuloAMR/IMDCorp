package main.java.br.ufrn.imdcorp.services;

import java.util.Scanner;

import main.java.br.ufrn.imdcorp.dao.DAODatabase;
import main.java.br.ufrn.imdcorp.models.Person;
import main.java.br.ufrn.imdcorp.models.Teacher;
import main.java.br.ufrn.imdcorp.models.AdminTechnician;

public class Operations {
    private DAODatabase database = DAODatabase.getInstance();

    public void registerTeacher(Teacher teacher) {
        database.getWorkers().add(teacher);
    }

    public void registerAdminTechnician(AdminTechnician technician) {
        database.getWorkers().add(technician);
    }

    public void listTeachers() {
        for (Person p : database.getWorkers()) {
            if (p instanceof Teacher) {
                Teacher teacher = (Teacher) p;
                System.out.println("Name: " + teacher.getName() + "\nClasses: " + String.join(", ", teacher.getClasses()));
            }
        }
    }

    public void listAdminTechnicians() {
        for (Person p : database.getWorkers()) {
            if (p instanceof AdminTechnician) {
                AdminTechnician technician = (AdminTechnician) p;
                System.out.println("Name: " + technician.getName() + "\nFunction: " + technician.getDepartment());
            }
        }
    }

    public void deleteTeacher(int registration) {
        Person person = searchTeacher(registration);
        if (person != null) {
            database.getWorkers().remove(person);
        } else {
            System.out.println("Teacher doesn't exist");
        }
    }

    public void deleteAdminTechnician(int registration) {
        Person person = searchAdminTechnician(registration);
        if (person != null) {
            database.getWorkers().remove(person);
        } else {
            System.out.println("Administrative technician doesn't exist");
        }
    }

    public Teacher searchTeacher(int registration) {
        for (Person p : database.getWorkers()) {
            if (p instanceof Teacher && p.getRegistration() == registration) {
                return (Teacher) p;
            }
        }
        return null;
    }

    public AdminTechnician searchAdminTechnician(int registration) {
        for (Person p : database.getWorkers()) {
            if (p instanceof AdminTechnician && p.getRegistration() == registration) {
                return (AdminTechnician) p;
            }
        }
        return null;
    }

    public double calculateSalary(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter registration: ");
        int reg = scan.nextInt();

        System.out.print("Enter 0 to teacher or 1 to adimin technician: ");
        int type = scan.nextInt();
        scan.close();

        double salary = -1;
        switch (type) {
            case 0: salary = this.searchTeacher(reg).calculateSalary(); break;
            case 1: salary = this.searchAdminTechnician(reg).calculateSalary(); break;
            default: System.out.println("Invalid argument!"); break;
        }
        return salary;
    }
}