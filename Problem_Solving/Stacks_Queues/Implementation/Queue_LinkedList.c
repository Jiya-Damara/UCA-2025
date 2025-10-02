#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include <assert.h>

struct Node {
  int item;
  struct Node* next;
};

struct Node* front = NULL;
struct Node* rear = NULL;
int N =0;

bool isEmpty() {
  return front == NULL;
}

int size() {
  return N;
}

void enqueue(int item) {
  struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
  newNode->item = item;
  newNode->next = NULL;
  if(rear == NULL) {
    front = rear = newNode;
  }
  else {
    rear->next = newNode;
    rear = newNode;
  }
  N++;
}

int dequeue() {
  if(isEmpty()) {
    return INT_MIN;
  }
  struct Node* temp = front;
  int item = front->item;
  front = front->next;
  if(front == NULL) {
    rear = NULL;
  }
  free(temp);
  N--;
  return item;
}

int peek() {
  if(isEmpty()) {
    return INT_MIN;
  }
  return front->item;
}

void test() {
  enqueue(10);
  enqueue(20);
  enqueue(30);
  assert(size() == 3);
  assert(isEmpty() == false);

  assert(dequeue() == 10);
  assert(peek() == 20);
  assert(dequeue() == 20);
  assert(dequeue() == 30);
  assert(isEmpty() == true);
  assert(size() == 0);
}

int main() {
  test();
  printf("ALL OPERATIONS ARE DONE SUCCESSFULLY!!\n");
  return 0;
}
