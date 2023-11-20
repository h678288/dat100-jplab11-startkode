package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			File fil = new File(mappe, filnavn);
			PrintWriter skriver = new PrintWriter(fil);

			skriver.println(samling.getAntall());

			for (Innlegg innlegg : samling.getSamling()) {
				if (innlegg != null) {
					skriver.println(innlegg.toString());
				}
			}

			skriver.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
