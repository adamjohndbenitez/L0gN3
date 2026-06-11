# [How to think through Question 1]

## ==>> STEP 1: Understand what a merge really does <<==
You can only merge:
left < right
And when you merge, the left gets absorbed into the right.
So the right side becomes bigger.
That means this problem naturally wants you to think:
“Can I keep growing a package by absorbing smaller packages from its left?”
That is the key mental shift.

## ==>> STEP 2: Notice the direction <<==
Since the right package survives and gets heavier, it is easier to think from:
right to left
Because a package on the right can absorb a smaller package on its left.

## ==>> STEP 3: Build intuition with the example <<==
For:
[2, 9, 10, 3, 7]
Start from the end.
current = 7
look left: 3 < 7, so merge → current = 10
look left: 10 < 10? no, equal is not allowed → reset current = 10
look left: 9 < 10, merge → current = 19
look left: 2 < 19, merge → current = 21
Best = 21
So the rule becomes:
keep a running package weight current
go from right to left
if left value is smaller than current, absorb it
otherwise, start a new package

## ==>> STEP 4: Why this works <<==
Any final merged package must come from a contiguous block.
And because the right package survives each merge, the condition must be checked from right to left.
So this greedy scan is not random. It matches exactly how the operation behaves.

## ==>> STEP 5: Write the algorithm in plain English <<==
set current to the last package
set best to current
scan from second-last down to first
if packageWeights[i] < current
merge it into current
else
current becomes this package alone
update best

## ==>> STEP 6: Watch the big trap <<==
Use long, not int.
Because:
2 * 10^5 * 10^9
is too large for int.

## ==>> STEP 7: Final code <<==
```java
public static long getHeaviestPackage(List<Integer> packageWeights) {
    int n = packageWeights.size();

    long current = packageWeights.get(n - 1);
    long best = current;

    for (int i = n - 2; i >= 0; i--) {
        if (packageWeights.get(i) < current) {
            current += packageWeights.get(i);
        } else {
            current = packageWeights.get(i);
        }
        best = Math.max(best, current);
    }

    return best;
}
```