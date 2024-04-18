package com.idformation.marioPizza.core.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.idformation.marioPizza.security.models.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`order`")
public class Order {

	/** a technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** the date of the order. */
	@Column(name = "`date`")
	@Temporal(TemporalType.DATE)
	private Date date;

	/** the total amount of the order. */
	@Column(name = "total_amount")
	private Double totalAmount = 0.;

	/** the user associated with the order. */
	@ManyToOne
	@JoinColumn(name = "usr_id", referencedColumnName = "id")
	private User user;

	/** the detail of the order. */
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private List<OrderLine> lines;

	/**
	 *
	 */
	public Order() {
		super();
	}

	/**
	 * add lines to the order.
	 *
	 * @param line the line to set
	 */
	public void addLine(final OrderLine line) {
		if (lines == null) {
			lines = new ArrayList<>();
		}

		line.setOrder(this);
		lines.add(line);
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lines
	 */
	public List<OrderLine> getLines() {
		return lines;
	}

	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param pDate the date to set
	 */
	public void setDate(final Date pDate) {
		this.date = pDate;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pLines the lines to set
	 */
	public void setLines(final List<OrderLine> pLines) {
		this.lines = pLines;
	}

	/**
	 * @param pTotalAmount the totalAmount to set
	 */
	public void setTotalAmount(final Double pTotalAmount) {
		this.totalAmount = pTotalAmount;
	}

	/**
	 * @param pUser the user to set
	 */
	public void setUser(final User pUser) {
		this.user = pUser;
	}

}
