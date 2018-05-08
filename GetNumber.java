import java.util.*;
public class GetNumber
{
//版本2.1
	public static void main(String[]args){
		System.out.println("输入操作字符");
		Scanner input = new Scanner(System.in);
		String File = input.next();
		test test = new test();
		Set  Postion = test.getFile(File);
		List number = test.getNumber(Postion,File);//获取的数字在List集合中的number中
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
		
		return Postion;
	}
	public List getNumber(Set Postion1,String File1){
	
		Integer[] Postion = (Integer[]) Postion1.toArray(new Integer[] {});
		String File=File1;
		List<Integer> number= new ArrayList<>();//新建一个double类集合用于储存得到的数字
		int x=-1;
		int y=0;
		for(int i=0;i<=Postion.length;i++){
			if(i==0){
				x=Postion[i];
				number.add(Integer.parseInt(File.substring(0,x)));
			}else if(i==Postion.length){
				number.add(Integer.parseInt(File.substring(Postion[i-1]+1,File.length())));
			}else{
				number.add(Integer.parseInt(File.substring(Postion[i-1]+1,Postion[i])));
			}
		}
		
	
	return number;}}
