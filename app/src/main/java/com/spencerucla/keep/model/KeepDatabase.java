package com.spencerucla.keep.model;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = KeepDatabase.NAME, version = KeepDatabase.VERSION)
public class KeepDatabase {

  public static final String NAME = "KeepDatabase";

  public static final int VERSION = 1;
}
