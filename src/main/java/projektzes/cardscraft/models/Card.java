package projektzes.cardscraft.models;

import java.util.Set;

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
import javax.validation.constraints.NotEmpty;

import org.hibernate.type.BlobType;

@Entity
@Table(name = "cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "health")
	@NotEmpty
	private int health;

	@Column(name = "damage")
	@NotEmpty
	private int damage;

	@Column(name = "img")
	@NotEmpty
	private BlobType img;

	@ManyToMany
	@JoinTable(
	  name = "decks_cards", 
	  joinColumns = @JoinColumn(name = "card_id"), 
	  inverseJoinColumns = @JoinColumn(name = "deck_id"))
	private Set<Deck> decks;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public BlobType getImg() {
		return img;
	}

	public void setImg(BlobType img) {
		this.img = img;
	}
}
