# [How to think through Question 2]

## ==>> STEP 1: Compress the problem into one sentence <<==

Whenever a problem feels too wordy, rewrite it into one short sentence:

Find the largest window size k such that at least one contiguous window satisfies
maxBoot + sumProcessing * k <= powerMax

That single sentence is the real problem.

## ==>> STEP 2: Identify what the formula needs

For each cluster/window, you need:

the maximum of bootingPower in that window
the sum of processingPower in that window
multiply that sum by window size k

So the problem is about windows.

That means your brain should immediately start thinking:

sliding window

But there is a twist:

sliding window sum is easy
sliding window max is harder

That is why this question is not simple.

## ==>> STEP 3: Ask whether brute force will work

Could you try every subarray?

No. Too slow.

With n = 10^5, checking all subarrays would be enormous.

So your brain must reject:

O(n^2)

very early.

That forces you to look for:

sliding window
deque
binary search on answer
## ==>> STEP 4: Ask whether the answer is monotonic

Suppose a cluster size k = 3 works.

Could a smaller size like k = 2 also work?

Usually yes, because smaller groups are easier to fit under the power limit.

That means feasibility behaves like this:

small sizes may work
larger sizes eventually stop working

This is a huge clue.

Whenever the answer has that pattern, think:

binary search on the answer

So instead of testing size 1, 2, 3, 4, ... one by one, you can binary search the best size.

## ==>> STEP 5: Split the problem into 2 layers
Outer layer

Guess a window size k

Inner layer

Check whether any window of size k is valid

This structure is powerful.

## ==>> STEP 6: Learn how to check one fixed size k

Suppose someone tells you:

Check whether any cluster of size 3 works.

Now the problem becomes easier.

You slide a window of size 3 across the arrays.

For each window, you need:

sum of processingPower
max of bootingPower

If any window satisfies the formula, return true.

If none do, return false.

## ==>> STEP 7: How to maintain the sum

Sum is easy.

As the window moves:

add the new right value
subtract the old left value

This is standard sliding window.

## ==>> STEP 8: How to maintain the maximum

This is the part that scares most people at first.

You need a monotonic deque.

Do not let the name scare you. Think of it as:

a special queue that always keeps the biggest useful values at the front

You store indices, not values.

Rule when adding a new index i

While the deque’s last value is smaller than or equal to the new bootingPower[i]:

remove it

Why?

Because the new value is better and will last longer in future windows.

Then add i.

Rule when moving the window

If the front index is no longer inside the current window:

remove it

Then the front of the deque always points to the max value in the window.

That is the whole trick.

## ==>> STEP 9: What the check function does

For a chosen size k:

move from left to right
maintain running sum
maintain deque for maximum booting power
once the window reaches size k
compute total power
if total power <= powerMax, return true

If no window works, return false

## ==>> STEP 10: Put the two layers together

You binary search k.

For each guessed k, you call the check function.

If check passes:

try larger k

If check fails:

try smaller k

That gives the final answer.