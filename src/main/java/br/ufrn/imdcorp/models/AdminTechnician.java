package main.java.br.ufrn.imdcorp.models;

import java.time.LocalDate;

import main.java.br.ufrn.imdcorp.enums.Gender;
import main.java.br.ufrn.imdcorp.enums.Level;
import main.java.br.ufrn.imdcorp.enums.Postgraduate;
import main.java.br.ufrn.imdcorp.interfaces.Workers;

public class AdminTechnician extends Person implements Workers{
    private Level level;
    private Postgraduate postgraduate;
    private Boolean unhealthy;
    private Boolean bonus;

    public AdminTechnician(String name, String cpf, LocalDate birthdate, Gender gender, Address address,
            Long registration, Double salary, String department, Integer workload, LocalDate entryDate, Level level,
            Postgraduate postgraduate, Boolean unhealthy, Boolean bonus) {
        super(name, cpf, birthdate, gender, address, registration, salary, department, workload, entryDate);
        this.level = level;
        this.postgraduate = postgraduate;
        this.unhealthy = unhealthy;
        this.bonus = bonus;
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

    public Boolean getUnhealthy() {
        return unhealthy;
    }

    public void setUnhealthy(Boolean unhealthy) {
        this.unhealthy = unhealthy;
    }

    public Boolean getBonus() {
        return bonus;
    }

    public void setBonus(Boolean bonus) {
        this.bonus = bonus;
    }

    @Override
    public Double calculateSalary() {
        
        /*
         * The base salary for technicians is R$ 2,500.00.
         * The calculation of the technician's salary also takes into account
         * the level and education. For each level, 3% is added over the
         * value of the previous level. For education, the addition to the
         * base salary is 25% for specialization, 50% for master's degree
         * and 75% for doctorate. Additionally, if the technician
         * receives hazard pay, 50% will be added to the base salary.
         * If the technician has a gratified role, the addition will be
         * 50% over the base salary.
        */

        // Make this

        throw new UnsupportedOperationException("Unimplemented method 'calculateSalary'");
    }
        
}
