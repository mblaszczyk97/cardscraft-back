package spring.springapp.user;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import spring.springapp.model.BaseEntity;
import spring.springapp.model.Human;

@Entity
@Table(name = "users")
public class User extends Human {
	@Column(name = "email")
    @NotEmpty
    private String email;
	
	@Column(name = "level")
    @NotEmpty
    private int lvl;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Deck> decks;
	

	
}
