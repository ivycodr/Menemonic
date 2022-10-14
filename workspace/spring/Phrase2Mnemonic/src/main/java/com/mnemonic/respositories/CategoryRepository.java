package com.mnemonic.respositories;








import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnemonic.entity.Category;


@Repository
@EntityScan( basePackages = {"com.mnemonic.entity.Category"} ) 
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);

	
	
	
	
	
	
}
