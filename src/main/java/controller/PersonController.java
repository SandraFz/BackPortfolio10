package controller;

import dto.PersonDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IPersonService;

@RestController
@RequestMapping("person/")
public class PersonController {
    
    //@Autowired
    //private IExperienceService expServ;
    
    @Autowired
    private IPersonService persoServ; 
    
    //@Autowired
    //private IProjectService proyServ;
    
    
    //Crea una nueva persona.
    @PostMapping("new")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO persDto){
        
        PersonDTO newPersDto = persoServ.createPerson(persDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPersDto); 
    }
    
    //Arroja la lista de personas.
    @GetMapping("list")
    public ResponseEntity<List<PersonDTO>> listPerson(){
        List<PersonDTO> listPersDto = persoServ.listPerson();
        return ResponseEntity.status(HttpStatus.OK).body(listPersDto);
    }
    
    //Elimina una persona de la lista.
    @DeleteMapping("delete/{id}")
    public void deletePerson(@PathVariable Long id){
        persoServ.deletePerson(id);
    }
    
    //Busca una persona de la lista.
    @GetMapping("find/{id}")
    public ResponseEntity<PersonDTO> findPerson(@PathVariable Long id){
        PersonDTO persDto = persoServ.findPerson(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(persDto);
    }
    
    //Edita una persona.
    @PutMapping("edit/{id}")
    public void editPerson(@PathVariable Long id, @RequestBody PersonDTO persDto){
        
        persoServ.editPerson(id, persDto);
    }
}

