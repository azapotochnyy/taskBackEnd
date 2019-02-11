package com.taskOne.homeTask.repository;

import com.taskOne.homeTask.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {
}
