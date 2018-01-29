package com.spencerucla.keep.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = KeepDatabase.class)
public class Note extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    int order;

    @Column
    String title;

    @Column
    String Text;

    // TODO: datetime for reminder
}
