
public class Example08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("1、添加----------------");
         add();
         System.out.println("2、删除----------------");
         remove();
         System.out.println("3、修改----------------");
         alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		sb.append("18481111 小明 男;18482222 小红 女;18483333 小亮 男;");
		System.out.println("append添加结果："+sb);
		sb.insert(0,"164801000 张三 男;");
		System.out.println("insert添加结果："+sb);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("18481111 小明 男;18482222 小红 女");
		sb.delete(0,14);
		System.out.println("删除指定位置结果："+sb);
		sb.deleteCharAt(12);
		System.out.println("删除指定位置结果："+sb);
		sb.delete(0,sb.length());
		System.out.println("清空缓冲区结果："+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("18481111 小明 男");
		sb.setCharAt(1,'0');
		System.out.println("修改指定位置字符结果："+sb);
		sb.replace(9,11,"小华");
		System.out.println("替换删除指定位置字符结果："+sb);
		System.out.println("字符串翻转结果："+sb.reverse());
	}

}