package test;

import MyApp.MyApp;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MyAppTest {

    @Test
    public void loadData1999Test(){
        MyApp app = new MyApp("1999");
        try {
            int sum = app.loadData(0);
            Assert.assertEquals(sum,421);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void loadData2000Test(){
        MyApp app = new MyApp("2000");
        try {
            int sum = app.loadData(0);
            Assert.assertEquals(sum,100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
