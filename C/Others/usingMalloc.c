#include <stdio.h>
#include <stdlib.h>

// Family is a node
typedef struct Family {
    char fam_mem[20];
    int mem_count;
    struct Family *next_mem;
} Family;

int main() {
    int choice;
    int mem_count = 0;
    // *family would be the main linked list
    Family *family = NULL;

    // allocate memory for the parent node
    Family *parent = malloc(sizeof(Family));
    if (parent == NULL) {
        return 1;
    }

    // first member of the node
    printf("Enter the name of the parent: ");
    scanf("%s", parent->fam_mem); // parent name
    parent->mem_count = mem_count++; // assigns mem_count and adds +1
    parent->next_mem = NULL;

    // point family to parent
    // safe practice for memory leaks
    family = parent;

    do {
        printf("\n0 - add children\n"
               "1 - display all children\n"
               "2 - exit\n\n"
               "Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 0: {
                // allocate memory for the child node
                Family *child = malloc(sizeof(Family));
                if (child == NULL) {
                    return 1;
                }

                printf("Enter child name: ");
                scanf("%s", child->fam_mem);
                child->mem_count = mem_count++;
                child->next_mem = NULL;

                // study this
                // appending to linked list
                Family *ptr = family;
                while (ptr->next_mem != NULL) { // if next is not empty
                    ptr = ptr->next_mem;    // move to the succeeding 'next'
                }
                ptr->next_mem = child; // at the very end, attach the new added child

                break;
            }

            case 1: {
                // child display
                Family *ptr = family;
                while (ptr != NULL) {
                    if(ptr->mem_count == 0) {
                        printf("\nThe children of %s are:\n", ptr->fam_mem);
                    }
                    else {
                        printf("%d. %s\n", ptr->mem_count, ptr->fam_mem);
                    }
                    ptr = ptr->next_mem;
                }
                break;
            }

            case 2:
                printf("Exiting...\n");
                break;

            default:
                break;
        }
    } while (choice != 2);

    // free the allocated memory
    Family *ptr = family;
    while (ptr != NULL) {
        Family *temp = ptr; // point temp to current node
        ptr = ptr->next_mem; // move to next node
        free(temp); // free node where temp is pointed
    }

    return 0;
}