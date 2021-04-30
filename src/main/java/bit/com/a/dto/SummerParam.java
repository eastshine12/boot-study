package bit.com.a.dto;

public class SummerParam {

	private String choice;
	private String search;
	private int page;

	public SummerParam() {
		// TODO Auto-generated constructor stub
	}
	

	public SummerParam(String choice, String search, int page) {
		this.choice = choice;
		this.search = search;
		this.page = page;
	}



	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}



	@Override
	public String toString() {
		return "SummerParam [choice=" + choice + ", search=" + search + ", page=" + page + "]";
	}

	

	
}
