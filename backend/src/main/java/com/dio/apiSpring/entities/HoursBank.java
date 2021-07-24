package com.dio.apiSpring.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.LocalDateType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_hours_bank")
public class HoursBank {

	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class HoursBankId implements Serializable{
		private static final long serialVersionUID = 1L;
	
		@ManyToOne
		@JoinColumn(name = "movimetation_id")
		private Movimetation movimetation;
		

		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;
	}
	
	@EmbeddedId
	private HoursBankId id;
	
	private LocalDateType worked;
	private BigDecimal hoursWorked;
	private BigDecimal hoursBalance;
}
