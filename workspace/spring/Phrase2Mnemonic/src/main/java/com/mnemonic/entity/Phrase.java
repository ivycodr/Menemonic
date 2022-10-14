package com.mnemonic.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "phrase")
public class Phrase {
	
	/*
	 * CREATE TABLE phrases (
		  id INT AUTO_INCREMENT  PRIMARY KEY,
		  phrase VARCHAR(512) NOT NULL,
		  password VARCHAR(250) NOT NULL,
		  inspiration VARCHAR(512) DEFAULT NULL,
		  category VARCHAR(512) DEFAULT NULL
  

	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private  long id;
	
	@Column(name="mnemonic")
	private String mnemonic;
	
	@Column(name="password", nullable = true)
	private String password;
	
	@Column(name="inspiration")
	private String inspiration;
	
	
	
	@Column(name="score", nullable = true)
	private int score;
	
	@JoinColumn(name = "category_id",referencedColumnName = "id")
	@OneToOne
	private Category category;
	
	protected Phrase() {
		// default constructor 
	}
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	public Phrase(String mnemonic, String password, String inspiration, String category, int score, int category_id) {
		super();
		this.mnemonic = mnemonic;
		this.password = password;
		this.inspiration = inspiration;
		
		this.score = score;
	}
	
	
	

    @Column(insertable=false, updatable=false)
	private long category_id;

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getInspiration() {
		return inspiration;
	}


	public void setInspiration(String inspiration) {
		this.inspiration = inspiration;
	}


	


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public long getId() {
		return id;
	}


	public String getMnemonic() {
		return mnemonic;
	}


	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}


	


	public long getCategory_id() {
		return category_id;
	}


	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}


	


	
	
	
}
