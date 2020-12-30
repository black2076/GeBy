package home.kbj.java.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/* title: �÷����� ���� ���� (����� �����ϴ� ����Ʈ����) */
/* condition
 * mov sum 0: sum������ 0�� ����
 * add sum i: sum������ i�� ����
 * sub n 1: n������ ���� 1 ����
 * jn0 n 3: ���� n�� ���� 0�� �ƴϸ� 3��° ������� ���ư���
 * prt sum 0: sum ������ ���� ����ϰ� ���α׷� ����
 * prt���� ������ 0�� Ư���� �ǹ̰� ����
 * go�� ���ݱ��� �Է��� ���α׷��� ó������ ����
 * 
 */
public class ExecuteCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperComputer superCom = new SuperComputer();
		
		while(true) {
			superCom.enterCommand();
			superCom.executeCommands();
		}
	}

}


class SuperComputer {
	private ArrayList<Command> commands;
	private HashMap<String, Integer> hm;
	private int index;
	private int tempIndex;
	
	public SuperComputer() {
		// TODO Auto-generated constructor stub
		commands = new ArrayList<>();
		hm = new HashMap<>();
		index = 0;
		System.out.println("Supercom works. Please enter the program. Type GO and it works.");
	}
	
	@SuppressWarnings("resource")
	void enterCommand() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print(">> ");
			String line = sc.nextLine();
			
			if("GO".equals(line.toUpperCase()))
				break;
			
			String[] lines = line.split(" ");
			commands.add(new Command(lines[0], lines[1], lines[2]));
		}
	}

	void executeCommands() {
		while(true) {
			String operator = commands.get(index).getOperator();
			String var = commands.get(index).getVariable();
			String value = commands.get(index).getValue();
			index++;
				
			switch (operator) {
			case "mov":
				mov(var, value);
				break;
			case "add":
				add(var, value);
				break;
			case "sub":
				sub(var, value);
				break;
			case "jn0":
				tempIndex = index;
				jn0(var, value);
				break;
			case "prt":
				prt(var, value);
				break;
			default:
				break;
			}
			
			if(index == commands.size()) {
				index = 0;
				hm.clear();
				commands.clear();
				break;
			}
		}
	}
	
	private void mov(String var, String value) {
		hm.put(var, Integer.parseInt(value));
	}

	private void add(String var, String value) {
		if(hm.containsKey(value))
			hm.put(var, hm.get(var) + hm.get(value));
		else
			hm.put(var, hm.get(var) + Integer.parseInt(value));
	}
	
	private void sub(String var, String value) {
		if(hm.containsKey(value))
			hm.put(var, hm.get(var) - hm.get(value));
		else
			hm.put(var, hm.get(var) - Integer.parseInt(value));
	}
	
	private void jn0(String var, String value) {
		if(hm.get(var) != 0)
			index = Integer.parseInt(value);
		else
			index = tempIndex;
	}
	
	private void prt(String var, String value) {
		System.out.printf("[prt %s %s] \n", var, value);
		for(Entry<String, Integer> entry : hm.entrySet()) {
			System.out.printf("%s:%s ", entry.getKey().toUpperCase(), entry.getValue());
		}
		System.out.printf("\nThe result to be printed is %s, end of program execution \n", hm.get(var));
	}
}


// command object
class Command {
	private String operator;
	private String variable;
	private String value;
	
	public Command(String operator, String variable, String value) {
		// TODO Auto-generated constructor stub
		this.operator = operator;
		this.variable = variable;
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public String getVariable() {
		return variable;
	}

	public String getValue() {
		return value;
	}
	
	
	
}

/* result
 * �������� �۵��մϴ�. ���α׷��� �Է����ּ���. GO�� �Է��ϸ� �۵��մϴ�. 	Supercom works. Please enter the program. Type GO and it works.
 * ��ɾ� �Է�..
 * [prt sum 0]
 * I:15 SUM:95 N:0
 * ����� ����� 95, ���α׷� ���� �� Printing 	The result to be printed is 95, end of program execution
 */
