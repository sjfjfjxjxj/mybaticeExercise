package notice.model.vo;

public class Pagenation {
	private int currentPage; //현재 페이지
	private int recordCountPerPage = 10; //한 페이지당 글 10개씩 보여주라.
	private int start; // 같은 페이지의 제일 첫글
	private int end; //같은 페이지의 제일 마지막글
	
	public Pagenation() {};
	
	
	
	public Pagenation(int currentPage, int recordCountPerPage) {
		super();
		this.currentPage = currentPage;
		this.recordCountPerPage = recordCountPerPage;
		this.start = currentPage*recordCountPerPage - (recordCountPerPage -1);
		this.end = currentPage*recordCountPerPage;
	}



	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}



	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	
	
	
	
}
