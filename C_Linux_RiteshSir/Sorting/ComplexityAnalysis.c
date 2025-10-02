#include<stdio.h>
#include<stdlib.h>
#include<sys/time.h>
#include<string.h>

// Function prototypes
void generate_report(char *input_type, int initial_input_size, int increment_by);
void generateInput(int a[], int s, char *c);
void generateRandom(int a[], int s);
void generateAscending(int a[], int s);
void generateDescending(int a[], int s);
void print(int a[], int s);
void selectionSort(int a[], int ctr);
void insertionSort(int a[], int ctr);
void quickSort(int a[], int left, int right);
void mergeSort(int a[], int aux[], int start, int end);
void merge(int a[], int aux[], int start, int mid, int end);
void swap(int a[], int i, int j);
void copyArray(int from[], int to[], int s);

int main(int argc, char *argv[]) {

	int initial_input_size = 8000;
	int increment_by = 4000;
	char *input_type = "r";

	if(argc > 1) input_type = argv[1];
	if(argc > 2) initial_input_size = atoi(argv[2]);
	if(argc > 3) increment_by = atoi(argv[3]);
	printf("Sorting input data of type %s with size = %d (incremented by %d) \n", input_type,initial_input_size, increment_by);

	generate_report(input_type,initial_input_size,increment_by);

	printf("\n");
	return 0;
}

void generate_report(char *input_type, int initial_input_size, int increment_by ){
	struct timeval te;
	int i;
	printf("----------------------------------------------");
	printf("\nsize \t sel \t ins \t Merge \t quick\n");
	printf("----------------------------------------------");
	for (i = 0; i < 8; i++) {
		int s = initial_input_size + increment_by * i;
		printf("\n%d", s);
		int a[s], b[s];

		generateInput(b, s, input_type);

		copyArray(b, a, s);

		gettimeofday(&te, NULL);
		long long start = te.tv_sec * 1000LL + te.tv_usec / 1000;
		selectionSort(a, s);
		gettimeofday(&te, NULL);
		long long end = te.tv_sec * 1000LL + te.tv_usec / 1000;
		printf("\t %lld", end - start);

		copyArray(b, a, s);

		gettimeofday(&te, NULL);
		start = te.tv_sec * 1000LL + te.tv_usec / 1000;
		insertionSort(a, s);
		gettimeofday(&te, NULL);
		end = te.tv_sec * 1000LL + te.tv_usec / 1000;
		printf("\t %lld", end - start);

		copyArray(b, a, s);
		int aux[s];
		gettimeofday(&te, NULL);
		start = te.tv_sec * 1000LL + te.tv_usec / 1000;
		mergeSort(a,aux,0,s-1);
		gettimeofday(&te, NULL);
		end = te.tv_sec * 1000LL + te.tv_usec / 1000;
		printf("\t %lld", end - start);

		copyArray(b, a, s);
		gettimeofday(&te, NULL);
		start = te.tv_sec * 1000LL + te.tv_usec / 1000;
		quickSort(a,0,s-1);
		gettimeofday(&te, NULL);
		end = te.tv_sec * 1000LL + te.tv_usec / 1000;
		printf("\t %lld", end - start);
	}
}

void generateInput(int a[], int s, char *c) {
	if (strcmp(c, "a") == 0) {
		generateAscending(a, s);
	} else if (strcmp(c, "d") == 0) {
		generateDescending(a, s);
	} else {
		generateRandom(a, s);
	}
}

void generateRandom(int a[], int s) {
	int i;
	for (i = 0; i < s; i++) {
		a[i] = rand() % s + 1;
	}
}

void generateAscending(int a[], int s) {
	int i;
	for (i = 0; i < s; i++) {
		a[i] = i;
	}
}

void generateDescending(int a[], int s) {
	int i;
	for (i = 0; i < s; i++) {
		a[i] = s - i;
	}
}

void print(int a[], int s) {
	int i;
	for (i = 0; i < s; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}

void selectionSort(int a[], int ctr) {
	int i = 0, j;
	for (i = 0; i < ctr; i++) {
		int min = i;
		for (j = i + 1; j < ctr; j++) {
			if (a[j] < a[min]) min = j;
		}
		if (min != i) swap(a, i, min);
	}
}

void insertionSort(int a[], int ctr) {
	int i, j;
	for (i = 1; i < ctr; i++) {
		int key = a[i];
		for (j = i - 1; j >= 0 && a[j] > key; j--) {
			swap(a, j, j + 1);
		}
	}
}

void quickSort(int a[],int left, int right){
	int i, last;
	if(left >= right)  return;
	//swap(a, left, (left + right)/2);
	last = left;
	for(i = left + 1; i <= right; i++)
		if(a[i] < a[left])
			swap(a, ++last, i);
	swap(a, left, last);
	quickSort(a, left, last-1);
	quickSort(a, last+1, right);
}

void mergeSort(int a[],int aux[],int start, int end){
	if(end<=start) return;
	int mid = (end+start)/2;
	mergeSort(a,aux,start,mid);
	mergeSort(a,aux,mid+1,end);
	merge(a,aux,start,mid,end);
}

void merge(int a[],int aux[],int start, int mid, int end){
	int i = start;
	int j = mid+1;
	int k;
	for(k=start;k<=end;k++){
		if(i>mid) aux[k] = a[j++];
		else if(j>end) aux[k] = a[i++];
		else if(a[i]>a[j]) aux[k] = a[j++];
		else aux[k] = a[i++];
	}
	for(k=start;k<=end;k++){
		a[k] = aux[k];
	}
}

void swap(int a[], int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}

void copyArray(int from[], int to[], int s) {
	int i;
	for (i = 0; i < s; i++) {
		to[i] = from[i];
	}
}
