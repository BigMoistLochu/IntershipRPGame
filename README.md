# Recruitment Showdown – Real-Time Multiplayer Battle

## Spis treści
1. [Opis gry](#opis-gry)
2. [Technologie](#technologie)
3. [Wyzwania](#wyzwania)
4. [Wnioski](#wnioski)
5. [Uruchomienie projektu](#uruchomienie-projektu)

---

## Opis gry
Projekt, nad którym pracowałem, to Recruitment Showdown – gra multiplayer w czasie rzeczywistym, napisana w Javie.
Główne wyzwanie projektu polegało na implementacji komunikacji między serwerem a klientami oraz zapewnieniu płynnej rozgrywki dla wielu graczy, jednocześnie zarządzając synchronizacją stanów gry w czasie rzeczywistym.

## Technologie:
- **Java** – język programowania używany do budowy logiki gry i komunikacji.
- **Sockets** – do komunikacji między klientem a serwerem, co umożliwia przesyłanie danych o ruchach, akcjach graczy i wynikach.
- **Maven** – narzędzie do zarządzania zależnościami i budowania projektu.
- **Docker** – konteneryzacja serwera: link

## Wyzwania:
- Synchronizacja stanów gry
- Optymalizacja wydajności

## Wnioski:
Praca nad tym projektem była świetnym wyzwaniem, które pozwoliło mi opanować nie tylko aspekty programistyczne
związane z Javą, ale także zarządzanie komunikacją sieciową, synchronizacją w czasie rzeczywistym oraz wielowątkowością.


## Uruchomienie projektu 
### 0. Uruchom Server (Opcjonalnie)
Wejdz pod podanego linka i podarzaj za instrukcja:
```
https://github.com/BigMoistLochu/IntershipRPGServer
```
Aby uruchomic gre potrzebujesz jave 17+!

### 1. Sklonowanie repozytorium

Najpierw sklonuj projekt na swój lokalny komputer:

```bash
git clone https://github.com/BigMoistLochu/IntershipRPGame.git
```

### 2. Zbudowanie Projektu
Zbuduj projekt za pomoca maven uzywajac tej komendy:

```bash
mvn clean package 
```

### 3. Odpal Projekt
Wejdz do folderu target i odpal projekt uzywajac tej komendy:

```bash
java -jar IntershipRPGamer-1.0-SNAPSHOT.jar
```

