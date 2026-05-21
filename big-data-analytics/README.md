## Endsem Practice Questions

#### **Q1. Define Big Data**
* Massive amount of data that cannot be stored/processed/analyzed using traditional tools.
* Requires specialized, cost effective, efficient forms of information processing → to extract insights for decision making and process automation
* 3V's of big data: hgh Volume, high. Velocity, high Variety info


#### **Q2. What is unstructured data**
* Unstructured data has unkown form, lack of architecture / undefined internal structure. 
* It cannot be stored cleanly within standard relational tables containing pre-defined columns and rigid rows.  
* Because its formatting cannot be known or predicted in advance; it presents major technical challenges during parsing/sorting/computational analytics (to derive business value)  
* Unstructured datasets are fundamentally multi-format and heterogeneous. Common examples:
    * .txt logs
    * photos/videos/audio files
    * machine/console logs
    etc


#### **Q3. Explain the convergence of key trends leading to Big Data.**
Tranistion into era of Big Data caused by:
* Use of social media platforms → producd continuous streams of text/image/video content.
* Smart devices and IoT sensors → huge volume of machine generated data
* Increase in computing power/processing speeds at reduced costs.
* Traditional SQL DBs had rigid schemas and single node hardware boundaries → new distributed systems can deal with large unstructured data
* Advancements in algorithms/AI/machine learning/NLP/image processing → enable extracting value/patterns from raw data.


#### **Q4. Discuss Big Data applications in marketing and advertising**
* Targeted advertising based on user behaviour and preferences
* Customer churn prediction
* Sentiment analysis of customer reviews and feedback (from social media data)
* Market basket analysis to identify products frequently purchased together
* Price optimization based on demand and competitor pricing

#### **Q5. Explain web analytics**
* Involves collecting/analysing/reporting website usage/user behaviour data -> to optimize online presence + achieve business objectives.
* Steps:
    * 1. Collect data → using cookies/tracking codes/log files to record visitor activity (page view/click/time spent/ referral codes, etc)
    * 2. Process data into info → quantify metrics like visitor count/bounce rate/conversion rate/ engagement levels, etc.
    * 3. Develop key performance indicators (KPIs) → identify trends + insights from user behaviour
    * 4. Formulate strategy → present insights through reports/dashboards for data-driven decision making
* Tools: Adobe Anaytics, Google Analytics, Matomo, etc


#### **Q6. Explain the role of Big Data in fraud detection and risk management**
* Real time analysis of transactions/patterns → detect anomalies/suspicious activity
* Risk assessment for loans/credit/insurance →  analyze customer financial history and behaviour
* BDA provides comprehensive view of customer behaviour → detect unusual patterns
* Risk assessment for investments → analyze market trends/patterns
* Use ML algos to identify fraudulent activities/stock price prediction, etc.


#### **Q7. What is hadoop?**
* Open source, distributed computing framework
* Designed for cost-effective storage + processing of large datasets
* Scales from 1 server to 1000s of m/cs
* Developed in 2005 by Doug Cutting and Mike Cafarella

* Components of Haddop:
    1. HDFS (Hadoop Distributed File System) → splits data into blocks and replicates them across nodes for fault tolerance → highly scalable
    2. MapReduce → programming model for parallel data processing
    3. YARN (Yet Another Resource Negotiator) → resource management and job scheduling 
    4. Hadoop Common → collection of common utilities/libraries/APIs to support other components

> *YARN decouples management from job scheduling for efficiency*


#### **Q8. Explain the concept of mobile business intelligence and crowd sourcing analytics.**
1. Mobile Business Intelligence:
    * BI analytics (reports/dashboards/KPIs) available on mobile devices
    * Enables real-time decision making on the go
    * Has responsive, touch friendly interfaces, native device functionality, real-time push notifications for critical business alerts
    * Enables sales teams/managers/remote execs to access insights and address issues on the fly without having to wait to return to a desktop/computer

