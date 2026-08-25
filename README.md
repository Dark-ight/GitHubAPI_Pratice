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