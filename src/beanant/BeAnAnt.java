/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanant;

/**
 * A little program that gives stats if you were an ant.
 * @author Ryan Cabanas
 */
public class BeAnAnt {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Person ryan = new Person("Ryan", 165, 5, 11);
    Person marcy = new Person("Marcy", 98, 5, 1);
    Person georgia = new Person("Georgia", 42, 44);
    
    IfIWasAnAnt.printAntStats(ryan);
    IfIWasAnAnt.printAntStats(marcy);
    IfIWasAnAnt.printAntStats(georgia);
    
  }
}

/**
 * Represents a person.
 * @author Ryan Cabanas
 */
class Person {
  final String name;
  final int weight;
  final int heightFeet;
  final int heightInches;
  final int heightAllInches;
  
  //Constructors
  Person(String name, int weight, int heightFeet, int heightInches) {
    this.name = name;
    this.weight = weight;
    this.heightFeet = heightFeet;
    this.heightInches = heightInches;
    this.heightAllInches = calculateHeightAllInches(heightFeet, heightInches);
  }
  
  Person(String name, int weight, int heightAllInches) {
    this.name = name;
    this.weight = weight;
    this.heightFeet = calculateHeightFeet(heightAllInches);
    this.heightInches = calculateHeightInches(heightAllInches);
    this.heightAllInches = heightAllInches;
  }
  
  //Helper methods
  final int calculateHeightFeet(int heightAllInches) {
    return heightAllInches / 12;
  }
  
  final int calculateHeightInches(int heightAllInches) {
    return heightAllInches - (calculateHeightFeet(heightAllInches) * 12);
  }
  
  final int calculateHeightAllInches(int heightFeet, int heightInches) {
    return (heightFeet * 12) + heightInches;
  }
}

/**
 * Provides information about a person if they were an ant.
 * @author Ryan Cabanas
 */
class IfIWasAnAnt {
  /**
   * Prints overall ant stats for a person.
   * @param person A {@code Person} class object.
   */
  static void printAntStats(Person person) {
    int antStrength = getAntStrength(person.weight);
    String antMilePace = getAntMilePace(person.heightAllInches);
    System.out.println("If " + person.name + " was an ant...");
    System.out.println(person.name + " could lift at least "
            + IfIWasAnAnt.getAntStrength(person.weight) + " pounds.");
    System.out.println(person.name + " could run a mile in "
            + IfIWasAnAnt.getAntMilePace(person.heightAllInches) + ".");
    System.out.println();            
  }
  
  /**
   * 
   * @param weight The weight in pounds of a {@code Person}.
   * @return How much a {@code Person} could lift, in pounds, if they were an ant.
   */
  static int getAntStrength(int weight) {
    return weight * 10;
  }
  
  /**
   * 
   * @param heightAllInches The height of someone in inches.
   * @return How fast someone could run 1 mile if they were an ant.
   */
  static String getAntMilePace(int heightAllInches) {
    long antInchesPerMinute = getAntInchesPerMinute(heightAllInches);
    return calculatePace(antInchesPerMinute);
  }
  
  /**
   * Helper method.
   * @param heightAllInches The height of someone in inches.
   * @return The distance someone could run, in inches, if they were an ant.
   */
  static long getAntInchesPerMinute(long heightAllInches) {
    return heightAllInches * 800;
  }
  
  /**
   * 
   * @param inchesPerMinute How many inches per minute someone is able to run.
   * @return A {@code String} formatted in "minutes:seconds", which is the subject's mile pace. 
   */
  static String calculatePace(long inchesPerMinute) {
    final long mileInInches = 63360;
    double pace = (double) mileInInches / inchesPerMinute;
    int minutes = (int) pace;
    double fractionSeconds = pace % minutes;
    int seconds = (int) (60 * fractionSeconds);
    return String.format("%d:%02d", minutes, seconds);
  }
}