2. Crowd Sourcing Analytics:
    * Data is collected (passively or actively) from a large group of people (crowd)
        * Eg: Drivers reporting traffic on navigation apps
        * Eg: Feedbacks forms/ surveys / reviews on social media
    * Capitalizes on the "wisdom of the crowd"
    * Replace/complement internal metrics with public inputs to discover trends, evaluate real-time situations (like traffic map updates) and drive community-backed product adjustments.


#### **Q9. Define NoSQL database**
* "Not Only SQL"
* BASE - compliant
* Flexible schemas
* Handle unstructured + semi-structured data
* Horizontal scalability (with cluster of smaller m/cs)→ eliminates single points of failure (coz of replication)
* Handles massive data writes → suitable for big data + distributed systems
* Types: 
    * Key-Value stores (Redis, DynamoDB)
    * Document databases (MongoDB, Couchbase)
    * Column-family stores (Cassandra, HBase)
    * Graph databases (Neo4j, ArangoDB)


#### **Q10. What is a key-value data model?**
* Simplest form of NoSQL architecture
* Stores data as collection of key-value pairs
* Key → unique identifier (string or index) of a record
    * Key must be unique
    * Key is used to retrieve the value
* Value → any data (text, image, JSON, etc.)
    * Value is completely opaque to DB server (read as an unexamined block of data like JSON/raw string/binary object)
* Pros:
    * Ultra low latency
    * No complex table scans or joins
    * Scalable
* Use case:
    * Caching sessions
    * Shopping cart data
    * User profile storage
* Eg: Amazon DynamoDB, Redis, Riak


#### **Q11. Explain aggregate data models with examples**
* Group related data together into single, cohesive unit called "aggregate" (instead of splitting it across multiple isolated tables like in relational DBs)
* Reduce complex runtime joins (ACID-compliant relational joins)
* Improve read performance by pre-calculating and storing aggregated values
* "Aggregate" is primary unit of storage + atomic updates

* Types of aggregate models:
    1. Key-Value Store:
        * Entire aggregate is a single blob mapped to a unique key 
        * Eg: Amazon DynamoDB, Redis, Riak
    2. Document Store:
        * Group related data together into a single, nested tree-like (JSON/BSON/XML) document
        * Eg: MongoDB, Couchbase
    3. Column-family Store:
        * Group related columns into column families
        * Eg: Cassandra, HBase

#### **Q12. Differentiate between relational DBs and NoSQL DBs**

| **Feature** | **Relational DBs** | **NoSQL DBs** |
|---|---|---|
| **Schema** | Fixed, predefined | Dynamic, flexible |
| **Data Model** | Tables with rows/columns | Key-value, document, column-family, graph |
| **Scalability** | Vertical (Add more CPU/RAM to one server) | Horizontal (Add more servers to a cluster) |
| **Transactions** | Strong ACID compliance (guaranteed consistency) | BASE properties (high availability, eventual consistency, partition tolerance) |
| **Query Language** | SQL | Varies (CQL, MongoDB Query Language, etc) |
| **Best For** | Structured data, transactions | Unstructured + semi-structured data, big data |
| **Use Case** | Financial systems, complex analytical queries | Real-time web apps, changing data structures |
| **Examples** | MySQL, PostgreSQL | MongoDB, Cassandra, Redis, Neo4j |


#### **Q13. What is sharding?**
* Horizontal partitioning of data across multiple nodes
* No replication (each shard holds a different subset of data)
* Each node performs it's own read/write operations
* Data is denormalized to avoid cross-shard operations (no distributed joins across shards)
* Massive horizontal scalability
* (shards can be further split as data/access grows)
* Fault tolerance (no single point of failure)


#### **Q14. Explain sharding and replication in NoSQL databases**

