
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.test.mail.DriverConfig;
import com.test.mail.IndexPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class IndexPageTest {
    private IndexPage ip;
    private DriverConfig dc;
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }
 
    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }
 
    @Before
    public void initTest() {
        dc = new DriverConfig();
        ip = new IndexPage(dc.getDriver(),dc.getLog());
    }
 
    @After
    public void afterTest() {
        dc.destroyConfig();
        dc = null;
    }
 
    @Test
    public void SendMail() throws Exception {
        ip.login("tmp", "tmp1");
        ip.createMail("vladimir_verb@yahoo.com", "Test", "Some data");
        //assertEquals(15, calculator.getSum(7,8));
    }
 
}
