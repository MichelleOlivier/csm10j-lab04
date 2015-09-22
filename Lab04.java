//package lab04;
/**
 * @author Michelle
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class Lab04 {
     static DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = ("input.txt");
        Scanner infile = new Scanner(new FileReader(filename)) ;

        System.out.println("Input: " + infile.nextLine());
        System.out.println("Mean: " + df.format(computeMean(filename)));
        System.out.println("Standard Deviation: " + df.format(computeStandardDeviation(filename, computeMean(filename))));
    }
    
    public static double computeMean (String filename)throws FileNotFoundException
    {
        Integer readInteger= 0, integerCount = 0;
        double integerTotal = 0;
        Scanner infile = new Scanner(new FileReader(filename)) ;
        while (infile.hasNextInt())
        {
              readInteger = infile.nextInt();
              integerTotal = readInteger + integerTotal;
              integerCount++;
        }
        return (integerTotal/integerCount);
    }
    
    public static double computeStandardDeviation (String filename, double mean)throws FileNotFoundException
    {
        Integer readInteger= 0, integerCount = 0;
        double integerTotal = 0;
        Scanner infile = new Scanner(new FileReader(filename)) ;
        while (infile.hasNextInt())
        {
              readInteger = infile.nextInt();
              integerTotal = (readInteger - mean)*(readInteger - mean) + integerTotal;
              integerCount++;
        }
        return Math.sqrt(integerTotal/integerCount);
    }
}
