Projekt: Recruitment Showdown – Real-Time Multiplayer Battle

Projekt, nad którym pracowałem, to Recruitment Showdown – gra multiplayer w czasie rzeczywistym, napisana w Javie. Główne wyzwanie projektu polegało na implementacji komunikacji między serwerem a klientami oraz zapewnieniu płynnej rozgrywki dla wielu graczy, jednocześnie zarządzając synchronizacją stanów gry w czasie rzeczywistym.
Opis gry:

BattleZone to arena, gdzie gracze rywalizują ze sobą w dynamicznych starciach. Każdy gracz steruje swoją postacią, porusza się po mapie i walczy z innymi uczestnikami w czasie rzeczywistym, korzystając z różnych broni i umiejętności. Celem gry jest zdobycie jak największej liczby punktów eliminując przeciwników.
Kluczowe funkcjonalności:

    Rozgrywka w czasie rzeczywistym – implementacja synchronizacji ruchów graczy, wykrywanie kolizji oraz zapewnienie płynności interakcji między graczami, mimo opóźnień w sieci.
    Komunikacja klient-serwer – zbudowałem asynchroniczny system komunikacji przy użyciu sockets w Javie, aby zapewnić szybkie przesyłanie danych między klientami a serwerem.
    Serwer wielowątkowy – serwer obsługuje jednocześnie wielu graczy, zapewniając równoczesną obsługę ruchów, akcji i komunikacji, przy jednoczesnym zarządzaniu stanem gry w czasie rzeczywistym.
    Model klient-serwer – serwer zarządza logiką gry, przetwarza ruchy graczy i aktualizuje ich stany, a następnie przesyła dane do klientów, którzy wizualizują rozgrywkę.
    Użycie protokołu TCP/IP – zapewnienie niezawodności w przesyłaniu pakietów, aby każdy ruch i akcja była poprawnie synchronizowana między graczami.
    Lobby – gracze mogą dołączać do gier, tworzyć nowe pokoje i rywalizować z innymi uczestnikami.

Technologie:

    Javan – język programowania używany do budowy logiki gry i komunikacji.
    Sockets – do komunikacji między klientem a serwerem, co umożliwia przesyłanie danych o ruchach, akcjach graczy i wynikach.
    Maven – narzędzie do zarządzania zależnościami i budowania projektu.
    JUnit – testowanie jednostkowe krytycznych funkcji gry.
    Docker - Konteneryzacja servera: link
Wyzwania:

    Synchronizacja stanów gry: Wyzwanie związane z zapewnieniem płynnej rozgrywki, gdzie ruchy i akcje graczy są odbierane, przetwarzane i wyświetlane w czasie rzeczywistym, mimo opóźnień sieciowych.
    Optymalizacja wydajności: Zapewnienie, że serwer obsługuje wielu graczy bez przeciążeń.
    Bezpieczeństwo i ochrona przed oszustami: Zaimplementowanie podstawowej walidacji ruchów po stronie serwera, aby uniemożliwić oszukiwanie graczy poprzez manipulację danymi po stronie klienta.

Wnioski:

Praca nad tym projektem była świetnym wyzwaniem, które pozwoliło mi opanować nie tylko aspekty programistyczne związane z Javą, ale także zarządzanie komunikacją sieciową, synchronizacją w czasie rzeczywistym oraz wielowątkowością. Projekt ten doskonale oddaje złożoność zadań, z jakimi mierzą się juniorzy – od pisania czystego kodu, przez zrozumienie wydajności aplikacji sieciowych, aż po tworzenie rozwiązań, które muszą działać niezawodnie w środowisku wieloosobowym.

Jeśli projekt nie zrobi na Tobie wrażenia – z przyjemnością dołączę do Twojego zespołu, aby wspólnie zmierzyć się z jeszcze większymi wyzwaniami! :)