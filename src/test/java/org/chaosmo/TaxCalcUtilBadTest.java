package org.chaosmo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TaxCalcUtilBadTest {

    @Test
    public void badDemoforTest() {
        TaxCalcUtil taxCalcUtil = new TaxCalcUtil();
        OrderInfo orderInfo = new OrderInfo(2999);
        double ret1 = taxCalcUtil.calc(orderInfo);
        assertEquals(89.97, ret1, 2);

        OrderInfo orderInfo2 = new OrderInfo(12001);
        double ret2 = taxCalcUtil.calc(orderInfo2);
        assertEquals(990.2, ret2, 2);


        List<Integer> inputs = Arrays.asList(2999, 12001);
        List<Double> expects = Arrays.asList(89.97, 990.2);
        for (int i = 0; i < inputs.size(); ++i) {
            OrderInfo orderInfo3 = new OrderInfo(inputs.get(i));
            double ret3 = taxCalcUtil.calc(orderInfo3);
            assertEquals(expects.get(i), ret3, 2);
        }

    }

}