package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Figure;
import view.MyView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Canvas canvas;

    @FXML
    Pane pane;

    Figure figure = new Figure();
    MyView view = new MyView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(evt -> draw());
        canvas.heightProperty().addListener(evt -> draw());
    }

    public void draw(ActionEvent actionEvent) {
        draw();
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setStroke(Color.BLUE);
        gc.scale(1.25,1.25);
        view.drawFigure(figure,gc);
        gc.scale(.8,.8);
    }
}
