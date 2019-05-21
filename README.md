# Streams
The Stream API is used to process collections of objects. A stream is a sequence of objects that supports various methods, which can be pipelined to produce desired results

## Advantages of Streams:
   - Will make you a more efficient programmer
   - make heavy use of lambda expressions
   - ParallelStreams make it very easy to multi-thread operations
   
 
   **A stream pipeline consists of a source, followed by zero or more intermediate operations  and a terminal operation**
   
   ## Stream Source
   Streams can be created from Collections, Lists, Sets, ints, longs, foubles, arrays, lines of a file
   
   Stream operations are either **intermediate** or **terminal**
   
   ## Intermediate Operations
   - Zero or more intermediate operations are allowed
   - Order matters for large datasets: filter first, then sort or map
   - For every large datasets use ParallelStream to enable multiple threads

   **Intermediate operations include:**
   - anyMatch() 
   - flatMap()
   - distinct()
   - map()
   - filter()
   - skip()
   - findFirst()
   - sorted()
   
   
   ## Terminal Operations
   - One terminal operation is allowed.
   - forEach() applies the same function to each element
   - collect saves the elements into a collection
   - other options reduce the stream to a single summary element
  
   **Terminal operations include:**
   - count()
   - min()
   - max()
   - reduce()
   - summaryStatistics()