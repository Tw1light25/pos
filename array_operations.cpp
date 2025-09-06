#include <iostream>
using namespace std;

void displayMenu() {
    cout << "\n=== Array Operations Menu ===\n";
    cout << "1. Access/Display Elements\n";
    cout << "2. Append Element\n";
    cout << "3. Replace Element\n";
    cout << "4. Insert Element\n";
    cout << "5. Delete Element\n";
    cout << "6. Search Element\n";
    cout << "7. Sort Array\n";
    cout << "8. Concatenate Arrays\n";
    cout << "9. Merge Arrays\n";
    cout << "10. Exit\n";
    cout << "Enter your choice (1-10): ";
}

void displayArray(int arr[], int size) {
    cout << "Array elements: ";
    for(int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int arr[100];  // Main array
    int size = 0;  // Current size of array
    int choice;
    
    // Initialize first 5 elements
    for(int i = 0; i < 5; i++) {
        arr[i] = i + 1;  // Values 1,2,3,4,5
    }
    size = 5;

    do {
        displayMenu();
        cin >> choice;

        switch(choice) {
            case 1: {
                cout << "\n1. Display specific element\n";
                cout << "2. Display all elements\n";
                cout << "Enter choice (1-2): ";
                int displayChoice;
                cin >> displayChoice;
                
                if(displayChoice == 1) {
                    cout << "Enter index (0-" << size-1 << "): ";
                    int index;
                    cin >> index;
                    if(index >= 0 && index < size)
                        cout << "Element at index " << index << " is: " << arr[index] << endl;
                    else
                        cout << "Invalid index!\n";
                } else if(displayChoice == 2) {
                    displayArray(arr, size);
                }
                break;
            }
            case 10:
                cout << "Exiting program...\n";
                break;
            default:
                cout << "Other operations will be implemented soon!\n";
        }
    } while(choice != 10);

    return 0;
}