package it.rubrica.business;


import java.util.List;

import it.rubrica.exceptions.IdNonSpecificatoException;
import it.rubrica.exceptions.ContattoNonTrovatoException;
import it.rubrica.entity.Contatto;
import it.rubrica.entity.NumTelefono;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
@LocalBean
public class RubricaEjb implements RubricaEjbLocal {

	@PersistenceContext(unitName="rubrica")
	EntityManager em;
    public RubricaEjb() {
       
    }

    public Contatto insertContatto(Contatto c) {
    	em.persist(c);
    	return c;
    	
    }
    
    public Contatto insertContatto(String nome, String cognome, String email) {
    	Contatto c = new Contatto(nome,cognome, email);
    	return insertContatto(c);
    
    }
     
    public void aggiornaContattoEsistente (int idContatto, String numero1, String numero2,String nome, String cognome, String email  ) throws ContattoNonTrovatoException {
    	Contatto c = em.find(Contatto.class, idContatto);
    	if (c== null) {
    		throw new ContattoNonTrovatoException();
    	}
    	c.setNome(nome);c.setCognome(cognome);c.setEmail(email);
    	if (!numero1.isBlank() ) {
    		NumTelefono n1 = new NumTelefono();
    		n1.setContatto(c);
    		n1.setNumTelefono(numero1);
    		c.getNumeriTel().add(n1);
    	}
    	c.setNome(nome);c.setCognome(cognome);c.setEmail(email);
    	if (!numero2.isBlank() ) {
    		NumTelefono n2 = new NumTelefono();
    		n2.setContatto(c);
    		n2.setNumTelefono(numero2);
    		c.getNumeriTel().add(n2);
    	}
    		em.merge(c);
    }
    
    
    public List<Object[]> getRubrica () {
    	String sql = "SELECT DISTINCT *\r\n"
    			+ "	FROM public.contatto inner JOIN public.numtelefono ON numtelefono.id_contatto = contatto.id_contatto";
    	Query q = em.createNativeQuery(sql);
    	List < Object[]> rubrica = q.getResultList();
    	return rubrica;
    }
    
    public List<Object[]> ricercaPerCognome (String cognomeparziale) {
    	String sql = "SELECT * FROM public.contatto inner JOIN public.numtelefono\r\n"
    			+ "ON numtelefono.id_contatto = contatto.id_contatto where cognome_contatto ILIKE  '%"+ cognomeparziale + "%'";
    	Query q = em.createNativeQuery(sql);
    	List < Object[]> rubrica = q.getResultList();
    	return rubrica;
    }
    
    public List<Object[]> ricercaPerNumero (String numeroparziale) {
    	String sql = "SELECT * FROM public.contatto inner JOIN public.numtelefono\r\n"
    			+ "ON numtelefono.id_contatto = contatto.id_contatto where id_telefono ILIKE  '%"+ numeroparziale + "%'";
    	Query q = em.createNativeQuery(sql);
    	List < Object[]> rubrica = q.getResultList();
    	return rubrica;
    }
    
    public void removeContatto(int i) throws ContattoNonTrovatoException {
    	

    	Contatto c = em.find(Contatto.class, i);
    	
    	if (c == null ) {
    		throw new ContattoNonTrovatoException();
    	}
    	em.persist(c);
    	em.remove(c);
    	
    }
    
    
    
}
