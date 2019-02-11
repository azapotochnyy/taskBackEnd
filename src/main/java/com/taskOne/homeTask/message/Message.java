package com.taskOne.homeTask.message;

public enum Message {

    SUCCESS_UPDATE_EMPLOYEE("Employee data updated successfully!"),
    SUCCESS_DELETE_EMPLOYEE("Employee data deleted successfully!"),
    SUCCESS_UPDATE_PROJECT("Project data updated successfully!"),
    SUCCESS_DELETE_PROJECT("Project data deleted successfully!"),
    SUCCESS_ADD_EMPLOYE_ON_PROJECT("Employee was added succesfully on the project"),
    SUCCESS_CHANGE_EMPLOYE_ON_PROJECT("Employee was changed on the project"),
    SUCCESS_DELETE_EMPLOYE_FROM_PROJECT("Employee was deleted succesfully from the project"),

    FAILED_DELETE_EMPLOYEE("delete process of Employee failed!"),

    FAILED_DELETE_EMPLOYE_FROM_PROJECT("Employee was not deleted  from the project"),
    FAILED_DELETE_PROJECT("Delete process of Project failed!"),
    FAILED_ADD_EMPLOYE_ON_PROJECT("Employee was not added  on the project"),
    FAILED_GETBYID_EMPLOYEE("There no employee with id provided"),
    FAILED_GETBYID_PROJECT("There no project with id provided"),

    FAILED_CHANGE_EMPLOYE_ON_PROJECT("Employee was not changed on the project"),
    ;



    private String description;

    Message() {
    }

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

