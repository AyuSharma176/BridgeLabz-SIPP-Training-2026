# Binary Search Assignment

A complete Java implementation of five Binary Search problems.

---

## Files

| File | Topic |
|------|-------|
| `Q1_StarBrightnessSearch.java` | Astronomer catalog – standard search, rotated search, first/last occurrence, minimum |
| `Q2_FindRotationPoint.java` | Find the rotation point (minimum index) in a rotated sorted array |
| `Q3_FindPeakElement.java` | Find a peak element using Binary Search |
| `Q4_Search2DMatrix.java` | Search a target in a 2-D globally sorted matrix |
| `Q5_FirstLastOccurrence.java` | First and last occurrence of an element in a sorted array |

---

## How to Compile & Run

### Compile all files
```bash
javac *.java
```

### Run individual questions
```bash
java Q1_StarBrightnessSearch
java Q2_FindRotationPoint
java Q3_FindPeakElement
java Q4_Search2DMatrix
java Q5_FirstLastOccurrence
```

---

## Algorithm Summary

### Q1 – Star Brightness Search
| Sub-task | Method | Time |
|----------|--------|------|
| Standard search | `binarySearch()` | O(log n) |
| Rotated catalog | `searchRotated()` | O(log n) |
| First occurrence | `firstOccurrence()` | O(log n) |
| Last occurrence | `lastOccurrence()` | O(log n) |
| Minimum element | `findMinimum()` | O(log n) |

### Q2 – Rotation Point
- Compare `arr[mid]` with `arr[right]` to decide which half contains the minimum.
- **Time:** O(log n) | **Space:** O(1)

### Q3 – Peak Element
- If `arr[mid]` is greater than both neighbors → peak found.
- Otherwise move toward the larger neighbor (a peak always exists in that direction).
- **Time:** O(log n) | **Space:** O(1)

### Q4 – 2-D Matrix Search
- Treat the matrix as a flattened 1-D array.
- Convert flat index → `(row, col)` using division and modulo.
- **Time:** O(log(rows × cols)) | **Space:** O(1)

### Q5 – First & Last Occurrence
- Two separate binary searches: one biased LEFT (first), one biased RIGHT (last).
- **Time:** O(log n) | **Space:** O(1)
