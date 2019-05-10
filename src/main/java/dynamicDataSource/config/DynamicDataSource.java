package dynamicDataSource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * dynamic datasource
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.peek();
    }
}