| Feature | **Sharding (Horizontal Partitioning)** | **Replication (Data Duplication)** |
| :--- | :--- | :--- |
| **Goal** | **Scale writes** + increase overall storage capacity | **Scale reads** + ensure high availability + prevent data loss |
| **Data Distribution** | Data is **split** across servers. Each server holds a unique subset of data | Data is **copied** across servers. Every server holds a full, identical backup |
| **Storage Capacity** | **Increases** linearly with each added server | **Stays the same**. Adding servers does not give you more total storage room |
| **Failure Impact** | If one shard crashes, **only a fraction of users** lose access to their data | If one replica crashes, **zero users lose access**. Another replica takes over |
| **Write Performance** | **Speeds up significantly** because writes are distributed across multiple machines | **Can slow down** because the system must copy the write to all replicas |
| **Read Performance** | Speeds up reads for individual items if you know exactly which shard to look at | Speeds up overall read capacity by letting users query any available replica |
| **Implementation Complexity** | **Very High** → (Code must know how to route data based on a specific "Shard Key") | **Medium** → (Most modern databases have replication features built right in) |


#### **Q15. Define master-slave replication**
* One node is designated as "Master" (primary node)
* Master node handles all write operations + process data updates (and changes are later propogated to slaves)
* Slave nodes handle read operations only
* Replication synchronizes slaves with master (usually asynchronously)
    * Slaves always lag slightly behind master (eventual consistency)

* Pros:
    * Read resilience (slaves can still perform read operations if master fails)
    * High availability (if master fails → designate a slave as new master temporarily to handle write operations as well)
* Cons:
    * Write bottleneck (master can become a bottleneck under heavy write loads)
    * Eventual consistency (slaves may lag behind master leading to stale reads)


#### **Q16. Discuss consistency and relaxing consistency in distributed databases**
* **CAP Theorem**: A distributed system can only guarantee 2 out of 3 properties:
    * Consistency (C): All nodes see the same data at the same time
    * Availability (A): Every request receives a response (system stays operational even if some nodes fail)
    * Partition Tolerance (P): The system continues to operate despite network failures (partitions)

* Strict consistency problem:
    * Enforcing instant consistency requires blocking systems until all nodes across a cluster match
    * This destroys system speed/availability during network drops

* In distributed systems, we must choose between Consistency and Availability (since network partitions are inevitable)

* Relaxing consistency:
    * Relax consistency to ensure high availability.
    * Shift from ACID to BASE model (eventual consistency)


#### **Q17. What is Map-Reduce?**
* Java-based distributed execution programming framework within Apache Hadoop
* For parallel processing of large datasets across a cluster of machines
* Uses HDFS for data input and output operations
* Automatically parallelizes jobs across the cluster

1. Map phase:
    * Input data is split into chunks
    * Each chunk is processed in parallel by multiple map tasks
    * `map()` function processes input records and produces intermediate key-value pairs
    * `map()` function doesn't need to be aware of other nodes (each map task operates independently)

2. Reduce phase:
    * Collects and aggregates intermediate key-value pairs from map phase
    * Groups all values for the same key together
    * `reduce()` function processes each group and produces final output
    * `reduce()` function can aggregate/sum/count or perform any custom aggregation


#### **Q18. Explain the working of Map-Reduce**
Input Data → Splits into chunks → Mapper processes → Shuffle (group same key together) → Reducers process → Final Output

*Draw word count example diagram*

* `map(k1, v1) → list(k2, v2)`
* `reduce(k2, list(v2)) → list(v3)`


#### **Q29. Explain anatomy of MapReduce job run**
1. Job Submission: Client application submits a configured execution job to the cluster manager
2. Job Initialization: The cluster manager allocates resource containers and initializes a driver manager instance known as the JobTracker (Classic) or ApplicationMaster (YARN)
3. Task Assignment: The driver pulls logical input splits from HDFS and schedules parallel task allocations to available cluster worker machines
4. Task Execution: Worker nodes spin up task processes to run the custom Mapper logic, followed by the Shuffle/Sort phase, and finally the Reducer code.
5. Job Completion: Reducers save the final output results directly back into HDFS blocks; and the driver cleans up allocated resource containers.


#### **Q32. What is task scheduling in MapReduce?**
* Refers to the process of assigning Map and Reduce tasks to available nodes in the cluster for parallel execution
* It is the responsibility of the JobTracker (in classic MapReduce) or ApplicationMaster (in YARN)

