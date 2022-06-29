package service;

import dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import mapper.PersonMapper;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IPersonRepository;

@Service
public class PersonService implements IPersonService {
    
    @Autowired
    public IPersonRepository persoRepo;
    
    @Autowired
    public PersonMapper mapper;
    
   
    //Recibe un DTO, crea una nueva Persona y la devuelve en forma de DTO.
    @Override
    public PersonDTO createPerson(PersonDTO persDto) {
       
       Person persona = mapper.requestPerson(persDto);
       Person newPerson = persoRepo.save(persona);
       PersonDTO newPersDto = mapper.responsePerson(newPerson);
        
       return  newPersDto;
    }
    
    //Genera una lista de personas, convierte a cada elemento en DTO y lo devuelve en forma de lista<DTO>.
    @Override
    public List<PersonDTO> listPerson() {
        
       List<Person> listPers = persoRepo.findAll();
       List<PersonDTO> listPersDto = new ArrayList();
            for (Person pers : listPers) {
                PersonDTO persDto = mapper.responsePerson(pers);
                listPersDto.add(persDto);
            }                    
         return listPersDto;
     }

    //Recibe un id y elimina a la persona correspondiente de la BD.
    @Override
    public void deletePerson(Long id) {
        persoRepo.deleteById(id);
    }

    //Recibe un id, encuentra a la persona correspondiente y la devuelve como DTO.
    @Override
    public PersonDTO findPerson(Long id) {
        Person pers = persoRepo.findById(id).orElse(null);
        PersonDTO persDto = mapper.responsePerson(pers);
        return persDto;
    }

    //Recibe un DTO, se setean sus propiedades a la entidad correspondiente según el id y guarda los cambios.
    @Override
    public void editPerson (Long id, PersonDTO persDto){
        
        Person person = persoRepo.getById(id);
        
        person.setName(persDto.getName());
        person.setLastName(persDto.getLastName());
        person.setAge(persDto.getAge());
        person.setProfession(persDto.getProfession());
        person.setOrigin(persDto.getOrigin());
        person.setPresentation(persDto.getPresentation());
        person.setProfessional_photo(persDto.getProfessional_photo());
        person.setEmail(persDto.getEmail());
        //person.setProject(persDto.getProject());
        
        Person editedPers = persoRepo.saveAndFlush(person);
    }
}
    
