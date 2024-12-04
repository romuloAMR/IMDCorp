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
        final double BASE = 4000.00;

        // Calculate level increment (5% per level)
        double levelMultiplier = 1;
        switch (this.getLevel()) {
            case VIII: levelMultiplier *= 1.05;
            case VII:  levelMultiplier *= 1.05;
            case VI:   levelMultiplier *= 1.05;
            case V:    levelMultiplier *= 1.05;
            case IV:   levelMultiplier *= 1.05;
            case III:  levelMultiplier *= 1.05;
            case II:   levelMultiplier *= 1.05;
            case I:    break;
        }

        // Calculate postgraduate increment
        double postgraduateMultiplier = 1.0;
        switch (this.getPostgraduate()) {
            case PhD:            postgraduateMultiplier = 1.75; break;
            case Masters_Degree: postgraduateMultiplier = 1.50; break;
            case Specialization: postgraduateMultiplier = 1.25; break;
        }

        // Final salary calculation
        double finalSalary = BASE * levelMultiplier * postgraduateMultiplier;
        return finalSalary;
    }

}