* Types of schedulers:
    * FIFO (First-In, First-Out)
        * Delault algo
        * Processes jobs in the sequence they are submitted
        * Large jobs can cause starvation for small jobs
        
    * Fair Scheduler
        * Guarantees all running applications receive equal share of processing resources
        * Better for multi-tenant environments
        
    * Capacity Scheduler
        * Allocates dedicated resource pools ("queues") to distinct sub-teams
        * Each queue has a guaranteed minimum capacity


#### **Q36. Explain task execution and job scheduling in MapReduce**
* Task Execution Pipeline:
    * Driver reads logical input boundaries (Input Splits)
    * Map tasks spin up inside isolated containers close to data blocks (Data Locality)
    * Intermediate records flow into memory buffers, spill to local disks, and pass through the Shuffle/Sort pipeline
    * Reducer tasks fetch sorted partitions, combine matches via custom reduce logic, and write to final outputs

* Job Scheduling Engine:
    * Done by central coordinator (ResourceManager/JobTracker) 
    * Scheduling policy chosen (FIFO/Capacity/Fair)
    * Resources/containers allocated to jobs based on priority


#### **Q37. What are input and output formats in MapReduce?**
1. Input Formats (`InputFormat`):
    * Defines how a MapReduce job reads data from HDFS and splits it into records for processing. It performs two main functions:
        * **Input Splits**: It divides the massive data files into logical chunks (`InputSplits`); each split is assigned to one Mapper node
        * **RecordReader**: It breaks down each split into individual Key-Value pairs that the Mapper can accept as input line-by-line 

2. Output Formats (`OutputFormat`):
    * Defines how final output results (from Reducer Nodes) are saved back to HDFS. It performs 2 main functions:
        * **Validation**: It checks that the output directory does not already exist before the job starts to prevent overwriting data
        * **RecordWriter**: It formats and writes the final Key-Value pairs from the Reducer onto the physical storage disk


#### **Q38. Explain various MapReduce Input and Output Formats**
1. Core Input Formats
    * `TextInputFormat`: Reads text files where each line is a record (key=byte offset, value=line content)
    * `KeyValueTextInputFormat`: Reads text files where each line contains a key and value separated by a delimiter (default tab)
    * `SequenceFileInputFormat`: Reads binary sequence files (compressed or uncompressed)

2. Core Output Formats
    * `TextOutputFormat`: (Default format) Writes each pair as a text line string separated by tab characters.
    * `SequenceFileOutputFormat`: Writes direct binary compressed key-value objects; ideal for chaining sequential MapReduce jobs.
    * `NullOutputFormat`: Explicitly suppresses file creation; used when pushing results directly to external databases.


#### **Q35. Define shuffle and sort phase**
Intermediate step in Hadoop MapReduce that transfers data from Mappers to Reducers
* Shuffle: The process of partitioning and transferring intermediate key-value pairs across the network from Mapper nodes to the designated Reducer nodes
* Sort: The process of grouping and sorting this transferred data by key, ensuring each Reducer receives a consolidated, ordered list of values for each unique key


#### **Q19. What is HDFS?**
* Hadoop Distributed File System
* Distributed file system designed for storing and processing very large datasets across a cluster of machines
* Master-slave architecture
    * NameNode (Master), JobTracker
    * DataNode (Slave), TaskTracker

* Key characteristics:
    * Fault tolerant
    * High throughput
    * Horizontal scalability
    * Highly optimized for streaming data access + large batch workloads
    * Optimized for large files (GB to TB)
    * WORM (Write-Once, Read-Many) data access model


#### **Q20. Explain HDFS architecture**
* NameNode (Master)
    * Manages and maintains DataNodes
    * Maps file blocks to DataNodes
    * Records file system changes
    * Stores metadata (file names/directories/permissions)
    * Performs namespace operations (open/close/rename files)
    * Actual data is not stored on NameNode (only metadata)
    * Single point of failure

