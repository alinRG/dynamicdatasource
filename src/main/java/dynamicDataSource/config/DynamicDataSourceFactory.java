package dynamicDataSource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dynamicDataSource.properties.DataSourceProperties;

/**
 * HikariDataSource Factory bean
 */
public class DynamicDataSourceFactory {
    public static HikariDataSource buidHikariDataSource(DataSourceProperties properties){
        HikariDataSource hikariDataSource = new HikariDataSource((HikariConfig)properties);
        return hikariDataSource;

    }
}
