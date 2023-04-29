/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymProject;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
*This class is to stor the clients information 
* @author seere
* @author judeanddana
*/
public class member  {

public String name;
public String phone;
public int[] entryDate=new int[3];
private int[]expirationDate=new int[3];

private int duration;  
private int age;
private int price;

    



//-------------------------------------------------------------------------

/**
 * default constructor
 */
public member()
{
    this.name="";
    this.phone="";
    
    this.duration=0;
    this.age=0;
    this.price=0;
   
}


/**
 * constructor 
 * @param name of the member
 * @param age of the member
 * @param phone of the member
 * @param health_p health problem of the member
 * @param duration the duration of the membership of the member
 * @param day of entry date
 * @param month of entry date
 * @param year of entry date
 * @throws IOException 
 */
public member(String name,int age,String phone,int duration
,int day,int month,int year)
{
    this.name=name;
    this.age=age;
    this.phone=phone;
  
    this.duration=duration;
    entryDate[0]=day;
    entryDate[1]=month;
    entryDate[2]=year;
    setExpirationDate();
    setPrice(duration);
    //setId();
}

/**
 * copy constructor
 * @param member 
 */
public member( member member)
    {
        this.name  = member.name;
        this.age = member.age;
        this.phone = member.phone;
  
        this.duration = member.duration;
        this.entryDate = member.entryDate;
        this.expirationDate=member.expirationDate;
       // Id=member.Id;  
    }


/**
 * setAge method
 * @param age of the client
 */
public void setAge(int age)
{
    this.age=age;
}

/**
 * getAge method
 * @return the age of the client
 */
public int getAge()
{
    return age;
}

/**
 * setDuration method
 * @param months 
 */
public void setDuration(int months)
{
    duration=months;
    setPrice(duration);
}

/**
 * getDuration method
 * @return the duration of membership
 */
public int getDuration()
{
    return duration;
}

/**
 * setHealthProblems method
 * @param health problems
 */


/**
 * getHealthProblems method
 * @return the health problems
 */


/**
 * setPrice method
 * @param duration 
 */
public void setPrice(int duration)
{
    if (duration==3)
        price=2225;
    else if(duration==6)
        price=3650;
    else
        price=5975;
}

/**
 * getPrice method
 * @return the price
 */
public String getPrice()
{
    return(price+" SR");
}

//required in tostring and addtofile
/**
 * getEntryDate method
 * @return the entry date
 */
public String getEntryDate()
{
    String EntryDate = (entryDate[0]+ " / "+entryDate[1]+" / "+entryDate[2]);
    return EntryDate;
}

/**
 * setExpirationDate method
 * this method is to set the expiration date
 */
public void setExpirationDate()
{
    int YearEntryDate = entryDate[2];
    int MonthEntryDate = entryDate[1];
    
    
    
    expirationDate[0] = entryDate[0];
    switch(duration)
    {
        case 3:
        if(entryDate[1]<10)
        {
            expirationDate[1]= MonthEntryDate+3;
            expirationDate[2]= YearEntryDate;
        }
        else 
        {          
            expirationDate[2]= ++YearEntryDate;
            if (entryDate[1]==10)
            {
                expirationDate[1] = 1;                
            }
            else if (entryDate[1]==11)
            {
                expirationDate[1] = 2;
            }            
            else  if(entryDate[1]==12)
            {
                expirationDate[1] = 3;
            }    
        }
        break;



        case 6:
            if(entryDate[1]<7)
            {
                expirationDate[1]= MonthEntryDate+6;
                expirationDate[2]= YearEntryDate;
            }
            else
            {          
                expirationDate[2]= ++YearEntryDate;
                if (entryDate[1]==7)
                {
                    expirationDate[1]=1;                
                }
                else if (entryDate[1]==8)
                {
                    expirationDate[1]=2;
                }            
                else  if(entryDate[1]==9)
                {
                    expirationDate[1]=3;
                }  
                else  if(entryDate[1]==10)
                {
                    expirationDate[1]=4;
                }   
                else  if(entryDate[1]==11)
                {
                    expirationDate[1]=5;
                }         
                else  if(entryDate[1]==12)
                {
                    expirationDate[1]=6;
                }              
            }
            break;



        case 12:
         expirationDate[1]= MonthEntryDate;
         expirationDate[2]= ++YearEntryDate;
            break;       
    }
}

/**
 * getExpirationDate method
 * @return the expiration date
 */
public String getExpirationDate()
{
   return(expirationDate[0]+ " / "+expirationDate[1]+" / "+
           expirationDate[2]);
}

/**
 * toString method
 * @return all members information
 */
public String toString()
{
return("The member's name is: "+this.name+
           "\nThe age is: "
            +this.age+"\nThe phone number is: "+phone+
            
            "\nThe entry date is: "+getEntryDate()+
            "\nThe duration is: "+duration+" months" +
            " \nThe expiration date is: "+getExpirationDate()
            +" \nThe price is: "+price + " SR\n");

}

/**
 * addToFile method
 * @throws IOException 
 */
public void addToFile()throws IOException
{
   //append in a Trainer file
   FileWriter fw = new FileWriter("Members.txt" , true);
   //to write in the file
   PrintWriter write = new PrintWriter(fw);

   write.println( name + "\t"  + age + "\t " + phone + "\t" + 
           getEntryDate()+ 
             " \t"+ getExpirationDate()+
             "\t"+duration+ " months\tt"
             +price+" SR"  );
           
           write.close();

           
           /*String.format("%.5s %4.4d %4.4d %10.4s %4.10s %4.10s %4.4d months %6.6s %4.4d %5.5" 
           ,name ,Id , age ,phone, getEntryDate() , getExpirationDate() , 
           duration ,healthProblems ,price ,Id)*/
}

/**
 * readFile method
 * @throws IOException 
 */
public void readFile()throws IOException
{
   //header
System.out.println("NAME\tID\t  AGE\t   PHONE\t\t  ENTRY DATE\t    EXPIRATION"
       +"\t\t DURATION\t\tPRICE");
       
   File file = new File("Members.txt");
   Scanner read = new Scanner(file);

   while( read.hasNext())
   {
       String line;

       line = read.nextLine();
       System.out.println(line);
   }
}}