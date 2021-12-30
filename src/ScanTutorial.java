import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanTutorial {
    private static final Scanner scan = new Scanner(System.in);
    public Integer coletarInteiro() {
        try {
            return ScanTutorial.scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Constants.ERROS.NUMERO_INVALIDO);
            ScanTutorial.scan.next();
            return coletarInteiro();
        }
    }

    public Double coletarDouble() {
        try {
            return ScanTutorial.scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(Constants.ERROS.NUMERO_INVALIDO);
            ScanTutorial.scan.next();
            return coletarDouble();
        }
    }
}
