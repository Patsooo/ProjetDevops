package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.esprit.examen.repositories.DetailFournisseurRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService fournisseurService;
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;

	
	@Test
	public void testAddFournisseur() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateDebColab = dateFormat.parse("30/09/2000");
		DetailFournisseur detF = DetailFournisseur.builder().email("fournisseur1@gmail.com").dateDebutCollaboration(dateDebColab).adresse("megrine").matricule("mat01").build();

		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).detailFournisseur(detF).build();
		Fournisseur savedF = fournisseurService.addFournisseur(f);

		assertNotNull(savedF.getIdFournisseur());
		assertNotNull(savedF.getCategorieFournisseur());
		assertTrue(savedF.getCode().length() > 0);
		assertTrue(savedF.getLibelle().length() > 0);

		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
	}
	@Test
	public void testSaveDetailFournisseur() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateDebColab = dateFormat.parse("30/09/2000");
		DetailFournisseur detF = DetailFournisseur.builder().email("fournisseur1@gmail.com").dateDebutCollaboration(dateDebColab).adresse("megrine").matricule("mat01").build();
		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).detailFournisseur(detF).build();

		Fournisseur savedF = fournisseurService.addFournisseur(f);
		DetailFournisseur savedDetF = fournisseurService.saveDetailFournisseur(f);

		assertEquals(detailFournisseurRepository.findById(detF.getIdDetailFournisseur()), savedF.getDetailFournisseur());

		detailFournisseurRepository.delete(savedDetF);
		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
	}

	@Test
	public void testDeleteFournisseur() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateDebColab = dateFormat.parse("30/09/2000");
		DetailFournisseur detF = DetailFournisseur.builder().email("fournisseur1@gmail.com").dateDebutCollaboration(dateDebColab).adresse("megrine").matricule("mat01").build();

		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).detailFournisseur(detF).build();
		Fournisseur savedF = fournisseurService.addFournisseur(f);

		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
		assertNull(fournisseurService.retrieveFournisseur(savedF.getIdFournisseur()));
	}

	@Test
	public void testRetrieveAllFournisseurs() {
		int expected = fournisseurService.retrieveAllFournisseurs().size();
		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).build();

		Fournisseur savedF = fournisseurService.addFournisseur(f);

		assertEquals(expected + 1, fournisseurService.retrieveAllFournisseurs().size());
		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
	}
	@Test
	public void testRetrieveFournisseur() {
		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).build();

		Fournisseur savedF = fournisseurService.addFournisseur(f);

		assertNotNull(fournisseurService.retrieveFournisseur(savedF.getIdFournisseur()));
		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
	}
	@Test
	public void testAssignSecteurActiviteToFournisseur() {
		Fournisseur f = Fournisseur.builder().code("f01").libelle("fournisseur1").categorieFournisseur(CategorieFournisseur.ORDINAIRE).build();
		Fournisseur savedF = fournisseurService.addFournisseur(f);

		SecteurActivite sec = SecteurActivite.builder().codeSecteurActivite("f01").libelleSecteurActivite("fournisseur1").build();
		SecteurActivite savedSec = secteurActiviteService.addSecteurActivite(sec);

		fournisseurService.assignSecteurActiviteToFournisseur(savedSec.getIdSecteurActivite(),savedF.getIdFournisseur());

		assertEquals(savedSec,fournisseurService.retrieveFournisseur(savedF.getIdFournisseur()).getSecteurActivites().stream().findAny());

		fournisseurService.deleteFournisseur(savedF.getIdFournisseur());
		secteurActiviteService.deleteSecteurActivite(savedSec.getIdSecteurActivite());
	}
}
