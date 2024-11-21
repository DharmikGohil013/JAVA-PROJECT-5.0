#include<iostream>
using namespace std;

struct Node
{
    int data;
    Node* next;

    Node(int value)
    {
        data=value;
        next=nullptr;
    }
};


int main()
{
    Node* head  = nullptr;

    insertAtFront(head,20);
    insertAtEnd(head,50);   
}
void insertAtFront(Node*& head , int value)
{
    Node* newNode = new Node(value);
    newNode->next = head;
    head=newNode;
}
void insertAtEnd(Node*& head, int value) {
    Node* newNode = new Node(value); // Create a new node
    if (head == nullptr) {           // If the list is empty
        head = newNode;
        return;
    }

    Node* temp = head; // Traverse to the end of the list
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    temp->next = newNode; // Link the last node to the new node
}
void insertAtPosition(Node*& head, int value, int position) {
    if (position == 1) { // If inserting at the front
        insertAtFront(head, value);
        return;
    }

    Node* newNode = new Node(value);
    Node* temp = head;

    for (int i = 1; i < position - 1 && temp != nullptr; i++) {
        temp = temp->next; // Traverse to the desired position
    }

    if (temp == nullptr) {
        cout << "Position out of bounds" << endl;
        return;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

