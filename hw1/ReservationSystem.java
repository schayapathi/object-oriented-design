import java.util.*;
import java.io.*;

public class ReservationSystem 
{
     private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
     public static void main (String[]args) 
     {
          ReservationSystem rs = new ReservationSystem();
          rs.initialMenu();
     }
     public void populateLists()
     {
          ShowManager.generateSeats();
          try
          {
               BufferedReader reader = new BufferedReader(new FileReader("/Users/swatichayapathi/Documents/TheaterReservation/reservations.txt"));
               String line = reader.readLine();
               while(line != null)
               {
                    String[]arr = line.split(" ");
                    String date = arr[0];
                    String time = arr[1];
                    String user = arr[2];
                    String seat = arr[3];
                    ShowManager.getShow(date, time).makeSeatUnavailable(seat);
                    UserManager.getUser(user).addReservation(new Reservation(new Show(date, time), UserManager.getUser(user), seat));
               }
               reader.close();
          } catch (FileNotFoundException e)
          {
               System.out.println(e);
          } catch (IOException eio)
          {
               System.out.println(eio);
          }
     }

     public void initialMenu()
     {
          createFile();
          populateLists();
          System.out.println("Sign [U]p   Sign [I]n   E[X]it     ");
          Scanner in = new Scanner(System.in);
          String userInput = in.nextLine();
          if(userInput.equals("U"))
          {
               System.out.println("Create a username: ");
               String createUserName = in.nextLine();
               System.out.println("Create a password: ");
               String createPassWord = in.nextLine();
               UserManager.addUser(createUserName, createPassWord);
               transactionMode(createUserName);

          }
          else if(userInput.equals("I"))
          {
               System.out.println("Enter username: ");
               String username = in.nextLine();
               if(UserManager.getUser(username)== null)
               System.out.println("That is an invalid username. Please enter a valid username: ");
               username = in.nextLine();
               System.out.println("Enter password: ");
               String password = in.nextLine();
               if(!UserManager.authenticateUser(username, password))
               {
                    System.out.println("Incorrect password. Please try again. ");
               }
               password = in.nextLine();
               if(UserManager.authenticateUser(username, password))
                    transactionMode(username);
               
          }
          else if(userInput.equals("E"))
          {
               updateReservations();
               System.exit(0);
          }
          else
          {
               System.out.println("Please enter a valid character: ");
          }
     }

     public void transactionMode(String username) 
     {    
          System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut     ");
          Scanner input = new Scanner(System.in);
          String userInput = input.nextLine();
          if(userInput.equals("R"))
          {
               reservationSession(username);
          }
          else if(userInput.equals("V"))
          {
               UserManager.getUser(username).printReservations();
          }
          else if(userInput.equals("C"))
          {
               System.out.println("Enter a date between Dec 23, 2020 and Jan 2, 2021: ");
               Scanner in = new Scanner(System.in);
               String showDate = in.nextLine();
               System.out.println("Enter a show time for that date (6:30 or 8:30): ");
               String showTime = in.nextLine();
               //print seat numbers reserved by user
               //cancel those seat numbers
          }
          else if(userInput.equals("O"))
          {
               displayReceipt();
               initialMenu();
          }
          else
               System.out.println("Please enter a valid character: ");
     }

     public void reservationSession(String username)
     {
          System.out.println("Enter date between Dec 23, 2020 and Jan 2, 2021: ");
          Scanner in = new Scanner(System.in);
          String showDate = in.nextLine();
          System.out.println("Enter a show time for that date (6:30 or 8:30): ");
          String showTime = in.nextLine();
          Show show = ShowManager.getShow(showDate, showTime);
          if(ShowManager.scheduledShows.contains(show))
               show.getAvailableSeats();
          
          String seatRequest = in.nextLine();
          while(!seatRequest.equals("C"))
          {
               show.makeSeatUnavailable(seatRequest);
               reservations.add(new Reservation(show, UserManager.getUser(username), seatRequest));
               System.out.println("Enter another seat number or type 'C' to confirm your reservations.");
               seatRequest = in.nextLine();
          }
          transactionMode(username);
     }

     public void updateReservations()
     {
          BufferedWriter writer;
          try
          {
               writer = new BufferedWriter(new FileWriter("/Users/swatichayapathi/Documents/TheaterReservation/reservations.txt"));
               for(Reservation r : reservations)
               {
                    writer.write(r.getShowDate() + " " + r.getShowTime() + " " + r.getUser().getUsername() + " " + r.getSeat());
                    writer.newLine();
               }
          } catch (IOException e)
          {
               System.out.println(e);
          }
     }
     public void createFile()
     {
          try {
               File reserve = new File("reservations.txt");
                if (!reserve.createNewFile()) 
                {
                  System.out.println();
                } 
          } catch (IOException e) {
                System.out.println("An error occurred.");
          }
     }
     public void displayReceipt()
     {
          System.out.println("Receipt");
     }
}












