package org.generation.italy;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		String[][] campo = new String[8][8];
		String[][] campoPlayer = new String[8][8];
		int nrRiga, nrColonna, navi, counter, orNave, spari;
		String risposta;

		// Inizio do while per ricominciare la partita
		do {
			counter = 0;
			spari = 0;
			navi = 0;
			// Assegnazione spazio "tilde" nella griglia impostata sia verticalmente che orizzontalmente
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8; c++) {
					campo[r][c] = "~";
					campoPlayer[r][c] = "~";
				}
			}
			
			// Inizio do while per inserimento nave
			do {
				// Decisione di un numero random per determinare se la nave sarà orizzontale o verticale
				orNave = rnd.nextInt(2);
				// Stampa orizzontale
				if (orNave == 0) {
					// Decisione posizione random per la nave in
					nrRiga = rnd.nextInt(6);
					nrColonna = rnd.nextInt(8);
					// Assegnazione della nave nella griglia
					for (int r = nrRiga; r < nrRiga + 3; r++) {
						campo[r][nrColonna] = "N";
					}
					navi+=3;
					break;
					// Stampa verticale
				} else {
					nrRiga = rnd.nextInt(8);
					nrColonna = rnd.nextInt(6);
					// Assegnazione della nave nella griglia
					for (int c = nrColonna; c < nrColonna + 3; c++) {
						campo[nrRiga][c] = "N";
					}
					navi+=3;
					break;
				}
				
			} while (true);

			// Stampa della griglia per verificare il corretto inserimento della nave
			System.out.println("Le navi sono: " + navi);
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8; c++) {
					System.out.print(campo[r][c]);
				}
				System.out.println();
			}
			System.out.println();
			// Stampa della griglia per verificare il campo del player
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8; c++) {
					System.out.print(campoPlayer[r][c]);
				}
				System.out.println();
			}
			
			// Inizio ciclo per inserimento mossa
			do {
				System.out.println("Dove vuoi colpire?");
				System.out.println("Inserisci la riga: ");
				nrRiga = sc.nextInt();
				System.out.println("Inserisci la colonna: ");
				nrColonna = sc.nextInt();
				sc.nextLine();

				// Verifica se lo sparo è dentro la griglia
				if (nrRiga < 8 && nrColonna < 8) {
					// Verifica dello sparo
					if (!campo[nrRiga][nrColonna].equals("~") && !campoPlayer[nrRiga][nrColonna].equals("X") && !campo[nrRiga][nrColonna].equalsIgnoreCase("o")) {
						campoPlayer[nrRiga][nrColonna] = "X";
						counter++;
						spari++;
						// Verifica se la nave è stata colpita o affondata
						if (counter < navi) {
							System.out.println("Colpito!");
						} else {
							System.out.println("Affondato!");
						}
						// Lo sparo non ha colpito la nave
					} else if (campoPlayer[nrRiga][nrColonna].equals("X") || campoPlayer[nrRiga][nrColonna].equalsIgnoreCase("o")) {
						System.out.println("Hai già colpito in questo punto! Riprova.");
					} else {
						System.out.println("Acqua!");
						campoPlayer[nrRiga][nrColonna] = "o";
						spari++;
					}
					// Stampa della griglia
					for (int r = 0; r < 8; r++) {
						for (int c = 0; c < 8; c++) {
							System.out.print(campoPlayer[r][c]);
						}
						System.out.println();
					}
					// Lo sparo è finito fuori campo
				} else {
					System.out.println("Hai colpito fuori il campo, riprova.");
				}
				// Fine ciclo quando le navi sono state affondate
			} while (counter < navi);
			// Messaggio di fine partita
			System.out.println("Complimenti, hai finito la partita! Vuoi rigiocare?");
			risposta = sc.nextLine();
			// Fine ciclo per l'intera partita 
		} while (risposta.equalsIgnoreCase("s"));
		// Messaggio di chiusura gioco
		System.out.println("Alla prossima!");
	}

}
