package week11hackerpractice;

public class Note7Practice6 {
	public static void main(String[] arg) {
		double h = 0.1;
		double[] f = new double[9];
		for(int i = 0; i < 9; i++) {
			f[i] = -1 * h * h;
		}
		double[][] jac = new double[9][9];
		for(int i = 0; i < 8; i++) {
			jac[i][i] = -2;
			jac[i + 1][i] = 1;
			jac[i][i + 1] = 1;
			jac[i + 1][i + 1] = -2;
		}
		Solver sol = new Solver();
		double[] phi1 = sol.solution(jac, f);
		System.out.println("The result by finite element is: ");
		for(int i = 0; i < 9; i++) {
			System.out.println(phi1[i]);
		}
		f[0] = -2 * h * h;
		double[] phi2 = sol.solution(jac, f);
		System.out.println("The result by finite difference is: ");
		for(int i = 0; i < 9; i++) {
			System.out.println(phi2[i]);
		}
	}
}
