package com.cg.bam.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountService;
import com.cg.bam.service.BankAccountServiceImpl;

public class TestClassJPA {

	
    
    @Test
    public void test_validateName_v1() throws BankAccountException{
    
        String name="Akhi121";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateName_v2() throws BankAccountException{
    
        String name="Akhil";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateName_v3() throws BankAccountException{
    
        String name="akhil";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    
    @Test
    public void test_validateMobNo_v1() throws BankAccountException{
    
        String mobNo="ABCD91828288";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateMobNo_v2() throws BankAccountException{
    
        String mobNo="9922974725";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateMobNo_v3() throws BankAccountException{
    
        String mobNo="992297";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateMobNo_v4() throws BankAccountException{
    
        String mobNo="012992297";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }

}
