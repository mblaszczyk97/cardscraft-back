package projektzes.cardscraft.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "decks")
public class Deck {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@ManyToMany(mappedBy = "decks")
	private Set<Card> cards;

	@ManyToMany(mappedBy = "decks") 
	private Set<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
	 * public Set<Card> getCards() { return cards; }
	 * 
	 * public void setCards(Set<Card> cards) { this.cards = cards; }
	 * 
	 * public Set<User> getUsers() { return users; }
	 * 
	 * public void setUsers(Set<User> users) { this.users = users; }
	 */
    
    
}
