package projektzes.cardscraft.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name = "name")
    @NotEmpty
    private String name;
	
	@Column(name = "acces_right")
    @NotEmpty
    private int accesRight;

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

	public int getAccesRight() {
		return accesRight;
	}

	public void setAccesRight(int accesRight) {
		this.accesRight = accesRight;
	}
	
	
}
