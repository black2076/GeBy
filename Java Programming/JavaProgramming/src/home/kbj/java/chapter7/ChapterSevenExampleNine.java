package home.kbj.java.chapter7;

import java.util.Vector;

/* title: ���׸� Ŭ���� �ۼ� ���� */
/* condition: 
 * IStack<T> �������̽��� �����ϴ� MyStack<T> Ŭ���� �ۼ�
 * ������ ���Ҵ� Vector<E> �̿� 
 */
public class ChapterSevenExampleNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//defined in the example
		IStack<Integer> stack = new MyStack<Integer>();
		
		for(int i = 0; i < 10; i++)
			stack.push(i);
		
		while(true) {
			Integer n = stack.pop();
			if(n == null)
				break;
			System.out.print(n + " ");
		}

	}
}

// defined in the example
interface IStack<T> {
	T pop();
	boolean push(T ob);
}

class MyStack<T> implements IStack<T> {
	private Vector<T> v;
	
	public MyStack() {
		// TODO Auto-generated constructor stub
		v = new Vector<>();
	}
	
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T t = null;
		if(!v.isEmpty()) {
			t = v.lastElement();
			v.removeElement(t);
		}
		
		return t;
	}

	@Override
	public boolean push(T ob) {
		// TODO Auto-generated method stub
		return v.add(ob);
	}
	
}


/* result
 * 9 8 7 6 5 4 3 2 1 0
 */