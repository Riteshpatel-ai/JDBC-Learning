# 🗄️ JDBC Learning - Java Database Connectivity Tutorial

A comprehensive hands-on repository demonstrating Java Database Connectivity (JDBC) operations with MySQL database. This project covers fundamental CRUD operations and advanced ResultSet manipulations.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Project Structure](#project-structure)
- [Code Examples](#code-examples)
- [How to Run](#how-to-run)
- [Learning Outcomes](#learning-outcomes)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This repository contains practical Java programs that demonstrate how to interact with MySQL databases using JDBC API. Each program focuses on specific database operations, making it ideal for beginners learning database connectivity in Java.

## ✨ Features

- **Basic CRUD Operations**
  - ✅ Create (Insert records)
  - 📖 Read (Query and display data)
  - ✏️ Update (Modify existing records)
  - ❌ Delete operations  
  
- **Advanced Concepts**
  - 🔄 Scrollable ResultSets
  - 🔴 Live data updates with TYPE_SCROLL_SENSITIVE
  - 🛡️ PreparedStatement for SQL injection prevention
  - 📊 ResultSet navigation and manipulation

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 8+ | Core programming language |
| MySQL | 8.0+ | Relational database |
| JDBC Driver | MySQL Connector/J | Database connectivity |
| IntelliJ IDEA | Latest | IDE (optional) |

## 📦 Prerequisites

Before running this project, ensure you have:

1. **Java Development Kit (JDK)** - Version 8 or higher
   ```bash
   java -version
   ```

2. **MySQL Server** - Installed and running
   ```bash
   mysql --version
   ```

3. **MySQL JDBC Driver** - `mysql-connector-java.jar`
   - Download from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/)

## 🗃️ Database Setup

### Step 1: Create Database
```sql
CREATE DATABASE testStudent;
USE testStudent;
```

### Step 2: Create Table
```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    sName VARCHAR(100) NOT NULL,
    age INT NOT NULL
);
```

### Step 3: Insert Sample Data
```sql
INSERT INTO student (id, sName, age) VALUES
(101, 'Ritesh', 22),
(102, 'Priya', 21),
(103, 'Amit', 23),
(104, 'Sneha', 20),
(105, 'Rahul', 24);
```

### Step 4: Update Connection Credentials
In each Java file, update the database credentials:
```java
Connection cn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/testStudent", 
    "YOUR_USERNAME",  // Change this
    "YOUR_PASSWORD"   // Change this
);
```

## 📁 Project Structure

```
JDBC-Learning/
│
├── src/
│   ├── JDBCDemo.java                 # Basic SELECT operation
│   ├── JDBCInsertDemo.java           # Insert using Statement
│   ├── JDBCPracticeDemo.java         # Insert using PreparedStatement
│   ├── JDBCUpdateDemo.java           # Update operation
│   └── JDBCScrollSensative.java      # Scrollable & Sensitive ResultSet
│
├── .gitignore
├── JDBCP01.iml
└── README.md
```

## 💻 Code Examples

### 1️⃣ Basic Read Operation

```java
import java.sql.*;

public class JDBCDemo {
    public static void main(String []args){
        try{
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish Connection
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testStudent","root","password");
            
            // Create Statement
            Statement statement = cn.createStatement();
            
            // Execute Query
            ResultSet rs = statement.executeQuery("select * from student");
            
            // Process Results
            while(rs.next()){
                System.out.println(rs.getInt("id") + " | " + 
                                 rs.getString("sname") + " | " + 
                                 rs.getInt("age"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
```

**Demonstrates:** Basic SELECT query execution and result iteration

---

### 2️⃣ Insert Operation (Statement)

```java
String query = "Insert Into student (id,sName,age) values(4,'Sanjeep',30)";
int querys = statement.executeUpdate(query);
System.out.println("inserted " + querys + " Rows");
```

**Demonstrates:** Direct SQL insertion using Statement

---

### 3️⃣ Insert Operation (PreparedStatement) ⭐ Recommended

```java
String query = "INSERT INTO Student (id, sName, Age) VALUES (?, ?, ?)";
PreparedStatement pr = con.prepareStatement(query);

pr.setInt(1, 5);
pr.setString(2, "Sivansh");
pr.setInt(3, 10);

int rowsInserted = pr.executeUpdate();
```

**Demonstrates:** Parameterized queries to prevent SQL injection

---

### 4️⃣ Update Operation

```java
String query = "Update Student set age=14 where id=105";
int update = stmt.executeUpdate(query);
System.out.println("Update " + update + " rows");
```

**Demonstrates:** Modifying existing records

---

### 5️⃣ Scrollable & Sensitive ResultSet 🔥

```java
Statement stmt = cn.createStatement(
    ResultSet.TYPE_SCROLL_SENSITIVE,  // Can scroll forward/backward
    ResultSet.CONCUR_READ_ONLY        // Read-only cursor
);
```

**Demonstrates:** 
- Scrollable cursor navigation
- Real-time data change detection
- `beforeFirst()` method to reset cursor

**Key Feature:** After reading data once, if you manually update the database, the second read reflects the **live changes**!

## 🚀 How to Run

### Method 1: Command Line

1. **Compile the Java file:**
   ```bash
   javac -cp .:mysql-connector-java.jar src/JDBCDemo.java
   ```

2. **Run the program:**
   ```bash
   java -cp .:mysql-connector-java.jar:src JDBCDemo
   ```

### Method 2: IDE (IntelliJ IDEA / Eclipse)

1. Open project in your IDE
2. Add `mysql-connector-java.jar` to project libraries
3. Update database credentials in the code
4. Right-click on any Java file → **Run**

## 📚 Learning Outcomes

After exploring this repository, you will understand:

| Concept | Description |
|---------|-------------|
| **JDBC Architecture** | Driver loading, connection establishment |
| **Statement vs PreparedStatement** | When to use each and security implications |
| **ResultSet Types** | Forward-only, scrollable, sensitive vs insensitive |
| **CRUD Operations** | Complete lifecycle of database interactions |
| **Exception Handling** | Managing SQLException and ClassNotFoundException |
| **Connection Management** | Best practices for opening/closing resources |

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewJDBCConcept`)
3. Commit your changes (`git commit -m 'Add batch processing example'`)
4. Push to the branch (`git push origin feature/NewJDBCConcept`)
5. Open a Pull Request

### Ideas for Contribution:
- Add DELETE operation example
- Implement batch processing
- Add connection pooling example
- Create examples using try-with-resources
- Add unit tests

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Ritesh Patel**
- GitHub: [@Riteshpatel-ai](https://github.com/Riteshpatel-ai)

## 🌟 Acknowledgments

- MySQL Documentation
- Oracle JDBC Tutorials
- Java Community

---

### 📌 Important Notes

⚠️ **Security Warning:** The current examples contain hardcoded database credentials for learning purposes only. In production:
- Use environment variables
- Implement connection pooling
- Use configuration files (excluded from version control)

💡 **Best Practices:**
- Always close database connections in `finally` block or use try-with-resources
- Use PreparedStatement to prevent SQL injection
- Handle exceptions properly with meaningful error messages

---

**⭐ If this repository helped you learn JDBC, please give it a star!**