* DataNode (Slave)
    * Stores actual file blocks (default block size = 128MB or 256MB)
    * Replicates blocks across multiple DataNodes
    * Reports block reports to NameNode periodically (every 6 seconds)
    * Serve client's read/write requests
    * Uses commodity hardware
    * Runs on the same machine as TaskTracker
    * Heartbeat to NameNode for health checks    

* JobTracker (Master)
    * Accepts job submission from clients * returns results after completion
    * Schedules MapReduce jobs (assigns to TaskTrackers)
    * Monitors task health (and reschedules failed tasks)

* TaskTracker (Slave)
    * Executes tasks assigned by JobTracker
    * Reports task status to JobTracker
    * Supports multiple concurrent tasks running in separate JVMs


#### **Q21. Define Hadoop Streaming**
* It is a utility framework in Apache Hadoop
* Bridges the gap between MapReduce and non-Java languages.
* Enables users to write MapReduce jobs in any programming language that can read from standard input and write to standard output (Python, Perl, PHP, C++, etc.)
* Uses Unix standard streams (`stdin` and `stdout`) to pass data back and forth between the Hadoop framework and the external code script.


#### **Q22. Discuss data flow in HDFS**
* Client Write Operation:
    1. Client requests NameNode to create a new file.
    2. NameNode checks permissions and replies with DataNode locations for the first block.
    3. Client streams data directly to the first DataNode in a pipeline.
    4. DataNodes replicate the block downstream to other DataNodes in a chain (Pipeline Replication).

* Client Read Operation:
    1. Client queries NameNode for block locations of a specific file.
    2. NameNode returns the addresses of DataNodes holding copies of those blocks (sorted by network proximity to the client).
    3. Client connects directly to the closest DataNode to stream the data blocks.


#### **Q23. What is data serialization?**
* The structured process of turning in-memory data objects into a continuous binary stream of bytes.
* Purpose: prepare data objects to be safely sent across a network or written flat onto a storage disk.
* Example: (Java object -> byte stream)
* Deserialization is the reverse process (converting a received byte stream back into live, in-memory structured objects).
* In Hadoop, serialization is used for:
    * Transferring data between Map and Reduce tasks.
    * Inter-process communication (RPC tasks between daemons)
* Hadoop uses its own serialization framework called Writable


#### **Q24. Explain Hadoop I/O and data integrity**
* Problem: Massive data transfers over commodity networks → inherent risk of bit rot + data corruption.
* Solution: Hadoop verifies correctness using checksums

* HDFS Write verification:
    * DataNode automatically computes checksums for each 512 bytes of data received
    * Store checksum value alongside file block (usually in a separate checksum file)

* HDFS Read verification:
    * On read request, client reads both data blocks and checksum files
    * Recomputes checksums and compares them with stored values

* Error handling:
    * If checksums don't match → error is detected
    * Client reports bad block to NameNode
    * NameNode marks the block as bad and re-replicates it from another DataNode


#### **Q25. What is Avro?**
* Data serialization framework within Hadoop ecosystem
* Features:
    * Uses compact binary format → efficient storage + fast data transfer
    * defines schemas in JSON format
    * Self-describing data → data schema embedded directly inside the data files
    * Schema evolution: supports seamless changes to the data structure over time (handles added/missing/renamed fields cleanly)
    * Supports multiple programming languages
    * Interoperability: Facilitates smooth data exchange across multiple distinct programming platforms and tools (Hive, Spark, MapReduce).


#### **Q26. Differentiate between Horizontal Scaling and Vertical Scaling. State any two features of Hadoop.**

