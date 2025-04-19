package com.library.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.library.model.Student;
import com.library.model.User;
import com.library.model.Book;
import com.library.model.IssueBook;

import com.library.service.UserService;
import com.library.service.StudentService;
import com.library.service.BookService;
import com.library.service.IssueBookService;



public class MainLibrary {
	public static void main(String[] args) throws SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n--------------------------------------------------------------|* श्री *|------------------------------------------------------------ ");
		System.out.println("\n-----------------------------------------------------|| वक्रतुण्ड महाकाय सूर्यकोटि समप्रभ।  ||---------------------------------------------------");
		System.out.println("\n-----------------------------------------------------|| निर्विघ्नं कुरु मे देव सर्वकार्येषु सर्वदा॥ ||-------------------------------------------------- ");
		System.out.println("\n\n==============================================* WElCOME TO LIBRERY MENEGEMENT SYSTEM *=========================================== ");
		
		UserService userservice = new UserService();
		StudentService studentservice = new StudentService();
		BookService bookservice = new BookService();
		IssueBookService issuebookservice = new IssueBookService();
		
		
		
		
		
		while(true) {
			System.out.println("\n\n\n===================================================* Choose operation below *================================================");
			System.out.println("1.Login\n2.view USER ID & PASSWORD detail\n3.Exit");
			System.out.println("Enter you choice");
			
			int choice = scanner.nextInt();
			
			
			
			//Login 
			switch(choice) {
			case 1 : 
			
			//User class
			System.out.println("Enter id:");
			int userid = scanner.nextInt();
			
			if(userid <= 123540 && userid >= 123540) {
				System.out.println("---------------------------Successfully submitted UserId--------------------------- ");
			}
			else{
				System.out.println("----------------------------Not Successful UserId------------------------------------");
			}
			
			scanner.nextLine(); //consume newline
			
			System.out.println("Enter Password : ");
				
				String password = scanner.nextLine();
				
				if(password.equals("Abhi123") ) {
					
			
					
					System.out.println("---------------------------------* VALIED PASSWORD *-------------------------------");
					System.out.println("\n\n\n===================================================* Choose operation below *================================================");
					System.out.println(" 1. Student Registration");
					System.out.println(" 2 . Add book");
					System.out.println(" 3.  issue Book & Return Book ");
					System.out.println("Enter you choice");
					
					int N = scanner.nextInt();
					if(N == 1) {
						
					while(true) {
						System.out.println("==========================--------------=======* WElCOME TO STUDENT REGISTRATION *=======------------------================");
						System.out.println("\n\n\n===================================================* Choose operation below *=====================================================");
					System.out.println(" 1. Student Registration");
					System.out.println(" 2. View Student List");
					System.out.println(" 3. Update Student List");
					System.out.println(" 4. Delete Student ");
					System.out.println(" 5. Exit ");
					
					System.out.println("Enter you choice");
					
					//Student Registration
					
						
					int choice1 = scanner.nextInt();
					
					switch(choice1) {
					
					
					case 1 : 
						
						
						System.out.println("==========---------------Student Registration----------==========");
						
						
						
						
						System.out.println(" Enter Id");
						int studentid = scanner.nextInt();
						scanner.nextLine(); //consume newline
						
						System.out.println(" Enter Name");
						String name = scanner.nextLine();
						
						System.out.println(" Enter course");
						String course = scanner.nextLine();
						
						System.out.println(" Enter Branch");
						String branch = scanner.nextLine();
						
						System.out.println(" Enter semester");
						String semester = scanner.nextLine();
						
						Student student = new Student(studentid,name,course,branch,semester);
						studentservice.addStudent(student);
						
						break;
						
					case 2 :
						
						System.out.println("=================------------------View Student List-----------------===============");
						List<Student> students = studentservice.fetchAllStudent();
						
						System.out.println("\n Student All  List ");
						
						for(Student s: students) {
							System.out.println(s.getStudentId()+"||"+s.getName()+"||"+s.getCourse()+"||"+s.getBranch()+"||"+s.getSemester());
						}
						break;
						
					case 3 :
						System.out.println("==============================------Update Student List----------------------==============");
						System.out.println(" Enter Id");
						int studentid1 = scanner.nextInt();
						scanner.nextLine();  //consume newline
						
						
						System.out.println(" Enter Name");
						String name1 =  (scanner.nextLine());
						
						System.out.println(" Enter course");
						String course1 = scanner.nextLine();
						
						System.out.println(" Enter Branch");
						String branch1 = scanner.nextLine();
						
						System.out.println(" Enter semester");
						String semester1 = scanner.nextLine();
						
						
						Student student1 = new Student(studentid1,name1,course1,branch1,semester1);
						studentservice.upStudent(student1);
						break;
						
					case 4 :
						System.out.println("=============================--------------Delete Student----------------=========================");
						
						System.out.println(" Enter Student Id");
						int  studentid2 =scanner.nextInt();
						
						studentservice.deleteStudent(studentid2);
						
						break;
					case 5 :
						System.out.println("=======================-------------Exit...--------------===========================");
						System.out.println("Exiting....");
						scanner.close();
						System.exit(0);
						
						default :
							System.out.println("invalid choice try again ");
					}
					
					}
					
					}	
					//Add Book 
					
					if(N == 2) {
						
						while(true) {
							
							System.out.println("\n\n=======================---------------WELCOME TO ADD BOOK------------================");
							System.out.println("1.Add Book");
							System.out.println("2.View Book List");
							System.out.println("3.Update Book");
							System.out.println("4.Delete Book");
							System.out.println("5. Exit ");
							System.out.println("Enter your choice");
							
							int choice3 = scanner.nextInt();
							
							switch(choice3) {
							//Add Book
							case 1 : 
								System.out.println("=========================----------------Add book---------------========================= ");
								System.out.println("Enter Book ID :");
								int id = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book NAME :");
								String name = scanner.nextLine();
								
								System.out.println("Enter Book PUBLISHER :");
								String publisher = scanner.nextLine();
								
								System.out.println("Enter Book PRICE :");
								int price = scanner.nextInt();
								scanner.nextLine();  //consume newline
								
								System.out.println("Enter Book YEAR :");
								int year= scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book STATUS :");
								String status = scanner.nextLine();
								
								Book book = new Book(id,name,publisher,price,year,status);
								bookservice.addBook(book);
								
								break;
							//show book list	
							case 2 :
								System.out.println("\n=======================----------View Book List------------=====================");
								System.out.println("");
								List<Book> books = bookservice.fetchAllBooks();
								
								System.out.println("\nBook list ");
								
								for(Book s : books) {
									System.out.println(s.getId()+"||"+s.getName()+"||"+s.getPublisher()+"||"+s.getPrice()+"||"+s.getYear()+"||"+s.getStatus()); 
								}
								
								break;
								
							
							case 3 :
								System.out.println("\n====================------------Update Book-------------==========================");
								System.out.println("Enter Book ID :");
								int id2 = scanner.nextInt();
								scanner.nextLine();   //
								
								System.out.println("Enter Book NAME :");
								String name2 = scanner.nextLine();
								
								System.out.println("Enter Book PUBLISHER :");
								String publisher2 = scanner.nextLine();
								
								System.out.println("Enter Book PRICE :");
								int price2 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book YEAR :");
								int year2 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book STATUS :");
								String status2 = scanner.nextLine();
								
								Book book2 = new Book(id2,name2,publisher2,price2,year2,status2);
								bookservice.updateBook(book2);
								
						
								break;
								
							// delete book	
							case 4 :
								System.out.println("=============-----------------------------delete book list---------------=========================");
								
								System.out.println("Enter Book Id ");
								
								int id1 = scanner.nextInt();
								
								bookservice.deleteBook(id1);
								break;
								
							// Exit 	
							case 5 :
								System.out.println("===================---------------------- Exit -----------------==================");
								System.out.println("Exiting...");
								scanner.close();
								System.exit(0);
						
							}
							
						}	
					}
					
					//IssueBook and Return Book 
					
					if(N==3) {
						
						while(true) {
							System.out.println("1.Issue Book");
							System.out.println("2.Issue Books & Return List");
							System.out.println("3.Update and Return Books List ");
							System.out.println("4.Detele Books");
							System.out.println("5.Exit...");
							
							System.out.println("Enter your choice");
							
							int choice4 = scanner.nextInt();
							
							switch(choice4) {
							
							case 1 :
								System.out.println("================----------------IssueBook------------==================== ");
								
								System.out.println("Enter Book ID ");
								int id = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book Name ");
								String name = scanner.nextLine();
								
								System.out.println("Enter Book Publisher ");
								String publisher = scanner.nextLine();
								
								System.out.println("Enter Book Year ");
								int year = scanner.nextInt();
								scanner.nextLine();
								
								System.out.println("Enter Book Issuedate ");
								int issuedate = scanner.nextInt();
								scanner.nextLine();
								
								System.out.println("Enter Book duedate");
								int duedate = scanner.nextInt();
								scanner.nextLine();
								
								System.out.println("Enter StudentId ");
								int  studentid = scanner.nextInt();
								scanner.nextLine();
								
								System.out.println("Enter Book status ");
								String status = scanner.nextLine();
								
								IssueBook issuebook = new IssueBook(id,name,publisher,year,issuedate,duedate,studentid,status);
								issuebookservice.addIssueBook(issuebook);
								break;
								
							case 2:
								System.out.println("============-------------------------View Issue Books & Return List-------------=================");
								List<IssueBook> issuebook1 = issuebookservice.fetchAllIssueBook();
								
								for(IssueBook s : issuebook1) {
									System.out.println(s.getId()+"||"+s.getName()+"||"+s.getPublisher()+"||"+s.getYear()+"||"+s.getIssuedate()+"||"+s.getDuedate()+"||"+s.getStudentid() +"||"+s.getStatus());                                       
								}
								
								break;
								
							case 3 :
								System.out.println("===================------------------Return Books List------------==================");
								System.out.println("Enter Book ID ");
								int id4 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book Name ");
								String name4 = scanner.nextLine();
								
								System.out.println("Enter Book Publisher ");
								String publisher4 = scanner.nextLine();
								
								System.out.println("Enter Book Year ");
								int year4 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book Issuedate ");
								int issuedate4 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book duedate");
								int duedate4 = scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter StudentId ");
								int studentid4= scanner.nextInt();
								scanner.nextLine(); //consume newline
								
								System.out.println("Enter Book status ");
								String status4 = scanner.nextLine();
								
								IssueBook issuebook4 = new IssueBook(id4,name4,publisher4,year4,issuedate4,duedate4,studentid4,status4);
								issuebookservice.updateIssueBook(issuebook4);
								break;
							
								
							
							case 4 :
								
								System.out.println("===================------------------Delete issue----------------====================== ");
								System.out.println("Enter Issue Book ID ");
								int id3 = scanner.nextInt();
								issuebookservice.deleteIssueBook(id3);
								break;
								
							case 5 :
								System.out.println("Exiting");
								scanner.close();
								System.exit(0);
								default : 
								System.out.println("invalid choise try again ");
							}
						}
					}
			}
		
	
				else {
					System.out.println("-----------------------------NOT VALIED PASSWORD-----------------------------");
				}
				
				scanner.nextLine(); //consume newline
				
				
				User user = new User(userid,password);
				
				userservice.addUser(user);
				
				break;
				
			case 2 :
				System.out.println("=================------------View Userid & Password-----------------================");
				List<User> users = userservice.fetchAllUsers();
				
				System.out.println("\n user list ");
				
				for(User s: users) {
					System.out.println(s.getUserid()+"||"+s.getPassword());
				}
				break;
				
			case 3 :
				System.out.println("Exiting....");
				scanner.close();
				System.exit(0);
				
				default :
					System.out.println("invalid choice try again ");
			}
		}
	}
}
