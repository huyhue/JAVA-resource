package Outsource;

public class Sosanh  implements Comparable<Sosanh> {

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(Sosanh s) {  //sap xep theo id
		return this.getId().compareTo(s.getId());
	}
	//Collections.sort(lh);  su dung no

}
