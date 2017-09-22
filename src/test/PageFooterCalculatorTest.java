package test;

import main.PageFooterCalculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pacifist on 21-09-2017.
 */
public class PageFooterCalculatorTest extends PageFooterCalculator {
    private String result;

    @Override
    protected String convertVisiblePagesToString() {
        result = super.convertVisiblePagesToString();
        return result;
    }

    @Test
    public void extractBoundariesTest(){
        printPageFooter(0,5,1,0);

        Assert.assertEquals(2,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 5",result);
    }

    @Test
    public void firstExample(){
        printPageFooter(4,5,1,0);

        Assert.assertEquals(3,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(4));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 4 5",result);
    }

    @Test
    public void secondExample(){
        printPageFooter(4,10,2,2);

        Assert.assertEquals(8,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(3));
        Assert.assertTrue(visiblePages.contains(4));
        Assert.assertTrue(visiblePages.contains(5));
        Assert.assertTrue(visiblePages.contains(6));
        Assert.assertTrue(visiblePages.contains(9));
        Assert.assertTrue(visiblePages.contains(10));

        Assert.assertEquals("1 2 3 4 5 6 ... 9 10",result);
    }

    @Test
    public void currentNumberInMiddle(){
        printPageFooter(10,20,2,0);

        Assert.assertEquals(5,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(10));
        Assert.assertTrue(visiblePages.contains(19));
        Assert.assertTrue(visiblePages.contains(20));

        Assert.assertEquals("1 2 ... 10 ... 19 20",result);
    }

    @Test
    public void currentNumberInCorner(){
        printPageFooter(1,5,1,0);

        Assert.assertEquals(2,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 5",result);
    }

    @Test
    public void currentNumberInMiddleWithAround(){
        printPageFooter(10,20,2,2);

        Assert.assertEquals(9,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(8));
        Assert.assertTrue(visiblePages.contains(9));
        Assert.assertTrue(visiblePages.contains(10));
        Assert.assertTrue(visiblePages.contains(11));
        Assert.assertTrue(visiblePages.contains(12));
        Assert.assertTrue(visiblePages.contains(19));
        Assert.assertTrue(visiblePages.contains(20));

        Assert.assertEquals("1 2 ... 8 9 10 11 12 ... 19 20",result);
    }

    @Test
    public void currentNumberNegative(){
        printPageFooter(-1,5,1,0);

        Assert.assertEquals(2,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 5",result);
    }

    @Test
    public void currentNumberBigger(){
        printPageFooter(6,5,1,0);

        Assert.assertEquals(2,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 5",result);
    }

    @Test
    public void showAllNumbers(){
        printPageFooter(3,5,2,2);

        Assert.assertEquals(5,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(3));
        Assert.assertTrue(visiblePages.contains(4));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 2 3 4 5",result);
    }

    @Test
    public void aroundBiggerThenTotalSize(){
        printPageFooter(3,5,0,6);

        Assert.assertEquals(5,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(3));
        Assert.assertTrue(visiblePages.contains(4));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 2 3 4 5",result);
    }

    @Test
    public void boundariesBiggerThenTotalSize(){
        printPageFooter(3,5,6,0);

        Assert.assertEquals(5,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(2));
        Assert.assertTrue(visiblePages.contains(3));
        Assert.assertTrue(visiblePages.contains(4));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 2 3 4 5",result);
    }

    @Test
    public void currentAndAroundNegative(){
        printPageFooter(-1,5,1,-1);

        Assert.assertEquals(2,visiblePages.size());
        Assert.assertTrue(visiblePages.contains(1));
        Assert.assertTrue(visiblePages.contains(5));

        Assert.assertEquals("1 ... 5",result);
    }
}
