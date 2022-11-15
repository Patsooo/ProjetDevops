package com.esprit.examen.services;


import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
    
	@Autowired
    private OperateurServiceImpl operateurServiceImpl;
	
	@Autowired
    private OperateurRepository operateurRepository;
	
	
       Operateur operateur = new Operateur(null, "haythem", "gharbi", "gha1920", null);
       @Test
       @Order(1)
       void testaddOperateur() {
       	Operateur operateurAdded =  operateurServiceImpl.addOperateur(operateur);
           Assertions.assertEquals(operateurAdded.getIdOperateur(), operateurAdded.getIdOperateur());
       }
       @Test
       @Order(2)
       void testRetrieveAllOperateurs() {
           List<Operateur> listOperateurs = operateurServiceImpl.retrieveAllOperateurs();
           Assertions.assertEquals(listOperateurs.size(), listOperateurs.size());
       }
}
