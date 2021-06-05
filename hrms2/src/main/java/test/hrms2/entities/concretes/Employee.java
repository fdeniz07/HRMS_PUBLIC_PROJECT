package test.hrms2.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.hrms2.entities.abstracts.User;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee extends User{

	@NotBlank(message = "İsim kısmı boş bırakılamaz.")
	@Column(name = "firstname")
	private String firstName;
	
	@NotBlank(message = "Soyisim kısmı boş bırakılamaz.")
	@Column(name = "lastname")
	private String lastName;
	
	@OneToMany(mappedBy = "employee")
	private List<ConfirmByEmployee> confirmByEmployees;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
}
