# GitHub API Practice

A Java command-line application that interacts with the GitHub REST API to retrieve and analyze GitHub user information.

This project was built to practice **REST APIs, HTTP requests, JSON parsing, OOP, Maven, and automated testing** in Java.

## Features

- Retrieve a GitHub user's profile
- Display username and public repository count
- Retrieve the user's public repositories
- Retrieve the user's public events
- Analyze `PushEvent` activity by repository
- Parse GitHub API responses using Jackson
- Handle JSON safely using Jackson's `JsonNode`
- Use a reusable `HttpClient` for API requests
- Manage dependencies with Maven
- Run the project using Maven Wrapper
- Includes JUnit tests for validating application behavior

## Technologies

- **Java**
- **GitHub REST API**
- **Jackson Databind**
- **JUnit**
- **Maven**
- **Maven Wrapper**
- **Git / GitHub**

## Project Structure

```text
GitHubAPI_Practice/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── GitHub_Activity.java
│   │       └── GitHubAPI.java
│   │
│   └── test/
│       └── java/
│           └── GitHubAPITest.java
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Requirements

- Java JDK
- Git

Note: You **do not need to install Maven** because this repository includes the Maven Wrapper.

## Clone the Repository

```bash
git clone https://github.com/your-username/GitHubAPI_Practice.git
cd GitHubAPI_Practice
```

## Setup

After cloning the repository, make sure Java is installed, and check your Java installation:

```bash
java -version
```

Note: The project uses the Maven Wrapper, so Maven does not need to be installed separately.

## Build the Project

On Windows, compile the project with:

```bash
.\mvnw.cmd compile
```

This will:

- Download the required Maven dependencies
- Compile the Java source code
- Create the target/ directory

## API Features

The application retrieves information from GitHub for:

- User profiles
- Public repositories
- Public events

Note: It also analyzes PushEvent activity to determine how many push events are associated with each repository.

## Future Improvements

Possible future improvements include:

- API pagination
- GitHub authentication
- More detailed error handling
- Additional GitHub API endpoints
- More extensive unit testing
- Improved command-line output
