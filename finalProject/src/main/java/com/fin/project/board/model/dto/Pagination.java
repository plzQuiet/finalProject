package com.fin.project.board.model.dto;

public class Pagination {

	// 게시판 페이지네이션

	private int currentPage; 		// 현재 페이지
	private int listCount; 			// 전체 게시글 수

	private int limit = 10;			// 보여질 글 게시글 수 -> 10
	private int pageSize = 5;		// 목록 하단 페이지 번호 노출 개수 -> 5

	private int maxPage;			// 마지막 페이지 번호
	private int startPage; 			// 목록 하단 노출 페이지 시작 번호
	private int endPage;			// 목록 하단 노출 페이지 끝 번호

	private int prevPage;			// 목록 하단 노출 번호의 이전 목록의 끝 번호 (<)
	private int nextPage;			// 목록 하단 노출 번호의 다음 목록의 시작 번호 (>)


	// 생성자
	public Pagination(int currentPage, int listCount) {
		this.currentPage = currentPage;
		this.listCount = listCount;

		calculatePagination(); // 계산 메소드 호출
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;

		calculatePagination(); // 계산 메소드 호출
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;

		calculatePagination(); // 계산 메소드 호출
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;

		calculatePagination(); // 계산 메소드 호출
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;

		calculatePagination(); // 계산 메소드 호출
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", MaxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}

	// 페이징 처리에 필요한 값 계산하는 메소드
	private void calculatePagination() {

		// maxPage 계산 : 최대 페이지 수 == 마지막 페이지 번호

		// 전체 게시글 수 200개 / 보여지는 게시글 수 10개
		// -> 마지막 페이지 번호 : 200/10 = 20

		// 전체 게시글 수 : 201 / 보여지는 게시글 수 10개
		// -> 마지막 페이지 번호 : 201/10 = 20..1 -> 21(올림 처리)

		// (int) : 올림 처리된 실수 값을 정수형으로 변환
		// (double)listCount : listCount를 double로 변환하여 연산의 결과가 실수로 정확히 계산되게 함
		// Math.ceil : 실수형 결과를 올림하여 정수형으로 변환(올림 처리)
		maxPage = (int)Math.ceil((double)listCount / limit);

		// startPage : 목록 하단 노출 페이지 시작 번호 

		// 목록 하단 페이지 번호의 노출 개수가 5개인 경우
		// 1~5 	 : 1 (3-1=2) / 5 = 0 -> 0 + 1 = 1 
		// 6~10  : 6 
		// 11~15 : 11
		// 16~20 : 16

		startPage = (currentPage - 1) / pageSize * pageSize + 1;

		// endPage 계산 : 목록 하단 노출 페이지 끝 번호

		// 노출된 페이지 개수 : 5개

		// 1~5   : 5
		// 6~10  : 10
		// 11~15 : 15
		// 16~20 : 20

		endPage = startPage + pageSize - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}


		// prevPage(<) : 이전 목록 끝 번호
		// nextPage(>) : 다음 목록 시작 번호

		// 1~5
		// < : 1
		// > : 6

		// 6~10
		// < : 5
		// > : 11

		// 11~15
		// < : 10
		// > : 16

		// 16~20  maxPage가 20
		// < : 15
		// > : 20
		
		if(currentPage <= pageSize) {
			prevPage = 1;
		}else {
			prevPage = startPage - 1;
		}
		
		
		if(endPage == maxPage) {
			nextPage = maxPage;
		}else {
			nextPage = endPage + 1;
		}


	}


}
