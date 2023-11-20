package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {

		innleggtabell = new Innlegg[20];
		nesteledig = 0;

	}

	public Blogg(int lengde) {

		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;

	}

	public int getAntall() {

		return nesteledig;

	}

	public Innlegg[] getSamling() {

		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {

		boolean funnet = false;
		int pos = 0;
		while (pos < nesteledig && !funnet) {
			if (innleggtabell[pos].erLik(innlegg)) {
				funnet = true;
			} else {
				pos++;
			}
		}
		if (funnet) {
			return pos;
		} else {
			return -1;
		}
	}

	public boolean finnes(Innlegg innlegg) {
		int finnes = finnInnlegg(innlegg);
		if (finnes >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ledigPlass() {

		return nesteledig < innleggtabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {

		String result = nesteledig + "\n";

		for (int i = 0; i < nesteledig; i++) {
			result += innleggtabell[i].toString();
		}

		return result;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {

		if (nesteledig == innleggtabell.length) {
			Innlegg[] nyTab = new Innlegg[innleggtabell.length * 2];

			for (int i = 0; i < nesteledig; i++) {
				nyTab[i] = innleggtabell[i];
			}

			innleggtabell = nyTab;
		}

	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}

	}

	public boolean slett(Innlegg innlegg) {

		int pos = finnInnlegg(innlegg);
		if(pos >= 0) {
			innleggtabell[pos] = innleggtabell[nesteledig - 1];
			innleggtabell[nesteledig - 1] = null;
			nesteledig--;
			return true;
		} else {
			return false;
		}
		
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}