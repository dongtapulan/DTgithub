#include <stdio.h>
#include <string.h>

#define MAX_GOALS 100

typedef struct {
    char description[256];
    int isCompleted;
} Goal;

Goal goals[MAX_GOALS];
int totalGoals = 0;

void displayGoals() {
    if (totalGoals == 0) {
        printf("\nNo goals have been set yet.\n");
        return;
    }

    printf("\nYour Goals:\n");
    for (int i = 0; i < totalGoals; i++) {
        printf("%d. %s [%s]\n", i + 1, goals[i].description, goals[i].isCompleted ? "Completed" : "Incomplete");
    }
}

void addGoal() {
    if (totalGoals >= MAX_GOALS) {
        printf("\nGoal list is full. Cannot add more goals.\n");
        return;
    }

    printf("\nEnter the description of your goal: ");
    getchar(); // Clear the input buffer
    fgets(goals[totalGoals].description, 256, stdin);
    goals[totalGoals].description[strcspn(goals[totalGoals].description, "\n")] = 0; // Remove trailing newline
    goals[totalGoals].isCompleted = 0;
    totalGoals++;

    printf("Goal added successfully!\n");
}

void markGoalCompleted() {
    if (totalGoals == 0) {
        printf("\nNo goals have been set yet.\n");
        return;
    }

    displayGoals();

    int choice;
    printf("\nEnter the number of the goal you have completed: ");
    scanf("%d", &choice);

    if (choice < 1 || choice > totalGoals) {
        printf("Invalid choice.\n");
        return;
    }

    goals[choice - 1].isCompleted = 1;
    printf("Goal marked as completed!\n");
}

void goalsMenu() {
    int choice;
    do {
        printf("\n[Goals Menu]\n");
        printf("1. View Goals\n");
        printf("2. Add a Goal\n");
        printf("3. Mark Goal as Completed\n");
        printf("4. Exit Goals Menu\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                displayGoals();
                break;
            case 2:
                addGoal();
                break;
            case 3:
                markGoalCompleted();
                break;
            case 4:
                printf("Exiting Goals Menu.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 4);
}