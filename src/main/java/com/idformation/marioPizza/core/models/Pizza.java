package com.idformation.marioPizza.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	/** a technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** the name of the pizza. */
	@Column
	private String name;

	/** the description of the pizza. */
	@Column
	private String description;

	/** an image for the pizza. */
	@Column
	private String image;

	/** the price. */
	@Column
	private Double price;

	/**
	 *
	 */
	public Pizza() {
		super();
	}

	/**
	 * .
	 *
	 * @param pId
	 */
	public Pizza(final Long pId) {
		super();
		this.id = pId;
	}

	/**
	 * @param pId
	 * @param pName
	 * @param pDescription
	 * @param pImage
	 * @param pPrice
	 */
	public Pizza(final Long pId, final String pName, final String pDescription, final String pImage,
			final Double pPrice) {
		super();
		this.id = pId;
		this.name = pName;
		this.description = pDescription;
		this.image = pImage;
		this.price = pPrice;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param pDescription the description to set
	 */
	public void setDescription(final String pDescription) {
		this.description = pDescription;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pImage the image to set
	 */
	public void setImage(final String pImage) {
		this.image = pImage;
	}

	/**
	 * @param pName the name to set
	 */
	public void setName(final String pName) {
		this.name = pName;
	}

	/**
	 * @param pPrice the price to set
	 */
	public void setPrice(final Double pPrice) {
		this.price = pPrice;
	}

}
