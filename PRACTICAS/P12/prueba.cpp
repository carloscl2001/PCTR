#include <thread>
#include <iostream>
#include <vector>
#include <mutex> //once_flag forma parte de <mutex>
std::once_flag bandera;
void una_vez() { std::cout << "Llamado una vez" << std::endl; }
void hello() {
    std::call_once(bandera, una_vez);
    std::cout << "Llamado muchas veces" << std::endl;
}
int main() {
    std::vector<std::thread> hilos;
    for(int i=0; i<5; i++) hilos.push_back(std::thread(hello));
    for(auto& hilo : hilos) hilo.join();
}
