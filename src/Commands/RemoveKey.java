package Commands;

import Database.Database;
import Interaction.Message;
import Movie.Movie;

import java.util.Hashtable;

public class RemoveKey extends CommandObject {
    private final String argument;


    public RemoveKey(String[] commandArgs) {
        this.argument = commandArgs[0];
    }

    @Override
    public Message execute(Hashtable<String, Movie> collection) throws Exception {
        if (!isAuthorized()) return getUnauthorizedMessage();
        if (!collection.isEmpty()) {
            if (collection.containsKey(argument)) {
                if (Database.deleteByKey(argument, userId)) collection.remove(argument);
                return new Message(true, "The element removed successfully.");
            } else {
                return new Message(true, "No key found.");
            }
        } else {
            return new Message(true, "Collection is empty.");
        }
    }
}
