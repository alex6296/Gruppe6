/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.unit;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robertfrancisti
 */
public class UnitTest {
    
    
    Coordinate position;
    
    
    protected void setUp(){
        int value1 = 3; 
        int value2 = 3;
    }
    
    public UnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
          // TODO review the generated test code and remove the default call to fail.
    }
    
    @AfterClass
    public static void tearDownClass() {
          // TODO review the generated test code and remove the default call to fail.
    }
    
//    @Before
//    public void setUp() {  
//          // TODO review the generated test code and remove the default call to fail.
//    }
    
    @After
    public void tearDown() {
          // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNextStep method, of class Unit.
     */
    @org.junit.Test
    public void testGetNextStep() {
        System.out.println("getNextStep");
        Coordinate position = null;
        Unit instance = new Unit();
        Coordinate expResult = null;
        Coordinate result = instance.getNextStep(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of getFootprint method, of class Unit.
     */
    @org.junit.Test
    public void testGetFootprint() {
        System.out.println("getFootprint");
        Unit instance = new Unit();
        int[][] expResult = null;
        int[][] result = instance.getFootprint();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCurrentPosition method, of class Unit.
     */
    @org.junit.Test
    public void testGetCurrentPosition() {
        System.out.println("getCurrentPosition");
        Unit instance = new Unit(0, 0, instance.getFootprint(), 0, 0, 0, instance.getCurrentPosition());
        Coordinate expResult = null;
        Coordinate result = instance.getCurrentPosition();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCost method, of class Unit.
     */
    @org.junit.Test
    public void testGetCost() {
        System.out.println("getCost");
        Unit instance = null;
        instance = new Unit(10, 10,instance.getFootprint(), 10, 10, 10,instance.getCurrentPosition());
        int expResult = 10;
        int result = instance.getCost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setCurrentPosition method, of class Unit.
     */
    @org.junit.Test
    public void testSetCurrentPosition() {
        System.out.println("setCurrentPosition");
        Coordinate coord = null;
        Unit instance = new Unit();
        instance.setCurrentPosition(coord);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of attack method, of class Unit.
     */
    @org.junit.Test
    public void testAttack() {
        System.out.println("attack");
        List<IPlaceableEntity> targetList = null;
        Unit instance = new Unit();
        instance.attack(targetList);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getSpriteUrl method, of class Unit.
     */
    @org.junit.Test
    public void testGetSpriteUrl() {
        System.out.println("getSpriteUrl");
        Unit instance = new Unit();
        String expResult = "";
        String result = instance.getSpriteUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getMaxHp method, of class Unit.
     */
    @org.junit.Test
    public void testGetMaxHp() {
        System.out.println("getMaxHp");
        Unit instance = new Unit();
        int expResult = 0;
        int result = instance.getMaxHp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getCurrentHp method, of class Unit.
     */
    @org.junit.Test
    public void testGetCurrentHp() {
        System.out.println("getCurrentHp");
        Unit instance = new Unit();
        int expResult = 0;
        int result = instance.getCurrentHp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAttackSpeed method, of class Unit.
     */
    @org.junit.Test
    public void testSetAttackSpeed() {
        System.out.println("setAttackSpeed");
        int attackSpeed = 0;
        Unit instance = new Unit();
        instance.setAttackSpeed(attackSpeed);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
