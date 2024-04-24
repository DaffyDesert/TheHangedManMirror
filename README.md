# The Hanged Man

Introducing The Hanged Man, a modern twist on the classic word-guessing challenge! This application is a Hangman-style game inspired by the Hanged Man from the Major Arcana of the Tarot Deck and is available for anyone to play and enjoy. During the game, a user can guess a randomly selected word one letter at a time for the chance to win the game upon guessing all letters in the word correctly. Each incorrect guess inches the hangman closer to death, adding a suspenseful layer to every decision you make. This application goes beyond the traditional, offering many features to enhance your gaming experience. Choose from a range of difficulty levels, from novice to expert, to suit your skill level. Immerse yourself in various themes that bring a fresh aesthetic to the classic gameplay, and let the sound effects heighten the tension as you race against the hangman's creation.

## How to Download and Install the Application:

To execute the program you first need to download the game's source code. You can do this by either clicking the green "Code" button on GitHub and selecting "Download ZIP" or by using git clone in your terminal. The source code must then be unzipped if downloaded and can be saved in whichever directory you like.

## Executing the program

The Driver.java file will start the program. Start by pressing the play button in your preferred IDE, with the preferred IDE for this environment being Eclipse. Eclipse is an open-source IDE, that can be downloaded and installed [here](https://www.eclipse.org/downloads/packages/installer). Follow the provided instructions and select the Eclipse IDE for Java Developers download option. If initializing within an IDE, please ensure the project is set up correctly within your preferred development environment. To run the program successfully, you must add the `flatlaf-3.4.jar` JAR file to your project's build path to configure the game's various themes that are offered during gameplay. The required JAR file is located within the lib folder of the repository and must be added as an external jar to the classpath subsection of your IDE's build path configurations. For more information on classpath initialization for Eclipse IDE and Command Line execution, please reference [this](https://www.geeksforgeeks.org/how-to-add-jar-file-to-classpath-in-java/) article.

## How to Interact

1. When launching the application, the user is greeted with a Main Menu screen, where the user can choose to begin a game, view game instructions, customize their game experience, and quit the game. When choosing the option to "Play the Hanged Man", the user will be met with the option to play the game on the available Easy, Medium, Hard, Extreme, and Arcade Modes. The user can also view specific instructions for gameplay and can customize gameplay themes and options at any time in the Main Menu.

2. When beginning a new game, several options will be listed for use by the user.
   
    - The Hangman Figure located on the left-hand side of the window updates as the number of incorrect guesses made by the user increases, denoting the current status of gameplay for the user.
    - The series of dashes located on the top of the right-hand side of the screen denotes the number of letters guessed within the target word and the location of all guessed letters. The user can use this to understand the condition of their current guess state.
    - Located below the status of the target word is the list of all incorrect letters guessed by the user for this current gameplay session, followed by the same for all incorrect words guessed by the user.
    - Located on the bottom right-hand side of the window is a textbox for the user to input a letter or word, and submit a guess for either by using the two buttons below the text area. The guessing mechanic of the game will prevent the user from making the same guess twice and will notify them if this is attempted.
    - While playing the game, the user also has the option to use hints during their gameplay process. When using a hint, one letter will be revealed in the target word at a time. However, the user's score will be reduced correspondingly for each hint the user uses.
    - Finally, the user will also hear sounds corresponding to page navigation, button usage, and correct & incorrect answers during their gameplay experience. The user will hear a G Sharp Major Chord upon guessing a correct answer, and a G Sharp Minor Chord upon guessing an incorrect answer.
  
3. The user will interact with the text area and guess submission buttons as the main form of gameplay. These items within the game window act as the main form of control for the user to play the game.
      
4. When the game is over, and the user has either won or lost the game, then they will be directed to a Game Over screen, in which they will be shown their game-ending condition and total points scored. From there, the user can then quit the game, return to the home menu, or play again via the two provided buttons on the screen.

## The Team
- **Scrum Master:** Emily Miller
- **Dev Team:** Alex DeAngelis, Wil Santos, and Maicol Parr
- **UI Artist:** Þórunn Cameron
