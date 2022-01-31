package it.rubrica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name="contatto")
@Entity 
public class Contatto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idContatto;
	private String nome;
	private String cognome;
	private String email;
	
	ArrayList<NumTelefono> numeriTel;
	
	
	public Contatto(String nome, String cognome, String email) {
	
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	public Contatto() {}
	

	/*******Getters**********/
	@Id
	@Column (name="id_contatto")
	@GeneratedValue (strategy = GenerationType.AUTO)
	public int getIdContatto() {return idContatto;}
	
	@Column (name="nome_contatto")
	public String getNome() {return nome;}
	
	@Column (name="cognome_contatto")
	public String getCognome() {return cognome;}
	
	@Column (name="email_contatto")
	public String getEmail() {return email;}
	
	@OneToMany (mappedBy = "contatto", cascade = CascadeType.ALL)
	public ArrayList<NumTelefono> getNumeriTel() {
		if (numeriTel == null) {
			numeriTel = new ArrayList<NumTelefono>();
		}
			
		return numeriTel;
	}
		
	
	/******************************Setters*******************************************/
	
	public void setIdContatto(int idContatto) {this.idContatto = idContatto;}
	public void setNome(String nome) {this.nome = nome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public void setEmail(String email) {this.email = email;}
	public void setNumeriTel(ArrayList<NumTelefono> numeriTel) {this.numeriTel = numeriTel;}
	
	
}
