package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {

private Quarto quarto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		quarto = new Quarto(1L,"20", "Master");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		quarto.setId(2L);
		//Assert
		assertEquals(2L,quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
		//Act
		quarto.setNum("10");
		//Assert
		assertEquals("10", quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
		//Act
		quarto.setTipo("quarto casal");
		//Assert
		assertEquals("quarto casal", quarto.getTipo());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		//Act
		Quarto novoQuarto = new Quarto(3L,"5","quarto de solteiro");
		//Assertion
		assertAll("novoQuarto",
				()-> assertEquals(3L, novoQuarto.getId()),
				()-> assertEquals("5", novoQuarto.getNum()),
				()-> assertEquals("quarto de solteiro", novoQuarto.getTipo()));
	}

}
