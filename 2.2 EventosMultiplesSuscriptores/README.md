Ejemplo que aplica el sistema de eventos a la detección de un número primo, multiples suscriptores se pueden suscribir al evento.

```mermaid
classDiagram
    class EventListener {
        <<interface>>
        +onEvent(event: String): void 
    }

    class EventSubscriber {
        -name: String
        +EventSubscriber(name: String)
    }

    class EventPublisher {
        -listeners: List<EventListener>
        +registerListener(listener: EventListener): void
        +notifyListeners(event: String): void
    }

    EventSubscriber ..|> EventListener
```