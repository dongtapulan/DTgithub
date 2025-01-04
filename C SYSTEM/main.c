#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "login_signup.c"       // Account Signup Module
#include "studentprofile.c"     // Student Profile Module
#include "goals.c"              // Goals Management Module
#include "mentalwellness.c"     // Mental Wellness Tracker
#include "study_planner.c"      // Personalized Study Planner Module

// Function prototypes
void setupStudentProfile();
void enterGradesAndActivities();
void viewPerformance();
void studyPlannerMenu();

void setupStudentProfile() {
    profileMenu(); // Existing function call to manage profiles and subjects
}

void enterGradesAndActivities() {
    // Call function here
}

void viewPerformance() {
    printf("\n[View Performance]\n");
}

int main() {
    logInSignUp(); // Call the login/signup function before displaying the menu

    int choice;
    do {
        printf("\033[1;33mWelcome to AchieveMate: Student's Personalized Academic App!\n\033[0m");
        printf("\033[1;92m\nHelping you for a better Mental health and Academic Performance!\n\033[0m");
        printf("1. Setup Student Profile and Subjects\n");
        printf("2. Personalized Study Planner\n");  // New Feature
        printf("3. Enter Grades and Activities\n");//wala pani, naay code pero usbononon
        printf("4. View Performance\n"); // not yet coded
        printf("5. Set and Track Goals\n");
        printf("6. Mental Wellness Tracker and Stress Relief\n");
        printf("7. Generate Reports\n");//not yet coded
        printf("8. Exit\n");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                setupStudentProfile();//Call StudenProfile Menu
                break;
            case 2:
                studyPlannerMenu(); // Call Study Planner Menu
                break;
            case 3:
                enterGradesAndActivities();
                break;
            case 4:
                viewPerformance();
                break;
            case 5:
                goalsMenu(); // Call the Goals Menu
                break;
            case 6:
                wellnessMenu(); // Call the Mental Wellness Tracker
                break;
            case 7:
                printf("\n[Generate Reports on your Academics]\n");// not yet
                break;
            case 8:
                printf("Exiting program. Goodbye!\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 9);

    return 0;
}
