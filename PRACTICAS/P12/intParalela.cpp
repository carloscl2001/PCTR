//Ejercicio 1 de la practica 12
//@author: Carlos Antonio Cortés Lora

#include <iostream>
#include <mutex>
#include <math.h>
#include <thread>
#include <chrono>
#include <ctime>

using namespace std;

//Numero total de puntos lanzados dentro del area
int totalHits = 0;

//Numero total de puntos lanzados, tanto dentro como fuera
int nHits = 0;

//Numero de puntos a lanzar
int nPuntos = 0;

//Numero de puntos a lanzar por hilo
int nPuntosPorHilo = 0;

//Mutex para controlar el acceso a las variables compartidas
recursive_mutex m;

//Metodo MoteCarlo
void MonteCarlo(){
    int hitsValidos = 0;
    int hits = 0;

    for (int i = 0; i < nPuntosPorHilo; i++)
    {
        double x = (double)rand() / RAND_MAX;
        double y = (double)rand() / RAND_MAX;
        if ( y <= pow(x, 2))
            hitsValidos++;
        hits++;
    }
    m.lock();
    totalHits += hitsValidos;
    nHits += hits;
    m.unlock();
}


//Main del ejericicio principal
int main()
{   
    int n = 0, n_hilos = 0;
    cout << "Introduzca el numero de puntos a lanzar -> ";
    cin >> nPuntos;

    cout<< "\nIntroduzca el numero de hilos a utilizar -> ";
    cin >> n_hilos;
    
    nPuntosPorHilo = nPuntos / n_hilos;

    std::chrono::time_point<std::chrono::system_clock> start, end;
    start = std::chrono::system_clock::now();

    thread hilos [n_hilos];
    
    for(int i =0; i < n_hilos ; i ++) 
        hilos[i] = thread(MonteCarlo);
    for(int i =0; i < n_hilos ; i ++) 
        hilos[i].join();
    
    end = std::chrono::system_clock::now();
    std::chrono::duration<double> elapsed_seconds = end-start;

    cout << "El resultadoo es: " << (double)totalHits / nHits << endl;
    cout << "Tiempo: " << elapsed_seconds.count() << "s\n";

    return 0;
}