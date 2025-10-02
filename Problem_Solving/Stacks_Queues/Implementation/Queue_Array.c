#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>

int *arr;
int capacity = 1;
int N = 0;
int front = 0;
int rear = 0;

void resize(int new_capacity) {
  int *new_arr = (int *) malloc(new_capacity * sizeof(int));
  for(int i = 0; i < N; i++) {
    new_arr[i] = arr[(front + i) % capacity];
  }
  free(arr);
  arr = new_arr;
  capacity = new_capacity;
  front = 0;
  rear = N;
}

void enqueue(int item) {
  if(N == capacity) {
    resize(capacity * 2);
  }
  arr[rear] = item;
  rear = (rear + 1) % capacity;
  N++;
}

int dequeue() {
  if(N == 0) {
    printf("Can't dequeue as queue is empty.");
    exit(1);
  }
  int item = arr[front];
  front = (front + 1) % capacity;
  N--;
  if(N > 0 && N <= capacity/2 && capacity > 1) {
    resize(capacity * 3 / 4);
  }
  return item;
}

int peek() {
  if(N == 0) {
    printf("Empty Queue");
    exit(1);
  }
  return arr[front];
}

bool isEmpty() {
  return N == 0;
}

int size() {
  return N;
}

void test() {
  enqueue(1);
  enqueue(2);
  enqueue(3);
  assert(size() == 3);
  assert(peek() == 1);
  assert(dequeue() == 1);
  assert(dequeue() == 2);
  assert(dequeue() == 3);

  for(int i = 10; i < 20; i++) {
    enqueue(i);
  }
  assert(size() == 10);
  assert(peek() == 10);
  for(int i = 10; i < 20; i++) {
    assert(dequeue() == i);
  }
  assert(isEmpty() == true);
}

int main() {
  arr = (int *) malloc(capacity * sizeof(int));
  test();
  free(arr);
  printf("ALL OPERATIONS ARE SUCCESSFUL!!\n");
  return 0;
}
