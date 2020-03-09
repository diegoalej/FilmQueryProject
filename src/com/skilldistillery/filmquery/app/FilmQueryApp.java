package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();// this is just to make sure we have connection
//    app.launch(); //uncomment this to run
	}

	private void test() {
		Film film = db.findFilmById(0);
		if (film.getTitle() == null) {
			System.out.println("empty!");
		}
		System.out.println(db.findLanguagebyFilmId(1));
		System.out.println(film);
		Actor actor = db.findActorById(1);
		System.out.println(actor);
		List<Film> actors = db.findFilmsByString("GOLDFIN");
		System.out.println(actors);
	}

	private void launch() {// this is where menu will go
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean menu = true;
		while (menu) {
			System.out.println("Welcome to the Movie app");
			System.out.println("Enter an integer to choose from the menu below");
			System.out.println("1) Look up a film by its id");
			System.out.println("2) Look up a film by a search keyword");
			System.out.println("3) Exit the application\n> ");
			int choice = input.nextInt();
			if (choice < 1 || choice > 3) {
				System.out.println("Choice out of bounds, try again");
				continue;
			} else {
				switch (choice) {
				case 1:
					System.out.print("Plese enter the film Id: ");
					int idChoice = input.nextInt();
					Film usrFilm = null;
					usrFilm = db.findFilmById(choice);
					if (usrFilm.getTitle() == null) {
						System.out.println("A film by that id does not exist in the database!");
						continue;
					}
					else {
						System.out.println("Here is your film info: ");
						System.out.println(usrFilm);
						continue;
					}
				case 2:
					List<Film> usrFilmKey = new ArrayList<>();
					System.out.print("Please enter your search keyword: ");
					String usrInput = input.nextLine();
					usrFilmKey = db.findFilmsByString(usrInput);
					if (usrFilmKey.size() == 0) {
						System.out.println("A film with that keyword does not exist in the database!");
						continue;
					}
					else {
						System.out.println("Here is your film(s) info: ");
						for (Film film : usrFilmKey) {							
							System.out.println(film);
						}
						continue;
					}
				case 3:
					menu = false;
					System.out.println("Goodbye!");
					break;
				}
			}
		}
	}

}