| **Feature** | **Scale Up (Vertical Scaling)** | **Scale Out (Horizontal Scaling)** |
| :--- | :--- | :--- |
| **Primary Action** | Add more power (CPU/RAM/Storage) to a single existing server | Add more independent servers to the existing infrastructure pool |
| **Hardware Strategy** | Upgrade to high-end/specialized/expensive enterprise hardware | Connect multiple low-cost/standard commodity servers into a cluster |
| **Scaling Limit** | Strict upper limit dictated by the maximum capacity of a single motherboard | Virtually infinite scaling potential by continuously adding new machines |
| **System Uptime** | Often requires system downtime to install physical parts or reboot virtual instances | Zero downtime; new servers are provisioned and added to the cluster live |
| **Resilience** | Low; a single server creates a single point of failure for the entire system | High; if one machine breaks, other servers in the cluster absorb the workload |
| **Data Consistency** | Easy; all operations take place locally on one machine (Strong Consistency) | Complex; data must sync across multiple machines over a network (Eventual Consistency) |
| **Software Impact** | None; existing code immediately benefits from faster hardware without rewrites | High; requires application load balancers and code designed for distributed computing |

Core features of Hadoop:
* Fault Tolerance: Automatically replicates data blocks across multiple machines; if a machine crashes, processing seamlessly fails over to a healthy node without data loss.
* High Scalability: Can easily scale out to store and process petabytes of data by dynamically adding standard commodity servers to the cluster.


#### **Q27. Explain file-based data structures in Hadoop**
* SequenceFiles:
    * Persistent, binary storage formats for storing sequential streams of `(Key, Value)` binary object pairs.
    * Optimized for passing intermediate data streams between Mappers and Reducers.
    * Acts as a container format to pack thousands of small files into a single, large, manageable SequenceFile block.
* MapFiles:
    * A specialized extension of SequenceFiles that includes an added index file.
    * Allows users to look up data objects directly by their Key string, rather than scanning the entire file sequentially from the beginning.


#### **Q30. What is YARN?**
* Yet Another Resource Negotiator
* Architectural resource management and job scheduling subsystem
* Introduced in Apache Hadoop 2.x
* Decouples resource management from processing logic → transforms Hadoop from MapReduce-only system into a general-purpose distributed computing platform.
* Primary Components:
    * ResourceManager (Master): Manages resource allocations (CPU, RAM) across all applications in the entire multi-node cluster
    * NodeManager (Slave): Reports resource status + launches local compute containers
    * ApplicationMaster (one per job): Manages the lifecycle of an application
    * Container: Represents a unit of resource allocation for executing a task (contains a single task - can be Map, Reduce, or other)


#### **Q31. Differentiate between classic MapReduce and YARN**

| **Feature** | **Hadoop 1.x (Classic)** | **Hadoop 2.x (YARN)** |
| :--- | :--- | :--- |
| **Architectural Generation** | Monolithic tracker framework | Decoupled, modular resource allocator |
| **Component Roles** | Dual-tracker system (JobTracker & TaskTrackers) | Distributed design (ResourceManager, NodeManager, ApplicationMaster, Container) |
| **Global Coordinator** | JobTracker (handles both resources and task lifecycles) | ResourceManager (tracks raw hardware capacity globally) |
| **Job Monitoring** | Managed centrally by JobTracker | Managed individually by ApplicationMaster |
| **Worker Management** | TaskTrackers execute worker commands | NodeManager tracks individual worker nodes |
| **Scalability Bottleneck** | JobTracker bottlenecks at ~4,000 nodes | Scales past 10,000 nodes due to separated layers |
| **Single Point of Failure** | High risk (JobTracker failure crashes all scheduling) | Low risk (Decoupled resource tracking and job monitoring) |


#### **Q33. Discuss failures in classic MapReduce and YARN**
* Classic MapReduce Failures:
    * Task Failure: 
        * Runtime crash inside a Mapper/Reducer process
        * TaskTracker catches it, logs the exit code; reports to JobTracker 
        * JobTracker reschedules the task
    * TaskTracker Failure: 
        * Stops sending heartbeats to JobTracker
        * JobTracker unassigns all tasks on that node and reruns them elsewhere
    * JobTracker Failure: 
        * Single Point of Failure (SPOF)
        * If it crashes, the entire active cluster grinds to a halt

