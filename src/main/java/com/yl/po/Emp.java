package com.yl.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 * @create 2019-11-20-10:04
 */
@Entity
public class Emp {
    private int id;
    private String jobId;
    private String name;
    private int age;
    private double salary;
    private String dept;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", jobId='" + jobId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public Emp(int id) {
        this.id = id;
    }

    public Emp(String jobId, String name, int age, double salary, String dept) {
        this.jobId = jobId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    public Emp(int id, String jobId, String name, int age, double salary, String dept) {
        this.id = id;
        this.jobId = jobId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jobId")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "dept")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}

        Emp emp = (Emp) o;

        if (id != emp.id) {return false;}
        if (age != emp.age){ return false;}
        if (Double.compare(emp.salary, salary) != 0){ return false;}
        if (jobId != null ? !jobId.equals(emp.jobId) : emp.jobId != null){ return false;}
        if (name != null ? !name.equals(emp.name) : emp.name != null) {return false;}
        if (dept != null ? !dept.equals(emp.dept) : emp.dept != null) {return false;}

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        return result;
    }
}
