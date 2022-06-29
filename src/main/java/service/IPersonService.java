package service;

import dto.PersonDTO;
import java.util.List;

public interface IPersonService {
    
    public PersonDTO createPerson(PersonDTO pers);
    public List<PersonDTO> listPerson();
    public PersonDTO findPerson(Long id);
    public void deletePerson(Long id);
    public void editPerson(Long id, PersonDTO persDto);
    
}

