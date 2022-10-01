package com.simplilearn.Project2;

/** LockedMe.com / Project Phase 1 **/

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/** This class allows users to find, create and delete files from the file system. */

public class LockMe {
	static File folder = new File("D:\\FSD_Class_Simplilearn\\Simplilearn-COURSE - 2");
	static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	/* Main Class.*/

	public static void main(String[] args) {

		boolean bExit = false;    //Boolean to identify if the loop continues or not
		Integer iResponse = 0;    // Option Selected
		while (!bExit) {          // Exits when user selects option 5

			menu();

			try {
				iResponse = Integer.parseInt(scanner.nextLine());      //User input is read
				PrintMessage(" > Selected: " + iResponse);

				switch (iResponse) {                                   // Choose the option selected by user
				case 1: {
					//All files are painted on screen
					Random random = new Random();
					int rn = random.nextInt(6) + 1;

					switch (rn) {
						case 1:                                        // Get all files using a for loop
							getAllFiles_forLoop();
							break;

						case 2:                                        // Get all files using a while loop
							getAllFiles_while();
							break;

						case 3:                                        // Get all files using a for each loop
							getAllFiles_forEachLoop();
							break;

						case 4:                                        // Get all files using an iterator of a Linked List
							getAllFiles_Iterator();
							break;
						
						case 5:                                        // Get all files using an iterator of a linkedlist
							getAllFiles_LambdaExpression();
							break;

						case 6:                                        // Get all files using the Enumeration Interface
							getAllFiles_EnumerationInterface();
							break;
					}
					break;
				}
				case 2: {                                              //User defines name and contents of a new file
					createFile(scanner);
					break;
				}

				case 3: {                                              //User chooses a file to delete
					deleteFile(scanner);
					break;
				}

				case 4: {                                              //Determine is a file exists
					searchFiles(scanner);
					break;
				}

				case 5: {                                              //Exit the program
					bExit = true;

					break;
				}
				default: {                                             //On error the program ends
					bExit = true;
				}
			}
		}catch(NumberFormatException e){
		PrintMessage("Please print only numbers");
		}
	}
}
	
/** Get All files using a for loop */
public static void getAllFiles_forLoop() {
	File[] listOfFiles = folder.listFiles();
	List<File> alListOfFiles = new ArrayList<File>();
	Collections.addAll(alListOfFiles, listOfFiles);
	try {
		for (int i = 0; i < alListOfFiles.size(); i++) {
			System.out.println(alListOfFiles.get(i));
		}
	//On error an exception is raised
	} catch (Exception e) {
		PrintMessage("Error: files not found");
	}
}

/** get all files using a while loop and a linkedlist  */
public static void getAllFiles_while() {
	File[] listOfFiles = folder.listFiles();
	LinkedList<File> llListOfFiles = new LinkedList<File>();
	Collections.addAll(llListOfFiles, listOfFiles);
	int counter = 0;
	while (llListOfFiles.size() > counter) {
		System.out.println(llListOfFiles.get(counter));
		counter++;
	}
}

/** Get all the files using a for each loop */
public static void getAllFiles_forEachLoop() {
	File[] listOfFiles = folder.listFiles();
	for (File myFile : listOfFiles) {
		System.out.println(myFile.getName());
	}
}

/** Get all the files using a lambda expression */
public static void getAllFiles_LambdaExpression() {
	File[] listOfFiles = folder.listFiles();
	List<File> alListOfFiles = new ArrayList<>();
	Collections.addAll(alListOfFiles, listOfFiles);
	alListOfFiles.forEach((file) -> {
		System.out.println(file.getName());
	});
}

/** Get all files using the enumeration interface */
public static void getAllFiles_EnumerationInterface() {
	File[] listOfFiles = folder.listFiles();
	List<File> alListOfFiles = new ArrayList<>();
	Collections.addAll(alListOfFiles, listOfFiles);
	Enumeration<File> e = Collections.enumeration(alListOfFiles);
	while (e.hasMoreElements()) {
		System.out.println(e.nextElement().getName());
	}
}

/** Return all files from directory */
public static void getAllFiles_Iterator() {
	File[] listOfFiles = folder.listFiles();
	List<File> alListOfFiles = new ArrayList<File>();
	Collections.addAll(alListOfFiles, listOfFiles);
	LinkedList<File> llListOfFiles = new LinkedList<>(alListOfFiles);
	try {
		Iterator<File> alListOfFilesIterator = llListOfFiles.iterator();
		while (alListOfFilesIterator.hasNext()) {
			System.out.println(alListOfFilesIterator.next());
		}
	} catch (Exception e) {
		PrintMessage("Error: file not found");
	}
}

/** A file deletion */
public static void deleteFile(Scanner scannerdelete) {
try {
	System.out.println("Write the name of the file you wanted to delete:");
	File fileToDelete = new File(folder + "//" +

	scannerdelete.nextLine());

	if (fileToDelete.delete()) {
		PrintMessage("File deleted successfully.");
	} else {
		PrintMessage("There was an error deleting the file");
	}
	} catch (Exception e) {
		PrintMessage("There was an error deleting the file");
	}
}

/** Search for a specific file */
public static void searchFiles(Scanner scannerSearch) {
try {
	System.out.println("Write the name of the file you want to find:");
	File fileTofind = new File(folder + "//" +

	scannerSearch.nextLine());
	if (fileTofind.exists()) {
		PrintMessage("File exists");
	} else {
		PrintMessage("File does not exist");
	}
	} catch (Exception e) {
		PrintMessage("There was an error searching the file.");
	}
}

/** User creates a new file */
public static void createFile(Scanner scannerCreate) {
	FileWriter writer = null;
	try {
		System.out.println("What is the name of your new file?");
		File newFile = new File(folder + "//" + scannerCreate.nextLine());
		writer = new FileWriter(newFile);
		System.out.println("And the contents of your file are...");
		writer.write(scannerCreate.nextLine());
		writer.close();
		PrintMessage("File created successfully");
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}

/** The menu is Displayed on screen */
public static void menu() {
System.out.println("\n");
System.out.println("****************************************************");
System.out.println("************* Welcome to LockMe.com****************");
System.out.println("****************************************************");
System.out.println("*********** Designed by Simplilearn shri************");
System.out.println("****************************************************");
System.out.println(" 1) Display all the files");
System.out.println(" 2) Add a new file ");
System.out.println(" 3) Delete a file ");
System.out.println(" 4) Search for file ");
System.out.println(" 5) Exit ");
System.out.println("");
System.out.println(" > Select an option...");
}
static void PrintMessage(String message){
System.out.println(" -----------------------------");
System.out.println(" " + message);
System.out.println(" -----------------------------");
}
}
