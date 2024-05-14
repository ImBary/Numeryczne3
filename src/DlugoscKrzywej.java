import java.util.function.DoubleUnaryOperator;

public class DlugoscKrzywej {
    double Xp ; 
    double Xk;
    int n;
    public DlugoscKrzywej(double Xp, double Xk, int n){
        this.Xp = Xp;
        this.Xk = Xk;
        this.n  = n;
    }

    private double lenOfSection(){
        return (Xk - Xp) / n;
    }

    // x1,x2,y1,y2 kordynaty do liczenia dlugosci
    public double calculateLen(DoubleUnaryOperator function,DoubleUnaryOperator derivativeFunction){
        double len = lenOfSection();
        double s = 0.0;
        double x1, y1; 
        
        for(int i = 0; i < n; i++){
            x1 = Xp + i * len; //              \
            //                                  K(x)
            y1 = function.applyAsDouble(x1);//  /
            System.out.println("x "+y1);
            System.out.println("x' "+derivativeFunction.applyAsDouble(y1));
            
            double lk = Math.sqrt(1 + Math.pow(derivativeFunction.applyAsDouble(y1),2));
            s+=lk;
        }
    
        return s;
    }
}
