package it.rubrica.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "numTelefono")
@Entity
public class NumTelefono implements Serializable{

	private static final long serialVersionUID = 1L;

	private String numTelefono;
	private Contatto contatto;
	
	public NumTelefono(String numTelefono, Contatto contatto) {
		this.numTelefono = numTelefono;
		this.contatto = contatto;
	}

	public NumTelefono() {
	}

	/****************Getters****************/
	
	@Id
	@Column (name = "id_telefono")
	@GeneratedValue (strategy = GenerationType.AUTO)
	public String getNumTelefono() {return numTelefono;}
	
	@ManyToOne (cascade =CascadeType.ALL)
	@JoinColumn (name ="id_contatto")
	public Contatto getContatto() {return contatto;}


	/************** Setters *****************/
	public void setNumTelefono(String numTelefono) {this.numTelefono = numTelefono;}
	public void setContatto(Contatto contatto) {this.contatto = contatto;}
	
	
	
	
}
