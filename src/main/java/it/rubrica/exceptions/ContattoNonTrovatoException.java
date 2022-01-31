package it.rubrica.exceptions;

public class ContattoNonTrovatoException extends Exception {
	private static final long serialVersionUID = 1L;
		
	public ContattoNonTrovatoException(String message) {
		super(message);
		
		
	}

	public ContattoNonTrovatoException() {
		super("Il contatto specificato non è stato trovato.");
		
	}
	

}
