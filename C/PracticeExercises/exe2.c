/*Practice Exercise 2
using FILE I/O*/
#include <stdio.h>

typedef struct Student {
    char name[10];
    char email[50];
    int age;
} Student;

int main() {
    Student student;

    FILE *storage = fopen("students.txt", "a");
    if(storage == NULL) {
        // error message
        return 1;
    }
    
    FILE *display = fopen("students.txt", "r");

    int choice;
    char buffer[50];
    do {
        printf("Select options:\n"
        "1. Add student\n"
        "2. Show all\n"
        "3. Exit\n"
        "Enter choice: ");

        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("\n");
            printf("Enter name: ");
            scanf("%s", student.name);

            printf("Enter email: ");
            scanf("%s", student.email);

            printf("Enter age: ");
            scanf("%d", &student.age);

            printf("Added successfully\n\n");

            fprintf(storage, "%s\n%s\n%d\n", student.name, student.email, student.age);
            break;
        
        case 2:
            printf("\nList of Students:\n");
            while ((fgets(buffer, sizeof(buffer), display)) != NULL) {
                printf("%s", buffer);
            }
            printf("\n");
            break;
            
        case 3:
            printf("Exiting...\n");
            break;

        default:
            break;
        }
    } while(choice == 1 || choice == 2);
    
    // data should be saved in a text file
    fclose(storage);
    fclose(display);

    return 0;
}

