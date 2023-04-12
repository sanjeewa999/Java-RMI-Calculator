import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import  java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class MathClient {
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new RMISecurityManager());
        }

        MathService service = null;

        try {
            service = (MathService) Naming.lookup("//loclhost/CalculatorService");

            System.out.println("Add" + service.add(2,2));
            System.out.println("Substract" + service.substract(5,2));
            System.out.println("Multiply" + service.multiply(6,2));
            System.out.println("Divide" + service.divide(20,2));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
