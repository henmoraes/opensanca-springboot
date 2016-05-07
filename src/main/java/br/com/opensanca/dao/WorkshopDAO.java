package br.com.opensanca.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opensanca.model.WorkshopEntity;

@Repository
public interface WorkshopDAO extends JpaRepository<WorkshopEntity, Integer> {

}
