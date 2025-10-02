#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>

int* arr;
int capacity = 1;
int N = 0;

void resize(int size) {
    int *new_arr = (int *) malloc(size * sizeof(int));
    for(int i = 0; i < N; i ++) {
        new_arr[i] = arr[i];
    }
    free(arr);
    arr = new_arr;
    capacity = size;
}

void push(int item) {
    if(N == capacity) {
        capacity *= 2;
        resize(capacity);
    }
    arr[N++] = item;
}

int pop() {
    if(N <= 0) {
        printf("No element to pop.\n");
        exit(1);
    }
    int item = arr[--N];
    if(N < capacity/2 && capacity > 1) {
        capacity = capacity * 3 / 4;
        resize(capacity);
    }
    return item;
}

bool isEmpty() {
    return N == 0;
}

int size() {
    return N;
}

void test() {
    push(1);
    push(10);
    assert(size() == 2);
    assert(pop() == 10);
    assert(pop() == 1);
    assert(isEmpty() == true);

    push(5);
    push(6);
    push(7);
    push(8);
    push(9);
    push(10);
    (assert(size() == 6));
}

int main() {
    arr = (int *) malloc(capacity * sizeof(int));
    test();
    free(arr);
    printf("All tests passed successfully!!\n");
    return 0;
}
