// Private props and methods in class
// Private
// Private static
// Public
// Public static
// Getter and Setter

var maxMarks = 1000;

class Student {
  #name; // private property
  constructor(name, obtainedMarks) {
    this.#name = name;
    this.obtainedMarks = obtainedMarks; // public property
  }

  checkResult() {
    let percentage = (this.obtainedMarks / maxMarks) * 100;
    if (percentage > 40) {
      return percentage;
    } else {
      return percentage;
    }
  }

  getName() {
    return this.#name;
  }
}
var student1 = new Student("John Doe", 450);
console.log(student1.getName()); // Accessing private property via public method

class StudentWithPAndNPFields {
  static firstName = 1; // Static Variable
  lastName; // Instance Variable

  constructor(obtainedMarks, firstName) {
    this.obtainedMarks = obtainedMarks;
    this.firstName = "Jiya";
    this.lastName = "Damara";
    StudentWithPAndNPFields.firstName = firstName++;
  }

  checkResult() {
    let percentage = (this.obtainedMarks / maxMarks) * 100;
    if (percentage > 40) {
      return percentage;
    } else {
      return percentage;
    }
  }
}

var student2 = new StudentWithPAndNPFields(550, 5);
console.log(student2.firstName); // Accessing public property directly
console.log(StudentWithPAndNPFields.firstName); // Accessing public static property directly
