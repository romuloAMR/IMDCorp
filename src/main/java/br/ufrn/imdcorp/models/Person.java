package main.java.br.ufrn.imdcorp.models;

import java.time.LocalDate;

import main.java.br.ufrn.imdcorp.enums.Gender;

public abstract class Person {
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private Gender gender;
    private Address address;
    private Long registration;
    private Double salary;
    private String department;
    private Integer workload;
    private LocalDate entryDate;

    public Person(String name, String cpf, LocalDate birthdate, Gender gender, Address address, Long registration,
            Double salary, String department, Integer workload, LocalDate entryDate) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.registration = registration;
        this.salary = salary;
        this.department = department;
        this.workload = workload;
        this.entryDate = entryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
    
}
