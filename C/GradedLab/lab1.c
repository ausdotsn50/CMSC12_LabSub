#include <stdio.h>
#include <string.h>

#define MAX_EMPLOYEES 10

// use typedef here
enum Department {HR, IT, SALES, MARKETING};

typedef struct Employee {
    int id;
    char name[20];
    int age;
    enum Department dep;
    int base_salary;
    int bonus;
} Employee;

int main() {
    Employee employees[MAX_EMPLOYEES];

    FILE *ptr = fopen("employees.txt", "r");

    if(ptr == NULL) {
        return 1;
    }

    // reading from txt and storing to struct
    int employee_count = 0;
    char reader[50];
    for (int i = 0; i < 3; i++) {
        // if NULL basically
        if(fscanf(ptr, "%d", &employees[i].id) != 1) {
            break;
        }
        fscanf(ptr, "%s", employees[i].name);
        fscanf(ptr, "%d", &employees[i].age);
        fscanf(ptr, "%d", &employees[i].dep); // read department as int -> enum
        fscanf(ptr, "%d", &employees[i].base_salary);
        fscanf(ptr, "%d", &employees[i].bonus);
        employee_count += 1;
    }

    int choice;
    do {
        // MAIN MENU
        printf("\nMenu\n"
        "1. Add Employee\n"
        "2. View Employees\n"
        "3. Search Employee\n"
        "4. Save and Exit\n"
        "Choice: ");

        scanf("%d", &choice);

        switch (choice)
        {
        case 1: // adding employee
            printf("\nPlease enter employee details:\n");

            printf("ID: ");
            scanf("%d", &employees[employee_count].id);

            printf("Name: ");
            scanf("%s", employees[employee_count].name);

            printf("Age: ");
            scanf("%d", &employees[employee_count].age);

            printf("Department\n"
            "0 - HR, 1 - IT, 2 - SALES, 3 - MARKETING\n"
            "Choice: ");
            scanf("%d", &employees[employee_count].dep);

            printf("Base Salary: ");
            scanf("%d", &employees[employee_count].base_salary);

            printf("Bonus: ");
            scanf("%d", &employees[employee_count].bonus);
            
            employee_count += 1;
            printf("\nEntry succesfully added!\n");
            break;
        
        case 2: // viewing employee
            // accessing Employee struct
            printf("\nE M P L O Y E E   L I S T\n");
            for(int i = 0; i < employee_count; i++) {
                printf("\nID: %d\n", employees[i].id);
                printf("Name: %s\n", employees[i].name);
                printf("Age: %d\n", employees[i].age);
                
                printf("Department: ");
                if(employees[i].dep == HR) {
                    printf("HR\n");
                }
                else if(employees[i].dep == IT) {
                    printf("IT\n");
                }
                else if(employees[i].dep == SALES) {
                    printf("SALES\n");
                }
                else if(employees[i].dep == MARKETING) {
                    printf("MARKETING\n");
                }
                printf("Base Salary: %d\n", employees[i].base_salary);
                printf("Bonus: %d\n", employees[i].bonus);
            }
            break;
        
        int ID;
        case 3:
            printf("\nEnter ID to search employee: ");
            scanf("%d", &ID);

            for(int i = 0; i < employee_count; i++) {
                if(employees[i].id == ID) {
                    printf("\nE M P L O Y E E   I N F O   S U M M A R Y\n");
                    printf("Name: %s\n", employees[i].name);
                    printf("Total Salary: %d\n", employees[i].base_salary + employees[i].bonus);
                    break;
                }
            }
            break;
        
        case 4: // exit
            printf("Data saved to a text file!\nBye!\n");
            break;
        default:
            break;
        }
    } while (choice != 4);

    // printf("%d\n", employee_count);
    FILE *ptr2 = fopen("employees.txt", "w");
    
    if(ptr2 == NULL) {
        return 1;
    }

    for(int i = 0; i < employee_count; i++) {
        fprintf(ptr2, "%d\n", employees[i].id);
        fprintf(ptr2, "%s\n", employees[i].name);
        fprintf(ptr2, "%d\n", employees[i].age);
        fprintf(ptr2, "%d\n", employees[i].dep);
        fprintf(ptr2, "%d\n", employees[i].base_salary);
        fprintf(ptr2, "%d\n", employees[i].bonus);
    }

    fclose(ptr);
    fclose(ptr2);
    return 0;
}