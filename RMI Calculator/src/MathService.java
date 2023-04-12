import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathService extends Remote{
    public int add(int  num1, int num2) throws RemoteException;
    public int substract(int num1, int num2) throws RemoteException;
    public int multiply(int num1, int num2) throws RemoteException;
    public int divide(int num1, int num2) throws RemoteException;
}
