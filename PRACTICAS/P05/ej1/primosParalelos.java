
import java.util.concurrent.*;
import java.util.*;

public class primosParalelos {

  public static void main(String[] args) throws Exception {
    long nPuntos     = Integer.parseInt(args[0]);
    int  nTareas     = 1;
    long tVentana    = nPuntos/nTareas;
    long primosTotal = 0;
    long linf        = 0;
    long lsup        = tVentana;
    
    List<Future<Long>> contParciales = Collections.synchronizedList(
      new ArrayList<Future<Long>>());

    long startTime = System.nanoTime(); 
    
    ThreadPoolExecutor ept = new ThreadPoolExecutor(
      nTareas,
      nTareas,
      0L,
      TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>());

    for(int i=0; i<nTareas; i++){
      contParciales.add(ept.submit(
      	 new tareaPrimos(linf, lsup)));
      linf=lsup+1;
      lsup+=tVentana;
    }  
    long endTime = System.nanoTime();

    for(Future<Long> iterador:contParciales)
      try{
      	  primosTotal +=  iterador.get(); 
      }catch (CancellationException e){}
       catch (ExecutionException e){}
       catch (InterruptedException e){}   
          
    ept.shutdown();
    System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms" + "Primos hallados: "+ primosTotal);
 }   
}
