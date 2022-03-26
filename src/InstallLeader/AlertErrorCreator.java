package InstallLeader;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @auther Alessio
 * @date 12/7/2021
 **/
public class AlertErrorCreator {
    String ImagePath = "file:src/InstallLeader/resources/pic/AAA.jpg";
    String title;
    String header;
    String context;

    public AlertErrorCreator(String title, String header, String context) {
        this.title = title;
        this.header = header;
        this.context = context;

        genAlert();
    }

    private void genAlert() {
        Alert alert = alertCreator(title, header, context, Alert.AlertType.INFORMATION);
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ImagePath));
        ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        alert.showAndWait();
    }

    /**
     * 创建alert框
     *
     * @param title
     * @param header
     * @param context
     * @param alertType
     * @return
     */
    public static Alert alertCreator(String title, String header, String context, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        return alert;
    }


}
