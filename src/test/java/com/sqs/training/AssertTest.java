package com.sqs.training;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class AssertTest {

    @Test
    public void assertTest(){
        Integer i = 100;


        assertTrue(1==1);



         assertThat(i, equalTo(100));
    }
}
