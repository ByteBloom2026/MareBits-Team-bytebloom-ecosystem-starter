# ByteBloom Ecosystem Management System

## Project Overview

The ByteBloom Ecosystem Management System is a Kotlin-based command-line application designed to manage teams, mentees, projects, attendance records, and performance evaluations within a mentorship ecosystem.

The system loads data from CSV files and provides various analytical and reporting features such as:

* Searching teams and mentees.
* Calculating team performance metrics.
* Finding top-performing mentees.
* Attendance analysis.
* Project and submission tracking.
* Interactive command-line operations.

The project was developed following **Clean Architecture** principles to ensure maintainability, scalability, and separation of concerns.

---

# Clean Architecture

The project follows Uncle Bob's Clean Architecture model.

![Clean Architecture](CleanArchitecture.jpg)

### Architecture Layers

#### 1. Domain Layer (Entities & Business Rules)

Contains the core business logic and rules of the system.

Packages:

```text
domain/model
domain/usecase
domain/validation
```

Responsibilities:

* Define business entities.
* Implement application use cases.
* Validate business rules.
* Remain independent from external frameworks and data sources.

---

#### 2. Data Layer

Responsible for data retrieval and mapping.

Packages:

```text
data/datasource
data/repository
data/repository/mappers
```

Responsibilities:

* Read CSV files.
* Convert raw data into domain models.
* Provide repository implementations.
* Handle asynchronous file operations using Coroutines.

---

#### 3. Dependency Injection Layer

Package:

```text
di
```

Responsibilities:

* Configure dependency injection using Koin.
* Register repositories, use cases, and data sources.

---

#### 4. Presentation Layer

Package:

```text
presentation
```

Responsibilities:

* Parse user commands.
* Route commands to use cases.
* Display results in the command-line interface.

Components:

```text
Command.kt
CommandParser.kt
```

---

# Implemented Features

## Team Management

* Search teams by name.
* Calculate team average score.
* Find teams with no assigned projects.

## Mentee Management

* Search mentees by name.
* Find top-scoring mentees.
* Analyze attendance performance.
* Detect low-performing mentees.

## Project Management

* Retrieve projects by team.
* Calculate project statistics.
* Track project submissions.

## Attendance Management

* Analyze attendance records.
* Identify perfect attendance.
* Identify poor attendance.

---

# Coroutines & Asynchronous Programming

As part of Week 8 requirements, the project was refactored to use Kotlin Coroutines.

Implemented concepts:

### Suspend Functions

Repository and Use Case operations were converted to suspend functions.

### Dispatchers.IO

All file I/O operations are executed using:

```kotlin
withContext(Dispatchers.IO)
```

to avoid blocking the main thread.

### Structured Concurrency

The application uses:

```kotlin
runBlocking
launch
```

to manage asynchronous command execution.

### Flow & Debounce

The mentee search feature uses:

```kotlin
Flow
debounce()
```

to demonstrate reactive and asynchronous search behavior.

---

# Interactive CLI

The final version includes a fully interactive Command Line Interface.

Supported Commands:

```text
search-teams <keyword>
search-mentees <query>
team-average <teamId>
top-mentee
help
exit
```

The CLI parses user input through a dedicated CommandParser and routes commands to the appropriate use cases.

---

# Technologies Used

* Kotlin
* Kotlin Coroutines
* Flow
* Koin Dependency Injection
* CSV Data Sources
* Clean Architecture
* Gradle

---

# Key Design Principles Applied

* Clean Architecture
* Separation of Concerns
* Dependency Inversion Principle
* Single Responsibility Principle
* Structured Concurrency
* Asynchronous File Processing
* Reusable Use Cases
* Dependency Injection

---

# Conclusion

This project demonstrates how Clean Architecture and Kotlin Coroutines can be combined to build a scalable, maintainable, and testable command-line application. The final system supports asynchronous operations, dependency injection, reactive search, and a clear separation between business logic, data access, and presentation layers.
