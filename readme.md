Requirements:
- At least 15 classes.
- All classes must contain properties (minimum 1).
- At least 5 private properties (in total, in any classes).
- All private variables must have getters and setters.
- All classes should have at least one custom constructor.
- Create separate class with main() which will instantiate objects of implemented classes.
- Use polymorphism with at least one abstract class.
- Create and override at least one abstract method.
- Use at protected modifier at least 5 times.
- Override methods from class Object (toString(), hashcode(), equals()) for at least 3 classes from the hierarchy.
- Add 5 interfaces to the existing hierarchy.
- Use polymorphism with the abstract class and interface from the hierarchy.
- Create final class, method, variable.
- Create a static block, method, variable.
- Create 5 custom exceptions.
- Handle exceptions in 2 ways.
- Use try-catch with resources.
- Log messages to the console, file.
- Add 5 collections to the hierarchy.
- Create custom implementation of LinkedList with generic and use it in your project.

File reader/writer:
- Read text from the file and calculate the numbers of the unique words. Write the result to the file. The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.

Lambda expressions:
- Use at least 5 lambda functions from the java.util.function package.
- Create 3 custom Lambda functions with generics.
- Create 5 complex Enums(with fields, methods, blocks).

Streams and reflection:
- Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
- Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods. Create object and call method using the only reflection.

Thread and Connection:
- Create 2 Threads using Runnable and Thread.
- Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized.
- Initialize Connection Pool object of size 5. Load Connection Pool using single threads and Java Thread Pool (7 threads in total). 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well.
- Implement previous point but with interfaces Future and CompletableStage.