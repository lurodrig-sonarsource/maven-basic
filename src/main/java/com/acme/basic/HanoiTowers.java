package com.acme.basic;

/**
 * The recursive algorithm in the `HanoiTowers` class solves the Tower of Hanoi problem by breaking it into smaller subproblems. Here's how it works:
 *
 * 1. **Base Case**:
 *    If there is only one disk (`n == 1`), it is directly moved from the `source` rod to the `target` rod. This is the simplest case and stops further recursion.
 *
 * 2. **Recursive Steps**:
 *    For more than one disk (`n > 1`):
 *    - **Step 1**: Move the top `n-1` disks from the `source` rod to the `auxiliary` rod, using the `target` rod as a temporary placeholder.
 *    - **Step 2**: Move the largest disk (the `nth` disk) directly from the `source` rod to the `target` rod.
 *    - **Step 3**: Move the `n-1` disks from the `auxiliary` rod to the `target` rod, using the `source` rod as a temporary placeholder.
 *
 * 3. **Recursive Calls**:
 *    The method calls itself twice for the `n-1` disks in steps 1 and 3, reducing the problem size with each call until it reaches the base case.
 *
 * This approach ensures that all disks are moved to the `target` rod while maintaining the rules of the Tower of Hanoi (only one disk moved at a time, and no larger disk placed on a smaller one).
 */

import org.springframework.stereotype.Service;

@Service
public class HanoiTowers {

    public void solve(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        solve(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        solve(n - 1, auxiliary, source, target);
    }
}