package a1;

public class SpecializedList implements SpecializedListInterface{
	
	private SListNode listFirst;
	private SListNode listLast;
	private int numItems;
	private SListNode forward;
	private SListNode backward;
	
	
	class SListNode {
		private byte info;
		SListNode prev;
		SListNode next;
		
		public SListNode(byte data, SListNode n, SListNode p) {
			info = data;
			next = n;
			prev = p;
		}
	}
	
	

	@Override
	public void resetForward() {
		// TODO Auto-generated method stub
		
		forward = listFirst;

	}

	@Override
	public byte getNextItem() {
		// TODO Auto-generated method stub
		
		byte value = 0;
		
		if (forward != null) {
			value = forward.info;
			if (forward == listLast) {
				forward = listFirst;
			}
			else {
				forward = forward.next;
			}
		}
		
		return value;
	}

	@Override
	public void resetBackward() {
		// TODO Auto-generated method stub
		backward = listLast;
	}

	@Override
	public byte getPriorItem() {
		// TODO Auto-generated method stub
		
		byte value = 0;
		
		if (backward != null) {
			value = backward.info;
			if (backward == listFirst) {
				backward = listLast;
			}
			else {
				backward = backward.prev;
			}
		}
		
		return value;
	}

	@Override
	public int lengthIs() {
		// TODO Auto-generated method stub
		return numItems;
	}

	@Override
	public void insertFront(byte item) {
		// TODO Auto-generated method stub
		
		SListNode newNode = new SListNode(item, null, null);
		
		if (listFirst == null) {
			listFirst = newNode;
			listLast = newNode;
		}
		else {
			newNode.next = listFirst;
			newNode.prev = null;
			listFirst.prev = newNode;
			listFirst = newNode;
		}
		numItems++;
	}

	@Override
	public void insertEnd(byte item) {
		// TODO Auto-generated method stub
		
		SListNode newNode = new SListNode(item, null, null);
		
		if (listLast == null) {
			listLast = newNode;
			listFirst = newNode;
		}
		else {
			newNode.prev = listLast;
			newNode.next = null;
			listLast.next = newNode;
			listLast = newNode;
		}
		numItems++;
	}
	
	
	public void printList() {
		resetForward();
		for(int i = 0; i < numItems; i++) {
			System.out.println(getNextItem());
		}
		
	}

}
