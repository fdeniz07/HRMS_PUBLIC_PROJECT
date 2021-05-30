package test.hrms2.entities.concretes;

import java.sql.Date; //sonra degisebilir

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.hrms2.entities.abstracts.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@NotBlank(message = "National identity cannot be empty.")
	@Size(min = 11, max = 11, message = "National identity length must be 11.")
	@Pattern(regexp = "^[1-9][0-9]{9}[02468]$", message = "National identity can't start with 0 or contain text.")
	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private Date birthDate;

}
