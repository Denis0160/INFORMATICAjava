#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

int n; // Numero che l'utente inserisce
bool controllo = false; // Variabile di controllo per la validità del numero

// Funzione per stampare la tabellina del numero n
void stampa_tabellina(int numero) {
    printf("P2: i primi 10 termini della tabellina del numero %d sono:\n", numero);
    for (int i = 1; i <= 10; i++) {
        printf("P2: %d * %d = %d\n", numero, i, numero * i);
    }
}

// Funzione per eseguire il conto alla rovescia da n a 0 con ritardo di 1 secondo
void conto_rovescia(int numero) {
    for (int i = numero; i >= 0; i--) {
        printf("P5: %d\n", i);
        sleep(1); // Pausa di 1 secondo tra ogni numero
    }
}

int main(int argc, char *argv[]) {
    int p1, p2, p3, p4, p5;

    // Ciclo per ottenere un numero valido da parte dell'utente
    do {
        printf("Inserisci un numero compreso tra 3 e 10\n");
        scanf("%d", &n);

        if (n >= 3 && n <= 10) {
            controllo = true; // Se il numero è valido, termina il ciclo
        } else {
            printf("Numero errato, reinserisci \n");
        }
    } while (!controllo); // Il ciclo continua finché il numero non è valido

    // Processo padre P1 crea P2
    p1 = fork();
    if (p1 == 0) { // Se siamo nel processo P1 (figlio del processo principale)
        printf("P1: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());

        // Processo P1 crea il processo P2
        p2 = fork();
        if (p2 == 0) { // Se siamo nel processo P2
            printf("P2: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());

            // P2 crea il processo P4
            p4 = fork();
            if (p4 == 0) { // Se siamo nel processo P4
                printf("P4: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());
                exit(0); // Processo P4 termina subito
            } else {
                wait(NULL); // P2 aspetta che P4 finisca
            }

            // P2 crea il processo P5
            p5 = fork();
            if (p5 == 0) { // Se siamo nel processo P5
                printf("P5: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());
                // P5 esegue il conto alla rovescia
                conto_rovescia(n);
                exit(0); // Processo P5 termina
            } else {
                wait(NULL); // P2 aspetta che P5 finisca
            }

            // P2 visualizza la tabellina del numero n
            stampa_tabellina(n);
            exit(0); // Processo P2 termina
        } else {
            wait(NULL); // P1 aspetta che P2 finisca
            printf("P1: mio PID = %d, mio figlio P2 ha PID = %d\n", getpid(), p2);
        }

        // Processo P1 crea il processo P3
        p3 = fork();
        if (p3 == 0) { // Se siamo nel processo P3
            printf("P3: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());
            // P3 crea il processo P4 e P5
            wait(NULL); // P3 aspetta che P4 finisca
            exit(0); // Processo P3 termina
        } else {
            wait(NULL); // P1 aspetta che P3 finisca
            printf("P1: mio PID = %d, mio figlio P3 ha PID = %d\n", getpid(), p3);
        }

        exit(0); // Processo P1 termina
    } else {
        wait(NULL); // Processo principale aspetta che P1 finisca
        exit(0); // Processo principale termina
    }

    return 0;
}
