package com.apress.prospring4.ch3;

public class BookwormOracle implements Oracle {

	@Override
	public String defineMeaningOfLife() {
		return "Encyclopedias are a waste of money - use the Internet";
	}
	
	@Override
	public String toString(){
		return "BookwormOracle Instance";
	}

}
