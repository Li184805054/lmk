public class Rental1 {      //Rental类第一次修改
	private Movie _movie;
	private int _daysRented;
	
	public Rental2(Movie movie,int daysRented){
		
		_movie=movie;
		_daysRented=daysRented;
		
		
	}
	public int getDaysRented(){
		
		return _daysRented;
	}
	public Movie getMovie(){
		
		return _movie;
	}
	
	 double getCharge(){
		
		double result=0;
		
		switch(getMovie().getPriceCode()){
		case Movie.REGULAR:
			result+=2;
		 if(getDaysRented()>2)
			 result+=(getDaysRented()-2)*1.5;
		  break;
		case Movie.NEW_RELEASE:
			result+=getDaysRented()*3;
			break;
		case Movie.CHILDRENS:
			result+=1.5;
			if(getDaysRented()>3)
				result+=(getDaysRented()-3)*1.5;
			break;
		
	}
		
		return result;
	 }
}
