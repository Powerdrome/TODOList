/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sérgio
 */
public class DadosIT {
    
    public DadosIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of guardaCalendario method, of class Dados.
     */
    @Test
    public void testGuardaCalendario() {
        System.out.println("guardaCalendario");
        Dados instance = new Dados();
        instance.guardaCalendario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeCadeiras method, of class Dados.
     */
    @Test
    public void testGetNomeCadeiras() {
        System.out.println("getNomeCadeiras");
        Dados instance = new Dados();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getNomeCadeiras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAnoCadeira method, of class Dados.
     */
    @Test
    public void testFindAnoCadeira() {
        System.out.println("findAnoCadeira");
        String nome = "";
        Dados instance = new Dados();
        int expResult = 0;
        int result = instance.findAnoCadeira(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSemestreCadeira method, of class Dados.
     */
    @Test
    public void testFindSemestreCadeira() {
        System.out.println("findSemestreCadeira");
        String nome = "";
        Dados instance = new Dados();
        int expResult = 0;
        int result = instance.findSemestreCadeira(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoras method, of class Dados.
     */
    @Test
    public void testGetHoras() {
        System.out.println("getHoras");
        Dados instance = new Dados();
        ArrayList<Hora> expResult = null;
        ArrayList<Hora> result = instance.getHoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCadeiras method, of class Dados.
     */
    @Test
    public void testGetCadeiras() {
        System.out.println("getCadeiras");
        Dados instance = new Dados();
        ArrayList<UnidadeCurricular> expResult = null;
        ArrayList<UnidadeCurricular> result = instance.getCadeiras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNCadeiras method, of class Dados.
     */
    @Test
    public void testGetNCadeiras() {
        System.out.println("getNCadeiras");
        Dados instance = new Dados();
        int expResult = 0;
        int result = instance.getNCadeiras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorasEstudo method, of class Dados.
     */
    @Test
    public void testGetHorasEstudo() {
        System.out.println("getHorasEstudo");
        Dados instance = new Dados();
        ArrayList<HoraEstudo> expResult = null;
        ArrayList<HoraEstudo> result = instance.getHorasEstudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCadeira method, of class Dados.
     */
    @Test
    public void testGetCadeira() {
        System.out.println("getCadeira");
        String id = "";
        Dados instance = new Dados();
        UnidadeCurricular expResult = null;
        UnidadeCurricular result = instance.getCadeira(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCadeira method, of class Dados.
     */
    @Test
    public void testAddCadeira() {
        System.out.println("addCadeira");
        String nome = "";
        Dados instance = new Dados();
        instance.addCadeira(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCadeira method, of class Dados.
     */
    @Test
    public void testRemoveCadeira() {
        System.out.println("removeCadeira");
        String nome = "";
        Dados instance = new Dados();
        instance.removeCadeira(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inscritoCadeira method, of class Dados.
     */
    @Test
    public void testInscritoCadeira() {
        System.out.println("inscritoCadeira");
        String nome = "";
        Dados instance = new Dados();
        boolean expResult = false;
        boolean result = instance.inscritoCadeira(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNota method, of class Dados.
     */
    @Test
    public void testAddNota() {
        System.out.println("addNota");
        String nomeUC = "";
        String titulo = "";
        String nota = "";
        Dados instance = new Dados();
        instance.addNota(nomeUC, titulo, nota);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHoraEstudo method, of class Dados.
     */
    @Test
    public void testAddHoraEstudo() {
        System.out.println("addHoraEstudo");
        String titulo = "";
        GregorianCalendar dataInicio = null;
        GregorianCalendar dataFim = null;
        Dados instance = new Dados();
        instance.addHoraEstudo(titulo, dataInicio, dataFim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeHoraEstudo method, of class Dados.
     */
    @Test
    public void testRemoveHoraEstudo() {
        System.out.println("removeHoraEstudo");
        String titulo = "";
        Dados instance = new Dados();
        instance.removeHoraEstudo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Dados.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int x = 0;
        Dados instance = new Dados();
        instance.setEstado(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Dados.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Dados instance = new Dados();
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
