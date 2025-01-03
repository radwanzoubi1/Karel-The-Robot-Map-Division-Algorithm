

# Karel Map Division Assignment

This project implements a solution to divide a map into equal chambers using Karel the Robot. The primary goal is to optimize map division into four chambers or, when not possible, the largest possible number of equal parts (e.g., 3, 2, or 1), while adhering to constraints and maximizing efficiency. The solution emphasizes reusable code, minimal movement, and optimized resource usage.

---
### About Karel the Robot

Karel the Robot is an educational programming environment designed to teach fundamental programming concepts in a simplified, engaging way. Created by Rich Pattis in the 1970s, Karel operates in a grid-like world and follows instructions written in a specialized programming language. The environment allows users to focus on problem-solving and algorithmic thinking, free from the complexities of full-featured programming languages.

Karel's world consists of:
- **Grid Layout**: Streets (horizontal) and avenues (vertical) form a grid where Karel operates.
- **Beepers**: Objects Karel can pick up or place to mark positions or achieve tasks.
- **Walls**: Obstacles that Karel must navigate around.

#### Key Capabilities
Out of the box, Karel supports a small set of commands:
- `move()`: Moves Karel one step forward.
- `turnLeft()`: Rotates Karel 90° counterclockwise.
- `pickBeeper()`: Picks up a beeper from the current corner.
- `putBeeper()`: Places a beeper on the current corner.

These simple commands serve as the building blocks for solving increasingly complex problems. Users can also define custom methods to extend Karel's functionality.

#### Further Reading
To learn more about Karel and its programming environment, explore these resources:
- [Stanford Karel Guide](https://compedu.stanford.edu/karel-reader/docs/python/en/chapter1.html)
- [Wikipedia Article on Karel](https://en.wikipedia.org/wiki/Karel_(programming_language)) 

--- 
## About the Problem

### Domain:
- **Karel Programming**: Teaching problem-solving and programming logic using a robot in a grid-like environment.
- **Purpose**: Solve a map division problem using only basic commands available in Karel's predefined API.

### Problem Overview:
- **Task**: Divide the map into chambers with equal areas, using beepers as markers.
- **Optimization Criteria**:
  - Minimize Karel's moves.
  - Reduce the use of beepers.
  - Simplify code with reusable functions.
- **Special Cases**: Handle scenarios where division into four chambers is not feasible.

---

## Project Objectives

1. **Map Division Logic**:
   - Implement algorithms to evenly divide a map or handle special cases for unequal division.
   - Utilize double lines of beepers when necessary while maintaining efficiency.

2. **Code Optimization**:
   - Use modular, reusable functions to simplify code and reduce redundancy.
   - Minimize the number of moves and operations Karel performs.

3. **Performance Monitoring**:
   - Add a move counter to track Karel's performance in real-time.
   - Optimize for the lowest possible number of moves.

4. **Comprehensive Documentation**:
   - Provide clear explanations of the problem-solving process and optimization techniques in a report.

---

## Key Features Explored

1. **How to maximize efficiency in Karel's movements?**
   - Addressed through reusable methods and logic optimization.

2. **How to minimize the use of beepers?**
   - Evaluated through efficient placement algorithms.

3. **How does the solution adapt to different map sizes and constraints?**
   - Tested on multiple scenarios with varying map dimensions.


---

## Tools and Libraries Used

- **Java**: Programming language.
- **Stanford Karel Library**: API for Karel the Robot.
- **JDK**: Java Development Kit for compiling and running the program.

---
## How to Run

### 1. Clone the Repository:
```bash
git clone https://github.com/your-repo/Karel-Map-Division.git
cd Karel-Map-Division
```

### 2. Set Up Java Environment:
Ensure you have JDK installed. If not, download and install it from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).

### 3. Compile and Run:
- **Compile the Code**:
```bash
javac Homework.java
```
- **Run the Program**:
```bash
java Homework
```

### 4. View Output:
- The program prints the move count and demonstrates map division in the Karel simulator.

---

## Acknowledgments

This project is inspired by the educational programming environment Karel the Robot. Learn more about Karel from the [Stanford Karel Guide](https://compedu.stanford.edu/karel-reader/docs/python/en/chapter1.html) and its [Wikipedia page](https://en.wikipedia.org/wiki/Karel_(programming_language)).
