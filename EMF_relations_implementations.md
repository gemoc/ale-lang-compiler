| Nbr | Multiplicity | Opposite Multiplicity | Containment | EList Implementation | EList Implementation Opposite |
| ------------ | --------------------- | ----------- | -------------------- | ------------ | ------------ |
| 0           | 1            | 1                     | false       | simple getter/setter + basic getter/setter | simple getter/setter + basic getter/setter |
| 1           | *            | 1                     | false       | EObjectWithInverseResolvingEList | simple getter/setter + basic getter/setter |
| 2           | 1            | *                     | false       | simple getter/setter + basic getter/setter | EObjectWithInverseResolvingEList |
| 3           | *            | *                     | false       | EObjectWithInverseResolvingEList.ManyInverse | EObjectWithInverseResolvingEList.ManyInverse |
| 4           | 1            | 1                     | true       | simple getter/setter + basic getter/setter + containment specific checks | simple getter/setter + basic getter/setter + containment specific checks |
| 5           | *            | 1                     | true       | EObjectContainmentWithInverseEList | simple getter/setter + basic getter/setter + containment specific checks |
| 6           | 1            | *                     | true       | static error, can't be contained several time | static error, can't be contained several time |
| 7           | *            | *                     | true       | static error, can't be contained several time | static error, can't be contained several time |
| 8 | 1 | none | false |  | none |
| 9 | * | none | false |  | none |
| 10 | 1 | none | true |  | none |
| 11 | * | none | true |  | none |

# TODO

- test with truffle
- merge interpreter and visitor generations
- test multiple inheritance
- ALE Sequences

## Structural evolutions

### Alternative 1

introduction of new classes/fields directly in the ALE

**Cons:** requires to redefine once again the expressiveness of ecore in ALE; making ecore useless 

**Pros:** Agile development, does not require the definition of concept in new files, can be 

### Alternative 2

