/* USER: u037
LANG: Java
TASK: hydrocarbons */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;


public class hydrocarbons {
	static int N;
	static int M;
	static int max;
	static Object[] objs;
	static long[] final_values;
	static String str;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		//elegxos xronou
		long arx = System.currentTimeMillis();
		//elegxos xronou
		File inputf = new File("hydrocarbons.in");
		readFile(inputf);
		makeFile(M, str);
		
		//elegxos xronou
		long tel = System.currentTimeMillis();
		long xronos_ekteleshs = (tel - arx)/1000;
		System.out.println(xronos_ekteleshs);
		//elegxos xronou

	}
	
	public static void readFile(File f) throws FileNotFoundException {
		Scanner sc = new Scanner(f);
		N = sc.nextInt();
		objs = new Object[N];
		
		for(int i=0;i<N;i++) {
			
			long x = sc.nextLong();
			long y = sc.nextLong();
			long z = sc.nextLong();
			objs[i] = new oikopedo(i+1, x, y, z, 0);
			
			if(((oikopedo) objs[i]).isWorth()) {
				M++;
			}

		}
		
			
		int k = 0;
		final_values = new long[N];
		for(int l=0;l<N;l++) {
			
			if(((oikopedo) objs[l]).isWorth()) {
				final_values[k] = ((oikopedo) objs[l]).apodosi;
				k++;
			}
		}
		Arrays.sort(final_values);
		
		str = "";
		for(int j=final_values.length-1;j>0;j--) {
			
			for(int g=0; g<objs.length;g++) {
				if(final_values[j] == ((oikopedo) objs[g]).apodosi && ((oikopedo) objs[g]).hi == 0) {
					str = str + ((oikopedo) objs[g]).ni+" ";
					((oikopedo) objs[g]).hi = 1;
				}
			}
			
		}
		
	}
	
	public static void makeFile(int q, String v) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter pw = new PrintWriter("hydrocarbons.out", "UTF-8");
		
		if(q != 0) {

			pw.print(q+"\n"+v);
			pw.close();
			
		} else {
			
			pw.print(q);
			pw.close();
			
		}
		
	}
	
}

class oikopedo{
	
	int ni;
	long ai;
	long bi;
	long ci;
	long apodosi;
	int hi;
	
	public  oikopedo(int n, long a, long b, long c, int h) {
		ni = n;
		ai = a;
		bi = b;
		ci = c;
		hi = h;

		apodosi = ai - ai*bi/3000 - ci*ai/40;
	}
	
	public boolean isWorth() {
		boolean condition = true;
		
		if(apodosi>0) {
			 condition = true;
		} 
		
		if(apodosi<0) {
			 condition = false;
		}
		
		return condition;

	}
}
