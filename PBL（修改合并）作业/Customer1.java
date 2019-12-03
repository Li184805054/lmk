public class Customer1{     //Customer类第一次修改
	private String _name;
	private Vector _rentals =new Vector();
	
	public  Customer1(String name){
		
		_name=name;
	}
	
	public void addRental(Renta1 arg){
		
		_rentals.addElement(arg);
	}
	
	public String getName(){
		
		return _name;
	}
	
	public String statement(){
		
		double totalAmount=0;// 总的数量
		int frequentRenterPoints=0;//积分
		Enumeration rentals =_rentals.elements();
		String result="Rental Record for "+getName()+"\n";//输出结果
		
		while(rentals.hasMoreElements()){
			
			double thisAmount=0;
			Renta1 each=(Renta1)rentals.nextElement();
			
			thisAmount =amountFor(each);//得到每一次的租赁记录
			
			frequentRenterPoints++;//积分++
			
			if((each.getMovie().getPriceCode()==Movie.NEW_RELEASE)&&
				each.getDaysRented()>1) frequentRenterPoints++;
			//新片另奖积分++
			result+="\t"+each.getMovie().getTitle()+"\t"+
			  String.valueOf(thisAmount)+"\n";
			totalAmount+=thisAmount;
		  }
			result+="Amount owed is "+String.valueOf(totalAmount)+"\n";
			result+="You earned "+String.valueOf(frequentRenterPoints)+
					" frequent renter points";
			
			return result;
		}
		
		private double amountFor(Renta1 each){
			
			double thisAmount=0;
			
			switch(each.getMovie().getPriceCode()){
			case Movie.REGULAR:
			 thisAmount+=2;
			 if(each.getDaysRented()>2)
				thisAmount+=(each.getDaysRented()-2)*1.5;
			  break;
			case Movie.NEW_RELEASE:
				thisAmount+=each.getDaysRented()*3;
				break;
			case Movie.CHILDRENS:
				thisAmount+=1.5;
				if(each.getDaysRented()>3)
					thisAmount+=(each.getDaysRented()-3)*1.5;
				break;
			
		}
			
			return thisAmount;
		}
		
}