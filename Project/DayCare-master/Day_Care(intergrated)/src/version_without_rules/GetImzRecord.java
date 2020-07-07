package version_without_rules;

import java.util.Hashtable;

public class GetImzRecord {
	private Hashtable<String, Integer> immurec;
	
	public GetImzRecord(){
		super();
		this.immurec = new Hashtable<>();
	}
	
    public Hashtable<String, Integer> getImmurec() {
		return immurec;
	}

	public void setImmurec(Hashtable<String, Integer> immurec) {
		this.immurec = immurec;
	}

	public void updateImmuRec(String csv) {
    	String[] temp = csv.split(",");
    	int value;
		try {
			value = Integer.valueOf(temp[1]);
	    	immurec.put(temp[0], value);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
