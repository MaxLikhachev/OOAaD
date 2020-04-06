package abstract_factory;

interface Button {
    void paint();
}

class WinButton implements Button {
    public void paint() {
        System.out.println("Win button painted");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Mac button painted");
    }
}

interface Checkbox {
    void paint();
}
class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Win checkbox painted");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Mac checkbox painted");
    }
}

// Абстрактная фабрика знает обо всех абстрактных типах
// продуктов.
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
    


// Каждая конкретная фабрика знает и создаёт только продукты
// своей вариации.
class WinFactory implements GUIFactory {

    public Button createButton() {
        return new WinButton();
    }
        
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }   
}
    

// Несмотря на то, что фабрики оперируют конкретными классами,
// их методы возвращают абстрактные типы продуктов. Благодаря
// этому фабрики можно взаимозаменять, не изменяя клиентский
// код.
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
        
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}
    


// Для кода, использующего фабрику, не важно, с какой конкретно
// фабрикой он работает. Все получатели продуктов работают с
// ними через общие интерфейсы.
class Application {
    private final GUIFactory factory;
    private Button button;

    public Application(final GUIFactory factory) {
        this.factory = factory;
        this.createUI();
        this.paint();
    }

    public void createUI() {
        this.button = factory.createButton();
    }

    public void paint() {
        button.paint();
    }
}

// Приложение выбирает тип конкретной фабрики и создаёт её
// динамически, исходя из конфигурации или окружения.

public class AppExample {
    public static void main(String[] args) {
        final String config = "Mac";

        GUIFactory factory;
        switch (config) {
            case "Windows":
                factory = new WinFactory();
                break;
            case "Mac":
                factory = new MacFactory();
                break;
            default:
                System.out.println("Error! Unknown operating system.");
                factory = new WinFactory();
                break;
        }
        final Application app = new Application(factory);
    }
}