package spring.springapp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.type.BlobType;

import spring.springapp.model.NamedEntity;

@Entity
@Table(name = "Cards")
public class Card extends NamedEntity {

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
	 
	 @ManyToOne
	 @JoinColumn(name = "deck_id")
	 private Deck deck;

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

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
