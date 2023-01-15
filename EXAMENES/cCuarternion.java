import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class cCuarternion{
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        //Imprime la lista de objetos remotos
        Registry registry = LocateRegistry.getRegistry();
        String[] names = registry.list();
        for (String name : names) {
            System.out.println(name);
        }

        //Introduce los cuaterniones
        System.out.println("Introduce el primer cuaterniones");
        float[] q1 = new float[4];
        for (int i = 0; i < q1.length; i++) {
            q1[i] = s.nextFloat();
        }

        System.out.println("Introduce el segundo cuaterniones");
        float[] q2 = new float[4];
        for (int i = 0; i < q2.length; i++) {
            q2[i] = s.nextFloat();
        }

        //Suma
        iCuaternion RefObRemoto1 = (iCuaternion)Naming.lookup("//localhost/Suma");
        float[] q3 = new float[4];
        RefObRemoto1.sumCuaternion(q1, q2) = q3;
        System.out.println("Cuaternario 1 sumado: ");
        for (int i = 0; i < q3.length; i++) {
            System.out.println(q1[i]);
        }
        System.out.println("Cuaternario 2 sumado: ");
        for (int i = 0; i < q3.length; i++) {
            System.out.println(q2[i]);
        }
        System.out.println("La suma de los cuaterniones es: ");
        for (int i = 0; i < q3.length; i++) {
            System.out.println(q3[i]);
        }

        //Conjugado
        iCuaternion RefObRemoto2 = (iCuaternion)Naming.lookup("//localhost/Conjugado");
        float[] q4 = new float[4];
        RefObRemoto2.conCuaternion(q1) = q4;
        System.out.println("Cuaternario 1 tras ser conjugado: ");
        for (int i = 0; i < q4.length; i++) {
            System.out.println(q4[i]);
        }

        //Escalado
        System.out.println("Introduce el numero por el que quieres escalar el cuaterniones");
        float p = s.nextFloat();
        iCuaternion RefObRemoto3 = (iCuaternion)Naming.lookup("//localhost/Escalado");
        float[] q5 = new float[4];
        RefObRemoto3.xCuaternion(q1, p) = q5;

        //Traza
        iCuaternion RefObRemoto4 = (iCuaternion)Naming.lookup("//localhost/Traza");
        float q6 = RefObRemoto4.tCuaternion(q1);
        System.out.println("La traza del cuaternio es: " + q6);


        
        
        

        
        
    }
}
