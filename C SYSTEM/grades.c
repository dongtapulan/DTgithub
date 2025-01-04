#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PROFILE_FILE "profile.txt"
#define GRADES_FILE "grades.txt"

typedef struct {
    float quizzes[10];
    int numQuizzes;
    float writtenWorks[10];
    int numWrittenWorks;
    float majorExams[5];
    int numMajorExams;
    float performanceTasks[10];
    int numPerformanceTasks;
    int attendancePoints;
} Grades;

void loadProfileNames() {
    FILE *file = fopen(PROFILE_FILE, "r");
    if (file == NULL) {
        printf("Error: PROFILE_FILE not found. Please create a profile first.\n");
        return;
    }

    char line[256];
    int profilesFound = 0;
    printf("\n[Available Profiles]\n");
    while (fgets(line, sizeof(line), file)) {
        if (strncmp(line, "Full Name:", 10) == 0) {
            profilesFound = 1;
            printf("- %s", line + 11); // Print the profile name
        }
    }
    fclose(file);

    if (!profilesFound) {
        printf("No profiles found. Please create profiles in profile.txt.\n");
    }
}

void addGrades() {
    char studentName[100];
    Grades grades = {0}; // Initialize all grades to 0

    printf("\n[Add Grades and Activities]\n");
    loadProfileNames();
    printf("\nEnter the full name of the student profile: ");
    getchar(); // Consume newline
    fgets(studentName, sizeof(studentName), stdin);
    studentName[strcspn(studentName, "\n")] = '\0'; // Remove newline

    FILE *gradesFile = fopen(GRADES_FILE, "a");
    if (gradesFile == NULL) {
        perror("Error opening grades file");
        return;
    }

    fprintf(gradesFile, "Student: %s\n", studentName);

    printf("\nEnter number of quizzes: ");
    scanf("%d", &grades.numQuizzes);
    for (int i = 0; i < grades.numQuizzes; i++) {
        printf("Enter score for Quiz %d: ", i + 1);
        scanf("%f", &grades.quizzes[i]);
    }

    printf("\nEnter number of written works: ");
    scanf("%d", &grades.numWrittenWorks);
    for (int i = 0; i < grades.numWrittenWorks; i++) {
        printf("Enter score for Written Work %d: ", i + 1);
        scanf("%f", &grades.writtenWorks[i]);
    }

    printf("\nEnter number of major exams: ");
    scanf("%d", &grades.numMajorExams);
    for (int i = 0; i < grades.numMajorExams; i++) {
        printf("Enter score for Major Exam %d: ", i + 1);
        scanf("%f", &grades.majorExams[i]);
    }

    printf("\nEnter number of performance tasks: ");
    scanf("%d", &grades.numPerformanceTasks);
    for (int i = 0; i < grades.numPerformanceTasks; i++) {
        printf("Enter score for Performance Task %d: ", i + 1);
        scanf("%f", &grades.performanceTasks[i]);
    }

    printf("\nEnter attendance points: ");
    scanf("%d", &grades.attendancePoints);

    fprintf(gradesFile, "Quizzes: ");
    for (int i = 0; i < grades.numQuizzes; i++) {
        fprintf(gradesFile, "%.2f ", grades.quizzes[i]);
    }
    fprintf(gradesFile, "\n");

    fprintf(gradesFile, "Written Works: ");
    for (int i = 0; i < grades.numWrittenWorks; i++) {
        fprintf(gradesFile, "%.2f ", grades.writtenWorks[i]);
    }
    fprintf(gradesFile, "\n");

    fprintf(gradesFile, "Major Exams: ");
    for (int i = 0; i < grades.numMajorExams; i++) {
        fprintf(gradesFile, "%.2f ", grades.majorExams[i]);
    }
    fprintf(gradesFile, "\n");

    fprintf(gradesFile, "Performance Tasks: ");
    for (int i = 0; i < grades.numPerformanceTasks; i++) {
        fprintf(gradesFile, "%.2f ", grades.performanceTasks[i]);
    }
    fprintf(gradesFile, "\n");

    fprintf(gradesFile, "Attendance Points: %d\n", grades.attendancePoints);
    fprintf(gradesFile, "-----------------------------\n");

    fclose(gradesFile);
    printf("Grades and activities added successfully!\n");
}

void calculateAverageGrade() {
    FILE *gradesFile = fopen(GRADES_FILE, "r");
    if (gradesFile == NULL) {
        printf("Error: GRADES_FILE not found. Please add grades first.\n");
        return;
    }

    char line[256];
    char studentName[100];
    printf("\n[Calculate Average Grade]\n");
    printf("Enter the full name of the student profile: ");
    getchar(); // Consume newline
    fgets(studentName, sizeof(studentName), stdin);
    studentName[strcspn(studentName, "\n")] = '\0'; // Remove newline

    int studentFound = 0;
    Grades grades = {0};
    float total = 0;
    int count = 0;

    while (fgets(line, sizeof(line), gradesFile)) {
        if (strstr(line, studentName)) {
            studentFound = 1;
            while (fgets(line, sizeof(line), gradesFile)) {
                if (strncmp(line, "Quizzes:", 8) == 0) {
                    sscanf(line + 8, "%f %f %f %f %f %f %f %f %f %f", 
                        &grades.quizzes[0], &grades.quizzes[1], &grades.quizzes[2], 
                        &grades.quizzes[3], &grades.quizzes[4], &grades.quizzes[5], 
                        &grades.quizzes[6], &grades.quizzes[7], &grades.quizzes[8], 
                        &grades.quizzes[9]);
                }
                if (strncmp(line, "Attendance Points:", 18) == 0) {
                    sscanf(line + 18, "%d", &grades.attendancePoints);
                    break;
                }
            }
        }
    }

    if (!studentFound) {
        printf("Student profile not found.\n");
    } else {
        for (int i = 0; i < grades.numQuizzes; i++) total += grades.quizzes[i], count++;
        printf("Average: %.2f", total / count);
    }
}
