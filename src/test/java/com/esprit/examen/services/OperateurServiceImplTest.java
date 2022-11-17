package com.esprit.examen.services;


import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Operateur;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
	@Autowired
	IOperateurService operateurService;

	@Test
	@Order(4)
	public void testRetrieveAllOperateurs() {
		List<Operateur> listOperateur = operateurService.retrieveAllOperateurs();
		Assertions.assertEquals(0, listOperateur.size());
	}
	@Test
	@Order(1)
	public void testAddOperateur() {
		List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
		int expected=operateurs.size();
		Operateur o = new Operateur(null,"hai","gha","haigha",null);
		Operateur savedOperateur= operateurService.addOperateur(o);

		assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
		assertNotNull(savedOperateur.getIdOperateur());
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());

	}

	@Test
	@Order(3)
	public void testAddOperateurOptimized() {

		Operateur o = new Operateur(null,"haithem","gharbi","haigha",null);
		Operateur savedOperateur= operateurService.addOperateur(o);
		assertNotNull(savedOperateur.getIdOperateur());
		assertSame("haithem", savedOperateur.getNom());
		assertTrue(savedOperateur.getPassword()=="haigha");
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());

	}

	@Test
	@Order(2)
	public void testDeleteOperateur() {
		Operateur o = new Operateur(null,"haithem","gharbi","haigha",null);
		Operateur savedOperateur= operateurService.addOperateur(o);
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		assertNull(operateurService.retrieveOperateur(savedOperateur.getIdOperateur()));
	}
}