* YARN Failures:
    * Task/Container Failure: 
        * Local container process exits with error
        * NodeManager logs it and notifies ApplicationMaster
        * ApplicationMaster reschedules container tasks
    * ApplicationMaster Failure: 
        * If it fails, the global ResourceManager initializes a fresh ApplicationMaster instance using a saved state log
    * ResourceManager Failure: 
        * Saved checkpoints allow a standby ResourceManager node to assume full control via ZooKeeper leader election (High Availability)


#### **Q39. What is HBase?**
* Hadoop DB
* Open source, column-oriented NoSQL database
* Modeled after Google's BigTable
* Built on top of HDFS (for primary storage) + Apache ZooKeeper (for cluster coordination)
* OPtimized for low latency operations on large datasets
* Supports random read/write access
* Stores data in key-value pairs
* Schema-less
* Handles TB to PB scale of data

#### **Q40. Explain architecture and data model of HBase**
Logically HBase looks like a table/grid but physically it is a sparse, ditributed, persistent, multi-dimensional sorted map.
`[Row Key] ➔ [Column Family:Column Qualifier] ➔ [Timestamp] ➔ [Value]`

1. **Data Model**
* Core Structural components:
    * Table: A collection of rows divided into row ranges called "regions". regions are governed by a RegionServer.
    * Column Family: A group of related columns (that are stored together physically in HFiles).
    * Column Qualifier: A specific column within a column family. These do not need to be predefined and can be created on the fly (dynamic schema). 
    * Cell: Combination of a row key, column family, column qualifier, and timestamp.
    * Timestamp (Version): HBase stores multiple versions of the same cell data. Each version is marked with a timestamp. By default, it retrieves the latest version.

* Characteristics of the model:
    * Sparse: If a row does not have data for a specific column, HBase does not store a NULL value. It simply skips writing that key-value cell entirely, saving massive disk space.
    * Column-Oriented: Data belonging to the same column family is stored together on disk. This optimizes read performance when queries only look for specific attributes

2. **Architecture**
* Master-slave architecture consisting of 3 main components:
    * HMaster (Master Server):
        * Metadata operations (create/delete tables)
        * Assigns regions to RegionServers (when system starts or a server fails)
        * Monitors cluster health
        * balances load between RegionServers

    * RegionServer (Slave Server):
        * Handles read/write requests from clients
        * Hbase table is horizontally split into chunks called "regions". A single RegionServer hosts multiple regions

    * Zookeeper (Coordinator):
        * Centralized coordination service
        * Tracks location of root metadata table so clients know which Regionserver to talk to 
        * Ensures high availability of HMaster (If HMaster dies, ZooKeeper elects backup master)

#### **Q41. Define Cassandra data model with example**
* Features of Cassandra DB
    * Distributed column family NoSQL DB
    * Peer-to-peer replication (Ring Topology)
    * **Query-driven modelling** → Tables are designed based on your application's queries , not entity relationships
    * Sparse storage → (If a column value is empty, cassandra stores nothing. No space is wasted on NULL values)

* Components of Cassandra:
    * Keyspace: Outermost logical container (like RDBMS schema or database)
    * Column Family/Table: Contains rows and columns
    * Row: Collection of columns identified by Primary Key
    * Column: Smallest data unit. Contains: `name` + `value` + `timestamp`

*  Primary Key: Uniquely identifies a row. 
    * `Primary Key = Partition Key + Clustering Key`
        * Partition Key: Determines which physical node/server stores data chunk
        * Clustering Key: Physically sorts data within a partition 

Example (user device logs)
CQL Table:
```cql
CREATE TABLE device_logs (
    device_id uuid,
    log_time timestamp,
    status text,
    PRIMARY KEY (device_id, log_time)
);
```
Physical disk layout (wide-row format):
* Partition Key (device_id) ➔ Routes all logs for Device-A to Node 1
* Clustering Key (log_time) ➔ Sorts logs sequentially on Node 1's disk


