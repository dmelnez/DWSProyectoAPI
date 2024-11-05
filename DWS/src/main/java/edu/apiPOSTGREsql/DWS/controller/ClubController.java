package edu.apiPOSTGREsql.DWS.controller;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.apiPOSTGREsql.DWS.dtos.ClubDtos;
import edu.apiPOSTGREsql.DWS.servicios.ClubFuncionalidade;


@RestController
@RequestMapping("/club")



/**
 * Clase que se encarga de gestionar las operaciones a ejecutar en la api.
 * @author dmn
 */
public class ClubController {
	
	/**
	 * Metodo que implemementa el servicio ClubFuncionalidade para acceder a la lógica de negocio de los clubes.
	 * Permite que  ClubController use sus métodos sin inicializar el servicio manualmente.
	 * @author rgv
	 */
	@Autowired
	private ClubFuncionalidade clubFuncionalidade;
	

	/**
	 * Metodo que se encarga de devolver la lista de clubes.
	 * @author rgv
	 * @return lista de objetos de ClubDto.
	 */
	@GetMapping
	public ArrayList<ClubDtos> getClub(){
		return this.clubFuncionalidade.getClub();
		
	}
	
	/**
	 * Metodo que se encarga de guardar un nuevo club.
	 * @param club
	 * @author rgv
	 * @return devuelve el objeto ClubDto nuevo.
	 */
	@PostMapping
	public ClubDtos guardaClub(@RequestBody ClubDtos club) {
		return this.clubFuncionalidade.guardaclub(club);
	}
	
	/**
	 * Metodo que se encarga de encontrar un club especifico mediante un id
	 * @param id del club de la ruta
	 * @author rgv
	 * @return contiene los datos del club sí se encuentra.
	 */
	@GetMapping(path = "/{id}")
	public Optional<ClubDtos> getClubbyId(@PathVariable("id") Long id){
		
		return this.clubFuncionalidade.getById(id);
		
	}
	
	/**
	 * Metodo que se encarga de actualizar los datos de un club existente
	 * @param request de los datos actualizados
	 * @param id del club que se a actualizar
	 * @author rgv
	 * @return devuelve el objeto ClubDto actalizado
	 */
	@PutMapping(path = "/{id}")
	public ClubDtos updateClubById(@RequestBody ClubDtos request, @PathVariable Long id) {
	    return this.clubFuncionalidade.updateById(request, id);
	}
	
	/**
	 * Metodo que se encarga de eliminar un objeto ClubDto mediante su id
	 * @param id del clubDto
	 * @author rgv
	 * @return mensaje de eliminacion
	 */
	@DeleteMapping(path = "/{id}")
	public String deleteClubById(@PathVariable("id") Long id) {
		
		
		boolean ok = this.clubFuncionalidade.DeleteClub(id);
		
		if(ok) {
			return "Club" + id + "Eliminao";
		}else {
			return "No sa Eliminao";
		}
		
	}
	
}
