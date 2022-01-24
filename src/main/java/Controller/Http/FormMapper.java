package Controller.Http;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface FormMapper<T> {
    public T map(HttpServletRequest request, Boolean update) throws SQLException;//HttpServletResponse response
}
