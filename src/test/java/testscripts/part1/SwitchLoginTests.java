package testscripts.part1;


import base.TestBase;
import org.testng.annotations.Test;

import pages.SwitchLoginpage;


public class SwitchLoginTests  extends TestBase {


    public SwitchLoginTests() {
        super (driver);
    }

    @Test
    public void login() throws Exception{

        SwitchLoginpage login = new SwitchLoginpage (driver);
        log.info("user can log in");
        login.login(data.getProperty("base.user"),data.getProperty("base.pass"));
        //Assert.assertTrue(true);
    }
}