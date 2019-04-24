/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.towerfactory;

import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.tower.Tower;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class towerFactoryTest {

    public towerFactoryTest() {

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
     * Test of getNewTower method, of class towerFactory.
     */
    @Test
    public void testGetNewTower() {
        System.out.println("getNewTower");
        
        towerFactory instance = new towerFactory();
        ITower result = instance.getNewTower();
        
        boolean expResult = false;
        if (result instanceof Tower) {
            expResult = true;
        }

        assertEquals(expResult, true);
        // TODO review the generated test code and remove the default call to fail.
    }
}
