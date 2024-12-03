package main.java.br.ufrn.imdcorp.models;

import java.time.LocalDate;
import java.util.List;

import main.java.br.ufrn.imdcorp.enums.Gender;
import main.java.br.ufrn.imdcorp.enums.Level;
import main.java.br.ufrn.imdcorp.enums.Postgraduate;
import main.java.br.ufrn.imdcorp.interfaces.Workers;

public class Teacher extends Person implements Workers {
    private Level level;
    private Postgraduate postgraduate;
    private List<String> classes;
    
    public Teacher(String name, String cpf, LocalDate birthdate, Gender gender, Address address, Long registration,
            Double salary, String department, Integer workload, LocalDate entryDate, Level level,
            Postgraduate postgraduate, List<String> classes) {
        super(name, cpf, birthdate, gender, address, registration, salary, department, workload, entryDate);
        this.level = level;
        this.postgraduate = postgraduate;
        this.classes = classes;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Postgraduate getPostgraduate() {
        return postgraduate;
    }

    public void setPostgraduate(Postgraduate postgraduate) {
        this.postgraduate = postgraduate;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    @Override
    public Double calculateSalary() {
        /*
        * The base salary for teacher is R$ 4,000.00
        * To calculate a professor's salary, the level and education must be considered.
        * For each level, 5% is added to the value of the previous level.
        * Additionally, a percentage is added to the base salary: 25% for specialization,
        * 50% for a master's degree, and 75% for a doctorate.
        */

        // Make this

        throw new UnsupportedOperationException("Unimplemented method 'calculateSalary'");
    }

    
}
