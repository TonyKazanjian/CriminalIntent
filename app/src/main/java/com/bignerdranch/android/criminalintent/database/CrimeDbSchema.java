package com.bignerdranch.android.criminalintent.database;

/**
 * Created by tonyk_000 on 12/7/2015.
 */
public class CrimeDbSchema {
    public static final class CrimeTable{
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";
            //updating db to store contact's ID
            public static final String CONTACT_ID = "contact_id";
        }
    }
}
