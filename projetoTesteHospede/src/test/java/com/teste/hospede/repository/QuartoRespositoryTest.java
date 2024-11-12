package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.hospede.entity.Quarto;

@DataJpaTest
class QuartoRespositoryTest {
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		
		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "20",
				                           "Master");
		
		// When / Act
		Quarto saveQuarto = quartoRepository.save(quarto1);
		
		// Then / Assert
		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId() > 0);
		
	}
	
	@DisplayName("Testando Get para todos os Quartos")
	@Test
	void testGetAllRespository() {
		
		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "20",
                                            "Master");
		
		Quarto quarto2 = new Quarto(null, "10",
                                             "Quarto de casal");
		
		quartoRepository.save(quarto1);
		quartoRepository.save(quarto2);

		
		// When / Act
		List<Quarto> quartoList = quartoRepository.findAll();	
		
		
		// Then / Assert
		assertNotNull(quartoList);
		assertEquals(2, quartoList.size());
		
	}
	
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "10",
                                         "Quarto de casal");
		
		quartoRepository.save(quarto1);
		
		// When / Act
		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();	
		
		
		// Then / Assert
		assertNotNull(saveQuarto);
		assertEquals(quarto1.getId(), saveQuarto.getId());
		
	}
	
	@DisplayName("Testando UPDATE")
	@Test
	void testUpdateQuarto() {
		
		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "10",
                                            "Quarto de casal");
		
		quartoRepository.save(quarto1);
		
		// When / Act
		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
		quarto1.setNum("5");
		quarto1.setTipo("quarto de solteiro");
		
		Quarto updateQuarto = quartoRepository.save(saveQuarto);
		
		
		// Then / Assert
		assertNotNull(updateQuarto);
		assertEquals("5", updateQuarto.getNum());
		assertEquals("quarto de solteiro", updateQuarto.getTipo());
		
	}
	
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteQuarto() {
		
		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "10",
                                               "quarto de casal");
		
		quartoRepository.save(quarto1);
		
		// When / Act
	     quartoRepository.deleteById(quarto1.getId());
		
		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());
		
		// Then / Assert
		assertTrue(quartoOptional.isEmpty());
	}




}
