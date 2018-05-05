import java.util.*;
public class test
{
	public static void main(String[]args){
		System.out.println("输入操作字符");
		Scanner input = new Scanner(System.in);
		String File = input.next();
		test test = new test();
		Set  Postion = test.getFile(File);
		List number = test.getNumber(Postion,File);
		Iterator<Integer> it = number.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public Set getFile(String File){
		/*整个getfile方法有获取英文标点符号的功能，位置在TreeSet的Postion
		*/
		String WaitGet=File; 
		int x=-1;
		Set Postion = new TreeSet();
		if(WaitGet.indexOf(",")!=-1){
			while(WaitGet.indexOf(",",x+1)!=-1){
				x++;
				Postion.add(WaitGet.indexOf(",",x));
			}
		}else{
			System.out.println("字符串未包含英文逗号或检查是否规范");
		}
		Iterator<Integer> it = Postion.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		return Postion;
	}
	public List getNumber(Set Postion1,String File1){
		Set Postion=Postion1;
		String File=File1;
		List<Integer> number= new ArrayList<>();//新建一个double类集合用于储存得到的数字
		Iterator<Integer> it = Postion.iterator();
		int x=0;
		int y=0;
		while(it.hasNext()){
			if(x==0){
				number.add(Integer.parseInt(File.substring(0,it.next()).trim()));
				x++;
				y=it.next();
			}else if(x==Postion.size()){
				number.add(Integer.parseInt(File.substring(it.next(),File.length()+1).trim()));
			}else{
				number.add(Integer.parseInt(File.substring(y+1,it.next()).trim()));
				y=it.next();
			}
		
	}
	return number;
}}
