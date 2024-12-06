package main.java.br.ufrn.imdcorp;

import java.util.Scanner;
import main.java.br.ufrn.imdcorp.dao.DAODatabase;
import main.java.br.ufrn.imdcorp.services.Operations;

public class Main {
    public static void main(String[] args) {
        DAODatabase database = DAODatabase.getInstance();

        boolean run = true;
        Scanner scan = new Scanner(System.in);
        byte op;

        while (run) {
            printPanel();
            System.out.print("Enter option: ");
            op = scan.nextByte();
            switch (op) {
                case 0: 
                    run = false; 
                    break;
                case 1: 
                    Operations.registerTeacher(); 
                    break;
                case 2: 
                    Operations.registerAdminTechnician(); 
                    break;
                case 3: 
                    Operations.listTeachers(); 
                    break;
                case 4: 
                    Operations.listAdminTechnicians(); 
                    break;
                case 5: 
                    System.out.print("Enter with the teacher's registration: ");
                    int regTeacherDelete = scan.nextInt();
                    Operations.deleteTeacher(regTeacherDelete);
                    break;
                case 6: 
                    System.out.print("Enter with the admin technician's registration: ");
                    int regTechnicianDelete = scan.nextInt();
                    Operations.deleteAdminTechnician(regTechnicianDelete);
                    break;
                case 7: 
                    System.out.print("Enter with the teacher's registration: ");
                    int regTeacherSearch = scan.nextInt();
                    Operations.showTeacher(regTeacherSearch);
                    break;
                case 8: 
                    System.out.print("Enter with the admin technician's registration: ");
                    int regTechnicianSearch = scan.nextInt();
                    Operations.showAdminTechnician(regTechnicianSearch);
                    break;
                default: 
                    System.out.println("Invalid argument!"); 
                    break;
            }
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println();
        }

        database.end();
        scan.close();
    }

    public static void printPanel() {
        System.out.println(
            "--------------- MENU: ---------------\n"+
            "| 1 - Register a teacher            |\n"+
            "| 2 - Register an admin technician  |\n"+
            "| 3 - Show all teachers             |\n"+
            "| 4 - Show all admin technicians    |\n"+
            "| 5 - Delete a teacher              |\n"+
            "| 6 - Delete an admin technician    |\n"+
            "| 7 - Search for a teacher          |\n"+
            "| 8 - Search for an admin technician|\n"+
            "| 0 - Quit                          |\n"+
            "-------------------------------------"
        );
    }
}