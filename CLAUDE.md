# Contexte du projet

Plateforme de validation technique.
Objectif : permettre à mon ESN de faciliter des entretien tech en ayant :
- une vue RH qui permet de planifier une validation tech avec un validateur
- et une vue validateur qui permet de visualiser ses entretiens avec des candidats à valider etc...

# Architecture du projet, ne pas tout lire à chaque nouvelle session claude
L'architecture est dans ARCHITECTURE.md du dossier Documentation. C'est ici que tu connaitras l'arborescence du projet et le contexte global technique.
Cela t'évite de tout relire à chaque nouvelle session

# Développement

En tant qu'expert Clean Architecture, TDD, et DDD, nous allons développer avec soin chaque fonctionnalité.

TDD : ATTENTION, je ne veux AUCUN code de production sans test.
Comment cela va se passer ? On fait UN test red, je valide, puis on implémente, puis on enchaine etc... Je ne veux pas que tu implémentes quelque chose avant que j'ai validé le test rouge !

UN SEUL TEST À LA FOIS : même quand plusieurs cas semblent évidents, on n'écrit qu'un seul test rouge, on attend le vert + validation, puis on passe au suivant. Ne jamais écrire plusieurs tests d'un coup.

PAS DE SOLUTION OVERKILL : implémenter toujours le minimum pour faire passer le test en cours. Fake it till you make it — si retourner [] suffit pour passer le premier test, c'est ce qu'on fait. C'est le test suivant qui force la vraie logique. Se laisser porter par les tests, ne pas anticiper.

Test by wishful thinking : Lors des tests, ne te lie pas à l'implémentation, imagine l'idéale de l'utilisation de ton objet.

Sociable test : ATTENTION, je veux limiter les tests sur les objets du domaine, je privilégie les tests sur les use case. Pourquoi ? car le domaine évolue beaucoup, et les refactos sont un enfer si une classe = un test. Donc on test une chaine par un use case.

MUTATION TESTING : le backend est sous PIT (profil Maven `mutation`), seuils bloquants `mutationThreshold=78` et `testStrengthThreshold=89`, sur `*.domain.*` et `*.application.*`. C'est le juge de paix du TDD ici : du code de production qu'aucun test ne tue fait baisser le score et casse le build. Donc pas de branche, pas de condition, pas de garde défensive qui n'ait été amenée par un test rouge — c'est exactement le « pas de solution overkill » ci-dessus, mais vérifié mécaniquement. Détails et commandes dans `Documentation/ARCHITECTURE.md` (section « Mutation testing »).

Clean Architecture : Use case, screaming architecture, séparation des responsabilité, ségrégation des interfaces. Architecture Hexagonale.

## DDD

### Informations générales
Domaine riche avec le bon Ubiquitous Language. Les agrégats et entités doivent avoir tout le comportement métier. Si le comportement ne peut pas loger dans un seul agrégat mais doit se faire sur plusieurs, alors domain service. Proposer des bounded contexts quand c'est pertinent.

### Domain Events
Un Domain Event capture quelque chose qui s'est passé dans le domaine et dont les experts métier accordent de l'importance. C'est un objet à part entière du domaine (package domain/), nommé au passé (`ReportSubmitted`, `InterviewScheduled`) car il représente un fait accompli après une opération en succès. L'interface `DomainEventPublisher` est aussi dans le domaine (c'est le domaine qui déclare le contrat de publication), l'implémentation est en infrastructure.

Un use case ne modifie qu'un seul agrégat. Si d'autres agrégats doivent réagir, le use case émet un Domain Event et des handlers (subscribers) traitent le reste. Coupler plusieurs agrégats dans un même use case crée du verrouillage et du couplage fort.

L'event transporte juste assez d'informations pour que les subscribers puissent réagir, ni plus.

Exemple appris : `ReportSubmitted` → `DeleteCvOnReportSubmittedHandler` (au lieu de coupler la suppression du CV dans `AddReportUseCase`).

Méthode de test en diamant : le coeur des tests sont sociables, les tests unitaires sur un seul composant sont très limité voir il n'y en a pas.

## TDD - Explication de la facon de faire

Dans 5 minutes tu te diras : « C’est donc ça TDD ?! Wow »

Le kata Prime Factors d'Uncle Bob est un bon exemple pour palper la bête :

Décomposer un entier en facteurs premiers.
À chaque test, le code bouge juste ce qu'il faut ; et l'algo émerge sous tes doigts.

🔴 Red → 🟢 Green → 🔵 Refactor

1️⃣ 1 → []
Le test le plus bête du monde. On retourne un tableau vide.

return [];

2️⃣ 2 → [2]
Rouge. On fake : un if, et on ajoute 2 en dur.

if (n > 1) factors.push(2);

3️⃣ 3 → [3]
Rouge (on aurait [2]). On généralise le littéral : 2 devient n. Toujours aucune division.

if (n > 1) factors.push(n);

4️⃣ 4 → [2,2]
La division apparaît — mais en if, pas en boucle. On divise une fois par 2, et un if de queue récupère le reste. Transformation minimale.

if (n % 2 === 0) { factors.push(2); n /= 2; }
if (n > 1) factors.push(n);

5️⃣ 6 → [2,3]
On écrit le test… déjà vert. Le premier if sort le 2, le if de queue sort le 3. Aucune ligne à changer.
Donc on VIRE ce test ! Inutile.

6️⃣ 8 → [2,2,2]
Rouge : on obtient [2,4]. Un seul if ne suffit plus pour absorber les 2 répétés. Le if devient un while. La boucle émerge ICI.

while (n % 2 === 0) { factors.push(2); n /= 2; }
if (n > 1) factors.push(n);

7️⃣ 9 → [3,3]
Rouge : on obtient [9]. Le 2 codé en dur devient un candidat qui s'incrémente. Le for absorbe le if de queue, qui disparaît.

for (let candidate = 2; n > 1; candidate++)
while (n % candidate === 0) { factors.push(candidate); n /= candidate; }

Le résultat final :

function primeFactors(n: number): number[] {
const factors: number[] = [];
for (let candidate = 2; n > 1; candidate++)
while (n % candidate === 0) {
factors.push(candidate);
n /= candidate;
}
return factors;
}

qui peut même devenir :

function primeFactors(n: number): number[] {
const factors: number[] = [];
for (let candidate = 2; n > 1; candidate++)
for (; n % candidate === 0; ) {
factors.push(candidate);
n /= candidate;
}
return factors;
}


Cinq lignes.
Un algorithme complet de division successive.

Ce qui est fascinant : à aucun moment tu ne l'as conçu, tu t’es fait « drivé » par les tests, d’où le terme « Test-Driven ».

Le if est devenu while, une boucle externe s'est invitée, et l'algo était juste… là. Émergé, pas décidé.

C'est ça, le TDD comme outil de conception. Pas de la vérification. Du design.

 