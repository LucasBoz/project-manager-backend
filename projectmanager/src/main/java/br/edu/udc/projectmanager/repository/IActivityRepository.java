package br.edu.udc.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.udc.projectmanager.entity.Activity;

public interface IActivityRepository extends JpaRepository<Activity, Long>  {

}
