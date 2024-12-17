#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <time.h>

float somma = 0;
float media = 0;
int numbers[5];

int main(int argc, char *argv[])
{
    int p1, p2, p3, p4, p5;

    p1 = fork();

    if (p1 == 0)
    {
        printf("P1: mio PID %d mio padre ha PID=%d\n", getpid(), getppid());

        srand(time(NULL)); // Inizializza il generatore di numeri casuali con il tempo

        // Popola il vettore con numeri casuali tra 1 e 10
        for (int i = 0; i < 5; i++)
        {
            numbers[i] = (rand() % 10) + 1;
        }

        printf("Numeri casuali generati: ");
        for (int i = 0; i < 5; i++)
        {
            printf("%d ", numbers[i]);
        }
        printf("\n");

        p2 = fork();

        if (p2 == 0)
        {
            printf("P2: mio PID %d mio padre ha pid = %d\n", getpid(), getppid());
            p4 = fork();

            if (p4 == 0)
            {
                printf("P4: mio PID %d mio padre ha pid = %d\n", getpid(), getppid());
                for (int i = 0; i < 5; i++)
                {
                    somma = somma + numbers[i];
                }

                printf("P4:La somma risulta %.2f\n", somma);
                exit(0);
            }
            else
            {
                wait(NULL);
                exit(0);
            }
        }
        else
        {
            wait(NULL);
            printf("P2: mio PID %d, mio figlio P4 ha PID=%d\n", getpid(), p4);
            exit(0);
        }
        p3 = fork();

        if (p3 == 0)
        {
            p5 = fork();

            if (p5 == 0)
            {
                for (int i = 0; i < 5; i++)
                {
                    somma = somma + numbers[i];
                }
                media = somma / 5;
                printf("P5:La media risulta %f\n", media);
            }
            else
            {
                wait(NULL);
                exit(0);
            }
        }
        else
        {
            wait(NULL);
            printf("P3: mio PID %d, mio figlio P5 ha PID=%d\n", getpid(), p5);
            exit(0);
        }
        exit(0);
    }
    else
    {
        wait(NULL);
        printf("P1: mio PID %d, mio figlio P2 ha PID=%d\n", getpid(), p2);
        printf("P1: mio PID %d, mio figlio P3 ha PID=%d\n", getpid(), p3);
        exit(0);
    }

    return 0;
}