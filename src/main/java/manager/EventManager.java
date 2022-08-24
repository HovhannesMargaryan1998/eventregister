package manager;

import db.DBConnectionProvider;
import model.Event;
import model.EventType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    public boolean addEvent(Event event) {
        String query = "INSERT INTO event (name,place,is_online,price,event_type)VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getName());
            preparedStatement.setString(2, event.getPlace());
            preparedStatement.setBoolean(3, event.isOnline());
            preparedStatement.setDouble(4, event.getPrice());
            preparedStatement.setString(5, event.getEventType().name());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                event.setId(resultSet.getInt(1));
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Event> showEvents(){
        String query ="SELECT * FROM event";
        List<Event>list=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Event event=new Event();
                event.setId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setPlace(resultSet.getString(3));
                event.setOnline(resultSet.getBoolean(4));
                event.setPrice(resultSet.getDouble(5));
                event.setEventType(EventType.valueOf(resultSet.getString(6)));
                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
