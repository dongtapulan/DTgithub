#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_SUBJECTS 10
#define MAX_PROFILES 100
#define PLANNER_FILE "study_planner.txt"
#define BREAK_LOG_FILE "study_breaks.txt"

typedef struct {
    char profileName[100];
    char subjects[MAX_SUBJECTS][100];
    int subjectCount;
} StudyPlanner;

// Function to display all profiles with subjects from studentdata.txt
void displayProfilesWithSubjects() {
    FILE *file = fopen("studentdata.txt", "r");
    if (file == NULL) {
        printf("Error: Unable to open studentdata.txt.\n");
        return;
    }

    char line[256];
    printf("\n[Available Profiles with Subjects]\n");
    while (fgets(line, sizeof(line), file)) {
        if (strncmp(line, "Full Name:", 10) == 0) {
            printf("%s", line);
        } else if (strncmp(line, "Subject:", 8) == 0) {
            printf("  %s", line); // Display subjects indented
        }
    }
    fclose(file);
}

// Function to set up a personalized study plan
void setupStudyPlanner() {
    char selectedProfile[100];
    StudyPlanner planner = {0};

    printf("\n[Select a Profile]\n");
    displayProfilesWithSubjects();
    printf("Enter the full name of the profile: ");
    getchar(); // Consume newline
    fgets(selectedProfile, sizeof(selectedProfile), stdin);
    selectedProfile[strcspn(selectedProfile, "\n")] = '\0';
    strncpy(planner.profileName, selectedProfile, sizeof(planner.profileName));

    printf("\n[Create Study Plan for %s]\n", planner.profileName);
    printf("How many subjects do you want to plan for? (Max %d): ", MAX_SUBJECTS);
    scanf("%d", &planner.subjectCount);

    if (planner.subjectCount > MAX_SUBJECTS || planner.subjectCount <= 0) {
        printf("Invalid number of subjects.\n");
        return;
    }

    getchar(); // Consume newline
    for (int i = 0; i < planner.subjectCount; i++) {
        printf("Enter subject %d: ", i + 1);
        fgets(planner.subjects[i], sizeof(planner.subjects[i]), stdin);
        planner.subjects[i][strcspn(planner.subjects[i], "\n")] = '\0';
    }

    // Save the planner to a file
    FILE *file = fopen(PLANNER_FILE, "a");
    if (file == NULL) {
        printf("Error: Unable to open study planner file.\n");
        return;
    }

    fprintf(file, "Profile: %s\n", planner.profileName);
    for (int i = 0; i < planner.subjectCount; i++) {
        fprintf(file, "- %s\n", planner.subjects[i]);
    }
    fprintf(file, "-----------------------------\n");
    fclose(file);

    printf("Study plan saved successfully!\n");
}

// Function to log study duration and recommend breaks
void logStudySession() {
    char selectedProfile[100], selectedSubject[100];
    int studyDuration;

    printf("\n[Select a Profile]\n");
    displayProfilesWithSubjects();
    printf("Enter the full name of the profile: ");
    getchar(); // Consume newline
    fgets(selectedProfile, sizeof(selectedProfile), stdin);
    selectedProfile[strcspn(selectedProfile, "\n")] = '\0';

    printf("Enter the subject you studied: ");
    fgets(selectedSubject, sizeof(selectedSubject), stdin);
    selectedSubject[strcspn(selectedSubject, "\n")] = '\0';

    printf("Enter the duration of your study session (in minutes): ");
    scanf("%d", &studyDuration);

    // Save log to a file
    FILE *file = fopen(BREAK_LOG_FILE, "a");
    if (file == NULL) 
    {
        printf("Error: Unable to open break log file.\n");
        return;
    }
    fprintf(file, "Profile: %s\nSubject: %s\nDuration: %d minutes\n-----------------------------\n", 
            selectedProfile, selectedSubject, studyDuration);
    fclose(file);

    // Provide break recommendations
    printf("\n[Break Recommendations]\n");
    if (studyDuration < 30) 
    {
        printf("- Take a 5-minute break.\n");
        printf("- Stretch or grab a glass of water.\n");
    } else if (studyDuration < 60) 
    {
        printf("- Take a 10-minute break.\n");
        printf("- Walk around or listen to a quick song.\n");
    } else 
    {
        printf("- Take a 15-20 minute break.\n");
        printf("- Step outside, have a snack, or meditate.\n");
    }

    // Motivational quotes
    const char *quotes[] = 
    {
        "You can do anything, but not everything.",
        "Success is the sum of small efforts, repeated day in and day out.",
        "Don’t watch the clock; do what it does. Keep going.",
        "The future depends on what you do today.",
        "Believe you can and you’re halfway there."
    };
    int quoteCount = sizeof(quotes) / sizeof(quotes[0]);
    srand(time(NULL));
    printf("\nMotivational Quote: %s\n", quotes[rand() % quoteCount]);
}

// Menu for study planner
void studyPlannerMenu() {
    int choice;
    do {
        printf("\n[Personalized Study Planner]\n");
        printf("1. Create Study Plan\n");
        printf("2. Log Study Session and Get Break Recommendations\n");
        printf("3. View Motivational Quote\n");
        printf("4. View Profiles with Subjects\n");
        printf("5. Back to Main Menu\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                setupStudyPlanner();
                break;
            case 2:
                logStudySession();
                break;
            case 3: {
                const char *quotes[] = {
                    "You can do anything, but not everything.",
                    "Success is the sum of small efforts, repeated day in and day out.",
                    "Don’t watch the clock; do what it does. Keep going.",
                    "The future depends on what you do today.",
                    "Believe you can and you’re halfway there."
                };
                int quoteCount = sizeof(quotes) / sizeof(quotes[0]);
                srand(time(NULL));
                printf("\nMotivational Quote: %s\n", quotes[rand() % quoteCount]);
                break;
            }
            case 4:
                displayProfilesWithSubjects();
                break;
            case 5:
                printf("Returning to main menu...\n");
                break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 5);
}