#### **Q43. What is Pig Latin?**
* High-level, data-flow programming language used to build data analysis applications within Apache Pig.
* Designed for engineers and analysts who find writing native Java MapReduce code too tedious
* Users write seuential data-flow steps in Pig Latin
* Underlying Apache Pig compiler automatically parses, optimizes and compiles the script into Mapreduce jobs for execution on Hadoop cluster
* Pig Latin is a procedural-style language not declarative (unlike SQL, you explicitly define step-by-step data pipeline flow)
* Pig Latin scripts run on Grunt shell


#### **Q44. Explain Pig Data model and Pig Latin scripts**
* Features of Apache Pig:
    * High-lvl data flow platform
    * Developed by Yahoo
    * Lesser lines of code needed (compared to Java MapReduce)
    * SCripts are internally converted to MapReduce and executed on HDFS
    * Flexible, reusable scripts
    * Extensible through custom functions

* Data Types in Pig (Data Model):
    * Atom → single basic scalar value (eg: string or int)
    * Tuple → ordered set of fields (similar to row)
    * Bag → unordered collection of tuples (can contain duplicate tuples)
    * Relation → group of tuples that belongs to same "schema" (like table in RDBMS)
    * Map → collection of key-value pairs

* Pig Latin Script Structure:
    * `LOAD` → Loads data from HDFS into a Pig relation
    * `FILTER` → Filters rows based on a condition
    * `GROUP` → Groups matching records together based on a key
    * `FOREACH...GENERATE` → Transforms data attributes lane-by-lane
    * `STORE` → Stores results to HDFS
    * `DUMP` → Prints results to console
    

#### **Q45. What is HiveQL?**
* Hive Query Language
* Declarative query language for Apache Hive
* Modeled after SQL (to make it familiar to DB Admins)
* Turns relational query commands to distributed batch application workloads
* Apache Hive compiles HQL queries directly into MapReduce, Tez or Spark jobs for execution
* Optimized for complex analytical queries on massive datasets
* Runs on top of HDFS


#### **Q46. Explain architecture of Apache Hive**
* Components:
    1. **UI Layer**:
        * Allows users to submit HQL queries
        * Supports multiple client types: CLI, Hive Web Interface or JDBC/ODBC drivers

    2. **Driver Core**:
        * Central management brain
        * Receives HQL query from client
        * Sets up session contexts and tracks execution boundaries

    3. **Compiler**:
        * Converts declarative HQL query to logical execution plan (DAG - Directed Acyclic Graph)
        * Validates syntax and semantics

    4. **Execution Engine**:
        * Takes compiled tasks from driver
        * Communicates with Hadoop cluster framework (HDFS/YARN) to process data and extract resuts

    5. **Metastore**:
        * Stores metadata about Hive tables
        * Includes table definitions, column schemas, partition details, etc.
        * Typically stored in relational DB like MySQL

    
#### **Q47. State any two features of Hive**
1. HQL is similar to SQL: Enables business analysts and data engineers to run complex data warehouse queries on massive petabyte-scale datasets using familiar SQL-like syntax without writing low-lvl Java MapReduce.

2. Schema-on-Read via Metastore : Raw data is stored without validation, and its schema is only applied from a separate repository at the exact moment the data is queried.

#### **Q48. Explain HiveQL data definition and data manipulation commands**
1. Data Definition Language (DDL) Commands:
* Used to define/alter/remove internal database structures and schemas.
* `CREATE DATABASE / TABLE`: Allocates metadata spaces and defines columns/data types.
* `ALTER TABLE`: Modifies existing column structures/renames schemas/adds partition paths.
* `DROP TABLE`: Permanently removes table schemas and underlying data from the metastore.

2. Data Manipulation Language (DML) Commands:
* Used to load/transfer/populate/query rows inside managed structures.
* `LOAD DATA`: Moves or copies raw files directly into Hive’s data storage directories.
* `INSERT INTO / OVERWRITE`: Appends or overwrites rows into a target table structure.
* `SELECT`: Queries attributes from datasets using analytical expressions, WHERE criteria, and `GROUP BY` aggregations.