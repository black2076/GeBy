package home.kbj.java.chapter4;

/* title: �뷡 �� ���� ��Ÿ���� Song Ŭ������ �ۼ� */
/* condition 1
 * �뷡�� ������ ��Ÿ���� title
 * ������ ��Ÿ���� artist
 * �뷡�� ��ǥ�� ������ ��Ÿ���� year
 * ������ ��Ÿ���� country 
 */
/* condition 2
 * ������ 2��: �⺻ �����ڿ� �Ű������� ��� �ʵ带 �ʱ�ȭ�ϴ� ������
 * �뷡 ������ ����ϴ� show() method
 * main method: 1978��, ������ ������ ABBA�� �θ� "Dancing Queen"�� ��ü�� �����ϰ� show()�� �̿��Ͽ� �뷡�� ������ ���
 */
public class ChapterFourExampleThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song("Dancing Queen", "ABBA", "1978", "Swedish");
		song.show();
	}

}

class Song {
	private String title, artist, year, country;
	
	// basic constructor
	Song() {}
	
	Song(String title, String artist, String year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	void show() {
		System.out.printf("%s sung by the %s national %s in %s", title, country, artist, year);
	}
}
/* result
 * Dancing Queen sung by the Swedish national ABBA in 1978
 */