package com.example.mypackage;

/*
 * P/Q(rational number) =if P(whole number) && Q(positive number)
 * */

public class Rational {

    private int numeratorP;
    private int denominatorQ;

    public Rational(int numer, int denom) {
       // Sets up the rational number by ensuring a nonzero
        if (denom == 0)
            denom = 1;

        // Make the numerator "store" the sign
        if (denom < 0) {
            numer = numer * -1;
            denom = denom * -1;
        }

        numeratorP = numer;
        denominatorQ = denom;

      //  reduce();
    }

    //  Returns the numerator of this rational number.
    public int getNumeratorP() {
        return numeratorP;
    }


    //  Returns the denominator of this rational number.
    public int getDenominatorQ() {
        return denominatorQ;
    }


    public boolean greaterThan(Rational numRational) {
        if ( (this.numeratorP * numRational.getDenominatorQ()) > (this.denominatorQ * numRational.getNumeratorP()) ){
            return true;
        }else {
            return false;
        }
    }

    public boolean equals(Rational numRational) {
        if ( (this.numeratorP * numRational.getDenominatorQ()) == (this.denominatorQ * numRational.getNumeratorP()) ){
            return true;
        }else {
            return false;
        }
    }

    public Rational plus(Rational numRational) {


        int commonDenominator =this.numeratorP * numRational.getDenominatorQ();
        int numerator1 = this.denominatorQ * numRational.getNumeratorP();
        int numerator2 = numRational.getDenominatorQ()*this.denominatorQ;
        int sum =  numerator1+numerator2;
        return new Rational (sum,commonDenominator);


    }

    public Rational minus(Rational numRational) {

        //return ( (this.numeratorP * numRational.getDenominatorQ()) - (this.denominatorQ * numRational.getNumeratorP()))/(numRational.getDenominatorQ()*this.denominatorQ) ;

        int commonDenominator =this.numeratorP * numRational.getDenominatorQ();
        int numerator1 = this.denominatorQ * numRational.getNumeratorP();
        int numerator2 = numRational.getDenominatorQ()*this.denominatorQ;
        int sum =  numerator1-numerator2;
        return new Rational (sum,commonDenominator);

    }

    public Rational multiplay(Rational numRational) {

        //return  (this.numeratorP * numRational.getNumeratorP())/(numRational.getDenominatorQ()*this.denominatorQ) ;

        int numer= this.numeratorP * numRational.getNumeratorP();
        int denom = numRational.getDenominatorQ()*this.denominatorQ;

        return new Rational (numer,denom);

    }

    public String toString(){

        String result;

        if (numeratorP == 0) {
            result = "0";
        }else {
        }if (denominatorQ == 1) {
            result = numeratorP + "";
        }else {
            result = numeratorP + "/" + denominatorQ;
        }
        return result;

    }


    //  Reduces this rational number by dividing both the numerator
    //  and the denominator by their greatest common divisor.

    public void reduce(){
        if (numeratorP != 0){
            int common = gcd (Math.abs(numeratorP), denominatorQ %numeratorP);

            numeratorP = numeratorP / common;
            denominatorQ = denominatorQ / common;
        }
    }

    //  Computes and returns the greatest common divisor of the two
    //  positive parameters. Uses Euclid's algorithm.
    private int gcd (int num1, int num2){
        while (num1 != num2)
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;

        return num1;
    }



}
