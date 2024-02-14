package com.company.data.interfaces;

import java.sql.Connection;

public interface IDB { //Define the interface for classes that need to establish database connections.
    Connection getConnection();
}
