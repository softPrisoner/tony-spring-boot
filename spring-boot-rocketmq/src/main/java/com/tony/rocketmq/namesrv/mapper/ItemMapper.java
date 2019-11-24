package com.tony.rocketmq.namesrv.mapper;

/**
 * @author tony
 * @describe ItemMapper
 * @date 2019-08-19
 */
public interface ItemMapper {

    void itemCreateDBInsert();

    //data in,no out
    void itemModifyDBUpadate();

    void itemDeleteDBUpdate();

    void itemCreateDBInsertBatch();

    void itemDeleteDBUpdateBatch();
}
