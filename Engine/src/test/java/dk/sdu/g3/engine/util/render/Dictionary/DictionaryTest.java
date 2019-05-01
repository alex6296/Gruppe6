/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.Coordinate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class DictionaryTest {

    public DictionaryTest() {
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
     * Test of search method, of class Dictionary.
     */
    @Test
    public void testSearch() {
        System.out.println("insert");
        Coordinate center = new Coordinate(5, 5);
        int size = 1;
        int foodprint = 1;
        Object expResult = new Object();
        Dictionary instance = new Dictionary();
        instance.insert(center, size, foodprint, expResult);

        System.out.println("search");
        Coordinate target = new Coordinate(5, 5);
        Object result = instance.search(target);

        assertEquals(expResult, result);

    }

}
