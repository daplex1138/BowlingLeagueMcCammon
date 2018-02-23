package view;
import java.util.List;
import java.util.Scanner;

import controller.GalleryArtHelper;
import model.GalleryArtPiece;

public class StartArtProgram {
	
	static Scanner in = new Scanner(System.in);
	static GalleryArtHelper gallery = new GalleryArtHelper();

	private static void addArtwork() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title of the artwork: ");
		String title = in.nextLine();
		System.out.print("Enter the artist's name: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media: ");
		String media = in.nextLine();
		System.out.print("Enter the year created: ");
		String year = in.nextLine();
		System.out.print("Enter the value: ");
		double value = in.nextDouble();

		GalleryArtPiece toAdd= new GalleryArtPiece(title, artistName, media, year, value);//can add all variables
		gallery.insertItem(toAdd);
		System.out.println("The following art was added to the database.");
		System.out.println(toAdd.print());
	}
	private static void deleteAnItem() {//could be better to use ID
		// TODO Auto-generated method stub
		System.out.print("Enter the title of the artwork you would like to remove from the gallery  ");
		String title = in.nextLine();
		System.out.print("Confirm the artist's name for the piece of artwork you would like to remove ");
		String artistName = in.nextLine();
		
		GalleryArtPiece toDelete = new GalleryArtPiece(title, artistName);
		gallery.deleteItem(toDelete);
		System.out.println("Item Deleted Successfully");
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
		}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Art Gallery List ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Enter a new gallery piece");
			System.out.println("*  2 -- Delete gallery piece");
			System.out.println("*  3 -- Display all the artwork");
			System.out.println("*  4 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addArtwork();
			} else if (selection == 2) {
				deleteAnItem();
			} else if (selection == 3) {
				viewTheList();
			} else {
				//lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

			private static void viewTheList() {
				// TODO Auto-generated method stub
				 List <GalleryArtPiece> allArt = gallery.showAllItems();
				for (GalleryArtPiece li: allArt) {
					System.out.println(li.returnArtPieceDetails());
				}
		}


	}



	


