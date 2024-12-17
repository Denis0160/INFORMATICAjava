#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

int n;
bool controllo = false;

void stampa_tabellina(int numero)
{
    printf("P2: i primi 10 termini della tabellina del numero %d sono:\n", numero);
    for (int i = 1; i <= 10; i++)
    {
        printf("P2: %d * %d = %d\n", numero, i, numero * i);
    }
}

void conto_rovescia(int numero)
{
    for (int i = numero; i >= 0; i--)
    {
        printf("P5: %d\n", i);
        sleep(1); // Pausa di 1 secondo tra ogni numero
    }
}

int main(int argc, char *argv[])
{
    int p1, p2, p3, p4, p5;

    do
    {
        printf("Inserisci un numero compreso tra 3 e 10\n");
        scanf("%d", &n);

        if (n >= 3 && n <= 10)
        {
            controllo = true;
        }
        else
        {
            printf("Numero errato, reinserisci \n");
        }
    } while (!controllo);

    p1 = fork();
    if (p1 == 0)
    {
        printf("P1: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());

        p2 = fork();
        if (p2 == 0)
        {
            printf("P2: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());

            p4 = fork();
            if (p4 == 0)
            {
                printf("P4: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());
                exit(0);
            }
            else
            {
                wait(NULL);
            }

            p5 = fork();
            if (p5 == 0)
            {
                printf("P5: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());

                conto_rovescia(n);
                exit(0);
            }
            else
            {
                wait(NULL);
            }

            stampa_tabellina(n);
            exit(0);
        }
        else
        {
            wait(NULL); // P1 aspetta che P2 finisca
            printf("P1: mio PID = %d, mio figlio P2 ha PID = %d\n", getpid(), p2);
        }

        p3 = fork();
        if (p3 == 0)
        {
            printf("P3: mio PID = %d, mio padre ha PID = %d\n", getpid(), getppid());
            wait(NULL);
            exit(0);
        }
        else
        {
            wait(NULL);
            printf("P1: mio PID = %d, mio figlio P3 ha PID = %d\n", getpid(), p3);
        }

        exit(0);
    }
    else
    {
        wait(NULL);
        exit(0);
    }

    return 0;
}
