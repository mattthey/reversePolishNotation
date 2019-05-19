package main;

import org.junit.Assert;

public class MainTest
{
    @org.junit.Test
    public void main()
    {
        try {
            Class.forName("main.Main");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Main");
        }
    }
}
