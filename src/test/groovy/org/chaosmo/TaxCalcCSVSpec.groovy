package org.chaosmo

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvToBeanBuilder
import spock.lang.Shared
import spock.lang.Specification

/**
 * 参考：https://spockframework.org/spock/docs/2.1/all_in_one.html#_multi_variable_data_pipes
 */
class TaxCalcCSVSpec extends Specification {

    @Shared
    List<TestData> targetData = Collections.emptyList()

    def setupSpec() {
        def dataFile = this.class.getClassLoader().getResourceAsStream("test.csv")
        try (InputStreamReader reader = new InputStreamReader(dataFile)) {
            targetData = new CsvToBeanBuilder(reader)
                    .withType(TestData.class)
                    .build()
                    .parse()
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    def "test with data table from csv data"() {
        given:
        def service = new TaxCalcUtil()
        expect: "when + then group"
        def haha = new OrderInfo(income)
        service.calc(haha) == result

        where: "each running case description"
        singleData << targetData
        income = singleData.income
        result = singleData.result
    }

    static class TestData {
        @CsvBindByName(column = "income")
        Double income
        @CsvBindByName(column = "result")
        Double result


        @Override
        public String toString() {
            return "TestData{" +
                    "income=" + income +
                    ", result=" + result +
                    '}';
        }
    }
}
