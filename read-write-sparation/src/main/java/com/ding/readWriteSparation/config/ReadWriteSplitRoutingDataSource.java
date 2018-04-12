package com.ding.readWriteSparation.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by ding on 2018/4/11.
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
