package com.tampro.dsggraphql01.model;

public class Pagination {
	private long totalRows;
	private int currentPage;
	
	
	
	public Pagination(long totalRows, int currentPage) {
		super();
		this.totalRows = totalRows;
		this.currentPage = currentPage;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


}
