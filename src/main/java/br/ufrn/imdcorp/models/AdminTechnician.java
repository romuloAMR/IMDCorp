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
        final double BASE = 2500.00;

        // Calculate level increment (3% per level)
        double levelMultiplier = 1;
        switch (this.getLevel()) {
            case VIII: levelMultiplier *= 1.03;
            case VII:  levelMultiplier *= 1.03;
            case VI:   levelMultiplier *= 1.03;
            case V:    levelMultiplier *= 1.03;
            case IV:   levelMultiplier *= 1.03;
            case III:  levelMultiplier *= 1.03;
            case II:   levelMultiplier *= 1.03;
            case I:    break;
        }

        // Calculate postgraduate increment
        double postgraduateMultiplier = 1.0;
        switch (this.getPostgraduate()) {
            case PHD:            postgraduateMultiplier = 1.75; break;
            case MASTERS_DEGREE: postgraduateMultiplier = 1.50; break;
            case SPECIALIZATION: postgraduateMultiplier = 1.25; break;
        }

        // Calculate hazard pay and bonus
        double hazardPay = this.getUnhealthy() ? BASE * 0.5 : 0;
        double bonus = this.getBonus() ? BASE * 0.5 : 0;

        // Final salary calculation
        double finalSalary = BASE * levelMultiplier * postgraduateMultiplier + hazardPay + bonus;
        return finalSalary;
    }

}
