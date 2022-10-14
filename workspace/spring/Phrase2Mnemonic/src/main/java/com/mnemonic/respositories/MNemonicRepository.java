package com.mnemonic.respositories;








import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mnemonic.entity.Phrase;


@Repository
@EntityScan( basePackages = {"com.mnemonic.entity.Phrase"} ) 
public interface MNemonicRepository extends JpaRepository<Phrase, Long> {

	
	public List<Phrase> findByCategoryId(Long categoryID);
	
	

	
	
	
	
	
	
}
