#include <iostream>
using namespace std;

int main() {
    // Create array with 5 elements
    int arr[5] = {1, 2, 3, 4, 5};  // Simple array with values 1,2,3,4,5
    int choice;
    
    while(true) {  // Infinite loop (will break with choice 10)
        // Display menu
        cout << "\n=== MENU ===\n";
        cout << "1. Access\n";
        cout << "2. Append\n";
        cout << "3. Replace\n";
        cout << "4. Insertion\n";
        cout << "5. Deletion\n";
        cout << "6. Search\n";
        cout << "7. Sorting\n";
        cout << "8. Catenate\n";
        cout << "9. Merging\n";
        cout << "10. Exit\n";
        cout << "Choose (1-10): ";
        cin >> choice;

        // Handle user choice using switch
        switch(choice) {
            case 1: {
                int position;
                cout << "Enter position (1-5): ";
                cin >> position;
                // Adjust position to array index (subtract 1)
                int index = position - 1;
                switch(position) {
                    case 1: case 2: case 3: case 4: case 5:
                        cout << "Element at position " << position << " is: " << arr[index] << endl;
                        break;
                    default:
                        cout << "Wrong position! Use 1 to 5 only\n";
                }
                break;
            }
            case 2: {
                cout << "Append functionality will be added soon!\n";
                break;
            }
            case 3: {
                int position, num;
                cout << "Enter position (1-5): ";
                cin >> position;
                // Adjust position to array index (subtract 1)
                int index = position - 1;
                switch(position) {
                    case 1: case 2: case 3: case 4: case 5:
                        cout << "Enter new number: ";
                        cin >> num;
                        arr[index] = num;
                        cout << "Number replaced!\n";
                        break;
                    default:
                        cout << "Wrong position! Use 1 to 5 only\n";
                }
                break;
            }
            case 4: case 5: case 6: case 7: case 8: case 9: {
                cout << "This functionality will be added soon!\n";
                break;
            }
            case 10: {
                cout << "Goodbye!\n";
                return 0;  // Exit the program
            }
            default: {
                cout << "Invalid choice! Please select 1-10\n";
                break;
            }
        }
        
        // Press enter to continue
        cout << "\nPress Enter to continue...";
        cin.ignore();
        cin.get();
    }
    
    return 0;
}