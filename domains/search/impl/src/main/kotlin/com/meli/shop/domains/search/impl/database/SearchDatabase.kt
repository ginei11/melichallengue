package com.meli.shop.domains.search.impl.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meli.shop.domains.search.impl.database.dao.RecentSearchDao

@Database(
    entities = [
        RecentSearchEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SearchDatabase : RoomDatabase() {

    /**
     * Recent search
     */
    abstract fun recentSearchDao(): RecentSearchDao
}
