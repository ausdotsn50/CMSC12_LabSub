/*Practice Exercise 1
using struct and enum*/
#include <stdio.h>

// writing enum
enum roles {manager, janitor, supervisor};

// writing a struct
typedef struct Employee {
    char name[10];
    enum roles role;
    int age;
} Employee;

int main() {
    int numof_e;
    printf("How many employees to add: ");
    scanf("%d", &numof_e);

    Employee employee[numof_e];

    // getting data
    for (int i = 0; i < numof_e; i++) {
        printf("Enter name: ");
        scanf("%s", employee[i].name);

        // storing int
        printf("0 - manager\n"
        "1 - janitor\n"
        "2 - supervisor\n\n"
        "Choose role number: ");
        scanf("%d", &employee[i].role);

        printf("Enter age: ");
        scanf("%d", &employee[i].age);
        printf("\n");
    }

    for (int i = 0; i < numof_e; i++) {
        printf("%s\n", employee[i].name);
        // use the 'string' instead of number because -> what if you changed the value above
        if (employee[i].role == manager) {
            printf("manager\n");
        }
        else if (employee[i].role == janitor) {
            printf("janitor\n");
        }
        else if (employee[i].role == supervisor){
            printf("supervisor\n");
        }
        printf("%d\n", employee[i].age);
    }
    
    return 0;
}