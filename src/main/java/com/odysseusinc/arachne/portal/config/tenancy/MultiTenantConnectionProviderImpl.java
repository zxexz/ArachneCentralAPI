package com.odysseusinc.arachne.portal.config.tenancy;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider {

    @Value("${arachne.tenancy.currentTenantDbVariable}")
    private String tenantVar;

    private DataSource dataSource;

    public MultiTenantConnectionProviderImpl(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {

        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {

        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {

        final Connection connection = getAnyConnection();
        setTenantToDb(connection, TenantContext.getCurrentTenant());
        return connection;
    }

    @Override
    public void releaseConnection(String s, Connection connection) throws SQLException {

        setTenantToDb(connection, null);
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {

        return true;
    }

    @Override
    public boolean isUnwrappableAs(Class aClass) {

        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {

        return null;
    }

    private void setTenantToDb(Connection connection, Long value) throws SQLException {

        connection.createStatement().execute("SELECT set_config('" + tenantVar + "', '" + ObjectUtils.firstNonNull(value, -1) + "', false)");
    }
}
