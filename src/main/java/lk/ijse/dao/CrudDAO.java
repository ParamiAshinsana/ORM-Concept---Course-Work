package lk.ijse.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    public List<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    public boolean add(T entity) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(T entity) throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;
}
