package robot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 * This is the view class of the MVC architecture. This class specifies the graphical user interface and sends output information through the controller class.
 * @author minttu and saini
 *
 */
public class PCView extends Application implements PCView_IF{

	private PCController_IF controller;
	private List<String> ownSongString = new ArrayList<String>();
	private ObservableList<String> songList2;
	private ListView<String> songList;
	private ListView<String> noteList;
	private ObservableList<String> noteList2;
	private ListView<String> noteLength;
	private ObservableList<String> noteLength2;
	private Text nuotit;
	private VBox center;

	public void init(){
		controller = new PCController(this);
		controller.startConnection();
	}

	/**
	 * This method specifies the graphical user interface, and activates it.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Piano Bot");
			BorderPane border = new BorderPane();
			border.setTop(addHBoxTop());
			border.setCenter(addVBoxSongsAndOwnSelection());
			border.setRight(addVBoxRight());


			Scene scene = new Scene(border);
			primaryStage.setScene(scene);
			primaryStage.show();
			// this is to quit also lejos program when PC program is quit
		    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		        @Override
		        public void handle(WindowEvent e) {
		        	controller.quit();
		        	System.exit(0);
		        }
		     });
		} catch(Exception e) {
			e.printStackTrace();
		}

	}


	public VBox addVBoxSongsAndOwnSelection(){
		center = new VBox();
		center.setPadding(new Insets (10));
		center.setSpacing(10);
		Text info = new Text();
		info.setText("Jos valitsit oman kappaleen, syötä nuotit alla:");
        info.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
		center.getChildren().addAll(addVBoxSongs(), info, addHBoxOwnSelection(), addHBoxOwnNotes());
		return center;
	}
	public HBox addHBoxOwnNotes(){
		HBox notes = new HBox();
		nuotit = new Text();
		nuotit.wrappingWidthProperty().bind(notes.widthProperty());
		notes.setMaxHeight(50);
		notes.setMaxWidth(250);
		notes.getChildren().add(nuotit);

		return notes;
	}

	public VBox addVBoxSongs() {
        songList = new ListView<String>();
        songList.setPrefSize(100, 120);

        songList2 = FXCollections.observableArrayList ();
        songList2.add("Ukko Nooa");
        songList2.add("Kulkuset");
        songList2.add("Hämähakki");
        songList2.add("Oma kappale");
        songList.setItems(songList2);

        VBox songBox = new VBox();
        songBox.setSpacing(10);
        songBox.setMaxSize(100, 130);
        songBox.setMinSize(100, 130); //lisï¿½tty
        songBox.getChildren().addAll(new Label("Kappaleet"), songList);
        return songBox;
	}

	public HBox addHBoxOwnSelection(){
		HBox ownSelection = new HBox();
		ownSelection.setSpacing(10);
		ownSelection.setMinSize(100, 130); //lisï¿½tty
		ownSelection.getChildren().addAll(addVBoxNotes(), addVBoxNoteLengths(), addAddButton());
		return ownSelection;
	}
	public VBox addAddButton(){
		VBox buttonBox = new VBox();
		buttonBox.setAlignment(Pos.CENTER);
		Button add = new Button();
		add.setText("Lisää");
		add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setNote(noteList.getSelectionModel().getSelectedIndex(),Integer.parseInt(noteLength.getSelectionModel().getSelectedItem()));
        		ownSongString.add("("+noteList.getSelectionModel().getSelectedItem()+", "+ noteLength.getSelectionModel().getSelectedItem()+")");
        		nuotit.setText(""+ownSongString);
            }
        });
		buttonBox.getChildren().add(add);
		return buttonBox;
	}

	public VBox addVBoxNotes() {
        noteList = new ListView<String>();
        noteList.setPrefSize(100, 120);
        noteList2 = FXCollections.observableArrayList ("F0", "G0", "A0", "H0", "C1", "D1", "E1", "F1",
        		 "G1", "A1", "H1", "C2", "D2", "E2");
        noteList.setItems(noteList2);

        VBox noteBox = new VBox();
        noteBox.getChildren().addAll(new Label("Nuotit"), noteList);
        return noteBox;
	}
	public VBox addVBoxNoteLengths() {
        noteLength = new ListView<String>();
        noteLength.setPrefSize(100, 120);

        noteLength2 = FXCollections.observableArrayList ("50", "100", "200", "400", "600", "800", "1000", "1200", "1400");
        noteLength.setItems(noteLength2);

        VBox noteBox = new VBox();
        noteBox.getChildren().addAll(new Label("Kesto millisekunneissa"), noteLength);
        return noteBox;
	}

	public HBox addImage() {
		File file = new File("src/robot/pianobot2.png");
		Image image = new Image(file.toURI().toString());
		HBox imageBox = new HBox();
		imageBox.setMaxSize(100, 100);

	    ImageView iv1 = new ImageView();
	    iv1.setImage(image);
        iv1.setFitWidth(400);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
	    imageBox.getChildren().add(iv1);
	    return imageBox;
	}


	public HBox addHBoxTop(){
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Text p = new Text("P");
        p.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        p.setFill(Color.CHARTREUSE);
        Text i = new Text("I");
        i.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        i.setFill(Color.ORANGE);
        i.setRotate(20);
        Text a = new Text("A");
        a.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        a.setFill(Color.BLUE);
        Text n = new Text("N");
        n.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        n.setFill(Color.RED);
        n.setRotate(-20);
        Text o = new Text("O");
        o.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        o.setFill(Color.BLUEVIOLET);
        Text b = new Text("B");
        b.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        b.setFill(Color.CHARTREUSE);
        Text o2 = new Text("O");
        o2.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        o2.setFill(Color.ORANGE);
        Text t = new Text("T");
        t.setFont(Font.font("Tahoma", FontWeight.BOLD, 32));
        t.setFill(Color.BLUE);
        t.setRotate(20);

        hBox.getChildren().addAll(p,i,a,n,o,b,o2,t);

		return hBox;
	}


	public VBox addVBoxRight(){
		VBox vBoxBottom = new VBox();
		vBoxBottom.setPadding(new Insets(15, 12, 15, 12));
        vBoxBottom.setSpacing(10);
        vBoxBottom.setAlignment(Pos.CENTER);
		File file = new File ("src/robot/play.png");
		Image image = new Image(file.toURI().toString());
		Button play = new Button("", new ImageView(image));
		play.setPadding(new Insets (20));
		play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setSong(songList.getSelectionModel().getSelectedIndex());
				controller.playSong();
            }
        });

		File file2 = new File ("src/robot/stop.png");
		Image image2 = new Image(file2.toURI().toString());
		Button stop = new Button("", new ImageView(image2));
		stop.setPadding(new Insets (20));
		stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
				controller.stopSong();
            }
        });

		HBox hBox = new HBox();
		hBox.getChildren().addAll(play, stop);
		hBox.setAlignment(Pos.CENTER);
		vBoxBottom.getChildren().addAll(addImage(), hBox);

		return vBoxBottom;

	}


	public static void main(String[] args) {
		launch(args);
	}

}
