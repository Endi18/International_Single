# International Single

## Assignment Summary
AlgoJukebox is a new record company that aims to offer music content by utilizing the power of algorithms. It wants to offer a duet of artists from different countries. The management people need to know the number of all possible artist combinations. It is required to compute this number, given the nationality information. There is a problem however, there is no clean database of artist information, only a list of pairs of artists which have the same nationality.

## Definition
The nationality information will be given in an input text file. The first line consists of two space-separated numbers, n and p, respectively the number of all artists and the number of lines that will follow this first line subject to conditions

* 1 ≤ n ≤ 10<sup>5</sup>
* 1 ≤ p ≤ 10<sup>4</sup>

Each artist is represented by its ID which is a unique value in the interval [0..n − 1]. Each of the following p lines have the form "a b", where a and b are two artist IDs that have the same nationality and of course a ≠ b. For the purpose of this problem it is assumed that each artist has only one nationality.

## Example Input

### Input 01
Consider the input below:<br />
5 4<br />
0 2<br />
2 4<br />
0 4<br />
1 3<br />

The first lines states that there are five artists, with id 0, 1, 2, 3 and 4. Additionally we are also given 4 lines about the nationalities of these artists. From this it follows that artists (0; 2; 4) have the same nationality, say x, and artists (1; 3) have the same nationality, say y, and also x ≠ y. All possible artist combinations are then (0; 1), (2; 1), (4; 1), (0; 3), (2; 3) and (4; 3) so the algorithm should output 6 for this input.

### Input 02
Consider the input below:<br /> 
4 1<br />
3 0<br />

The first lines states that there are four artists, namely 0, 1, 2 and 3. The single fact line states that artists 0 and 3 share the same nationality, but artists 1 and 2 do not share nationality with any other 
artists. There are therefore 5 possible combinations, namely (0, 1), (0, 2), (1, 2), (1, 3) and (2, 3). The algorithm must therefore output 5 for this input.
