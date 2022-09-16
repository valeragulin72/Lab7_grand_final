package Commands;

import Interaction.Message;

public abstract class CommandObject implements Command{
    protected int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAuthorized(){
        return userId != 0;
    }

    public Message getUnauthorizedMessage(){
        return new Message(true, "You are not authorized to execute this command./n" +
                "Enter 'register' if you're a new one, or 'login' if you already were here");
    }

    public Message getAuthorizedMessage(){
        return new Message(true, "You are already authorized.");
    }
}
