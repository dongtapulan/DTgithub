#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CREDENTIALS_FILE "credentials.txt"
#define MAX_USERNAME_LENGTH 50
#define MAX_PASSWORD_LENGTH 50

// Function to check if an account already exists
int isAccountExists(const char *username) {
    FILE *file = fopen(CREDENTIALS_FILE, "r");
    if (file == NULL) {
        return 0; // File doesn't exist yet, no accounts exist
    }

    char existingUsername[MAX_USERNAME_LENGTH];
    char existingPassword[MAX_PASSWORD_LENGTH];
    while (fscanf(file, "%s %s", existingUsername, existingPassword) != EOF) {
        if (strcmp(existingUsername, username) == 0) {
            fclose(file);
            return 1; // Account already exists
        }
    }

    fclose(file);
    return 0; // Account does not exist
}

// Function to handle sign-up
void signUp() {
    FILE *file = fopen(CREDENTIALS_FILE, "a"); // Open file in append mode
    if (file == NULL) {
        perror("Error opening credentials file");
        return;
    }

    char username[MAX_USERNAME_LENGTH];
    char password[MAX_PASSWORD_LENGTH];

    printf("\n[Sign Up]\n");
    printf("Enter a username: ");
    scanf("%s", username);

    if (isAccountExists(username)) {
        printf("Account with username '%s' already exists. Please try a different username.\n", username);
        fclose(file);
        return;
    }

    printf("Enter a password: ");
    scanf("%s", password);

    fprintf(file, "%s %s\n", username, password); // Write credentials to file
    fclose(file);

    printf("Sign up successful!\n");
}

// Function to handle login
int logIn() {
    FILE *file = fopen(CREDENTIALS_FILE, "r"); // Open file in read mode
    if (file == NULL) {
        perror("Error opening credentials file");
        return 0;
    }

    char username[MAX_USERNAME_LENGTH];
    char password[MAX_PASSWORD_LENGTH];
    char enteredUsername[MAX_USERNAME_LENGTH];
    char enteredPassword[MAX_PASSWORD_LENGTH];
    int isAuthenticated = 0;

    printf("\n[Log In]\n");
    printf("Enter your username: ");
    scanf("%s", enteredUsername);
    printf("Enter your password: ");
    scanf("%s", enteredPassword);

    while (fscanf(file, "%s %s", username, password) != EOF) {
        if (strcmp(username, enteredUsername) == 0 && strcmp(password, enteredPassword) == 0) {
            isAuthenticated = 1;
            break;
        }
    }

    fclose(file);

    if (isAuthenticated) {
        printf("Login successful!\n");
        return 1;
    } else {
        printf("Invalid credentials. Please try again.\n");
        return 0;
    }
}

// Function to handle login or sign-up
void logInSignUp() {
    int choice;
    int isLoggedIn = 0;

    do {
        printf("\033[1;92m\nHello! What do you want to do:\n\033[0m");
        printf("1. Sign Up/Register\n");
        printf("2. Log In\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                signUp();
                break;
            case 2:
                isLoggedIn = logIn();
                if (isLoggedIn) {
                    return; // Proceed to the main menu
                }
                break;
            case 3:
                printf("Exiting program. Goodbye!\n");
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (1);
}
