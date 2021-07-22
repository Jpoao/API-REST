package com.dio.apiSpring.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
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
@Table(name = "tb_movimetation")
public class Movimetation {

	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class MovimetationId implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;
	}
	
	@Id
	@EmbeddedId
	private MovimetationId id;
	
	private LocalDateType entryDate;
	private LocalDateType exitDate;
	private BigDecimal period;
	
	@ManyToOne
	@JoinColumn(name = "occurrence_id")
	private Occurrence occurrence;
	
	@ManyToOne
	@JoinColumn(name = "calendar_id")
	private Calendar calendar;
}
