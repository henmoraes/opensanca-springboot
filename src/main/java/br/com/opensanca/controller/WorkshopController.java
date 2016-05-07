package br.com.opensanca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import br.com.opensanca.dao.WorkshopDAO;
import br.com.opensanca.model.WorkshopEntity;

@RestController
@RequestMapping(value = WorkshopController.PATH)
public class WorkshopController {

	public static final String PATH = "/workshop";
	public static final String BY_ID = "/{id}";
	public static final String CREATE = "/create";

	@Autowired
	private WorkshopDAO workshopDAO;

	@RequestMapping(value = WorkshopController.BY_ID, method = RequestMethod.GET)
	public ResponseEntity<WorkshopEntity> findById(final @PathVariable Integer id) {
		return new ResponseEntity<WorkshopEntity>(workshopDAO.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<WorkshopEntity>> findAll() {
		return new ResponseEntity<List<WorkshopEntity>>(workshopDAO.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> clear() {
		workshopDAO.deleteAll();
		return new ResponseEntity<String>("Clear !",HttpStatus.OK);
	}

	@RequestMapping(value = WorkshopController.BY_ID, method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(final @PathVariable Integer id) {
		workshopDAO.delete(id);
		return new ResponseEntity<String>("Id " + id + " Deleted !",HttpStatus.OK);
	}
	
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<WorkshopEntity> save(@RequestBody final WorkshopEntity workshopEntity) {
		return new ResponseEntity<WorkshopEntity>(workshopDAO.save(workshopEntity), HttpStatus.CREATED);
	}

	@RequestMapping(value = WorkshopController.CREATE, method = RequestMethod.GET)
	public ResponseEntity<WorkshopEntity> selfCreate() {
		WorkshopEntity workshopEntity = new WorkshopEntity();
		workshopEntity.setDuracao(new UUIDGenerator().generateId(this)+"");
		workshopEntity.setNome("Nome teste " + new UUIDGenerator().generateId(this)+"");
		return new ResponseEntity<WorkshopEntity>(workshopDAO.save(workshopEntity), HttpStatus.CREATED);
	}

}
