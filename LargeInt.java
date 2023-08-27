package a1;

public class LargeInt implements LargeIntInterface {
	
	private SpecializedList spList;
	private boolean isNegative;
	
	public LargeInt(String num) {
		spList = new SpecializedList();
		isNegative = false;
		
		if(!num.isEmpty() && num.charAt(0) == '-') {
			for(int i = 1; i < num.length(); i++) {
				int number = Character.getNumericValue(num.charAt(i));
				spList.insertEnd((byte)number);
			}
			setNegative();
		}
		else {
			for(int i = 0; i < num.length(); i++) {
				int number = Character.getNumericValue(num.charAt(i));
				spList.insertEnd((byte)number);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        LargeInt m = new LargeInt("20");
        LargeInt n = new LargeInt("1263");
        
        n.spList.printList();
        n.spList.resetForward();
        n.spList.resetBackward();
        

        m.spList.resetForward();
        m.spList.resetBackward();
        n.spList.resetForward();
        n.spList.resetBackward();
        
        System.out.println("Result: " + m.subtract(m));

	}
	
	

	@Override
	public LargeInt add(LargeInt lgNum) {
		// TODO Auto-generated method stub
		
		spList.resetForward();
		spList.resetBackward();
		lgNum.spList.resetForward();
		lgNum.spList.resetBackward();
		
		int i = 0;

		int addResult = 0; 
		LargeInt result = new LargeInt("");
		boolean carry = false;
		


		if(lgNum == this) {
			lgNum = new LargeInt(lgNum.toString());
		}
		
		if (!isNegative && !lgNum.isNegative) {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();
			
			while (i < Math.max(spList.lengthIs(), lgNum.spList.lengthIs())) {
				
				if (carry) {
					if (i >= spList.lengthIs()) {
						addResult = lgNum.spList.getPriorItem() + 1;
					}
					else if (i >= lgNum.spList.lengthIs()) {
						addResult = spList.getPriorItem() + 1;
					}
					else {
						addResult = spList.getPriorItem() + lgNum.spList.getPriorItem() + 1;
					}
				}
				else {
					if (i >= spList.lengthIs()) {
						addResult = lgNum.spList.getPriorItem();
					}
					else if (i >= lgNum.spList.lengthIs()) {
						addResult = spList.getPriorItem();
					}
					else {
						addResult = spList.getPriorItem() + lgNum.spList.getPriorItem();
					}
					
				}
				
				
				if (addResult >= 10) {
					carry = true;
				}
				else {
					carry = false;
				}
				result.spList.insertFront((byte)(addResult % 10));
				i++;
			}
		}
		else if (isNegative && lgNum.isNegative) {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			
			setNegative();
			lgNum.setNegative();
			
			result = add(lgNum);
			
			
			result.setNegative();
			setNegative();
			lgNum.setNegative();

			
		}
		else if (isNegative && !lgNum.isNegative) {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			setNegative();
			result = lgNum.subtract(this);
			setNegative();
			
		}
		else {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			lgNum.setNegative();
			result = subtract(lgNum);
			lgNum.setNegative();
			
		}
		
		if(carry == true) {
			result.spList.insertFront((byte) 1);
		}
		
		
		
		return result;
		
	}

	@Override
	public LargeInt subtract(LargeInt lgNum) {
		// TODO Auto-generated method stub
		
		spList.resetForward();
		spList.resetBackward();
		lgNum.spList.resetForward();
		lgNum.spList.resetBackward();
		int i = 0;
		int size = spList.lengthIs();
		int j = 0;
		int subResult = 0; 
		LargeInt result = new LargeInt("");
		boolean borrow = false;
		boolean larger = false;
		
		if(lgNum == this) {
			lgNum = new LargeInt(lgNum.toString());
		}
		
		if (!isNegative && !lgNum.isNegative) {

			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();
			
			if(size > lgNum.spList.lengthIs()) {
				larger = true;
			}
			else if(size == lgNum.spList.lengthIs()){
				for(j = 0; j < size; j++) {
					byte a = spList.getNextItem();
					byte b = lgNum.spList.getNextItem();
					if(a > b) {
						larger = true;
						break;
					}
					else if(a < b) {
						larger = false;
						break;
					}
					
				}
				if(j == size) {
					result = new LargeInt("0");
					return result;
				}
				
			}
			
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();
			
			if(larger) {
				while (i < Math.max(size, lgNum.spList.lengthIs())) {
					if (borrow) {					
						if (i >= lgNum.spList.lengthIs()) {
							subResult = spList.getPriorItem() - 1;
						}
						else {
							subResult = spList.getPriorItem() - lgNum.spList.getPriorItem() - 1;
						}
					}
					else {
						if (i >= lgNum.spList.lengthIs()) {
							subResult = spList.getPriorItem();

						}
						else {
							subResult = spList.getPriorItem() - lgNum.spList.getPriorItem();
						}

					}
					
					
					if (subResult < 0) {
						borrow = true;
					}
					else {
						borrow = false;
					}
					result.spList.insertFront((byte)(subResult >= 0? subResult : subResult + 10));
					
					i++;
				}
			}
			else {
				result = lgNum.subtract(this);
				result.setNegative();
			}
			
			
		}
		else if (!isNegative && lgNum.isNegative) {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			lgNum.setNegative();
			result = add(lgNum);
			lgNum.setNegative();
			
		}
		else if (isNegative && !lgNum.isNegative) {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			setNegative();
			result = add(lgNum);
			result.setNegative();
			setNegative();
		}
		else {
			spList.resetForward();
			spList.resetBackward();
			lgNum.spList.resetForward();
			lgNum.spList.resetBackward();

			setNegative();
			lgNum.setNegative();
			result = lgNum.subtract(this);
			setNegative();
			lgNum.setNegative();
		}
		


		return result;
		
		
	}

	@Override
	public void setNegative() {
		// TODO Auto-generated method stub


		isNegative = !isNegative;

	}
	
	public String toString() {
		
		String str = "";
		spList.resetBackward();
		spList.resetForward();
		boolean valid = false;
		int size = spList.lengthIs();
		
		if(isNegative) {
			str += "-";
			
		}

		for(int i = 0; i < size; i++) {
			int bit = spList.getNextItem();
			
			if(bit != 0 || i == size - 1) {
				valid = true;
			}
				
			if(valid) {
				str += bit;
			}			
		}

		

		

		
		return str;
	}
	
	

}
