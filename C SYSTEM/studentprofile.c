#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STUDENT_DATA_FILE "studentdata.txt"

typedef struct {
    char fullName[100];
    int age;
    char school[100];
    char email[100];
    char gradeLevel[50];
    char schoolID[50];
} StudentProfile;

void displayAllProfiles() {
    FILE *file = fopen(STUDENT_DATA_FILE, "r");
    if (file == NULL) {
        printf("No profiles found.\n");
        return;
    }

    char line[256];
    printf("\n[All Profiles and Subjects]\n");
    while (fgets(line, sizeof(line), file)) {
        printf("%s", line);
    }
    fclose(file);
}

void addSubjects(FILE *file) {
    int semester;
    printf("\n[Add Subjects]\n");
    printf("Enter semester (1 for First, 2 for Second): ");
    scanf("%d", &semester);
    getchar(); // Consume newline

    if (semester != 1 && semester != 2) 
    {
        printf("Invalid semester. Please enter 1 or 2.\n");
        return;
    }

    char subject[100];
    fprintf(file, "Semester: %s\n", semester == 1 ? "First" : "Second");
    printf("Enter subjects (type 'done' when finished):\n");

    while (1) {
        printf("Subject: ");
        fgets(subject, sizeof(subject), stdin);
        subject[strcspn(subject, "\n")] = '\0'; // Remove newline

        if (strcmp(subject, "done") == 0) {
            break;
        }

        fprintf(file, "- %s\n", subject);
    }

    fprintf(file, "-----------------------------\n");
    printf("Subjects added successfully!\n");
}

void createStudentProfile() {
    FILE *file = fopen(STUDENT_DATA_FILE, "a"); // Open in append mode
    if (file == NULL) {
        perror("Error opening student data file");
        return;
    }

    StudentProfile student;

    printf("\n[Add New Student Profile]\n");
    getchar(); // Consume leftover newline
    printf("Enter full name: ");
    fgets(student.fullName, sizeof(student.fullName), stdin);
    student.fullName[strcspn(student.fullName, "\n")] = '\0';

    printf("Enter age: ");
    scanf("%d", &student.age);

    getchar(); // Consume newline
    printf("Enter school: ");
    fgets(student.school, sizeof(student.school), stdin);
    student.school[strcspn(student.school, "\n")] = '\0';

    printf("Enter email: ");
    fgets(student.email, sizeof(student.email), stdin);
    student.email[strcspn(student.email, "\n")] = '\0';

    printf("Enter grade level: ");
    fgets(student.gradeLevel, sizeof(student.gradeLevel), stdin);
    student.gradeLevel[strcspn(student.gradeLevel, "\n")] = '\0';

    printf("Enter school ID: ");
    fgets(student.schoolID, sizeof(student.schoolID), stdin);
    student.schoolID[strcspn(student.schoolID, "\n")] = '\0';

    // Append the new profile data
    fprintf(file, "Full Name: %s\nAge: %d\nSchool: %s\nEmail: %s\nGrade Level: %s\nSchool ID: %s\n", 
            student.fullName, student.age, student.school, student.email, student.gradeLevel, student.schoolID);

    // Call addSubjects to include subjects for the student
    addSubjects(file);

    fclose(file);
    printf("Profile and subjects added successfully!\n");
}

void deleteAllProfiles() {
    if (remove(STUDENT_DATA_FILE) == 0) {
        printf("All profiles and subjects have been deleted successfully.\n");
    } else {
        printf("No profiles found to delete.\n");
    }
}

void profileMenu() {
    int choice;
    do {
        printf("\n\033[1;33m[Profile Management Menu]\033[0m\n");
        printf("1. Add New Profile and Subjects\n");
        printf("2. Display All Profiles and Subjects\n");
        printf("3. Delete All Profiles and Subjects\n");
        printf("4. Exit to Main Menu\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                createStudentProfile();
                break;
            case 2:
                displayAllProfiles();
                break;
            case 3:
                deleteAllProfiles();
                break;
            case 4:
                printf("Returning to main menu...\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 4);
}
