package ru.ama.ottest.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TestInfoDao {
   /* @Query("SELECT * FROM test_info ORDER BY testId asc")
    fun getTestInfo(): LiveData<List<TestInfoDbModel>>*/

@Query("SELECT * FROM test_info  ORDER BY testId asc ")
    fun getTestInfo(/*testId:Int*/): List<TestInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestInfo(testInfo: TestInfoDbModel)
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestList(testList: List<TestInfoDbModel>):List<Long>
}

/*
@Transaction
@Query(“SELECT * FROM test_info”)
List<TestQuestionsDbModel> getTestInfo();
*/