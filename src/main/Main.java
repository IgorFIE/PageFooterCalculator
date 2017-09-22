package main;

/**
 * Created by pacifist on 22-09-2017.
 */
public class Main {

    public static void main(String[] args) {
        PageFooterCalculator pageFooterCalculator  = new PageFooterCalculator();
        pageFooterCalculator.printPageFooter(4,5,1,0);
        pageFooterCalculator.printPageFooter(4,10,2,2);

        pageFooterCalculator.printPageFooter(0,5,1,0);
        pageFooterCalculator.printPageFooter(10,20,2,0);
        pageFooterCalculator.printPageFooter(1,5,1,0);
        pageFooterCalculator.printPageFooter(10,20,2,2);
        pageFooterCalculator.printPageFooter(-1,5,1,0);
        pageFooterCalculator.printPageFooter(6,5,1,0);
        pageFooterCalculator.printPageFooter(3,5,2,2);
        pageFooterCalculator.printPageFooter(3,5,0,6);
        pageFooterCalculator.printPageFooter(3,5,6,0);
        pageFooterCalculator.printPageFooter(-1,5,1,-1);
    }

}
