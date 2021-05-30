package test.hrms2.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verification_codes"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$", message = "Email musst be this keyword valid")
	@Email(message = "Mail Format is invalid")
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="is_mail_verify")
	private boolean isMailVerify;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "user_id")
}
