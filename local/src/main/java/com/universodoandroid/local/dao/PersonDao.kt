package com.universodoandroid.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universodoandroid.domain.people.Person
import com.universodoandroid.local.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeople(people: List<PersonEntity>): Completable


    @Query("SELECT * FROM PersonEntity")
    fun getPeople(): Flowable<List<PersonEntity>>

    @Query("SELECT * FROM PersonEntity WHERE id = :personId")
    fun getPerson(personId: String): Flowable<PersonEntity>

}