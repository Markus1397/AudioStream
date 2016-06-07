/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostream.at;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eva
 */
public class MusicTable {
    TableView musicTable;

    public TableView getTable() {
        return musicTable;
    }
    TableColumn title;
    TableColumn interprets;
    TableColumn durations;

    public TableColumn getTitle() {
        return title;
    }

    public TableColumn getDurations() {
        return durations;
    }
    public MusicTable(ObservableList<Music> data) {
        musicTable = new TableView();
        title = new TableColumn("Title");
        interprets = new TableColumn("Interpret");
        durations = new TableColumn("Duration");
        title.setPrefWidth(400);
        title.setCellValueFactory(new PropertyValueFactory<>("name"));
        interprets.setPrefWidth(200);
        interprets.setCellValueFactory(new PropertyValueFactory<>("interpret"));
        durations.setPrefWidth(200);
        durations.setCellValueFactory(new PropertyValueFactory<>("duration"));
        musicTable.setItems(data);
        musicTable.getColumns().addAll(title, interprets, durations);
    }
}
