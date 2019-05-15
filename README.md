# Ramayana

Ramayana Is a Command Line Game Based on ancient India epic.For More Details about Ramayana Please Check
https://en.wikipedia.org/wiki/Ramayana.

## How To Build
mvn clean install

## How To Run
java -jar target/ramayana-1.0-SNAPSHOT.jar

## Requirements
* JDK 8
* Maven

## External Jars
* Junit 5 :junit-jupiter-api , junit-jupiter-params and junit-jupiter-engine
* lombok (For better code readability)

## Design Summary
The Implementation is mix baggage of MVC and Functional Interfaces as commands.   

## Thought Process and Key Design Progress Steps 
* I Started With Simple Procedural and Interface based approach focusing on expressing behaviour using domain objects.
  As i started making progress, Realized the stuff which i was doing after accepting user input can be converted in to kind of commands. So introduce commands as SAM.  
* After Implementing exploration part of game, Display portion of a code started scattering at multiple places. At this point i introduce MVC.
This portion of code is inspire by this post  https://dzone.com/articles/poor-mans-console-mvc
* During the end of my Implementation, Main class was calling functions one by one. To rectify this issue and have better understanding of flow of 
 program added Steps in my Implementation.

## Trade off                    
* I have given preference to readability and maintainability over Performance.Focus was on showcasing my design skills and thought process rather then
implementing complex gaming logic.

## Meaning of terms in the context of implementation
   * Characters - Different characters  of game , against  which player will be playing. 
   * Battle - Fight between Player and character 
   * Steps - Different Phases of Game and not the Levels of Game  
   * CreateGameMenu, MainMenu : Options/Operation that Created new Game
   * UpdateMenu, SubMenu : Options/Operation that updates or Change the Steps of Game
   
## Extensibility   
  * In order to add new features probably we might need to add new Step/Command/View/Controller by implemetaing Some interface and without needing 
  any changes in existing classes.
  * Code is supported with Unit Test cases. Used Junit 5 parameterized test whenever possible.

## Time 
I have Spend approximately 12 to 13 Hrs For this     
    
    
          
        
