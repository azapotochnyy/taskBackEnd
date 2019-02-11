package com.taskOne.homeTask.service;

import java.util.Set;

public interface EmployeeProjectService<T> {

    /**
     * Method save entity with parameters into Data Base.
     *
     * @param dto object for saving into Data Base
     * @return entity with genereted Id
     */
    T create(T dto);

    /**
     * Method get the object from a Data Base by id.
     *
     * @param id id of the object which will be selected from database
     * @return an Optional with a present value if the specified value is non-null, otherwise an empty Optional
     */
    T getById(Long id);

    /**
     * Method delete the object from a Data Base by id.
     *
     * @param id object's id which will be deleted from database
     */
    boolean delete(Long id);

    /**
     * Method for updating object in database.
     *
     * @param dto object to be updated
     */
    boolean update(T dto);

    /**
     * Method get all objects from a Data Base.
     *
     * @return list of objects from database or empty list otherwise
     */
    Set<T> getAll();

}
