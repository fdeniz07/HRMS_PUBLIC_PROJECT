package test.hrms2.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

	@NotBlank(message = "İsim alanı boş bırakılamaz. ")
	@Column(name = "firstname")
	private String firstname;

	@NotBlank(message = "Soyisim alanı boş bırakılamaz. ")
	@Column(name = "lastname")
	private String lastname;

	@NotBlank(message = "Kimlik numarası alanı boş bırakılamaz. ")
	@Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır.")
	@Pattern(regexp = "^[1-9][0-9]{9}[02468]$", message = "National identity can't start with 0 or contain text.")
	@Column(name = "identification_number")
	private String identificationNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
}
