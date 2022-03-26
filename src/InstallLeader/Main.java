package InstallLeader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();
        primaryStage.setTitle("安装向导 Powered by INST.AAA");
        primaryStage.resizableProperty().set(false);
        primaryStage.getIcons().add(new Image("pic/AAA.jpg"));
        primaryStage.setScene(new Scene(controller, 500, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
