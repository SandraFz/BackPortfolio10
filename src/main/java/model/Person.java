package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name="persona")
public class Person {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_person;
    
    @Column (name="name")
    private String name;
    @Column (name="lastName")
    private String lastName;
    @Column (name="age")
    private int age;
    @Column (name="profession")
    private String profession;
    @Column (name="origin")
    private String origin;
    @Column (name="presentation")
    private String presentation;
    @Column (name="professional_photo")
    private String professional_photo;
    @Column (name="email")
    private String email;

    /*@OneToOne*/
    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Project> project; 
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experience;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Study> study;
    
    @OneToMany(cascade  = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialMedia> soc_med;
*/

    public Person() {
    }

    public Person(String name, String lastName, int age, String profession, String origin, String presentation, String professional_photo, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.profession = profession;
        this.origin = origin;
        this.presentation = presentation;
        this.professional_photo = professional_photo;
        this.email = email;
    }

    
}
