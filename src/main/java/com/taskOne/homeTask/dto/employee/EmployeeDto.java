package com.taskOne.homeTask.dto.employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeDto {

    private Long employeeId;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String surname;

    @NotBlank()
    @Size(min = 1, max = 3)
    private String age;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String cityzen;

    @NotBlank()
    @Size(min = 12, max = 20)
    private String phone;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, String age, String cityzen, String phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cityzen = cityzen;
        this.phone = phone;
    }

    public EmployeeDto(Long employeeId, String name, String surname, String age, String cityzen, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cityzen = cityzen;
        this.phone = phone;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCityzen() {
        return cityzen;
    }

    public void setCityzen(String cityzen) {
        this.cityzen = cityzen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cityzen='" + cityzen + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

