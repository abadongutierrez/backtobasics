import java.util.*;

public class Factorizer {

    private List<Integer> factors = new ArrayList<Integer>();
    private Iterator<Integer> primesIterator;

    public void factorize(Integer number) {
        primesIterator = getPrimesIterator();
        factors.clear();
        innerFactorize(number, primesIterator.next());
    }

    private void innerFactorize(Integer number, Integer k) {
        if (isPrime(number)) return;
        Integer n = number;
        while (n % k == 0) {
            this.factors.add(k);
            if (isPrime(n / k)) {
                this.factors.add(n/k);
                return;
            }
            n = n / k;
            System.out.println("Adding factor [" + k + "], [" + n + "]");
        }
        innerFactorize(n, primesIterator.next());
    }

    private Iterator getPrimesIterator() {
        //Integer[] primesArray = new Integer[]{2,3,5,7,11,19};
        //return Arrays.asList(primesArray).iterator();
        PrimesIterator pi = new PrimesIterator();
        return pi;
    }

    public List<Integer> getFactors() {
        return this.factors;
    }

    private boolean isPrime(Integer number) {
        Integer[] primesArray = new Integer[]{2,3,5,7,11,19};
        return Arrays.asList(primesArray).contains(number); 
    }

    public static void main(String[] args) {
        Factorizer f = new Factorizer();
        f.factorize(2394);
        List<Integer> factors = f.getFactors();
        System.out.println(factors);
        Integer r = 1;
        for (Integer factor : factors) {
            r *= factor;
        }
        System.out.println(r);
    }
}