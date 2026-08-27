# GitHub API Practice

A Java command-line application that interacts with the GitHub REST API to retrieve and analyze GitHub user information.

> **Name:** GitHub API Project  
> **Inspired by:** roadmap.sh  
> **Check here:** ([link](https://roadmap.sh/projects/github-user-activity))

Note from the owner: This project is a good starting point for anyone who has little or no experience with APIs, Jackson, and Maven.
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
│   └── wrapper/                         # Maven Wrapper configuration files
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── GitHub_Activity.java     # Main application and data display
│   │       └── GitHubAPI.java           # Handles GitHub API requests
│   │
│   └── test/
│       └── java/
│           └── GitHubAPITest.java       # Tests GitHub API functionality
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml                              # Manages Maven dependencies and configuration
└── README.md                            # Project documentation and usage instructions                                                   
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

## Run Tests

Run the JUnit tests using Maven:
```bash
.\mvnw.cmd test
```
This will:

- Compile the test code
- Run all JUnit tests
- Display the test results in the terminal

## Run the Application

After building the project, run the application with Maven:

```bash
.\mvnw.cmd compile exec:java "-Dexec.mainClass=GitHub_Activity" "-Dexec.args=<your_GitHub_username>"
```
Note: Enter your GitHub's username without < >

The application will then retrieve and display information about the user, including:

- Username
- Total public repositories
- Public repository names
- Push event activity by repository
```text
______________________Display/Info______________________
Username: octocat
Total public repositories: 8
This user pushed 12 commits on this Python_Project
This user pushed 5 commits on this WebHTML
__________________________END___________________________
```

## Maven Commands
| Command                      | Description                   |
|------------------------------|-------------------------------|
| **.\mvnw.cmd compile**       | Compile the application       |
| **.\mvnw.cmd test**          | Run all JUnit tests           |
| **.\mvnw.cmd clean**         | Remove compiled files         |
| **.\mvnw.cmd clean compile** | Clean and compile the project |
| **.\mvnw.cmd clean test**    | Clean and run all tests       |


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
