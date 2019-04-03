# TODO ALE Compiler

- fix EMF generation
- EMap
- the Nothing type-system bug
- multiple-inheritance
- modular definition (important bug huge)
- truffle for all implementation targets
- mutability analysis

## Urgent

Problème cast en retour d'appel de service (parce que type system ne résoud pas bien les service, problème d'ordre d'initialisation ??)

Problème d'ordre dans la déclaration des champs de numéro des concepts dans le package interface, cf logo.lang

Problème cast, cf BackOperationImpl dans logo visitor

tester champs key et value de EMap aussi exhaustivement que testrelations

tester les autres options configurables des EStructuralFeatures (unique...)

**IMPORTANT:** problème dégalité dans les eMethods des EClass, dans le doute, générer la méthode la plus safe, même si non conforme EMF.

