package StatePattern;

interface State {
    void publish(User user);
}

class DraftState implements State {
    private Document document;

    public DraftState(Document document) {
        this.document = document;
    }

    @Override
    public void publish(User user) {
        if (user.getRole().equals("admin")) {
            document.changeState(new PublishedState(document));
        } else {
            document.changeState(new ModerationState(document));
        }
    }
}

class ModerationState implements State {
    private Document document;

    public ModerationState(Document document) {
        this.document = document;
    }

    @Override
    public void publish(User user) {
        if (user.getRole().equals("admin")) {
            document.changeState(new PublishedState(document));
        }
    }
}

class PublishedState implements State {
    private Document document;

    public PublishedState(Document document) {
        this.document = document;
    }

    @Override
    public void publish(User user) {
        System.out.println("Is already published");
    }
}

class User {
    private String role;
    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}

class Document {
    //用於紀錄 Document 當前狀態
    private State state;

    //Document 建立的時候是 draft
    public Document() {
        this.state = new DraftState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }


    public State getState() {
        return this.state;
    }

    //每個 State 改變狀態的邏輯是可以封裝在當前的 State 物件中的
    public void publish(User user) {
        this.state.publish(user);
    }
}

public class Main {
    public static void main(String[] args) {
        User admin = new User("admin");
        User author = new User("author");
        Document document = new Document();
        document.publish(author);
        System.out.println(document.getState());
        document.publish(admin);
        System.out.println(document.getState());
        document.publish(admin);
    }
}
