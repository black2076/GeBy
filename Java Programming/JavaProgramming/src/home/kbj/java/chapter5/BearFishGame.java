package home.kbj.java.chapter5;

import java.util.Scanner;

/* Application: Bear�� Fish �Ա� ���� */
/* Explanation
 * Bear�� Fish ��ü�� ����, 10�� 20���� ������
 * Bear: ����(a), �Ʒ�(s), ��(d), ������(f)
 * Fish: �ټ� �� �� �� ���� ���ڸ�, �� ���� �������� �� ĭ
 * Bear�� Fish�� ������ game over
 * Ű�� �Էµ� ������ Bear�� Fish ��ü�� move()�� ������� ȣ��
 * */


public class BearFishGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// grid
		char[][] grid = new char[10][20];
		
		
		// create object of bear, fish
		Bear bear = new Bear(0, 0, 1);
		Fish fish = new Fish(5, 5, 1);
		
		// initialize
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = '-';
			}
		}
			
		// put bear, fish in the grid
		grid[bear.getX()][bear.getY()] = bear.getShape();
		grid[fish.getX()][fish.getY()] = fish.getShape();
		
		System.out.println("** Let's start Bear's Fish Eating Game. **");
		
		int fishCount = 0;
		while(true) {
			// print current grid
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++)
					System.out.print(grid[i][j]);
				System.out.println();
			}
			
			// move bear
			grid[bear.getX()][bear.getY()] = '-';
			bear.move();
			grid[bear.getX()][bear.getY()] = bear.getShape();
			
			// exit
			if(bear.collide(fish))
				break;
			
			// move fish
			if(++fishCount > 3) {
				grid[fish.getX()][fish.getY()] = '-';
				fish.move();
				grid[fish.getX()][fish.getY()] = fish.getShape();
				if(fishCount >= 5)
					fishCount = 0;
			}

		}
		
		System.out.println("Bear Wins!!");
		
	}
	
}

// Bear
class Bear extends GameObject {
	
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.print("left(a), down(s), up(d), right(f) >> ");
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		
		switch (direction) {
		case "a":
			y -= distance;
			if(y <= 0) {
				System.out.println("cannot be move left");
				y += distance;
			}
			break;
		case "s":
			x += distance;
			if(x >= 10) {
				System.out.println("cannot be move down");
				x -= distance;
			}
			break;
		case "d":
			x -= distance;
			if(x <= 0) {
				System.out.println("cannot be move up");
				x += distance;
			}
			break;
		case "f":
			y += distance;
			if(y >= 20) {
				System.out.println("cannot be move right");
				y -= distance;
			}
			break;
		default:
			break;
		}
		
	}

	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'B';
	}
	
}

// Fish
class Fish extends GameObject {
	
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		boolean isMove = true; // move unconditionally
		while(isMove) {
			int direction = (int)(Math.random()*4) + 1;
			switch (direction) {
			case 1:
				y -= distance;
				if(y <= 0) {
					y += distance;
				}
				else
					isMove = false;
				break;
			case 2:
				x += distance;
				if(x >= 10) {
					x -= distance;
				}
				else
					isMove = false;
				break;
			case 3:
				x -= distance;
				if(x <= 0) {
					x += distance;
				}
				else
					isMove = false;
				break;
			case 4:
				y += distance;
				if(y >= 20) {
					y -= distance;
				}
				else
					isMove = false;
				break;
			default:
				break;
			}
		}

	}

	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return '@';
	}
	
}


/* result
 * ** Bear�� Fish �Ա� ������ �����մϴ�. ** Let's start Bear's Fish Eating Game.
 * Bear Wins!! 
 */