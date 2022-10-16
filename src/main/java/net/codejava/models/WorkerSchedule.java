package net.codejava.models;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class WorkerSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monday", nullable = false, length = 20)
    private String monday;
    @Column(name = "tuesday", nullable = false, length = 20)
    private String tuesday;
    @Column(name = "wednesday", nullable = false, length = 20)
    private String wednesday;
    @Column(name = "thursday", nullable = false, length = 20)
    private String thursday;
    @Column(name = "friday", nullable = false, length = 20)
    private String friday;
    @Column(name = "saturday", nullable = false, length = 20)
    private String saturday;
    @Column(name = "sunday", nullable = false, length = 20)
    private String sunday;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;


    public WorkerSchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

}
