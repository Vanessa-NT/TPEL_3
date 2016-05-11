package personenidentity;

import java.util.Scanner;

class ClubManagement {

	public static void main(String[] args) {

		MembershipList list = new MembershipList(); // Inititalisierung der
													// Klasse MembershipList
		Member list1 = new Member(0, null, null, 0);
		/**
		 * Members werden erstellt
		 */
		Member mem1 = new Member(2, "Heinz", "Mustermann", 16);
		Member mem2 = new Member(6, "Anette", "Koch", 15);
		Member mem3 = new Member(5, "Bart", "Simpson", 9);
		Member mem4 = new Member(3, "Lisa", "Simpson", 5);

		/**
		 * Members werden in der Liste eingefügt
		 */
		list.put(mem1);
		list.put(mem2);
		list.put(mem3);
		list.put(mem4);
		System.out.println(list.toString());

		/**
		 * Gibt Länge der Liste aus
		 */

		System.out.println("Die Länge beträgt: " + list.size());

		/**
		 * Entferntes mitgliederID 2
		 */

		list.remove(2);

		/**
		 * Gibt die neue List aus
		 */

		MembershipList list2 = new MembershipList();
		list2.putAll(list);

		System.out.println("Die neue Liste beträgt:\n" + list2.toString());

		/**
		 * Füge die mitgliederID 2 wieder zu
		 */

		mem1.setVorname("Lisa");
		mem1.setNachname("Simpson");
		mem1.setMitgliedsJahre(5);
		list2.put(mem1);
		System.out.println("Member in die alten Liste wieder eingefügt: " + list2.toString());

		/**
		 * Auf Existenz von mitgliederID 2 prüfen in der alten Liste
		 */

		System.out.println("Der Member ist nicht vorhanden: " + list.get(2));

		/**
		 * Auf Existenz von mitgliederID 2 in der neuen Liste prüfen
		 */

		System.out.println("Der Member mit der mitgliederID 2: " + list2.get(2) + " ist vorhanden.");

		/**
		 * Vornamen vom mitgliederID 5 ändern
		 */

		list2.setVorname(5, "Günter");

		/**
		 * mitgliederID 5 ausgeben
		 */

		System.out.println("Der Member mit der mitgliederID 5 lautet: " + list2.get(5));

		/**
		 * Aus der neuen Liste(zweite Liste) den Mitglied mit der mitgliederID 5
		 * löschen
		 */

		list2.remove(5);

		/**
		 * Erste Liste ausgeben
		 */

		System.out.println("Alle Member der ersten Liste: " + list.toString());

		/**
		 * Zweite Liste ausgeben
		 */

		System.out.println("Alle Member der zweiten Liste ausgeben: " + list2.toString());

	}
}