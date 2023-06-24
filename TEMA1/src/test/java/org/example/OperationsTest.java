package org.example;

import Model.Polinom;
import Operations.Operatie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest  {
    public Polinom p1;
    public Polinom p2;
    public Polinom p3;

    public OperationsTest(){
        Polinom pol1 = new Polinom();
        Polinom pol2 = new Polinom();
        Polinom pol3 = new Polinom();
        pol1.addMonom(2,2.0);
        pol1.addMonom(1,-1.0);
        pol1.addMonom(0,2.0);
        p1 = pol1; //2x^2-x+2

        pol2.addMonom(2, -1.0);
        pol2.addMonom(1,2.0);
        pol2.addMonom(0,-3.0);
        p2 = pol2; //-x^2+2x-3

        pol3.addMonom(4, 1);
        pol3.addMonom(3,5.0);
        pol3.addMonom(1,-2.0);
        pol3.addMonom(0,7);
        p3 = pol3; //x^4+5x^3-2x+7
    }
    @Test
    public void addTest(){ //test pt adunarea a 2 polinoame
        assertEquals(Operatie.add(p3,p2).toString(),"x^4+5.0*x^3-x^2+4.0");
    }

    @Test
    public void subTest(){ //test pt scaderea a 2 polinoame
        assertEquals(Operatie.sub(p1,p2).toString(),"3.0*x^2-3.0*x+5.0");
    }

    @Test
    public void mulTest(){ //test pt inmultirea a 2 polinoame
        assertEquals(Operatie.mul(p1,p2).toString(), "-2.0*x^4+5.0*x^3-10.0*x^2+7.0*x-6.0");
    }

   // @Test
    //public void divTest(){
        //nu este implementata operatia de impartire :)
    //}

    @Test
    public void derivativeTest(){ //test pt derivarea unui polinom
        assertEquals(Operatie.derivate(p3).toString(), "4.0*x^3+15.0*x^2-2.0" );
    }

    @Test
    public void integrateTest(){ //test pt integrarea unui polinom
        assertEquals(Operatie.integrate(p3).toString(), "0.2*x^5+1.25*x^4-x^2+7.0*x");
    }
}
