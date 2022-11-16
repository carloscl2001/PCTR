static boolean esPerfecto(long n) {
        long suma = 0;

        for (long i = 1; i < n; ++i){if (n % i == 0) suma += i;}
            
        if (n == suma){return (true);}
        else{return (false);}
    }