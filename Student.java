//package dev.m3s.programming2.homework1;
import java.util.Random;
import java.util.Scanner;

public class Student {
    
    private Scanner sc = new Scanner(System.in);
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private double bachelorCredits;
    private double masterCredits;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
    private int startYear = 2023;
    private int graduationYear;
    private int randomId;

    public Student(final String lname, final String fname){
        if(fname!=null){this.firstName = fname;} else {this.firstName=ConstantValues.NO_NAME;}
        if(lname!=null){this.lastName = lname;} else {this.lastName=ConstantValues.NO_NAME;}
        this.randomId = getRandomId();
        this.bachelorCredits = getBachelorCredits();
        this.masterCredits = getMasterCredits();
        this.titleOfBachelorThesis = getTitleOfBachelorThesis();
        this.titleOfMastersThesis = getTitleOfMastersThesis();
        this.startYear = getStartYear();
        this.graduationYear = getGraduationYear();
    }

    public Student(){
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.randomId = getRandomId();
        this.bachelorCredits = getBachelorCredits();
        this.masterCredits = getMasterCredits();
        this.titleOfBachelorThesis = getTitleOfBachelorThesis();
        this.titleOfMastersThesis = getTitleOfMastersThesis();
        this.startYear = getStartYear();
        this.graduationYear = getGraduationYear();
    }

    public void setFirstName(String etunimi){
        if(firstName == ConstantValues.NO_NAME){
            if (etunimi == null) {
                this.firstName = ConstantValues.NO_NAME;
            } else {
                this.firstName = etunimi;
            }
        }
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String sukunimi){
        if(lastName == ConstantValues.NO_NAME){
            if (sukunimi == null) {
                this.lastName = ConstantValues.NO_NAME;
            } else {
                this.lastName = sukunimi;
            }
        }
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setId(final int id_joku){
        if (id_joku<=ConstantValues.MAX_ID && id_joku>=ConstantValues.MIN_ID) {
            this.id = id_joku;
        }
    }

    public int getId(){
        return this.id;
    }

    public void setBachelorCredits(final double bachelorCreditit){
        if (bachelorCreditit>=ConstantValues.MIN_CREDIT && bachelorCreditit<=ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCreditit;
        }
    }

    public double getBachelorCredits(){
        return this.bachelorCredits;
    }

    public void setMasterCredits(final double masterCreditit){
        if (masterCreditit<=ConstantValues.MAX_CREDITS && masterCreditit>=ConstantValues.MIN_CREDIT) {
            this.masterCredits = masterCreditit;
        }
    }

    public double getMasterCredits(){
        return this.masterCredits;
    }

    public void setTitleOfBachelorThesis(String title1){
        if (title1 != null) {
            this.titleOfBachelorThesis = title1;
        }
    }

    public String getTitleOfBachelorThesis(){
        return this.titleOfBachelorThesis;
    }

    public void setTitleOfMastersThesis(String title2){
        if (title2 != null) {
            this.titleOfMastersThesis = title2;
        }
    }

    public String getTitleOfMastersThesis(){
        return this.titleOfMastersThesis; 
    }

    public void setStartYear(final int vuosi){
        if (vuosi<=2023 && vuosi>=2001) {
            this.startYear = vuosi;
        }
    }

    public int getStartYear (){
        return this.startYear;
    }

    public String setGraduationYear(final int valmistumisvuosi){
        
        if (canGraduate() == false) {
            return "Check the required studies";
        }
        if (2023<valmistumisvuosi || valmistumisvuosi<startYear) {
            return "Check graduation year";
        } 
        else {
            this.graduationYear = valmistumisvuosi;
            return "Ok";
        }
    }

    public int getGraduationYear(){
        return this.graduationYear;
    }

    public boolean hasGraduated(){
        if (graduationYear<=2023 && canGraduate()==true && graduationYear>2000) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean canGraduate(){
        if (bachelorCredits>=ConstantValues.BACHELOR_CREDITS && masterCredits>=ConstantValues.MASTER_CREDITS && titleOfBachelorThesis!=null && titleOfMastersThesis!=null && titleOfBachelorThesis!=ConstantValues.NO_TITLE && titleOfMastersThesis!=ConstantValues.NO_TITLE) {
            return true;
        }
        else{
            return false;
        }
    }

    public int getStudyYears(){
        if (hasGraduated() == true) {
            return graduationYear - startYear;
        } else {
            return 2023-startYear;
        }
    }

    private int getRandomId(){
        Random randId = new Random();
        return id = randId.nextInt(100) + 1;
    }

    public String onkoValmistunut(){
        if (hasGraduated()==true) {
            return "The student has graduated in " + graduationYear;
        }
        else{
            return  "The student has not graduated, yet.";
        }
    }

    public String toString(){
        return "\n" + "Student id: " + id +"\n"+ "\tFirstName: " + firstName +", " + "LastName: " + lastName + "\n\tStatus: " + onkoValmistunut() + "\n\tStartYear: "+ startYear + " (studies have lasted for " + (2023-startYear) + " years)" + "\n\t" + "BachelorCredits: " + bachelorCredits +"\n\t"+ "MasterCredits: " + masterCredits +"\n\t"+ "TitleOfMasterThesis: " + titleOfMastersThesis +"\n\t"+ "TitleOfBachelorThesis: " + titleOfBachelorThesis +"\n";
    }
}