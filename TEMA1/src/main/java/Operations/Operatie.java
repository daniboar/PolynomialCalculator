package Operations;

import Model.Polinom;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatie {
    public Operatie(){
    }

    //metoda de adunare a 2 polinoame
    public static Polinom add(Polinom p1, Polinom p2){
        Polinom p = new Polinom();
        double coef;
        int gradMax;
        if(p1.getGradMax() >= p2.getGradMax())
            gradMax = p1.getGradMax();
        else
            gradMax = p2.getGradMax();
        for(int i=0;i<=gradMax;i++){
            coef = p1.getCoef(i) + p2.getCoef(i);
            p.addMonom(i,coef);
        }
        return p;
    }

    //metoda de scadere a 2 polinoame
    public static Polinom sub(Polinom p1, Polinom p2){
        Polinom p = new Polinom();
        double coef;
        int gradMax;
        if(p1.getGradMax() >= p2.getGradMax())
            gradMax = p1.getGradMax();
        else
            gradMax = p2.getGradMax();
        for(int i=0;i<=gradMax;i++){
            coef = p1.getCoef(i) - p2.getCoef(i);
            p.addMonom(i,coef);
        }
        return p;
    }

    //metoda de inmultire a 2 polinoame
    public static Polinom mul(Polinom p1, Polinom p2){
        Polinom p = new Polinom();
        double coef;
        int grad;
        for(int i: p1.getPolinom().keySet()){
            for(int j:p2.getPolinom().keySet()){
                grad = i + j;
                if(p.getPolinom().get(grad) != null){
                    double coef_v = p.getCoef(grad);
                    coef = p1.getCoef(i) * p2.getCoef(j);
                    p.getPolinom().put(grad, coef + coef_v);
                }
                else{
                    coef = p1.getCoef(i) * p2.getCoef(j);
                    p.getPolinom().put(grad, coef);
                }
            }
        }
        return p;
    }

    //metoda de impartire a 2 polinoame (nu este implementata)
    public static Polinom div(Polinom p1, Polinom p2){
        Polinom p = new Polinom();
        return p;
    }

    //metoda de derivare a unui polinom
    public static Polinom derivate(Polinom p1){
        Polinom p = new Polinom();
        for(int i: p1.getPolinom().keySet()) {
            double coef = p1.getCoef(i);
            if (i > 0) {
                p.addMonom(i - 1, i * coef);
            }
        }
        return p;
    }

    //metoda de integrare a unui polinom
    public static Polinom integrate(Polinom p1){
        Polinom p = new Polinom();
        DecimalFormat df = new DecimalFormat("#.##"); // formatul rezultatului
        for(int grad: p1.getPolinom().keySet()){
            double coef = p1.getCoef(grad);
            p.addMonom(grad+1,Double.valueOf(df.format(coef/(grad+1)))); //afisez cu 2 zecimale un double
        }
        return p;
    }

    //metoda de conversie a unui String intr-un polinom folosind regex
    public static Polinom convert(String s){
        Polinom polynomial = new Polinom();
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)?\\*?x(\\^(\\d+))?|([-+]?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String coeficient = matcher.group(1);
            String grad = matcher.group(3);
            String constanta = matcher.group(4);
            if (coeficient != null || grad != null) {//daca nu avem termen liber
                double coef = (coeficient == null || coeficient.equals("") || coeficient.equals("+")) ? 1.0 : (coeficient.equals("-") ? -1.0 : Double.parseDouble(coeficient));
                int exp = (grad == null || grad.equals("")) ? 1 : Integer.parseInt(grad);

                if (polynomial.getPolinom().get(exp) != null) {
                    polynomial.addMonom(exp, polynomial.getCoef(exp) + coef);
                } else {
                    polynomial.addMonom(exp, coef);
                }
            } else if (constanta != null) {//daca avem termenul liber
                double constCoeff = Double.parseDouble(constanta);
                if (polynomial.getPolinom().get(0) != null) {
                    polynomial.addMonom(0, polynomial.getCoef(0) + constCoeff);
                } else {
                    polynomial.addMonom(0, constCoeff);
                }
            }
        }
        return polynomial;
    }
}
