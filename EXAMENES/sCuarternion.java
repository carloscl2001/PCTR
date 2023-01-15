import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class sCuarternion extends UnicastRemoteObject implements iCuaternion {
    public float[] sumCuaternion(float[] q1,float[] q2) throws RemoteException{
        float[] q = new float[4];
        for (int i = 0; i < q.length; i++) {
            q[i] = q1[i] + q2[i];
        }
        return q;
    }

    public float[] conCuaternion(float[] q)throws RemoteException{
        float[] q1 = new float[4];
        q1[0] = q[0];
        for (int i = 1; i < q.length; i++) {
            q1[i] = -q[i];
        }
        return q1;
    }

    public float[] xCuaternion(float[] q, float p)throws RemoteException{
        float[] q1 = new float[4];
        for (int i = 0; i < q.length; i++) {
            q1[i] = q[i] * p;
        }
        return q1;
    }   

    public float tCuaternion(float[] q)throws RemoteException{
        float t = 0;
        for (int i = 0; i < q.length; i++) {
            t += q[i];
        }
        return t;
    }
    
    public sCuarternion() throws RemoteException{}

    

    public static void main(String[] args) throws Exception{
        //creamos el objeto remoto
        iCuaternion obj1 = new sCuarternion();
        iCuaternion obj2 = new sCuarternion();
        iCuaternion obj3 = new sCuarternion();
        iCuaternion obj4 = new sCuarternion();

        //Se registra el servicio
        Naming.bind("Suma", obj1);
        Naming.bind("Conjugado", obj2);
        Naming.bind("Escalado", obj3);
        Naming.bind("Traza", obj4);
        System.out.println("Servidor preparado");
    }
}

