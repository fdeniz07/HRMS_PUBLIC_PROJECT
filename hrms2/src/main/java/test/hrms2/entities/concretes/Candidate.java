package test.hrms2.entities.concretes;

import java.sql.Date; //sonra degisebilir

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.hrms2.entities.abstracts.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper=false)
public class Candidate extends User{

	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
}
