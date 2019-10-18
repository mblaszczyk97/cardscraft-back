package projektzes.cardscraft.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	@NotEmpty
	private String username;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Column(name = "email")
	@NotEmpty
	private String email;

	@Column(name = "level")
	private int lvl;
	
	@ManyToMany
	@JoinTable(
	  name = "decks_users", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "deck_id"))
	private Set<Deck> decks;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	/*
	 * public Role getRole() { return role; }
	 * 
	 * public void setRole(Role role) { this.role = role; }
	 * 
	 * protected Set<Deck> getDecksInternal() { if (this.decks == null) { this.decks
	 * = new HashSet<>(); } return this.decks; }
	 * 
	 * public List<Deck> getDecks() { List<Deck> sortedDecks = new
	 * ArrayList<>(getDecksInternal()); PropertyComparator.sort(sortedDecks, new
	 * MutableSortDefinition("name", true, true)); return
	 * Collections.unmodifiableList(sortedDecks); }
	 * 
	 * protected void setDecksInternal(Set<Deck> decks) { this.decks = decks; }
	 */

}
