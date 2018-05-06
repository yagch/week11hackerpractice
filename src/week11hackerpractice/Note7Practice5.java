package week11hackerpractice;

public class Note7Practice5 {
	public static void main(String[] arg) {
		double leastSqEr = 0; // least-square error
		double areaEst = 0;  // the area estimated
		double areaGT = 0;   // ground truth area
		double range = Math.PI / 2;
		double x;
		for(int i = 1; i <= 100; i++) {
			x = i * range / 101;
			leastSqEr += (approxf(x) - f(x)) * (approxf(x) - f(x));
			areaEst += approxf(x) * range / 101;
			areaGT += f(x) * range / 101;
			System.out.println(approxf(x));
		}
		System.out.println("The least-square error is:");
		System.out.println(leastSqEr);
		System.out.println("The percentage area error is:");
		System.out.println(100 * (areaEst - areaGT) / areaGT + "%");
	}
	public static double xi(int i) {
		return (i / 16) * Math.PI;
	}
	public static double f(double x) {
		if(x > Math.PI / 2 || x < 0) {
			return 0;
		}
		else {
			return Math.sin(x);
		}
	}
	public static double[] v(double x) {
		double[] res = new double[7];
		for(int i = 0; i < 7; i++) {
			if(x >= xi(i) && x < xi(i + 1)) {
				res[i] = (x - xi(i)) / (xi(i+1) - xi(i));
			}
			else if(x >= xi(i + 1) && x < xi(i + 2)) {
				res[i] = (xi(i + 2) - x) / (xi(i + 2) - xi(i + 1));
			}
			else {
				res[i] = 0;
			}
		}
		return res;
	}
	public static double approxf(double x) {
		double res = 0;
		for(int i = 0; i < 7; i++) {
			res += f(xi(i + 1)) * v(x)[i];
		}
		return res;
	}
}
