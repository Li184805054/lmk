public class Customer4 {   //Customer类第四次修改
	private String _name;
	private Vector _rentals =new Vector();
	
	public  Customer4(String name){
		
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
			
			//double thisAmount=0;
			Rental each=(Rental)rentals.nextElement();
		
			//thisAmount =each.getCharge();//得到每一次的租赁记录
			
			frequentRenterPoints++;//积分++
			
			if((each.getMovie().getPriceCode()==Movie.NEW_RELEASE)&&
				each.getDaysRented()>1) frequentRenterPoints++;
			//新片另奖积分++
			result+="\t"+each.getMovie().getTitle()+"\t"+
			  String.valueOf(each.getCharge())+"\n";
			totalAmount+=each.getCharge();
		  }
			result+="Amount owed is "+String.valueOf(totalAmount)+"\n";
			result+="You earned "+String.valueOf(frequentRenterPoints)+
					" frequent renter points";
			
			return result;
		}
}