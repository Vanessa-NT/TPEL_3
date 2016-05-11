package personenidentity;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Iterator;

@SuppressWarnings("serial")
public class MembershipList extends HashMap<Integer, Member> implements Map<Integer, Member> {

	private static final String KEY_ID_DIFFERENT_STRING = "key und ID sind ungleich";
	private static final String KEY_ALREADY_USED_STRING = "ID ist schon vorhanden";

	/**
	 * je nach Methode durchläuft Sie die Objekte in einer Collection
	 */
	public Iterator<Member> Iterator() {
		return values().iterator();
	}

	/**
	 * befüllt die Liste mit value
	 */
	public Member put(Member value) {
		return put(value.getMitgliederID(), value);
	}

	/**
	 * befüllt die Liste mit key/value
	 */
	@Override
	public Member put(Integer key, Member value) {
		if (key != value.getMitgliederID()) {
			throw new InvalidParameterException(KEY_ID_DIFFERENT_STRING);
		}
		if (this.containsKey(key)) {
			throw new InvalidParameterException(KEY_ALREADY_USED_STRING);
		}
		return super.put(key, value);
	}

	/**
	 * Ändert den Vornamen
	 */
	public void setVorname(int mitgliederID, String newVorname) {
		this.get(mitgliederID).setVorname(newVorname);
	}

	/**
	 * Ändert den Nachnamen
	 */
	public void setNachname(int mitgliederID, String newNachname) {
		this.get(mitgliederID).setNachname(newNachname);
	}

	/**
	 * Ändert die mitgliederJahre
	 */
	public void setMitgliederJahre(int mitgliederID, int newYear) {
		Member tmp = this.get(mitgliederID);
		this.remove(mitgliederID);
		tmp.setMitgliedsJahre(newYear);
		this.put(tmp);
	}

	/**
	 * entfernt Objekt von der Liste
	 */
	@Override
	public Member remove(Object key) {
		return super.remove(key);
	}

	@Override
	public String toString() {
		String title = "------------------------------------------------------\n" + "ID" + "\t" + "Vorname" + "\t\t"
				+ "Nachname" + "\t" + "Mitgliedsjahre" + "\n------------------------------------------------------\n";
		String enter = "\n";
		String tmp = "";

		for (int i = 0, j = 0; j < this.size(); i++) {
			if (this.get(i) != null) {
				j++;
				tmp += this.get(i) + enter;
			}
		}

		return title + tmp;
	}
}