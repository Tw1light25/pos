#include <iostream>
using namespace std;

int main() {
    // Create array with 5 elements
    int arr[5] = {1, 2, 3, 4, 5};  // Simple array with values 1,2,3,4,5
    int choice;
    
    while(true) {  // Infinite loop (will break with choice 10)
        // Display menu
        cout << "\n=== MENU ===\n";
        cout << "1. Display one element\n";
        cout << "2. Display all elements\n";
        cout << "3. Replace element\n";
        cout << "4. Insert element\n";
        cout << "5. Delete element\n";
        cout << "6. Search element\n";
        cout << "7. Sort array\n";
        cout << "8. Join arrays\n";
        cout << "9. Merge arrays\n";
        cout << "10. Exit\n";
        cout << "Choose (1-10): ";
        cin >> choice;

        // Handle user choice
        if(choice == 1) {
            int index;
            cout << "Enter position (0-4): ";
            cin >> index;
            if(index >= 0 && index < 5) {
                cout << "Element at position " << index << " is: " << arr[index] << endl;
            } else {
                cout << "Wrong position! Use 0 to 4 only\n";
            }
        }
        else if(choice == 2) {
            cout << "All elements: ";
            for(int i = 0; i < 5; i++) {
                cout << arr[i] << " ";
            }
            cout << endl;
        }
        else if(choice == 3) {
            int pos, num;
            cout << "Enter position (0-4): ";
            cin >> pos;
            if(pos >= 0 && pos < 5) {
                cout << "Enter new number: ";
                cin >> num;
                arr[pos] = num;
                cout << "Number replaced!\n";
            } else {
                cout << "Wrong position! Use 0 to 4 only\n";
            }
        }
        else if(choice == 10) {
            cout << "Goodbye!\n";
            break;  // Exit the program
        }
        else {
            cout << "This option will be added soon!\n";
        }
        
        // Press enter to continue
        cout << "\nPress Enter to continue...";
        cin.ignore();
        cin.get();
    }
    
    return 0;
}