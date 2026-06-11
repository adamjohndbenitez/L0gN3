# Code Question 2

## Problem:
Amazon Web Services (AWS) has several data centers which have multiple processors that perform computations.
In one such data center, these processors are placed in a sequence with their IDs denoted by 1, 2, ..., n.
Each processor consumes a certain amount of power to boot up, denoted by bootingPower[i].
After booting, a processor consumes processingPower[i] power to run the processes.
For maximum utilization, the data center wishes to group these processors into clusters.
Clusters can only be formed of processors located adjacent to each other.

### For example:
processors 2, 3, 4, 5 can form a cluster   <- aj: these numbers are indexes not values, continuous/"contiguous" (ie. adjacent in space & time)
processors 1, 3, 4 cannot   <- aj: indexes [1, ?, 3, 4], this is why it's invalid.

Net power consumption
The net power consumption of a cluster of k processors:
(i, i+1, ..., i+k-1)
is defined as:
max(bootingPower in the cluster) + (sum(processingPower in the cluster)) * k

^ aj: 
$$max(bootingPower[i], bootingPower[i + 1],...,bootingPower[i+k-1])$$
$$+$$
$$(\sum_{j=i}^{j=i+k-1} processingPower[j]) * k$$

That is:
take the maximum booting power among the k processors
add the sum of processing powers
multiply that sum by k

A cluster is said to be sustainable if its net power consumption does not exceed:
powerMax

Given the bootingPower consumption and processingPower consumption of _n_ processors 
denoted by _bootingPower_ and _processingPower_ respectively, and the threshold value powerMax,
find the maximum possible number of processors which can be grouped together to form a _sustainable cluster_. 
If no such clusters can be formed, return 0.

Note: It is not mandatory for all clusters of size k to be sustainable. Even one sustainable cluster of that size is enough.

Example
bootingPower    = [3, 6, 1, 3, 4]
processingPower = [2, 1, 3, 4, 5]
powerMax        = 25

If k = 2, any adjacent pair can be chosen. The highest usage is the pair [4, 5] with net power consumption 4 + (4 + 5 * 2) = 22. 
Next, try k = 3. Group the first 3 processors together as:

```plain
                  cluster of 3 processors
                  -------------
Booting Power     | 3   6   1 |   3   4      <- max booting power = max(3, 6, 1) = 6
Processing Power  | 2   1   3 |   4   5      <- sum of processing power = 2 + 1 + 3 = 6
                  -------------
Maximum Power = 25

So net power is:
6 + 6 * 3 = 24
which is <= 25 So cluster size 3 works.
Thus, we can group k = 3 processors to form a sustainable cluster.
```

Note that the minimum power consumption to form a cluster of k = 4 processors is 46, 
by forming a cluster of the first 4 processors. 
Since this cost is greater than the threshold, we cannot form a cluster with 4 processors. 
The maximum possible cluster size is 3.




For k = 4, the minimum possible net power is larger than 25, so no size-4 cluster works. Answer: 3


## Function Description
Complete the function findMaximumSustainableClusterSize in the editor below.

### Parameters
int processingPower[n]: power consumption of each processor while running
int bootingPower[n]: power consumption of each processor during bootup
long_int powerMax: threshold power consumption
Returns
int: maximum sustainable cluster size, or 0 if none exists

## Constraints
- $1 <= n <= 10^5$
- $1 <= powerMax <= 10^14$
- $1 <= processingPower[i] <= 10^4$
- $1 <= bootingPower[i] <= 10^9$
- $length(processingPower) = length(bootingPower)$

### Input Format For Custom Testing
The first line contains integer, _n_, the number of elements in _processingPower_.
Each line _i_ of the _n_ subsequent lines _(where $0 \le i < n$)_ contains an integer,
_bootingPower[i]_. The next line contains a long_integer.

next n lines contain processingPower[i]
next line contains integer n, size of bootingPower
next n lines contain bootingPower[i]
last line contains long_integer powerMax
> ^ chatgpt

---

### Sample Case 0
```plain
Sample Input For Custom Testing
STDIN          FUNCTION
-----          --------
5      ->      processingPower[] size n = 5
4      ->      processingPower[4, 1, 4, 5, 3]
1
4
5
3
5      ->      bootingPower[] size n = 5
8      ->      bootingPower[8, 8, 10, 9, 12]
8
10
9
12
33      ->      powerMax = 33
```
__Sample Output:__
```plain
0
```

### Explanation
Here processingPower = [4, 1, 4, 5, 3],
bootingPower = [8, 8, 10, 9, 12] and
powerMax = 33.
We can form a cluster of size k = 2, consisting
of the first 2 processors. 
The net power consumption is net power consumption =
max (8, 8) + (4 + 1) * 2 = 18, which is less than the threshold. 
There are other clusters of size 2 which can be formed as well. 
However, the minimum net power consumption for a cluster of size 3 is 37 
(the first 3 processors, max (8, 8, 10) + (4 + 1 + 4) * 3 = 37). 
This is greater than the threshold (33), thus not sustainable. 
The maximum possible sustainable cluster size is 2.

This means:<br>
processingPower = [4, 1, 4, 5, 3]<br>
bootingPower    = [8, 8, 10, 9, 12]<br>
powerMax        = 33<br>
Output
2
> ^ chatgpt

Explanation:
A cluster of size 2 works.
Example, first two processors:
max boot = max(8, 8) = 8
sum processing = 4 + 1 = 5
Net power:
8 + 5 * 2 = 18
which is <= 33
For size 3, the minimum possible net power is 37, which exceeds 33.
So the maximum sustainable cluster size is:2
> ^ chatgpt

---

### Sample Case 1
```plain
Sample Input For Custom Testing
STDIN          FUNCTION
-----          --------
3       ->      processingPower[] size n = 3
10      ->      processingPower = [10, 8, 7]
8
7
3       ->      bootingPower[] size n = 3
11      ->      bootingPower = [11, 12, 19]
12
19
6       ->      powerMax = 6
```
__Sample Output:__
```plain
0
```

### Explanation
It is not possible to form any sustainable cluster for the given processors with net power consumption less than or equal to powerMax, thus the answer is 0.

This means:
processingPower = [10, 8, 7]
bootingPower    = [11, 12, 19]
powerMax        = 6
Output
0
Explanation
No sustainable cluster can be formed.
> ^ chatgpt