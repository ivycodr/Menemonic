package com.mnemonic.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mnemonic.entity.Phrase;
import com.mnemonic.service.CategoryService;
import com.mnemonic.service.MnemonicService;



@RestController
@RequestMapping("/api/v1/mnemonic")
@ComponentScan("com.mnemonic.service")
@ComponentScan("com.mnemonic.adapter")
@ComponentScan("com.mnemonic.respositories")
public class MnemonicController {
	
	@Autowired

	MnemonicService mnemonicService;
	
	
	@GetMapping("/phrases")
	public List<Phrase> getAllPhrases() {
		
		return mnemonicService.getAllPhrases();
		
	}
	
	@GetMapping("/phrases/category")
	public List<Phrase> getPhrasesByCategory(@RequestParam(value="id") Long id) {
		
		return mnemonicService.getPhrasesByCategory(id);
		
	}
	
	
	@PostMapping("/phrases")
	public Phrase createPhrase(@RequestBody Phrase phrase){
		
		Phrase ph  = mnemonicService.createPhrase(phrase);
		return ph;
		
		
	}
	
	
	
	
	
	
}
