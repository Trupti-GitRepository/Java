package com.java.cmsc_203_Lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class GradeBook
{
   private double[] scores;
   private int scoresSize;
   
  /* public static void main(String[] args) {
	   GradeBook gB=new GradeBook(4);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.sum());	   
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());
	   
	   
	   gB.addScore(50);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.sum());
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());
	    gB.addScore(40);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());
	  gB.addScore(30);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());
	   gB.addScore(20);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());
	   gB.addScore(10);
	   System.out.println(gB.getScoreSize());
	   System.out.println(gB.toString());
	   System.out.println(gB.minimum());
	   System.out.println(gB.finalScore());}*/
	   
	   


   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   /** Returns scoresSize from the GradeBook
    * @return scoresSize
    */
   public int getScoreSize()
   {
	   	   
	return scoresSize;
	   
   }
  
   /**returns a string with each score in scores field of the Gradebook separated by a space.
    *
    * @param scores
    * @return 
    */
      public String toString()
   {
	   return(Arrays.toString(scores));
}
      public static void main(String[] args) {
		GradeBook g=new GradeBook(4);
		g.addScore(5.67);
		g.addScore(5.67);
		g.addScore(5.67);
		System.out.println(g.toString());;
		
	}
}
