package br.edu.udc.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.udc.projectmanager.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Long>  {

}

