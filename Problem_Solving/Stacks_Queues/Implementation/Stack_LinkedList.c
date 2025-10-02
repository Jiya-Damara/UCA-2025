#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include <assert.h>

struct Node {
  int val;
  struct Node* next;
};

struct Node* head = NULL;
int N = 0;

bool isEmpty() {
  return head == NULL;
}

int size() {
  return N;
}

void push(int item) {
  struct Node* oldHead = head;
  struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
  newNode->val = item;
  newNode->next = oldHead;
  head = newNode;
  N++;
}

int pop() {
  if(head == NULL) {
    return INT_MIN;
  }
  struct Node* temp = head;
  int item = head->val;
  head = head->next;
  N--;
  free(temp);
  return item;
}

void test() {
  push(3);
  push(5);
  push(7);
  assert(size() == 3);
  assert(isEmpty() == false);

  assert(pop() == 7);
  assert(size() == 2);
  assert(isEmpty() == false);

  pop();
  assert(pop() == 3);
  assert(size() == 0);
  assert(isEmpty() == true);
}

int main() {
  test();
  printf("ALL OPERATIONS ARE SUCCESSFUL!!\n");
  return 0;
}
