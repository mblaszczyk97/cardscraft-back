package spring.springapp.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import spring.springapp.model.NamedEntity;

@Entity
@Table(name = "decks")
public class Deck extends NamedEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "deck")
	private Set<Card> cards;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
