# File IO
- java.io package provides useful classes to perform input and output (I/O) in Java

**InputStream**
- used to read data from a source

**OutputStream**
- used to write data to a destination

### ByteStream
- when we use a bytestream to read/write to a file transfered 1 byte by 1 byte of data

> FileInputStream

> FileOutputStream

### CharacterStream
- while a bytestream represents a stream of data in the form of 8-bit bytes, character streams are used to perform input/output for 16-bit characters
- built on a bytestream, but handles the encoding of the characters for you 

> FileReader

> FileWriter

### Buffering ByteStreams and CharacterStreams
- going one byte or character at a time can be pretty costly, so we read/write in larger chunks using buffered streams

> BufferedInputStream/ BufferedOutputStream -> buffered byte streams

> BufferedReader/ Buffered Writer -> buffered character streams

- when we use any of these buffering objects, we pass our stream objects in as a parameter

#### BufferedReader
```java
FileReader fr = new FileReader("input.txt");
BufferedReader br = new BufferedReader(fr);
// read a single character, read a line
```

#### BufferedWriter
```java
FileWriter fw = new FileWriter(file);
BufferedWriter bw = new BufferedWriter(fw);
// write or append 
// write will only take a String which must not be null and returns void
// append will take any CharSequence which can be null and return the Writer so it can be chained.
```

# Serialization
- Serialization allows for objects to be written directly to streams 
- we convert java objects to a bytestream - from here it can be written to a file
- wrapping our stream in an ObjectInputStream/ObjectOutputStream allows us to do this conversion
- Serializable is a marker interface (no methods) which indicates that an object is meant to be serialized 
- serialization is a means for persistence, up until now, all of our java objects do not have a lifecycle which extend past the lifecycle of the application - this will be the first time we'll be able to see objects states be saved beyond that
- SerialVersionUID is used to define the version of a java object; it's used at runtime to assure that the serializer and the deserializer have compatible objects  
- **transient** keyword indicates that a particular instance variable is not to be serialized

