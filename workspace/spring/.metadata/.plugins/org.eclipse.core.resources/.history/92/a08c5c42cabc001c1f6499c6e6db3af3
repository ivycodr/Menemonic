package com.mnemonic.service;

import java.util.List;
import java.util.Optional;

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
		
		// you can do the computation for the password and score
		
		Phrase ph  = mnemonicRepository.save(phrase);
		return ph;
	}
	
	
	
	

	

}
