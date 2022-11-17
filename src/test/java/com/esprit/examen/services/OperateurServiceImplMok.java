package com.esprit.examen.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import java.util.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@SpringBootTest(classes =OperateurServiceImplMok.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMok {
	
	@Mock
	 OperateurRepository operateurRepository;

	 @InjectMocks
	 OperateurServiceImpl operateurServiceImp;

	 Operateur operateur = new Operateur(null,"haythem","gharbi","haigha",null);

	 List<Operateur> listOperateurs = new ArrayList<Operateur>() {
	  {
	   add(new Operateur(null,"hay","gha","haigha",null));
	   add(new Operateur(null,"gha","hay","haigha",null));
	  }
	 };
	 @Test
	  void testRetrieveOperateur() {
	  Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
	  Operateur operateur1 = operateurServiceImp.retrieveOperateur(1L);
	  Assertions.assertNotNull(operateur1);
	 }


	    @Test
	    void testRetrieveOperateurByid() {
	        when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
	        Operateur operateur2 = operateurServiceImp.retrieveOperateur(1L);
	     System.out.println(operateur2);
	        Assertions.assertNotNull(operateur2);
	    }
	    @Test
	    void testRetrieveAllOperateurs() {
	        List<Operateur> operateurs = new ArrayList();
	        operateurs.add(new Operateur());
	        when(operateurRepository.findAll()).thenReturn(operateurs);
	        List<Operateur> expected = operateurServiceImp.retrieveAllOperateurs();
	        Assertions.assertEquals(expected, operateurs);
	        verify(operateurRepository).findAll();
	    }
	    @Test
	    void testCreateNewObject() {
	    	Operateur obj = new Operateur(null,"new","user","newnew",null);
	        when(operateurRepository.save(isA(Operateur.class))).thenAnswer(invocation -> (Operateur) invocation.getArguments()[0]);
	        Operateur returnedObj = operateurServiceImp.addOperateur(obj);
	        ArgumentCaptor<Operateur> savedObjectArgument = ArgumentCaptor.forClass(Operateur.class);
	        verify(operateurRepository, times(1)).save(savedObjectArgument.capture());
	        verifyNoMoreInteractions(operateurRepository);
	        Operateur savedRestObject = savedObjectArgument.getValue();
	        Assertions.assertNotNull(savedRestObject);
	    }
	    @Test
	    void testDeleteObject() {
	    	Operateur operateur = new Operateur();
	    	operateur.setNom("new");
	    	operateur.setIdOperateur(1L);
	        when(operateurRepository.findById(operateur.getIdOperateur())).thenReturn(Optional.of(operateur));
	        Operateur operateur3 = operateurServiceImp.retrieveOperateur(1L);
	        operateurServiceImp.deleteOperateur(operateur3.getIdOperateur());
	        verify(operateurRepository).deleteById(operateur3.getIdOperateur());
	    }

}
