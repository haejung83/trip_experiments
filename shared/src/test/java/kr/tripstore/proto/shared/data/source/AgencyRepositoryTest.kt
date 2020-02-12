package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.agency.AgencyCacheDataSource
import kr.tripstore.proto.shared.data.agency.AgencyDataSource
import kr.tripstore.proto.shared.data.agency.AgencyLocalDataSource
import kr.tripstore.proto.shared.data.agency.AgencyRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AgencyRepositoryTest {

    private lateinit var agencyRemoteDataSource: AgencyDataSource
    private lateinit var agencyLocalDataSource: AgencyCacheDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        agencyRemoteDataSource = FakeAgencyRemoteDataSource()
        agencyLocalDataSource = AgencyLocalDataSource()
    }

    @Test
    fun getAgencies_isNotNull() =
        runBlockingTest {
            // Given an agency data sources
            val agencyRepository =
                AgencyRepository(
                    agencyRemoteDataSource,
                    agencyLocalDataSource
                )
            // When getting a result of agencies
            val agenciesResult = agencyRepository.getAgencies()
            // Then the result is not null
            assertResult(agenciesResult)
        }

    @Test
    fun getAgencies_isSameAsTestData() =
        runBlockingTest {
            // Given an agency data sources
            val agencyRepository =
                AgencyRepository(
                    agencyRemoteDataSource,
                    agencyLocalDataSource
                )
            // When getting a result of agencies
            val agenciesResult = agencyRepository.getAgencies()
            val data = (agenciesResult as Result.Success).data
            // Then the result is not null
            assertThat(data, IsEqual.equalTo(TestData.agencies.agencies))
        }

}