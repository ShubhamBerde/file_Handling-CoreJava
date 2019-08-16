import java.io.*;
import java.util.*;
class Assignment
{
	String name;
	int rn, val;
	String add;
	Scanner sc=new Scanner(System.in);
	
	public void accept() 
	{
		try{
			System.out.println("Enter your roll no: ");
			rn=sc.nextInt();

			System.out.println("Enter your name: ");
			name=sc.nextLine();		
			name=sc.nextLine();		
			
			System.out.println("Enter your address: ");
			add=sc.nextLine();

			FileWriter fw1=new FileWriter("D:\\shubham\\test.txt",true);
			fw1.write(rn+";"+name+";"+add+".");
			fw1.close();
	
		}catch(Exception e){System.out.print(e);}
	}

	public void select()
	{
		System.out.println("\n**Select option**\n");		
		System.out.println("1. Add record");		
		System.out.println("2. Update record");
		System.out.println("3. Delete record");
		System.out.println("4. Search record");
		System.out.println("5. Show all records");
		System.out.println("6. Exit");
	
		val=sc.nextInt();		
		switch(val)
		{
			case 1:
				accept();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();	
				break;
			case 5:
				disp();
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid option");
				break;				
		}

		if(val<6)
		{
			select();		
		}
		
	}
	public void update()
	{
		try{
			FileReader fr=new FileReader("D:\\shubham\\test.txt");
			BufferedReader br=new BufferedReader(fr);
			String str;	
			String upd;
			int uprn;
			String upname,upadd;
			System.out.println("Enter rollno. to updtae its data: ");
			upd=sc.nextLine();
			upd=sc.nextLine();
			String[] arrOfStr=null;
			FileWriter FD=new FileWriter("D:\\shubham\\test2.txt");
			while((str=br.readLine())!=null)		
			{
				arrOfStr = str.split("\\.");
   				for (String a : arrOfStr) 
				{
					arrOfStr= a.split(";");
					if(upd.equals(arrOfStr[0]))
					{
						System.out.println("Enter name: ");
						upname=sc.nextLine();
	
						System.out.println("Enter address: ");
						upadd=sc.nextLine();
		
						FD.write(upd+";"+upname+";"+add+".");

					}
					else 
					{
						FD.write(a+".");				
					}
				}	
			}
		
			br.close();
			FD.close();
			fr.close();
			
			
			File f=new File("D:\\shubham\\test.txt");
			f.delete();
			File of=new File("D:\\shubham\\test2.txt");
			File nf=new File("D:\\shubham\\test.txt");
			of.renameTo(nf);
			
		}catch(Exception e){System.out.println(e);}
	}
	
	public void delete()
	{
		try{
			FileReader fr=new FileReader("D:\\shubham\\test.txt");
			BufferedReader br=new BufferedReader(fr);
			String str;	
			String search;
			System.out.println("Enter rollno: ");
			search=sc.nextLine();
			search=sc.nextLine();
			String[] arrOfStr=null;
			FileWriter fw2=new FileWriter("D:\\shubham\\test2.txt");
			while((str=br.readLine())!=null)		
			{
				arrOfStr = str.split("\\.");
   				for (String a : arrOfStr) 
				{
					arrOfStr= a.split(";");
					if(search.equals(arrOfStr[0]))
					{
					}
					else 
					{
						fw2.write(a+".");				
					}
				}	
			}
			br.close();
			fw2.close();
			fr.close();
			File f=new File("D:\\shubham\\test.txt");
			f.delete();
			File f1=new File("D:\\shubham\\test2.txt");
			File nf=new File("D:\\shubham\\test.txt");
			f1.renameTo(nf);	
		}catch(Exception e){System.out.print(e);}
	}
	public void search()
	{
		try{
			FileReader fr=new FileReader("D:\\shubham\\test.txt");
			BufferedReader br=new BufferedReader(fr);
			String str;	
			String search;
			System.out.println("Enter rollno: ");
			search=sc.nextLine();
			search=sc.nextLine();
			String[] arrOfStr=null;
			while((str=br.readLine())!=null)		
			{
				arrOfStr = str.split("\\.");
      				for (String a : arrOfStr) 
				{
					arrOfStr= a.split(";");

					if(search.equals(arrOfStr[0]))
					{
						System.out.println(a);
						break;
					}
				}	
			}	
			br.close();	 
			fr.close();	
		}catch(Exception e){System.out.print(e);}
	}
	public void disp()
	{	
		try{
			FileReader fr=new FileReader("D:\\shubham\\test.txt");
			BufferedReader br=new BufferedReader(fr);
			String str;
			while((str=br.readLine())!=null)		
			{
				str=str.replace('.','\n');			
				str=str.replace(';','\t');
				System.out.print(str);
			}
			br.close();
			fr.close();
		}catch(Exception e){System.out.print(e);}
	}

	public static void main(String args[]) throws Exception
	{
		Assignment asg=new Assignment();
		asg.select();
	}
}