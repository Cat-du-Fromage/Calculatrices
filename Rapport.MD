# Rapport
>Auteur Changanaqui Yoann & Duruz Florian

## Points clés de l'implémentations
les opérations sont des classes distinctes héritant tout de la classe abstraite `Operation`, 
Les `Operator` lié aux opérations mathématiques ont été regroupéees dans une classe abstraite héritant de `Operator`
cette dernière implémente une version constante de la méthode `execute()` la séquence étant identique, cette structure permet de définir et redéfinir uniquement le nécessaire;
 les classes dérivées doivent implémenter:
* `calculate()`: l'opération mathématique
* `hasError()`: Redéfinition quand d'autre erreur doivent être pris en compte(division par 0 et valeur hors domaine de définition.

Il en va de même pour les action lié à l'ajout de valeurs (numérique, point, etc...), ces dernière ont été regroupées dans
la classe `DigitOperator` permettant de regrouper les variables et méthodes communes comprenant:
* `checkBeforeCommit()`: Guard clause qui définit si on rentre ou non dans la fonction
* `commitDigit()`: Action permettant d'ajouter un caractère la redéfinition permet de faire des actions avant ou après.

Concernant la structure de `State`, en accord avec une discussion avec l'assistant du cours, il à été décidé que les éléments de `State`
ne doivent en aucuns cas être manipulé directement, les éléments sont manipulé via des fonctions précises 
permettant d'intéragir avec les attributs permettant un meilleur contrôle des intéractions et permettant aussi les exceptions
lié au conversion de valeurs en retournant des valeurs par défaut.

Concernant le comportement vis-a-vis de la stack:
si cette dernière est vide, on prend la valeur 0 par défaut.

Quelque cas particuliers:

Afin de rendre les valeurs intermédiaire immuable:
* Backspace ne fait rien si la valeur affiché est intermédiaire
* Le changement de signe est bloqué si la valeur affichée est intermédiaire

la Touche `Clear` efface aussi la valeur en mémoire (selon consigne de l'assistant)


## Tests effectués

Pour les tests nous nous sommes concentrés sur les cas ne pouvant pas être factorisé car lié à une opération particulières

pour les inputs type `digits`:

* vérifier qu'on ne peut pas mettre une suite de zéro avant un chiffre si ce dernier est avant la décimal (exemple: 03).
* Mettre plus d'un point (`PointOperator`) provoque une erreur "SYNTAX_ERROR" quand on tente de la mettre en stack via l'opérateur d'entrée (`EnterOperator`). 

Pour les opérations mathématiques :

* Vérifier que les opérations liés aux divisions (division + réciproque) affiche une erreur "DIVID_BY_ZERO" si le dénominateur est égal à 0;
* Vérifier que l'opération SquareRoot lance une erreur "DOMAIN_ERROR" quand l'input est hors du domaine de définition de cette opération.
