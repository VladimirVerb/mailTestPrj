
import com.test.mail.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.test.mail.DriverConfig;
import com.test.mail.IndexPage;
import com.test.mail.User;

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
    private Data data;
    
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
        data = new Data();
        dc = new DriverConfig(data.GetHUB());
        ip = new IndexPage(dc.getDriver(),dc.getLog());
    }
 
    @After
    public void afterTest() {
        dc.destroyConfig();
        dc = null;
    }
 
    @Test
    public void SendMail() throws Exception {
        ip.login(data.InitUser()).createMail("vladimir_verb@yahoo.com", "Test", "Some data");
    }
 
}
