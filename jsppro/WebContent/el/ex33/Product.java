package jspbook;

public class Product {

	// 상품 목록을 저장할 배열
	private String[] productList = {"item1","item2","item3","item4","item5"};
	
	// 변수 설정
	private int num1 = 10;
	private int num2 = 20;
	
	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public String[] getProductList() {
		return productList;
	}
}