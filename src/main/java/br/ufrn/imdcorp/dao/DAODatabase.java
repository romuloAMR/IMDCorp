package main.java.br.ufrn.imdcorp.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.java.br.ufrn.imdcorp.models.Person;

public class DAODatabase {
    private static final String FILE_PATH = "src/main/resources/database.bin";
    private static DAODatabase database;
    private List<Person> workers;

    private DAODatabase(){
        workers = new ArrayList<>();
    }

    public static synchronized DAODatabase getInstance(){
        if (database == null){
            database = new DAODatabase();
            database.load();
        }
        return database;
    }

    public List<Person> getWorkers() {
        return workers;
    }

    // Load data of database.bin
    @SuppressWarnings("unchecked")
    private void load(){
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            workers = (List<Person>) in.readObject();
        } catch (IOException i) {
            System.err.println("File not found!");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not found!");
        }
    }

    // Write workers in database.bin
    public void end(){
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(workers);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
