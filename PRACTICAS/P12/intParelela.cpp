#include <iostream>
#include <mutex>
#include <math.h>
#include <thread>

using namespace std;

//Numero total de puntos lanzados dentro del area
int totalHits = 0;

//Numero total de puntos lanzados, tanto dentro como fuera
int nHits = 0;

//Numero de puntos a lanzar
int nPuntos = 0;

//Mutex para controlar el acceso a las variables compartidas
recursive_mutex m;

void MonteCarlo(){
    int hitsValidos = 0;
    int hits = 0;

    for (int i = 0; i < nPuntos; i++)
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




int main()
{   
    int n = 0, n_hilos = 0;
    cout << "Introduzca el numero de puntos a lanzar -> ";
    cin >> nPuntos;

    cout<< "\nIntroduzca el numero de hilos a utilizar ->";
    cin >> n_hilos;

    thread hilos [ n_hilos ];
    for(int i =0; i < n_hilos ; i ++) 
        hilos[i] =thread(MonteCarlo);
    for(int i =0; i < n_hilos ; i ++) 
        hilos[i].join();

    cout << "El resultadoo es: " << (double)totalHits / nHits << endl;

    return 0;
}