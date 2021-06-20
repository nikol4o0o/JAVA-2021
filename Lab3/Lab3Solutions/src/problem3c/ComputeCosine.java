package problem3c;

public class ComputeCosine {
    private double epsilon;
    // 0 < epsilon < 1;
    // values as 0.001 guarantee approx. solution for cos(x) up to 2 digits equal to the exact value for cos(x)
    // similarly,
    // values as 0.00001 guarantee approx. solution for cos(x) up to 4 digits equal to the exact value for cos(x)
    public ComputeCosine(double epsilon) {
        setEpsilon(epsilon);
    }

    public double getEpsilon() {
        return epsilon;
    }

    // Validate! x is defined from Double.MIN_VALUE, DOUBLE.MAX_VALUE
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon <= Double.MAX_VALUE && epsilon >= Double.MIN_VALUE? epsilon: 0.0 ;
    }

    public double  computeCos(double x){
        // To Do
        // declarations
        double sum; // sum of terms
        double term;  // single term of series expansion   
        int counter ; // term sequence

        // initialization
        sum = 1;
        term = 1;
        counter = 1;
        
        // processing
        do { // reuse result from the previous iteration
            term = -term * x * x / ((2 * counter) * (2 *counter -1));
            sum += term;
            counter++;
        } while (Math.abs(term) > epsilon);
        // output
        return sum;
    }
 
}
