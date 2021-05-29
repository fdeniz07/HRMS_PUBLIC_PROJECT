package test.hrms2.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="confirm_by_employee")
public class ConfirmByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
	@Column(name = "confirm_date")
	private Date confirmDate;
	
	@ManyToOne()
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
}
