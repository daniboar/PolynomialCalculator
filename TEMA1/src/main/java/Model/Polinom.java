package Model;

import java.util.HashMap;
import java.util.Map;

public class Polinom {
    private Map<Integer, Double> polinom;
    private int grad;
    private double coef;

    //constructor pentru initializarea polinomului
    public Polinom() {
        super();
        this.polinom = new HashMap<Integer, Double>();
    }

    public Map<Integer, Double> getPolinom() {
        return this.polinom;
    }

    //metoda care ne returneaza gradul maxim al unui polinom
    public int getGradMax() {
        int gradMax = 0;
        for (int i : this.polinom.keySet()) {
            gradMax = i;
        }
        return gradMax;
    }

    //metoda care ne returneaza coeficientul gradului "grad" din polinom
    public double getCoef(int grad) {
        if(this.polinom.get(grad) == null)
            return 0;
        else
             return this.polinom.get(grad);
    }

    //metoda care ne adauga un monom in polinomul nostru
    public void addMonom(int grad, double coef) {
        if (this.polinom.containsKey(grad)) {
            double coef_v = this.polinom.get(grad);
            double coef_n = coef_v + coef;
            if (coef_n == 0) {
                this.polinom.remove(grad);
            } else {
                this.polinom.put(grad, coef_n);
            }
        } else
            this.polinom.put(grad, coef);
    }

    //metoda de toString pentru afisarea polinomului
    public String toString() {
       String s = "";
        int gradMax = getGradMax();
        for(int i = gradMax; i >= 0; i-- ) {
            double coef = getCoef(i);
            if(coef !=0){
                if(s.length() > 0){
                    if(coef > 0){
                        s +="+";}
                }
                if(i == 0){
                    s += coef;
                }else if(i == 1){
                    if(coef == 1){
                        s += "x";
                    }else if(coef == -1){
                        s += "-x";}
                    else{
                        s += coef + "*x";
                    }
                }else{
                    if(coef == 1){
                        s += "x^" + i;
                    }else if(coef == -1){
                        s += "-x^" + i;
                    }
                    else{
                        s += coef + "*x^" + i;
                    }
                }
            }
        }
        if(s.length() == 0)
            s = "0";
        return s;
    }
}
