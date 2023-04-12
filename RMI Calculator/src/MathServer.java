//import java.rmi.RMISecurityManager;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class MathServer extends UnicastRemoteObject implements MathService {

    public MathServer() throws RemoteException{
        super();
    }

    @Override
    public int add(int num1, int num2) throws RemoteException {
        System.out.println("Adding "+ num1 + "and" + num2 + " in the server");
        return num1+num2;
    }

    @Override
    public int substract(int num1, int num2) throws RemoteException {
        System.out.println("Substracting "+ num1 + "and" + num2 + " in the server");
        return num1-num2;
    }

    @Override
    public int multiply(int num1, int num2) throws RemoteException {
        System.out.println("Multipling "+ num1 + "and" + num2 + " in the server");
        return num1*num2;
    }

    @Override
    public int divide(int num1, int num2) throws RemoteException {
        System.out.println("Dividing "+ num1 + "and" + num2 + " in the server");
        return num1/num2;
    }

    public int test(int num1) throws RemoteException{
        System.out.println("This is testing");
        return 0;
    }

    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new RMISecurityManager());

            try {
                MathServer svr = new MathServer();

                Registry registry = LocateRegistry.getRegistry();
                registry.bind("CalculatorService",svr);

                System.out.println("Service startd");
            }
            catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            catch (AlreadyBoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
