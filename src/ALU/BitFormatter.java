package ALU;

public class BitFormatter {
	public static boolean[] i2b(int num) {
		int N = num;
		boolean[] ret = new boolean[32];
		for (int i = 0; i < 32; i++) {
			ret[i] = N % 2 == 0 ? false : true;
			N /= 2;
		}

		return ret;
	}

	public static String toString(boolean[] b) {
		char[] c = new char[39];
		int d = 38;
		for (int i = 0; i < 32; i++) {
			if (i % 4 == 0 && i!=0)
				c[d--] = ' ';
			c[d--] = b[i] ? '1' : '0';
		}
		String ret = new String(c);
		return new String(c);
	}
	
	public static int b2i(boolean[] bit) {
		int ret=0;
		int d=1;
		for(boolean b:bit) {
			ret+=(d*(b?1:0));
			d*=2;
		}
		
		return ret;
	}

}
