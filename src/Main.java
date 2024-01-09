//src
//|-- com
//|   `-- yourcompany
//|       `-- app
//|           |-- admin

//|           |   |-- authentication
//|           |   |   |-- AuthenticationManager.java
//|           |   |   |-- User,java
//|           |   |
//|           |   |-- gui
//|           |   |   |-- JavaFXAdminController.java
//|           |   |   |-- NotificationPanel.java
//|           |   |   |-- EventCalendar.java
//|           |   |
//|           |   |-- event
//|           |   |   |-- Event,java
//|           |   |   |-- EventType.java
//|           |   |   |-- EventStatus.java
//|           |   |   |-- EventManager.java
//|           |   |   |-- EventEditor.java
//|           |   |   |-- EventEditorFactory.java
//|           |   |   `-- BasicEventEditor.java
//|           |   |
//|           |   |-- feedback
//|           |   |   |-- Rating.java
//|           |   |   |-- Comment.java
//|           |   |   |-- FeedbackManager.java
//|           |   |
//|           |   |-- security
//|           |   |   |-- EncryptionUtils.java
//|           |   |   |-- SecurityConfig.java
//|           |   |
//|           |   |-- concurrency
//|           |   |   |-- ConcurrentTaskManager.java
//|           |   |
//|           |   |-- migration
//|           |       |-- DatabaseMigrationManager.java
//|           |
//|           |-- user
//|               |-- UserController.java
//|               |-- UserEventManager.java
//|               |-- UserProfile.java
//|               |
//|               |-- gui
//|                   |-- JavaFXUserInterface.java
//|                   |-- UserNotificationPanel.java
//|                   |-- UserEventCalendar.java
//|                   |-- UserEventRegistrationPanel.java
//|                   |-- UserEventCancellationPanel.java
//|                   |-- UserFeedbackPanel.java
//|                   |-- UserProfilePanel.java
//|
//|-- resources
//    |-- documentation
//        |-- user_guide.pdf

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}