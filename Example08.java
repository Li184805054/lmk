
public class Example08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("1�����----------------");
         add();
         System.out.println("2��ɾ��----------------");
         remove();
         System.out.println("3���޸�----------------");
         alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		sb.append("18481111 С�� ��;18482222 С�� Ů;18483333 С�� ��;");
		System.out.println("append��ӽ����"+sb);
		sb.insert(0,"164801000 ���� ��;");
		System.out.println("insert��ӽ����"+sb);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("18481111 С�� ��;18482222 С�� Ů");
		sb.delete(0,14);
		System.out.println("ɾ��ָ��λ�ý����"+sb);
		sb.deleteCharAt(12);
		System.out.println("ɾ��ָ��λ�ý����"+sb);
		sb.delete(0,sb.length());
		System.out.println("��ջ����������"+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("18481111 С�� ��");
		sb.setCharAt(1,'0');
		System.out.println("�޸�ָ��λ���ַ������"+sb);
		sb.replace(9,11,"С��");
		System.out.println("�滻ɾ��ָ��λ���ַ������"+sb);
		System.out.println("�ַ�����ת�����"+sb.reverse());
	}

}