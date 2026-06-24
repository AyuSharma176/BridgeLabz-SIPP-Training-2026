===============================================================
   JAVA KEYWORDS PROGRAMS - static | this | final | instanceof
===============================================================

FOLDER STRUCTURE:
-----------------
JavaKeywordsPrograms/
├── README.txt
├── BankAccountSystem.java            ← Program 1
├── LibraryManagementSystem.java      ← Program 2
├── EmployeeManagementSystem.java     ← Program 3
├── ShoppingCartSystem.java           ← Program 4
├── UniversityStudentManagement.java  ← Program 5
├── VehicleRegistrationSystem.java    ← Program 6
└── HospitalManagementSystem.java     ← Program 7

===============================================================
KEYWORD CONCEPTS — QUICK REFERENCE
===============================================================

STATIC
  - Variables: one shared copy across ALL objects of the class.
    E.g., bankName, totalAccounts — same value for every BankAccount.
  - Methods: called on the CLASS (not an object). No 'this' inside.
    E.g., BankAccount.getTotalAccounts(); — no object needed.

THIS
  - Refers to the current object's instance variable.
  - Used in constructors when parameter names match attribute names:
      this.name = name;
  - Without 'this', the parameter would shadow the attribute.

FINAL
  - Variables: value set once in constructor and NEVER changed.
    E.g., final String accountNumber — immutable after creation.
  - Ideal for IDs, ISBNs, registration numbers, patient IDs, etc.

INSTANCEOF
  - Checks whether an object is an instance of a given class.
    E.g., if (obj instanceof BankAccount) { ... }
  - Used for safe type-checking before downcasting an Object reference.
  - Prevents ClassCastException at runtime.

===============================================================
PROGRAM DESCRIPTIONS:
===============================================================

Program 1 - BankAccountSystem.java
  → static : bankName (shared), totalAccounts (counter), getTotalAccounts()
  → this   : this.accountNumber, this.accountHolderName in constructor
  → final  : accountNumber — cannot be reassigned after creation
  → instanceof : checked before displaying account details
  → Features: deposit, withdraw

Program 2 - LibraryManagementSystem.java
  → static : libraryName (shared), displayLibraryName()
  → this   : this.isbn, this.title, this.author in constructor
  → final  : isbn — unique book identifier, immutable
  → instanceof : checked before displaying book details
  → Features: borrowBook(), returnBook(), availability tracking

Program 3 - EmployeeManagementSystem.java
  → static : companyName (shared), totalEmployees, displayTotalEmployees()
  → this   : this.id, this.name, this.designation in constructor
  → final  : id — employee ID, immutable
  → instanceof : checked before displaying employee details
  → Features: setSalary(), applyRaise()

Program 4 - ShoppingCartSystem.java
  → static : discount (shared %, applies to all), updateDiscount()
  → this   : this.productID, this.productName, this.price, this.quantity
  → final  : productID — unique product identifier, immutable
  → instanceof : checked before displaying and processing product
  → Features: calculateDiscountedPrice() (private helper)
               updateDiscount() updates price across ALL products instantly

Program 5 - UniversityStudentManagement.java
  → static : universityName (shared), totalStudents, displayTotalStudents()
  → this   : this.rollNumber, this.name, this.grade in constructor
  → final  : rollNumber — unique student identifier, immutable
  → instanceof : checked before displaying AND before updating grade
  → Features: updateGrade() with grade validation (A/B/C/D/F only)

Program 6 - VehicleRegistrationSystem.java
  → static : registrationFee (common for all), updateRegistrationFee()
  → this   : this.registrationNumber, this.ownerName, this.vehicleType
  → final  : registrationNumber — unique vehicle ID, immutable
  → instanceof : checked before displaying registration details
  → Features: updateRegistrationFee() reflects immediately on all vehicles

Program 7 - HospitalManagementSystem.java
  → static : hospitalName (shared), totalPatients, getTotalPatients()
  → this   : this.patientID, this.name, this.age, this.ailment
  → final  : patientID — unique patient identifier, immutable
  → instanceof : checked before displaying AND before discharging patient
  → Features: discharge() decrements totalPatients counter

===============================================================
HOW TO COMPILE AND RUN:
===============================================================

Using Terminal / Command Prompt:

  1. Navigate to the folder:
       cd JavaKeywordsPrograms

  2. Compile:
       javac BankAccountSystem.java

  3. Run:
       java BankAccountSystem

Repeat for each program (compile then run using the class name
ending in 'System', 'Management', or 'Demo').

===============================================================
BEST PRACTICES FOLLOWED:
===============================================================
  ✔ static used for shared values and utility/counter methods
  ✔ this used in every constructor to avoid ambiguity
  ✔ final applied to all unique identifiers (IDs, numbers, ISBNs)
  ✔ instanceof used for type-safe checking before every display/action
  ✔ Private attributes + public getters/setters (encapsulation)
  ✔ Private helper methods for calculations (e.g. calculateDiscountedPrice)
  ✔ Input validation in setters (salary > 0, discount 0-100, grade A-F)
  ✔ Scanner closed after use (sc.close())

===============================================================
