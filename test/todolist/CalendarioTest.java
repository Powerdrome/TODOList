/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorgetrovisco
 */
public class CalendarioTest {
    
    public CalendarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("setUp");
    }
    
    @After
    public void tearDown() {
        System.out.println("setUp");
    }
    /**
     * Test of setCadeiras method, of class Calendario.
     */
    @Test
    public void testSetGetCadeiras() {
        System.out.println("set&getCadeiras");
        Calendario instance = new Calendario();
        
        ArrayList<UnidadeCurricular> cadeiras = new ArrayList<>();
        cadeiras.add(new UnidadeCurricular("Teste", 1, 1));
        cadeiras.add(new UnidadeCurricular("Teste", 2, 1));
        
        instance.setCadeiras(cadeiras);
        //---^^---\\
        ArrayList<UnidadeCurricular> expResult = new ArrayList<>();
        expResult.add(new UnidadeCurricular("Teste", 1, 1));
        expResult.add(new UnidadeCurricular("Teste", 2, 1));
        
        ArrayList<UnidadeCurricular> result = instance.getCadeiras();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addCadeira method, of class Calendario.
     */
    @Test
    public void testAddCadeira() {
        System.out.println("addCadeira");
        UnidadeCurricular cadeira = new UnidadeCurricular("Teste", 1, 2);
        ArrayList<UnidadeCurricular> expResult = new ArrayList<>();
        expResult.add(cadeira);
        Calendario instance = new Calendario();
        instance.addCadeira(cadeira);
        ArrayList<UnidadeCurricular> result = instance.getCadeiras();
        assertEquals(expResult, result);
    }

    /**
     * Test of addHoraEstudo method, of class Calendario.
     */
    @Test
    public void testAddGetHoraEstudo() {
        Calendario instance = new Calendario();
        ArrayList<HoraEstudo> expResult = new ArrayList<>();
        expResult.add(new HoraEstudo("TesteEstudo"));
        
        System.out.println("add&GetHoraEstudo");
        
        instance.addHoraEstudo(expResult.get(0));
        //---^^---\\
        System.out.println("getHorasEstudo");
        
        ArrayList<HoraEstudo> result = instance.getHorasEstudo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHoras method, of class Calendario.
     */
    @Test
    public void testGetHoras() {
        HoraEstudo he = new HoraEstudo("TesteEstudo");
        he.setInicio(2016, 12, 10, 10, 0);
        he.setFim(2016, 12, 10, 15, 0);
        UnidadeCurricular cadeira = new UnidadeCurricular("Teste", 1, 2);
        HoraAula ha = new HoraAula(1, "L1.2", 1, "");
        try {
            ha.setInicio("10/12/2016 10:00");
            ha.setFim("10/12/2016 13:00");
        } catch (ParseException ex) {
            Logger.getLogger(CalendarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadeira.addAula(ha);
        
        
        System.out.println("getHoras");
        Calendario instance = new Calendario();
        instance.addCadeira(cadeira);
        instance.addHoraEstudo(he);
        
        ArrayList<Hora> expResult = new ArrayList<>();
        expResult.add(new Hora(cadeira.getNome(), cadeira.getAulas().get(0).getInicio(), cadeira.getAulas().get(0).getFim()));
        expResult.add(new Hora(he.getTitulo(), he.getInicio(), he.getFim()));
        
        ArrayList<Hora> result = instance.getHoras();
        assertEquals(expResult, result);
    }
    
}
