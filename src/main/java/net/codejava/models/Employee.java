package net.codejava.models;

import javax.persistence.*;

@Entity
@Table(name = "employees1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "contract_Id", nullable = false, length = 20)
    private int contractId;

    @Column(name = "salary", nullable = false, length = 20)
    private double salary;

    @Column(name = "created_At", length = 20)
    private String createdAt;

    @Column(name = "general_furlough", nullable = false, length = 2)
    private int generalFurlough;

    @Column(name = "remaining_furlough", nullable = false, length = 2)
    private int remainingFurlough;

    @Column(name = "used_furlough", nullable = false, length = 2)
    private int usedFurlough;

    public Employee() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return null;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getGeneralFurlough() {
        return generalFurlough;
    }

    public void setGeneralFurlough(int generalFurlough) {
        this.generalFurlough = generalFurlough;
    }

    public int getRemainingFurlough() {
        int result = getGeneralFurlough() - getUsedFurlough();
        return result;
    }

    public void setRemainingFurlough(int remainingFurlough) {
        this.remainingFurlough = remainingFurlough;
    }

    public int getUsedFurlough() {
        return usedFurlough;
    }

    public void setUsedFurlough(int usedFurlough) {
        this.usedFurlough = usedFurlough;
    }

}
