# Experiment 1 - Runtime Performance of List Implementations

## Synopsis
This test compares the runtime performance of different list implementations for various common usage patterns.

## Implementations
* ArrayList (as a benchmark)
* GapList
* BigList 

## Operations Performed During Test
* _Add at End_: All lists will be filled by adding n random integers at the end
* _Serial Iteration_: All lists are traversed front to back using their iterator implementation
* _Random Access_: the elements for n random indexes is requested
* _Add at Index_: n elements are added one-by-one at a random index
* _Remove at Index_: Every second element of the inflated list (as a result of add at index) is removed from back to front

## Results
* For lists of 1000 elements, ArrayList outperformed all other lists
* For > 100.000 elements the ArrayList did perform poorly in the _Add at Index_ and _Remove at Index_ tests
* No considerable performance improvement for the BigList over the GapList could be observed

See [Spreadsheet](results.ods) for exemplary measurements. 

## Shortcomings of the Tests
* All lists are initialized with a size of 0
* The tests do not consider performance in terms of required memory footprint (which would be relevant for BigList)

## References
* <http://www.magicwerk.org/page-collections-overview.html> - GapList, BigList

