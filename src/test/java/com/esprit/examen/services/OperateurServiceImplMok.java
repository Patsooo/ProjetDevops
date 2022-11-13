package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMok {
    @Mock
    private OperateurRepository operateurRepository;

    @InjectMocks
    private OperateurServiceImpl operateurServiceImpl;

    Operateur operateur = new Operateur(null, "haythem","gharbi", "haythemgha", null);
    Operateur operateur1 = new Operateur(null, "taher","gharbi", "tahergha", null);
    Operateur operateur2 = new Operateur(null, "azer","gharbi", "azergha", null);
    List<Operateur> list = new ArrayList<Operateur>() {
    	{
    		add(operateur1);
    		add(operateur2);
    		
    		
    	}
    };
    
    @Test
    void testRetrieveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Operateur oper1 = operateurServiceImpl.retrieveOperateur(1L);
        Assertions.assertNotNull(oper1);
    }
    
    @Test
    void updateOperateurTest(){
    	operateur.setPassword("new password");
        Assertions.assertNotNull(operateurServiceImpl.updateOperateur(operateur));
    }
    
    @Test
    void deleteOperateurTest(){
    	operateurServiceImpl.deleteOperateur(
    			operateur2.getIdOperateur());
        Assertions.assertNotNull(list);
    }

}
