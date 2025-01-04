#include <stdio.h>
#include <string.h>

// Maximum entries for the wellness tracker
#define MAX_WELLNESS_ENTRIES 100
#define WELLNESS_LOG_FILE "wellness_logs.txt"

typedef struct {
    char date[20];
    int mood;          // 1-10 scale
    int stressLevel;   // 1-10 scale
    char comments[100];
} WellnessEntry;

WellnessEntry wellnessLogs[MAX_WELLNESS_ENTRIES];
int wellnessCount = 0;

// Function to save an entry to the text file
void saveToTextFile(WellnessEntry entry) {
    FILE *file = fopen(WELLNESS_LOG_FILE, "a"); // Open in append mode
    if (file == NULL) {
        printf("Error: Unable to open file for saving wellness logs.\n");
        return;
    }

    fprintf(file, "%s,%d,%d,%s\n", entry.date, entry.mood, entry.stressLevel, entry.comments);
    fclose(file);
}

// Function to load existing entries from the text file
void loadFromTextFile() {
    FILE *file = fopen(WELLNESS_LOG_FILE, "r");
    if (file == NULL) {
        // File might not exist on the first run
        return;
    }

    while (fscanf(file, "%[^,],%d,%d,%[^]%*c", 
                  wellnessLogs[wellnessCount].date, 
                  &wellnessLogs[wellnessCount].mood, 
                  &wellnessLogs[wellnessCount].stressLevel, 
                  wellnessLogs[wellnessCount].comments) != EOF) {
        wellnessCount++;
    }

    fclose(file);
}

// Function to add a new wellness entry
void addWellnessEntry() {
    if (wellnessCount >= MAX_WELLNESS_ENTRIES) {
        printf("Wellness log is full! Cannot add more entries.\n");
        return;
    }

    WellnessEntry newEntry;
    printf("Enter date (YYYY-MM-DD): ");
    scanf("%s", newEntry.date);

    printf("\033[1;33m\nMood Scale (Adapted on Anxiety, Depression, and Mood Scale - ADAMS by (Esbensen et al., 2003).):\n\033[0m");
    printf("1-2: Very low mood (deep sadness or depression)\n");
    printf("3-4: Low mood (mild unhappiness or dissatisfaction)\n");
    printf("5-6: Neutral mood (neither happy nor sad)\n");
    printf("7-8: Positive mood (happiness or contentment)\n");
    printf("9-10: Very positive mood (joy or elation)\n");
    printf("Rate your mood (1-10): ");
    scanf("%d", &newEntry.mood);

    printf("\033[1;32m\nStress Scale (Based on Perceived Stress Scale - PSS-10 by Cohen, S., & Williamson, G. (1988).):\n\033[0m");
    printf("1-2: Very low stress (calm and relaxed)\n");
    printf("3-4: Low stress (minimal tension or worry)\n");
    printf("5-6: Moderate stress (noticeable but manageable tension)\n");
    printf("7-8: High stress (significant pressure or anxiety)\n");
    printf("9-10: Very high stress (overwhelming stress or panic)\n");
    printf("Rate your stress level (1-10): ");
    scanf("%d", &newEntry.stressLevel);

    printf("Any comments for today? ");
    getchar(); // Consume the newline
    fgets(newEntry.comments, 100, stdin);
    newEntry.comments[strcspn(newEntry.comments, "\n")] = '\0'; // Remove newline

    wellnessLogs[wellnessCount++] = newEntry;
    saveToTextFile(newEntry); // Save to the file
    printf("Wellness entry added successfully and saved to file!\n");
}

// Function to view all wellness entries
void viewWellnessEntries() {
    if (wellnessCount == 0) {
        printf("No wellness entries found.\n");
        return;
    }

    printf("\n--- Wellness Logs ---\n");
    for (int i = 0; i < wellnessCount; i++) {
        printf("Date: %s | Mood: %d | Stress Level: %d\n", 
               wellnessLogs[i].date, wellnessLogs[i].mood, wellnessLogs[i].stressLevel);
        printf("Comments: %s\n\n", wellnessLogs[i].comments);
    }
}

// Function to suggest stress relief activities
void suggestStressRelief(int mood, int stressLevel) {
    printf("\nSuggestions for Stress Relief:\n");
    if (stressLevel > 7) 
    {
        printf("- Practice deep breathing or mindfulness.\n");
        printf("- Take a short walk or step away for a break.\n");
    } else if (stressLevel > 4) 
    {
        printf("- Listen to music or read something calming.\n");
        printf("- Try some light exercises or yoga.\n");
    } else {
        printf("- You're doing great! Keep enjoying your day.\n");
    }

    if (mood <= 3) 
    {
        printf("- Talk to a friend or watch a comedy.\n");
    } else if (mood <= 6) {
        printf("- Spend some time journaling your thoughts.\n");
    } else {
        printf("- Share your positivity with others around you!\n");
    }
}

// Function to handle the wellness menu
void wellnessMenu() {
    loadFromTextFile(); // Load existing data from the file

    int choice;
    do {
        printf("\033[1;36m\n--- Mental Wellness Tracker ---\033[0m\n");

        printf("\033[1;36m\nAccording to Kelley et al. (2024), maintaining a mental wellness tracker\n");
        printf("is a proactive step towards enhancing one’s emotional health. By fostering\n");
        printf("self-awareness, guiding personalized care strategies, and facilitating\n");
        printf("professional support, these trackers empower individuals to take control\n");
        printf("of their mental well-being effectively.\n\n");

        printf("Stress and poor mental health affect all age groups, but they're\n");
        printf("especially common among undergraduates and graduate students.\n\n");

        printf("Source: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5600512/\033[0m\n\n");

        printf("1. Add Wellness Entry\n");
        printf("2. View Wellness Entries\n");
        printf("3. Get Stress Relief Suggestions\n");
        printf("4. Back to Main Menu\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                addWellnessEntry();
                break;
            case 2:
                viewWellnessEntries();
                break;
            case 3: {
                int mood, stressLevel;
                printf("Enter your current mood (1-10): ");
                scanf("%d", &mood);
                printf("Enter your current stress level (1-10): ");
                scanf("%d", &stressLevel);
                suggestStressRelief(mood, stressLevel);
                break;
            }
            case 4:
                printf("Returning to main menu...\n");
                break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 4);
}
