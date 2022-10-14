package com.mnemonic.service;

import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.hibernate.type.PrimitiveCharacterArrayClobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mnemonic.entity.Category;
import com.mnemonic.entity.Phrase;
import com.mnemonic.respositories.MNemonicRepository;


@Component
public class MnemonicService {
	
	@Autowired
	private MNemonicRepository  mnemonicRepository;
	
	
	public Optional<Phrase> findById(long id) {
		return  mnemonicRepository.findById(id);

	}
	
	public List<Phrase> getAllPhrases() {
		return mnemonicRepository.findAll();
	}
	
	public List<Phrase> getPhrasesByCategory(Long categoryID) {
		return mnemonicRepository.findByCategoryId(categoryID);
	}
	
	public Phrase createPhrase(Phrase phrase) {
		
		// calculate score and password
		StringTokenizer st = new StringTokenizer(phrase.getMnemonic());
		String password = new String();
		while (st.hasMoreTokens()) {
	         password = password + st.nextToken().charAt(0);
			
	     }
		 phrase.setPassword(password);
		 
		 int upperCaseClass = 26;
		 int lowerCaseClass = 26;
		 int numberClass = 10;
		 int specialCharClass = 33;
		 int total = 0;
		 
		 int counter = 0;
		
		 while (counter < password.length()) {
			 if (Character.isUpperCase(password.charAt(counter))) {
				 total = total + upperCaseClass;
			 }else if (Character.isLowerCase(password.charAt(counter))) {
				 total = total + lowerCaseClass;
			 }else if (Character.isDigit(password.charAt(counter))) {
				 
				 total = total + numberClass;
				 
			 }else {
				 total = total + specialCharClass;
			 }
			 counter ++;
		 }
		 
		 
		 
		 
		System.out.println("CharacterClass Count " + total);
		 
		 int passwordLength = password.length();
		 int score = (int) Math.log10((Math.pow(total, passwordLength)));
		 phrase.setScore(score);
		
	    Phrase ph  = mnemonicRepository.save(phrase);
		return ph;
	}
	
	
	
	

	

}